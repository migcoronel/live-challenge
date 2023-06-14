package com.example.challenge.repository;


import com.example.challenge.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Integer> {
}
