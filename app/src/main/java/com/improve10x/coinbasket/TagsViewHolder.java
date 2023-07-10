package com.improve10x.coinbasket;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.coinbasket.databinding.TagsItemBinding;

public class TagsViewHolder extends RecyclerView.ViewHolder {
    TagsItemBinding binding;
    public TagsViewHolder(TagsItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
