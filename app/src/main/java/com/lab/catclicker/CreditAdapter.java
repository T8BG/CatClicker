package com.lab.catclicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.MyViewHolder>{
    public ArrayList<CreditInfo> creditInfos;
    public CreditAdapter(ArrayList<CreditInfo> creditInfos){
        this.creditInfos = creditInfos;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, link;
        ImageView pic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.catName);
            link = itemView.findViewById(R.id.catLink);
            pic = itemView.findViewById(R.id.imageView3);
        }
    }
    @NonNull
    @Override
    public CreditAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View creditInfos = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_item,parent,false);
        return new CreditAdapter.MyViewHolder(creditInfos);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditAdapter.MyViewHolder holder, int position) {
        holder.name.setText(creditInfos.get(position).getName());
        holder.link.setText(creditInfos.get(position).getLink());
        holder.pic.setImageResource(creditInfos.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return creditInfos.size();
    }
}
