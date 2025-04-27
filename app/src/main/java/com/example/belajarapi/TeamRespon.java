package com.example.belajarapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamRespon {
    @SerializedName("teams") // Nama Array di JSON
    private List<ItemModel> teams;

    public List<ItemModel> getTeams() {
        return teams;
    }

}
