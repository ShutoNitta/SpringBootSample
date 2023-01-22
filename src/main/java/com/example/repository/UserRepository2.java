package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.user.model.Salary;

public interface UserRepository2 extends JpaRepository<Salary,String>{
}
