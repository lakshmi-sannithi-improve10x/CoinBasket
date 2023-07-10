package com.improve10x.coinbasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.coinbasket.databinding.ActivityCoinDetailsBinding;
import com.improve10x.coinbasket.databinding.ActivityCoinsBinding;
import com.improve10x.coinbasket.model.Coin;
import com.improve10x.coinbasket.model.Tags;
import com.improve10x.coinbasket.model.Team;
import com.improve10x.coinbasket.network.CoinApi;
import com.improve10x.coinbasket.network.CoinServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDetailsActivity extends AppCompatActivity {
    private ActivityCoinDetailsBinding binding;
    private String id;
    private TagsAdapter tagsAdapter;
    private List<Tags> tags = new ArrayList<>();
    private TeamsAdapter teamsAdapter;
    private List<Team> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoinDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra("id")) {
            id = getIntent().getStringExtra("id");
            binding.setShowActive(true);
        }
        setupTagsAdapter();
        connectTagsRv();
        setupTeamsAdapter();
        connectTeamsRv();
        getCoinDetails(id);
    }

    private void connectTeamsRv() {
        binding.teamsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.teamsRv.setAdapter(teamsAdapter);
    }

    private void setupTeamsAdapter() {
        teamsAdapter = new TeamsAdapter();
        teamsAdapter.setTeams(teams);
    }

    private void connectTagsRv() {
        binding.tagRv.setLayoutManager(new GridLayoutManager(this, 3));
        binding.tagRv.setAdapter(tagsAdapter);
    }

    private void setupTagsAdapter() {
        tagsAdapter = new TagsAdapter();
        tagsAdapter.setTags(tags);
    }

    private void getCoinDetails(String id) {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinServiceApi();
        Call<Coin> call = coinServiceApi.getCoinDetails(id);
        call.enqueue(new Callback<Coin>() {
            @Override
            public void onResponse(Call<Coin> call, Response<Coin> response) {
                tagsAdapter.setTags(response.body().getTags());
                teamsAdapter.setTeams(response.body().getTeams());
                binding.setCoin(response.body());
            }

            @Override
            public void onFailure(Call<Coin> call, Throwable t) {
                Toast.makeText(CoinDetailsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}