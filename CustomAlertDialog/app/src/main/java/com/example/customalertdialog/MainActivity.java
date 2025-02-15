package com.example.customalertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

/*    1. Implementation of single button.

       AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
       alertBuilder.setIcon(R.drawable.alert);
       alertBuilder.setTitle("Terms & Conditions.");
       alertBuilder.setMessage("Are you agree with above term and conditions.");

       alertBuilder.setNeutralButton("I Agree.", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
           }
       }); alertBuilder.show(); */


        /* 2. Implementation of multiple button.

        AlertDialog.Builder alertBuilderTwo = getBuilder();

        alertBuilderTwo.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Agreed!", Toast.LENGTH_LONG).show();
            }
        });

        alertBuilderTwo.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Canceled!" ,Toast.LENGTH_LONG).show();
            }
        });

        alertBuilderTwo.show(); */


        Dialog  dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        dialog.setCancelable(false);

        AppCompatButton btnOk = dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Canceled!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private AlertDialog.Builder getBuilder() {
        AlertDialog.Builder alertBuilderTwo = new AlertDialog.Builder(this);
        alertBuilderTwo.setTitle("Do you want to perform this action.");
        alertBuilderTwo.setMessage("Press button according to your choice.");
        alertBuilderTwo.setIcon(R.drawable.alert);

        alertBuilderTwo.setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Thanks we will remind you later",Toast.LENGTH_LONG).show();
            }
        });
        return alertBuilderTwo;
    }
}