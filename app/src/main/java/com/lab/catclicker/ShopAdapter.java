package com.lab.catclicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        Upgrades upgrade = upgrades.get(position);
        holder.name.setText(upgrades.get(position).getName());
        holder.des.setText(upgrades.get(position).getDis());
        holder.price.setText("Price: "+ upgrades.get(position).getPriceValue());
        holder.icon.setImageResource(upgrades.get(position).getImage());
        // experimenting with lambda expressions. taken from: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
        holder.button.setOnClickListener(v -> {
            // AMI it works for every upgrade, will do later the devider for different upgrades
            // do the cat health methods so i can play around it
            if (upgrade.checkers()) {
                switch (upgrade.getName()) {
                    case "Multi-Cat":
                        UserInfo.addMult();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(2);
                        break;
                    case "Funny-Cat":
                        UserInfo.addBigMult();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(4);
                        break;
                    case "Lazy-Cat":
                        UserInfo.autoBuy();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(100);
                        break;
                    case "Hungry-Cat":
                        UserInfo.Healthy();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(2);
                        break;
                    case "Gentle-Cat":
                        UserInfo.addNiceMult();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(3);
                        break;
                    case "The Thinker":
                        UserInfo.theThinker();
                        UserInfo.payTheBills(upgrade.getPriceValue());
                        upgrade.priceIsPricier(5);
                        break;
                    default:
                        Toast.makeText(v.getContext(), "Unknown choice, try again", Toast.LENGTH_SHORT).show();
                        return;
                }

                    notifyItemChanged(position); // Refresh UI after upgrade

            } else {
                Toast.makeText(v.getContext(), "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return upgrades.size();
    }
}
