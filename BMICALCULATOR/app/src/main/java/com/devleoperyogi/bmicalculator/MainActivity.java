package com.devleoperyogi.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        TextView txtResult;
        EditText edtheightfinch, edtheightfeet,edtweight;
        Button btnCalculate;
        LinearLayout main;

        txtResult = findViewById(R.id.txtResult);
        edtheightfinch = findViewById(R.id.edtheightfinch);
        edtheightfeet = findViewById(R.id.edtheightfeet);
        edtweight = findViewById(R.id.edtweight);
        btnCalculate = findViewById(R.id.btnCalculate);
        main = findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheightfeet.getText().toString());
                int in = Integer.parseInt(edtheightfinch.getText().toString());

                int totalInchs = ft*12 + in;
                double totalCm = totalInchs * 2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("You're OverWeight !!");
                    main.setBackgroundColor(getResources().getColor(R.color.oW));
                } else if (bmi<18) {
                    txtResult.setText("You're UnderWeight !!");
                    main.setBackgroundColor(getResources().getColor(R.color.uW));
                } else {
                    txtResult.setText("You're Healthy !!");
                    main.setBackgroundColor(getResources().getColor(R.color.hW));
                }
            }
        });

    }
}