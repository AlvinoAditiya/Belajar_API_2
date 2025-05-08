package com.example.belajarapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_menu_utama extends AppCompatActivity {

    Button btnPremiere;
    Button btnLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);

        btnPremiere = findViewById(R.id.btnPremiere);
        btnLiga = findViewById(R.id.btnLiga);

        btnPremiere.setOnClickListener(v ->{
            Intent intent = new Intent(activity_menu_utama.this, MainActivity.class);
            intent.putExtra("league", "English Premier League"); // Paramater untuk Premier League
            startActivity(intent);
        });

        btnLiga.setOnClickListener(v -> {
            Intent intent = new Intent(activity_menu_utama.this, MainActivity.class);
            intent.putExtra("league", "Spanish La Liga"); //  Nama sesuai API
            startActivity(intent);
        });


    }
}