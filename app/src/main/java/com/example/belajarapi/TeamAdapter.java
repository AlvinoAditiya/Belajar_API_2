package com.example.belajarapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<ItemModel> teamList;

    public TeamAdapter(List<ItemModel> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent , false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel team = teamList.get(position);
        holder.tvTeam.setText(teamList.get(position).getTeam());
        holder.tvStadium.setText(teamList.get(position).getStadium());


        // Gambar (bonus)
        Glide.with(holder.itemView.getContext())
                .load(teamList.get(position).getImage())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTeam, tvStadium;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTeam = itemView.findViewById(R.id.tvTeam);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
