package com.example.bottomnavigationviewexample;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id==R.id.navHome){
            loadFrag(new HomeFragment(),false);
            } else if (id==R.id.navSearch) {
            loadFrag(new SearchFragment(), false);
            } else if (id==R.id.navUtility) {
            loadFrag(new UtilityFragment(), false);
            } else if (id==R.id.navContactUs) {
            loadFrag(new ContactUsFragment(), false);
            }else {loadFrag(new ProfileFragment(),true);
            }

            return  true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomNavigation.setSelectedItemId(R.id.navSearch);
    }

    public void loadFrag(Fragment fragment, boolean flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag) ft.add(R.id.frameContainer, fragment);
        else ft.replace(R.id.frameContainer,fragment);
        ft.commit();
    }
}