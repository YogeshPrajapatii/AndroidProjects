package com.devleoperyogi.intentpassing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class PassingIntentToThis extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_passing_intent_to_this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent fromActivity = getIntent();

        String title = fromActivity.getStringExtra("title");
        String name = fromActivity.getStringExtra("name");
        int rollNo = fromActivity.getIntExtra("rollNo" , 0);

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);
        txtStudentInfo.setText("Name: " + name + "\nRoll No: " + rollNo);


        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}