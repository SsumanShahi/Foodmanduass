package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.model.Details;

import java.util.List;

public class DetailsAdaptar extends RecyclerView.Adapter<DetailsAdaptar.DetailsViewHolder> {

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
                .inflate(R.layout.card_view, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        for (Details details : detailsList) {
            String imgPath = url.imagePath +  details.getImage();

            Log.d("the image link is ","this is message"+ imgPath+details.getName()+detailsList.size());


        }

        Details details = detailsList.get(position);
        String imgPath = url.imagePath +  details.getImage();

//        holder.card1.setImageResource(details.getImage());
        holder.tvtitle.setText(details.getItemtype());
        holder.tvname.setText(details.getName());
        holder.tvaddress.setText(details.getLocation());
        Glide.with(mContext).load(imgPath).into(holder.card1);



    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {

        ImageView card1;
        TextView tvtitle,
                tvaddress,tvname;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            card1 = itemView.findViewById(R.id.card1);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvname = itemView.findViewById(R.id.tvname);
            tvaddress = itemView.findViewById(R.id.tvaddress);
        }
    }
}
