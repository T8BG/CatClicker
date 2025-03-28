package com.lab.catclicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    public ArrayList<Upgrades> upgrades;

    public ShopAdapter(ArrayList<Upgrades> upgrades) {
        this.upgrades = upgrades;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,des,price;
        ImageView icon;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            des = itemView.findViewById(R.id.itemDes);
            button = itemView.findViewById(R.id.button3);
            icon = itemView.findViewById(R.id.imageView);
            price = itemView.findViewById(R.id.priceView);
        }
    }
    @NonNull
    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View upgrades = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlook,parent,false);
        return new MyViewHolder(upgrades);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.MyViewHolder holder, int position) {
        holder.name.setText(upgrades.get(position).getName());
        holder.des.setText(upgrades.get(position).getDis());
        holder.price.setText((upgrades.get(position).getPrice()));
        holder.icon.setImageResource(upgrades.get(position).getImage());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return upgrades.size();
    }
}
