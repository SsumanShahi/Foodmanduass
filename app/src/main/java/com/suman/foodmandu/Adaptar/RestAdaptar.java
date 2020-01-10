package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestAdaptar extends RecyclerView.Adapter<RestAdaptar.RestViewHolder> {

    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RestViewHolder extends RecyclerView.ViewHolder {
        public RestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
