package com.improve10x.coinbasket;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.coinbasket.databinding.TeamItemBinding;
import com.improve10x.coinbasket.model.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamViewHolder> {
    private List<Team> teams;

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TeamItemBinding teamItemBinding = TeamItemBinding.inflate(inflater,parent,false);
        TeamViewHolder viewHolder = new TeamViewHolder(teamItemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
     Team team = teams.get(position);
     holder.binding.setTeams(team);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}
