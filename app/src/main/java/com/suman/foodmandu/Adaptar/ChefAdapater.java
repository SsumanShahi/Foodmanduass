package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChefAdapater extends RecyclerView.Adapter<ChefAdapater.ChefViewHolder> {

    @NonNull
    @Override
    public ChefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ChefViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ChefViewHolder extends RecyclerView.ViewHolder {
        public ChefViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
