package com.devleoperyogi.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listView;
    ArrayList<String> arrListView = new ArrayList<>();

    Spinner spinner;
    ArrayList<String> arrId = new ArrayList<>();

    AutoCompleteTextView actTxtView;
    ArrayList<String> arrLanguages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        actTxtView = findViewById(R.id.acTxtview);
        arrListView.add("Yogesh");
        arrListView.add("Yogi");
        arrListView.add("Yuvraj");
        arrListView.add("Shyam");
        arrListView.add("Jatin");
        arrListView.add("Ram");
        arrListView.add("Ravi");
        arrListView.add("Naresh");
        arrListView.add("Yoga");
        arrListView.add("Yami");
        arrListView.add("Yogesh");
        arrListView.add("Yogi");
        arrListView.add("Yuvraj");
        arrListView.add("Shyam");
        arrListView.add("Jatin");
        arrListView.add("Ram");
        arrListView.add("Ravi");
        arrListView.add("Naresh");
        arrListView.add("Yoga");
        arrListView.add("Yami");
        arrListView.add("Yogesh");
        arrListView.add("Yogi");
        arrListView.add("Yuvraj");
        arrListView.add("Shyam");
        arrListView.add("Jatin");
        arrListView.add("Ram");
        arrListView.add("Ravi");
        arrListView.add("Naresh");
        arrListView.add("Yoga");
        arrListView.add("Yami");
        arrListView.add("Yogesh");
        arrListView.add("Yogi");
        arrListView.add("Yuvraj");
        arrListView.add("Shyam");
        arrListView.add("Jatin");
        arrListView.add("Ram");
        arrListView.add("Ravi");
        arrListView.add("Naresh");
        arrListView.add("Yoga");
        arrListView.add("Yami");
        arrListView.add("Yogesh");
        arrListView.add("Yogi");
        arrListView.add("Yuvraj");
        arrListView.add("Shyam");
        arrListView.add("Jatin");
        arrListView.add("Ram");
        arrListView.add("Ravi");
        arrListView.add("Naresh");
        arrListView.add("Yoga");
        arrListView.add("Yami");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {

            if (i==1){
                Toast.makeText(MainActivity.this, "Clicked on 2nd item.", Toast.LENGTH_SHORT).show();
            }
        });


        arrId.add("AADHAR CARD");
        arrId.add("VOTER CARD");
        arrId.add("PAN CARD");
        arrId.add("LICENCE");
        arrId.add("AABHA CARD");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrId);
        spinner.setAdapter(stringArrayAdapter);

        arrLanguages.add("JAVA");
        arrLanguages.add("C");
        arrLanguages.add("C++");
        arrLanguages.add("PYTHON");
        arrLanguages.add("RUBY");
        arrLanguages.add("KOTLIN");
        arrLanguages.add("SWIFT");
        arrLanguages.add("JAVA SCRIPT");

        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguages);
        actTxtView.setAdapter(langAdapter);
        actTxtView.setThreshold(1);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
