package com.example.bankdemo.controller;

import com.example.bankdemo.dto.Deposit;
import com.example.bankdemo.dto.FundTransfer;
import com.example.bankdemo.dto.Withdraws;
import com.example.bankdemo.entity.User;
//import com.example.demo.service.BankService;
import com.example.bankdemo.exception.myex;
import com.example.bankdemo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bankdemo.dto.ServicesAvail;


@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankService Bservice;

    @PostMapping("/register")
    public String register(@RequestBody User user){

        return Bservice.register(user);

    }

    @GetMapping("/{sno}")
    public User getStudentById(@PathVariable Integer sno)
    {
        return Bservice.getUserById(sno);
    }

    @ExceptionHandler(myex.class)
    public String abcd(myex myex){
        return myex.getMessage();
    }

    @PostMapping("/service")
    public String services(@RequestBody ServicesAvail sa){
        return Bservice.setServices(sa);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestBody Deposit d){
        return Bservice.deposits(d);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody Withdraws w){
        return Bservice.withdraw(w);
    }

    @PostMapping("/fund-transfer")
    public String transfer(@RequestBody FundTransfer f){
        return Bservice.transfer(f);
    }

    @DeleteMapping("/close")
    public String closeAccount(@RequestBody Integer accountNo) {
        return Bservice.closeAccount(accountNo);
    }

    @PostMapping("/updateEmail")
    public String updateEmail(Integer accountNo, String email){
        return Bservice.updateEmail(accountNo, email);
    }

    @PostMapping("/updateMobile")
    public String updateMobile(Integer accountNo, String mobile){
        return Bservice.updateMobile(accountNo, mobile);
    }







}