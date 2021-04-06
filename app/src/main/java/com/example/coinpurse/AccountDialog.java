package com.example.coinpurse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Locale;

public class AccountDialog extends AppCompatDialogFragment {
    private EditText accountName;
    private EditText accountAmount;
    private AccountDialogListener accountListener;

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.account_dialog, null);

        builder.setView(view)
                .setTitle("Account Info")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String Name = accountName.getText().toString();
                        String Amount = accountAmount.getText().toString();
                        accountListener.applyAccountInfo(Name, Amount);

                    }
                });
        accountName = view.findViewById(R.id.account_name);
        accountAmount = view.findViewById(R.id.account_amount);

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            accountListener = (AccountDialogListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "implementation wrong");
        }
    }

    public interface AccountDialogListener{
        void applyAccountInfo(String Name, String Amount);

    }
}
