package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.foodmandu.R;
import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.model.Globe;

import java.util.List;

import retrofit2.http.GET;

public class GlobeAdaptar extends RecyclerView.Adapter<GlobeAdaptar.GlobeViewHolder>{

    Context mContext;
    List<Globe> globes;

    public GlobeAdaptar(Context mContext, List<Globe> globes) {
        this.mContext = mContext;
        this.globes = globes;
    }

    @NonNull
    @Override
    public GlobeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card4,parent,false);
        return new GlobeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlobeViewHolder holder, int position) {
        Globe globe = globes.get(position);
        holder.card4.setImageResource(globe.getGimage());
        holder.tvtitle4.setText(globe.getgTitle());
        holder.tvcountry.setText(globe.getgCountry());
        holder.tvaaddress.setText(globe.getgAddress());
    }

    @Override
    public int getItemCount() {
        return globes.size();
    }

    public class GlobeViewHolder extends RecyclerView.ViewHolder{

        private ImageView card4;
        private TextView tvtitle4,tvcountry,tvaaddress;

        public GlobeViewHolder(@NonNull View itemView) {
            super(itemView);

            card4= itemView.findViewById(R.id.card4);
            tvtitle4 = itemView.findViewById(R.id.tvtitle4);
            tvcountry = itemView.findViewById(R.id.tvcountry);
            tvaaddress = itemView.findViewById(R.id.tvaaddress);


        }
    }
}
