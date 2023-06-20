package com.improve10x.coinbasket;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.coinbasket.databinding.CoinsItemBinding;
import com.improve10x.coinbasket.model.Coin;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    private List<Coin> coins;
    private Boolean showActive = false;

    public void setShowActive(Boolean showActive) {
        this.showActive = showActive;
        notifyDataSetChanged();
    }

    public void setCoins(List<Coin> coins){
        this.coins = coins;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CoinsItemBinding coinsItemBinding = CoinsItemBinding.inflate(inflater,parent,false);
        CoinViewHolder viewHolder = new CoinViewHolder(coinsItemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
      Coin coin = coins.get(position);
      holder.binding.setCoin(coin);
      holder.binding.setShowActive(true);
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }
}
