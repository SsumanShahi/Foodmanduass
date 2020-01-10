package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SweetAdaptar extends RecyclerView.Adapter<SweetAdaptar.SweetViewHolder> {

    @NonNull
    @Override
    public SweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SweetViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SweetViewHolder extends RecyclerView.ViewHolder {
        public SweetViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
