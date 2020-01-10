package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.strictmode.StrictModeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
//        for (Details details : detailsList) {
//            String imgPath = url.imagePath +  details.getImage();
//
//            Log.d("the image link is ","this is message"+ imgPath+details.getName()+detailsList.size());
//            String imgPath2 = url.imagePath +  details.getImage();
//            Log.e("Image path2 is :",imgPath2);
//
//        }

        Details details = detailsList.get(position);
        String imgPath = url.imagePath + details.getImage();
//        Log.e("Image path is :", "iamge patha is " + imgPath);
//        Picasso.get().load(imgPath).into(holder.card1);
//        holder.card1.setImageResource(details.getImage());
        holder.tvtitle.setText(details.getItemtype());
        holder.tvname.setText(details.getName());
        holder.tvaddress.setText(details.getLocation());

        StrictModeClass.StrictMode();
        try {
            URL url = new URL(imgPath);
            holder.card1.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Glide.with(mContext).load(imgPath).into(holder.card1);

    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {

        ImageView card1;
        TextView tvtitle,
                tvaddress, tvname;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            card1 = itemView.findViewById(R.id.card1);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvname = itemView.findViewById(R.id.tvname);
            tvaddress = itemView.findViewById(R.id.tvaddress);
        }
    }
}
