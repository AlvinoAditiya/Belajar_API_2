package com.example.belajarapi;

import com.google.gson.annotations.SerializedName;

public class ItemModel {

    @SerializedName("strTeam") // Nama Key di JSON
    private String Team;

    @SerializedName("strStadium") // Nama Key di JSON
    private String Stadium;

    @SerializedName("strBadge") // Nama Key di JSON
    private String Image;

    public String getTeam() {
        return Team;
    }

    public String getStadium() {
        return Stadium;
    }

    public String getImage() {
        return Image;
    }
}
