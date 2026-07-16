package com.example.bankdemo.dto;

public class FundTransfer {

    private Integer senderAccountNo;
    private Integer receiverAccountNo;
    private Integer amount;

    public Integer getSenderAccountNo() {
        return senderAccountNo;
    }

    public void setSenderAccountNo(Integer senderAccountNo) {
        this.senderAccountNo = senderAccountNo;
    }

    public Integer getReceiverAccountNo() {
        return receiverAccountNo;
    }

    public void setReceiverAccountNo(Integer receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}