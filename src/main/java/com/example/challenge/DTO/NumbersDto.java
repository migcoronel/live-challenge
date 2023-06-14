package com.example.challenge.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class NumbersDto {

    private List<Integer> numberList;
}
