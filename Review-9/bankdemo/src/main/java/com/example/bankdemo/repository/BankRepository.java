package com.example.bankdemo.repository;

import com.example.bankdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<User, Integer> {
    //User getUserBy(Integer );

    // void saveAccountNo(int y);
    User findByAccountNo(Integer accountNo);
}
