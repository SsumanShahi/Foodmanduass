package com.suman.foodmandu.Adaptar;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.model.Chef;
import com.suman.foodmandu.model.Special;
import com.suman.foodmandu.strictmode.StrictModeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class SpecialAdaptar extends RecyclerView.Adapter<SpecialAdaptar.SpecialViewHolder>{
    Context mContext;
    List<Special> specials;

    public SpecialAdaptar(Context mContext, List<Special> specials) {
        this.mContext = mContext;
        this.specials = specials;
    }

    @NonNull
    @Override
    public SpecialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view3,parent,false);


        return new SpecialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialViewHolder holder, int position) {
        Special special = specials.get(position);
//        holder.card3.setImageResource(special.getImage());
        String imgPath = url.imagePath + special.getImage();
        holder.tvtitle3.setText(special.getName());
        StrictModeClass.StrictMode();
        try {
            URL url = new URL(imgPath);
            holder.card3.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return specials.size();
    }

    public class SpecialViewHolder extends RecyclerView.ViewHolder{
        private ImageView card3;
        private TextView tvtitle3;


        public SpecialViewHolder(@NonNull View itemView) {
            super(itemView);
            card3 = itemView.findViewById(R.id.card3);
            tvtitle3 = itemView.findViewById(R.id.tvtitle3);
        }
    }
}
