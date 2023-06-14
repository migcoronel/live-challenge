package com.example.challenge.controller;


import com.example.challenge.DTO.NumbersDto;
import com.example.challenge.converter.DtoToDomainConverter;
import com.example.challenge.service.NumbersService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "numbers")
@Api(value = "Numbers Api", tags = "numbers-api")
public class NumbersController {

    @Autowired
    private NumbersService service;

    @Autowired
    private DtoToDomainConverter dtoToDomainConverter;

    @PostMapping("/sum")
    public ResponseEntity<Integer> sumNumbers(@RequestBody NumbersDto numbersDto){

        return ResponseEntity.ok(service.getSum(dtoToDomainConverter.convert(numbersDto.getNumberList())));
    }

    @GetMapping("/rank")
    public ResponseEntity<List<Integer>> getRank(@RequestParam(required = false) Integer limit) {

        if(limit == null || limit == 0){
            limit = 10;
        }

        return ResponseEntity.ok(service.getTopSumRank(limit));

    }


}
