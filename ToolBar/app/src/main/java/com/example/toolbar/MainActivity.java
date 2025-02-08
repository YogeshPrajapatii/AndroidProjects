package com.example.toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar customToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Toolbar by ID
        customToolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(customToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.add_document); // Back Button Icon
        }
    }

    // Inflate the menu XML file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.option_new) {
            Toast.makeText(this, "New File Created", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.option_open) {
            Toast.makeText(this, "File Opened", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.option_save) {
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == android.R.id.home) {
            Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
