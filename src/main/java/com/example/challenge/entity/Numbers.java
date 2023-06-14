package com.example.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Table(name = "numbers", schema = "challenge")
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Numbers {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String numberList;
    private Integer sum;
}
