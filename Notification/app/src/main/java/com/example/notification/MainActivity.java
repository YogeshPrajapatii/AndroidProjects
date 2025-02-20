package com.example.notification;  // Package name

// Import required Android classes
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 🔹 Unique ID for the notification channel (Used for Android 8.0+)
    private static final String CHANNEL_ID = "Test_Notification";

    // 🔹 Unique ID for the notification (Used for displaying notifications)
    private static final int NOTIFICATION_ID = 10;
    private static final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Enables edge-to-edge UI
        setContentView(R.layout.activity_main);  // Sets the layout file for this activity

        // ✅ Step 1: Convert Drawable to Bitmap (For Notification Large Icon)
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.bell, null);
        Bitmap largeIcon = null;
        if (drawable instanceof BitmapDrawable) {
            largeIcon = ((BitmapDrawable) drawable).getBitmap();
        }


        // ✅ Step 2: Get NotificationManager Service (Manages notifications)
        NotificationManager manager;
        manager = getSystemService(NotificationManager.class);

        // Creating Intent
        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                REQUEST_CODE,
                iNotify,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        // Big Picture Style
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle()
                .bigLargeIcon(largeIcon)
                .bigPicture(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.bell, null)).getBitmap())
                .setBigContentTitle("You have received messages from your contacts.")
                .setSummaryText("Messages check in inbox");

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("Hi")
                .addLine("How are you")
                .addLine("A")
                .addLine("B")
                .addLine("Hi")
                .addLine("How are you")
                .addLine("A")
                .addLine("B")
                .addLine("Hi")
                .addLine("How are you")
                .addLine("A")
                .addLine("B")
                .addLine("Hi")
                .addLine("How are you")
                .addLine("A")
                .addLine("B")
                .addLine("Hi")
                .addLine("How are you")
                .setBigContentTitle("Detailed Message")
                .setSummaryText("Message from your friend");

        // ✅ Step 3: Create Notification Channel (For Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,     // Channel ID (Must be unique)
                    "Messages",     // Channel Name (Visible to user)
                    NotificationManager.IMPORTANCE_HIGH  // Importance Level (High = Shows alerts)
            );
            manager.createNotificationChannel(channel);  // Creates the notification channel
        }

        // ✅ Step 4: Create Notification (Common for all Android versions)
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setLargeIcon(largeIcon)  // Sets large icon (Only for Android < 8.0)
                .setSmallIcon(R.drawable.bell)  // Sets small notification icon
                .setContentTitle("New Messages")  // Title of notification
                .setContentText("You have 20 messages from 4 chats.")  // Main text
                .setContentIntent(pendingIntent)
                .setStyle(bigPictureStyle)
                .setAutoCancel(false)
                .setOngoing(true)
                .setSubText("Check your inbox");  // Additional text below the main text

        // ✅ Step 5: Display the Notification
        manager.notify(NOTIFICATION_ID, notification.build());  // Triggers notification

        // ✅ Step 6: Handle Edge-to-Edge UI (For modern UI layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
