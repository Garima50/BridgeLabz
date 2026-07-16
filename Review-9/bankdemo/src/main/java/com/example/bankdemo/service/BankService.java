package com.example.bankdemo.service;


import com.example.bankdemo.dto.Deposit;
import com.example.bankdemo.dto.FundTransfer;
import com.example.bankdemo.dto.ServicesAvail;
import com.example.bankdemo.dto.Withdraws;
import com.example.bankdemo.entity.User;


public interface BankService {


    String register(User user);

    User getUserById(Integer sno);
    String setServices(ServicesAvail s);

    String deposits(Deposit d);

    String withdraw(Withdraws w);

    String closeAccount(Integer accountNo);

    String updateEmail(Integer accountNo, String email);

    String updateMobile(Integer accountNo, String mobile);

    String transfer(FundTransfer f);
}
