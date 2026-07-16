package com.example.bankdemo.entity;


import jakarta.persistence.*;

@Entity
@Table
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sno;

    private String name;
    private String email;
    private String mobile;
    private Integer balance;

    private Integer accountNo=0;

    private boolean isDebit=false;
    private boolean isCredit=false;
    private boolean isPassbook=false;

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public void setCredit(boolean credit) {
        isCredit = credit;
    }

    public boolean isPassbook() {
        return isPassbook;
    }

    public void setPassbook(boolean passbook) {
        isPassbook = passbook;
    }


    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }


    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


}

// banking management web app
// 4 api
// depositM