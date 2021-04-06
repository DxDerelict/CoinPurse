package com.example.coinpurse;

public class Card {
    private String amount_card_text;
    private String category_card_text;


    Card(String Amt, String Cat){
        this.amount_card_text = Amt;
        this.category_card_text = Cat;


    }

    public String getAmount_card_text() {
        return amount_card_text;
    }

    public void setAmount_card_text(String amount_card_text) {
        this.amount_card_text = amount_card_text;
    }

    public String getCategory_card_text() {
        return category_card_text;
    }

    public void setCategory_card_text(String category_card_text) {
        this.category_card_text = category_card_text;

    }

}
