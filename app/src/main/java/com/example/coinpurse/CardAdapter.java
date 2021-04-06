package com.example.coinpurse;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<Card> mCardList;

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        public TextView mAmountText;
        public TextView mCategoryText;
        public TextView mTimestampText;


        public CardViewHolder(View itemView){
            super(itemView);
            mAmountText = itemView.findViewById(R.id.amount_card_text);
            mCategoryText = itemView.findViewById(R.id.category_card_text);
            mTimestampText = itemView.findViewById(R.id.time_card_text);

        }

    }

    public  CardAdapter(ArrayList<Card> CardList ){
        this.mCardList = CardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        CardViewHolder evh = new CardViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card currentItem = mCardList.get(position);
        holder.mAmountText.setText(currentItem.getAmount_card_text());
        holder.mCategoryText.setText(currentItem.getCategory_card_text());

        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String TimeText = formatter.format(ts);

        holder.mTimestampText.setText(TimeText);

    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }


}

