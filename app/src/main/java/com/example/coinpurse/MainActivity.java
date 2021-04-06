package com.example.coinpurse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AccountDialog.AccountDialogListener{
    private Expenses StarterExpense;
    private Button amt_display;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText expenseTime, expenseAmount, expenseCategory;
    private Button Save, Cancel;

    private ArrayList<Card> CardList;
    private Account Account1;

    public MainActivity(){
        super();
        Account1 = new Account("Wallet", TransactionType.CASH, 200.0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCardList();
        amt_display = (Button) findViewById(R.id.amt_display);
        amt_display.setText(Account1.getAccountName() +": " + String.valueOf( Account1.getAccountTotal()));
        Button fab = findViewById(R.id.expense_button);

        buildRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewExpenseDialog();
            }

        });

        amt_display.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                createNewAccountDialog();
            }

        });

    }

    public void createCardList(){
        CardList = new ArrayList<>();
//        CardList.add(new Card("10", "Food"));
//        Account1.deductAmount(10.0);
//        CardList.add(new Card("70", "Groceries"));
//        Account1.deductAmount(70.0);

    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(CardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void createNewExpenseDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View expensePopUpView = getLayoutInflater().inflate(R.layout.popup, null);

        expenseAmount = (EditText) expensePopUpView.findViewById(R.id.amount_text);
        expenseCategory = (EditText) expensePopUpView.findViewById(R.id.category_text);
        //expenseTime = ;


        Save =  (Button) expensePopUpView.findViewById(R.id.Save_button);
        Cancel = (Button) expensePopUpView.findViewById(R.id.Cancel_button);

        dialogBuilder.setView(expensePopUpView);
        dialog = dialogBuilder.create();
        dialog.show();

        Save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String y = expenseCategory.getText().toString();
                String z = expenseAmount.getText().toString();
                CardList.add(new Card(z, y));
                Account1.deductAmount(Double.parseDouble(expenseAmount.getText().toString()));
                mAdapter.notifyDataSetChanged();
                amt_display.setText(Account1.getAccountName() +": " + String.valueOf( Account1.getAccountTotal()));
                dialog.cancel();
            }

        });

        Cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }

    public void createNewAccountDialog(){
        AccountDialog accountDialog = new AccountDialog();
        accountDialog.show(getSupportFragmentManager(), "test dialog");


    }

    @Override
    public void applyAccountInfo(String Name, String Amount) {
        Account1 = new Account(Name, TransactionType.CASH, Double.parseDouble(Amount));
        amt_display.setText(Account1.getAccountName() +": " + String.valueOf( Account1.getAccountTotal()));

    }
}