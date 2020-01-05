package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.foodmandu.R;
import com.suman.foodmandu.model.Details;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdaptar extends RecyclerView.Adapter<DetailsAdaptar.DetailsViewHolder>{

    Context mContext;
    List<Details> detailsList;

    public DetailsAdaptar(Context mContext, List<Details> detailsList) {
        this.mContext = mContext;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_menu,parent,false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        Details details = detailsList.get(position);
        holder.resimg.setImageResource(Integer.parseInt(details.getImage().toString()));
        holder.tvresname.setText(details.getRTitle());



    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView resimg;
        private TextView tvresname;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
//            resimg = itemView.findViewById(R.id.resimg);
//            tvresname =  itemView.findViewById(R.id.tvresname);
        }
    }
}
