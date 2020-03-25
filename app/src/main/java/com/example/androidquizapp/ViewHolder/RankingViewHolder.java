package com.example.androidquizapp.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidquizapp.Interface.ItemClickListener;
import com.example.androidquizapp.R;

public class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txt_name, txt_score;
    private ItemClickListener itemClickListener;
    public RankingViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_score = itemView.findViewById(R.id.txt_score);

        itemView.setOnClickListener(this);

    }

    public void setTxt_name(TextView txt_name) {
        this.txt_name = txt_name;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
