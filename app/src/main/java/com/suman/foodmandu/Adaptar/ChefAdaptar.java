package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.foodmandu.R;
import com.suman.foodmandu.model.Chef;
import com.suman.foodmandu.model.Details;

import java.util.List;

public class ChefAdaptar extends RecyclerView.Adapter<ChefAdaptar.ChefViewHolder>{

    Context mContext;
    List<Chef> chefList;

    public ChefAdaptar(Context mContext, List<Chef> chefList) {
        this.mContext = mContext;
        this.chefList = chefList;
    }

    @NonNull
    @Override
    public ChefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view1,parent,false);


        return new ChefViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChefViewHolder holder, int position) {

        Chef chef1 = chefList.get(position);
        holder.card2.setImageResource(chef1.getChefimage());
    }

    @Override
    public int getItemCount() {
        return chefList.size();
    }

    public class ChefViewHolder extends RecyclerView.ViewHolder{

        private ImageView card2;

        public ChefViewHolder(@NonNull View itemView) {
            super(itemView);

            card2= itemView.findViewById(R.id.card2);
        }
    }
}
