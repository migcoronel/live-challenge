package com.example.challenge.converter;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToDomainConverter {


    int[] convert(List<Integer> numberList);

}
