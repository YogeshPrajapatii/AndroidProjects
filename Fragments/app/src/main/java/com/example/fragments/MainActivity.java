package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btaFragA, btaFragB, btaFragC;
    FrameLayout frameContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btaFragA = findViewById(R.id.btaFragA);
        btaFragB = findViewById(R.id.btaFragB);
        btaFragC = findViewById(R.id.btaFragC);

        loadFrag(new AFragment(),0);


        btaFragA.setOnClickListener(v -> {

            loadFrag(new AFragment(),1);

        });

        btaFragB.setOnClickListener(v -> {
loadFrag(new BFragment(),1);
        });

        btaFragC.setOnClickListener(v -> {
loadFrag(new CFragment(),1);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void loadFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag==0){
        ft.add(R.id.frameContainer, fragment);}
        else {
            ft.replace(R.id.frameContainer,fragment);
        }
        ft.commit();
    }
}