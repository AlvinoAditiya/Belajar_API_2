package com.example.belajarapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamRespon> getTeams(@Query("l") String league);


}
