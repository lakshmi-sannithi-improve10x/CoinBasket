package com.improve10x.coinbasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.coinbasket.databinding.ActivityCoinsBinding;
import com.improve10x.coinbasket.model.Coin;
import com.improve10x.coinbasket.network.CoinApi;
import com.improve10x.coinbasket.network.CoinServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsActivity extends AppCompatActivity implements OnItemActionListener {
    private ActivityCoinsBinding binding;
    private List<Coin> coins = new ArrayList<>();
    private CoinsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoinsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        connectAdapter();
        getCoinsApi();
    }

    private void getCoinsApi() {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinServiceApi();
        Call<List<Coin>> call = coinServiceApi.getCoins();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                Toast.makeText(CoinsActivity.this, "Success", Toast.LENGTH_SHORT).show();
                coins = response.body();
                adapter.setCoins(coins);
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(CoinsActivity.this, "Failed get coin", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.coinsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.coinsRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new CoinsAdapter();
        adapter.setCoins(coins);
        adapter.setShowActive(true);
        adapter.setActionListener(this);
    }

    @Override
    public void onClicked(String id) {
        Intent intent = new Intent(this,CoinDetailsActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}