package com.suman.foodmandu.Adaptar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlavourAdaptar extends RecyclerView.Adapter<AlchoholAdapter.AlchoholViewHolder>{

    @NonNull
    @Override
    public AlchoholAdapter.AlchoholViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlchoholAdapter.AlchoholViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FlavourViewHolder extends RecyclerView.ViewHolder{

        public FlavourViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
