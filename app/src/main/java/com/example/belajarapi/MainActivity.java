package com.example.belajarapi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTeam;
    TeamAdapter adapter;

    List<ItemModel> teamList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Inisialisasi Recycler View
        rvTeam = findViewById(R.id.rvTeam);
        rvTeam.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface api = RetrofitClient.getInstance().create(ApiInterface.class);
        Call<TeamRespon> call = api.getTeams("English Premier League");

        call.enqueue(new Callback<TeamRespon>() {
            @Override
            public void onResponse(Call<TeamRespon> call, Response<TeamRespon> respon) {
                if (respon.isSuccessful() && respon.body() != null) {
                    List<ItemModel> teams = respon.body().getTeams();
                        TeamAdapter TeamAdapter = new TeamAdapter(teams);
                    rvTeam.setAdapter(TeamAdapter);
                }
            }

            @Override
            public void onFailure(Call<TeamRespon> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}