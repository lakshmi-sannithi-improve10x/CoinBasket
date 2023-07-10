package com.improve10x.coinbasket;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.coinbasket.databinding.TagsItemBinding;
import com.improve10x.coinbasket.model.Tags;

import java.util.List;

public class TagsAdapter extends RecyclerView.Adapter<TagsViewHolder> {

    private List<Tags> tags;

    public void setTags(List<Tags> tags) {
        this.tags = tags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TagsItemBinding tagsItemBinding = TagsItemBinding.inflate(inflater,parent,false);
        TagsViewHolder viewHolder = new TagsViewHolder(tagsItemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagsViewHolder holder, int position) {
      Tags tags1 = tags.get(position);
      holder.binding.setTags(tags1);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
