package com.example.connorglennon.firstapidemo.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connorglennon.firstapidemo.R;
import com.example.connorglennon.firstapidemo.data.network.model.CakeModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Connor Glennon on 22/11/2017.
 */

public class CakeAdapter extends RecyclerView.Adapter {

    private List<CakeModel> cakes;
    private int rv_row_cake_details;
    private Context applicationContext;

    public CakeAdapter(List<CakeModel> cakes, int rv_row_cake_details, Context applicationContext) {
        this.cakes = cakes;
        this.rv_row_cake_details = rv_row_cake_details;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(applicationContext).inflate(rv_row_cake_details, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        CakeModel cakeModel = cakes.get(position);

        Log.i("BINDHOLDER", holder.toString());
        Log.i("BINDMYHOLDER", myViewHolder.tvTitle.toString());

        myViewHolder.tvTitle.setText(cakeModel.getTitle());
        myViewHolder.tvDesc.setText(cakeModel.getDesc());
        Picasso.with(applicationContext).load(cakeModel.getImage()).into(myViewHolder.ivImage);
    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc;

        ImageView ivImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.title);
            this.tvDesc = (TextView) itemView.findViewById(R.id.desc);
            this.ivImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
