package com.devleoperyogi.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<contactModel> arrContacts = new ArrayList<>();
    FloatingActionButton fabAddContact;
    RecyclerContactAdapter adapter;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rContact);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(layoutManager);

        fabAddContact = findViewById(R.id.fabAddContact);


        arrContacts.add(new contactModel(R.drawable.a, "Ramesh", "9887766554"));
        arrContacts.add(new contactModel(R.drawable.b, "Suresh", "9123456789"));
        arrContacts.add(new contactModel(R.drawable.c, "Mahesh", "9876543210"));
        arrContacts.add(new contactModel(R.drawable.d, "Rajesh", "9765432109"));
        arrContacts.add(new contactModel(R.drawable.e, "Naresh", "9654321098"));
        arrContacts.add(new contactModel(R.drawable.f, "Dinesh", "9543210987"));
        arrContacts.add(new contactModel(R.drawable.g, "Mohan", "9432109876"));
        arrContacts.add(new contactModel(R.drawable.h, "Rohan", "9321098765"));
        arrContacts.add(new contactModel(R.drawable.a, "Sohan", "9210987654"));
        arrContacts.add(new contactModel(R.drawable.b, "Ravi", "9109876543"));
        arrContacts.add(new contactModel(R.drawable.c, "Ganesh", "9098765432"));
        arrContacts.add(new contactModel(R.drawable.d, "Vikram", "8987654321"));
        arrContacts.add(new contactModel(R.drawable.e, "Yogesh", "8876543210"));
        arrContacts.add(new contactModel(R.drawable.f, "Manoj", "8765432109"));
        arrContacts.add(new contactModel(R.drawable.g, "Sunil", "8654321098"));
        arrContacts.add(new contactModel(R.drawable.h, "Anil", "8543210987"));
        arrContacts.add(new contactModel(R.drawable.a, "Pankaj", "8432109876"));
        arrContacts.add(new contactModel(R.drawable.b, "Deepak", "8321098765"));
        arrContacts.add(new contactModel(R.drawable.c, "Arjun", "8210987654"));
        arrContacts.add(new contactModel(R.drawable.d, "Vikas", "8109876543"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        fabAddContact.setOnClickListener(v -> {

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.add_update_lay);

            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText edtNumber = dialog.findViewById(R.id.edtNumber);
            Button actionButton = dialog.findViewById(R.id.actionButton);

            actionButton.setOnClickListener((View view) -> {
                String name = edtName.getText().toString().trim();
                String number = edtNumber.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a valid Contact Name.", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if name is empty
                }

                if (number.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a valid Contact Number.", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if number is empty
                }

                arrContacts.add(new contactModel(name, number));
                adapter.notifyItemInserted(arrContacts.size() - 1);
                recyclerView.scrollToPosition(arrContacts.size() - 1);
                dialog.dismiss();
            });

            dialog.show();
        });

        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}