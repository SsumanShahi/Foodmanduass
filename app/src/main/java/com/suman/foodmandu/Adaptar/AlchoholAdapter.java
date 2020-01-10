package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlchoholAdapter extends RecyclerView.Adapter<AlchoholAdapter.AlchoholViewHolder> {

    @NonNull
    @Override
    public AlchoholViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlchoholViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AlchoholViewHolder extends RecyclerView.ViewHolder{

        public AlchoholViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
