package com.example.bankdemo.service;


import com.example.bankdemo.dto.Deposit;
import com.example.bankdemo.dto.FundTransfer;
import com.example.bankdemo.dto.ServicesAvail;
import com.example.bankdemo.dto.Withdraws;
import com.example.bankdemo.entity.User;
import com.example.bankdemo.exception.myex;
import com.example.bankdemo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository repo;

    @Override
    public String register(User user) {
        if(user.getBalance() < 1000) return "Not Enough balance!";
        else {
            Random x = new Random(); //random acc no generation
            int y = x.nextInt(10000, 1000000);
            user.setAccountNo(y);
            repo.save(user);
            return "Successfully Registered!";
        }
    }

    @Override
    public User getUserById(Integer sno) {
        Optional<User> u = repo.findById(sno);
        if(u.isPresent()) {
            return u.get();
        }
        throw new myex();
    }

    @Override
    public String setServices(ServicesAvail s) {
         User u = repo.findByAccountNo(s.getAccountNo());
        if(u != null) {
            if(s.getServices().equals("Debit")) if (!u.isDebit()) {
                u.setDebit(true);

            }
            else return "Service used already";
            if(s.getServices().equals("Credit")) if (!u.isCredit()) {
                u.setCredit(true);

            }
            else return "Service used already";
            if(s.getServices().equals("Passbook")) if (!u.isPassbook()) {
                u.setPassbook(true);

            }
            else return "Service used already";
            repo.save(u);
            return "Service Provided!";

        }

        return "Account number not found!";
    }

    @Override
    public String deposits(Deposit d) {
        User u = repo.findByAccountNo(d.getAccountNo());
        if(u == null) return "Account not found!";
        u.setBalance(u.getBalance() + d.getAmount());
        repo.save(u);
        return "Deposit Done!";
    }

    @Override
    public String withdraw(Withdraws w) {
        User u  = repo.findByAccountNo(w.getAccountNo());
        if (u == null) return "Account not found!";
        if(u.getBalance() < w.getAmount()) return "Insufficient balance";
        u.setBalance(u.getBalance() - w.getAmount());
        repo.save(u);
        return "Withdrawal Done!";
    }


    @Override
    public String transfer(FundTransfer f) {
        User sender = repo.findByAccountNo(f.getSenderAccountNo());
        User receiver = repo.findByAccountNo(f.getReceiverAccountNo());
        if(sender == null || receiver == null) return "Invalid Account Number";
        if(sender.getBalance() < f.getAmount()) return "Insufficient Balance";
        sender.setBalance(sender.getBalance() - f.getAmount());
        receiver.setBalance(receiver.getBalance() + f.getAmount());
        repo.save(sender);
        repo.save(receiver);
        return "Money Transferred Successfully";
    }

    @Override
    public String closeAccount(Integer accountNo) {

        User u = repo.findByAccountNo(accountNo);
        if(u == null) return "Account Not Found";
        repo.delete(u);
        return "Account Closed Successfully";
    }











    @Override
    public String updateEmail(Integer accountNo, String email) {

        User user = repo.findByAccountNo(accountNo);

        if(user == null)
            return "Account Not Found";

        user.setEmail(email);

        repo.save(user);

        return "Email Updated Successfully";
    }

    @Override
    public String updateMobile(Integer accountNo, String mobile) {

        User user = repo.findByAccountNo(accountNo);

        if(user == null)
            return "Account Not Found";

        user.setMobile(mobile);

        repo.save(user);

        return "Mobile Updated Successfully";
    }



}
