package com.example.a12_shitov_pr22102;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
import android.os.Handler;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

public class Table  extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    private TextView digitalClock;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        btn = findViewById(R.id.btnBorsch);
        btn.setOnClickListener(this);
        Button backButton = findViewById(R.id.back_button);

        digitalClock = findViewById(R.id.digital_clock);
        updateDigitalClock();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Table.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void updateDigitalClock() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        digitalClock.setText(dateFormat.format(calendar.getTime()));

        // Обновляем каждую секунду
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateDigitalClock();
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ShowItem.class));
    }
}