package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.user.model.Salary;
import com.example.domain.user.model.SalaryKey;

public interface UserRepository2 extends JpaRepository<Salary,SalaryKey>{
}
