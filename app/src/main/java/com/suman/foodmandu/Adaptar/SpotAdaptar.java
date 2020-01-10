package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpotAdaptar extends RecyclerView.Adapter<SpotAdaptar.SpotViewHolder>{

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SpotViewHolder extends RecyclerView.ViewHolder {
        public SpotViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
