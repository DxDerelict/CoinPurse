package com.example.coinpurse;

public class Account {
    private String AccountName;
    private TransactionType AccountTransactionType;
    private Double AccountTotal;


    Account(String Name, TransactionType Type, Double Amt){
        this.AccountName = Name;
        this.AccountTransactionType = Type;
        this.AccountTotal = Amt;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public TransactionType getAccountTransactionType() {
        return AccountTransactionType;
    }

    public void setAccountTransactionType(TransactionType accountTransactionType) {
        AccountTransactionType = accountTransactionType;
    }

    public Double getAccountTotal() {
        return AccountTotal;
    }

    public void setAccountTotal(Double accountTotal) {
        AccountTotal = accountTotal;
    }

    public void addAmount(Double fig){
        this.AccountTotal += fig;
    }
    public void deductAmount(Double fig){
        this.AccountTotal -= fig;
    }


}

