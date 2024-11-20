package com.devleoperyogi.animationsinandroid;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlpha;
    Button btnScale;
    Button btnRotate;
    Button btnMove;
    TextView txtAnim;

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

        btnAlpha = findViewById(R.id.btnAlpha);
        btnMove = findViewById(R.id.btnMove);
        btnRotate = findViewById(R.id.btnRotate);
        btnScale = findViewById(R.id.btnScale);
        txtAnim = findViewById(R.id.txtAnim);

        Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);

        btnScale.setOnClickListener(v -> txtAnim.startAnimation(scale));
        btnAlpha.setOnClickListener(v -> txtAnim.startAnimation(alpha));

        btnRotate.setOnClickListener(v -> txtAnim.startAnimation(rotate));
        btnMove.setOnClickListener(v -> txtAnim.startAnimation(move));
    }
}