package com.example.challenge.service;

import com.example.challenge.entity.Numbers;
import com.example.challenge.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumbersService {

    @Autowired
    private NumbersRepository numbersRepository;


    public Integer getSum(int[] array) {
        Integer result = 0;
        HashSet<Integer> alreadyAddedNumbers = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < array.length ; i++) {
            Integer num = array[i];

            if(alreadyAddedNumbers.contains(num)){
                duplicates.add(num);
                alreadyAddedNumbers.remove(num);
                result -= num;

            }else if (!duplicates.contains(num)) {
                alreadyAddedNumbers.add(num);
                result += num;
            }
        }

        Numbers number = Numbers.builder()
                .numberList(Arrays.toString(array))
                .sum(result)
                .build();

        numbersRepository.save(number);

        return result;
    }

    public List<Integer> getTopSumRank(Integer limit){

        List<Numbers> storedNumber = numbersRepository.findAll();

        return storedNumber.stream()
                .map(Numbers::getSum).sorted()
                .limit(limit)
                .collect(Collectors.toList());
    }

}