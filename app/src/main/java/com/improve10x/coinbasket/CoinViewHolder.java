package com.improve10x.coinbasket;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.coinbasket.databinding.CoinsItemBinding;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    CoinsItemBinding binding;
    public CoinViewHolder(CoinsItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
