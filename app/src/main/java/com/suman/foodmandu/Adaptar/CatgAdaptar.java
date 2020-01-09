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
import com.suman.foodmandu.model.Catg;
import com.suman.foodmandu.model.Globe;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CatgAdaptar extends RecyclerView.Adapter<CatgAdaptar.CatgViewHolder> {

    Context mContext;
    List<Catg> catgs;

    public CatgAdaptar(Context mContext, List<Catg> catgs) {
        this.mContext = mContext;
        this.catgs = catgs;
    }

    @NonNull
    @Override
    public CatgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.catg,parent,false);
            return new CatgViewHolder(view1);

    }

    @Override
    public void onBindViewHolder(@NonNull CatgViewHolder holder, int position) {
        Catg catg = catgs.get(position);
        holder.catgg.setImageResource(catg.getCimage());
        holder.cattitle.setText(catg.getCtitle());
    }

    @Override
    public int getItemCount() {
        return catgs.size();
    }

    public class CatgViewHolder extends RecyclerView.ViewHolder{
        private ImageView catgg;
        private TextView cattitle;

        public CatgViewHolder(@NonNull View itemView) {
            super(itemView);
            catgg= itemView.findViewById(R.id.catgg);
            cattitle = itemView.findViewById(R.id.cattitle);

        }
    }
}
