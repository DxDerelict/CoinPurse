package com.example.coinpurse;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Expenses {
    private TransactionType expenseTranType;
    private String expenseCategory;
    private Double expenseAmount;
    private Timestamp expenseTimeStamp;


    Expenses(TransactionType x, String y, double z){
        this.expenseTranType = x;
        this.expenseCategory = y;
        this.expenseAmount = z;

        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);
        this.expenseTimeStamp = sqlTimestamp;

    }

    public TransactionType getExpenseTranType() {
        return expenseTranType;
    }

    public void setExpenseTranType(TransactionType expenseTranType) {
        this.expenseTranType = expenseTranType;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Timestamp getExpenseTimeStamp() {
        return expenseTimeStamp;
    }

    public void setExpenseTimeStamp(Timestamp expenseTimeStamp) {
        this.expenseTimeStamp = expenseTimeStamp;
    }
}
