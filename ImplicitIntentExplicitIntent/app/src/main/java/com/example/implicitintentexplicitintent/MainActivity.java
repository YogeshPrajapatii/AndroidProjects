package com.example.implicitintentexplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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

        AppCompatButton dial = findViewById(R.id.dial);
        AppCompatButton email = findViewById(R.id.email);
        AppCompatButton message = findViewById(R.id.message);
        AppCompatButton share = findViewById(R.id.share);

        dial.setOnClickListener(v -> {
            Intent iDial = new Intent();
            iDial.setAction(Intent.ACTION_DIAL);
            iDial.setData(Uri.parse("tel: +919728526371"));
            startActivity(iDial);
        });

        email.setOnClickListener(v -> {
            Intent iEmail = new Intent(Intent.ACTION_SEND);
            iEmail.setType("message/rfc822");
            iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"yogeshprajapati9781@gmail.com",
                    "verma981133@gmail.com"});
            iEmail.putExtra(Intent.EXTRA_SUBJECT, "Query regarding app");
            iEmail.putExtra(Intent.EXTRA_TEXT, "HI");
            startActivity(Intent.createChooser(iEmail,"Email via"));
        });

        share.setOnClickListener(v -> {
            Intent iShare = new Intent();
            iShare.setAction(Intent.ACTION_SEND);
            iShare.setType("text/plain");
            iShare.putExtra(Intent.EXTRA_TEXT,"Enjoy our App");
            startActivity(Intent.createChooser(iShare,"Share Via"));
        });

        message.setOnClickListener(v -> {
            Intent iMessage = new Intent(Intent.ACTION_SENDTO);
            iMessage.setData(Uri.parse("site:" +Uri.encode("+919728526371")));
            iMessage.putExtra("sms_body","Hlo sir your app is great.");
            startActivity(iMessage);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}