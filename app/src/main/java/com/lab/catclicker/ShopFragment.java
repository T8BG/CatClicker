package com.lab.catclicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopFragment extends Fragment {
    private ArrayList<Upgrades> upgrades;
    int[] CatPics = {R.drawable.mio, R.drawable.funny_cat, R.drawable.milly};
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        upgrades = new ArrayList<>();
        recyclerView = view.findViewById(R.id.shopRecView);
        setUpgrades();
        setAdapter();
        return view;
    }
    private void setAdapter() {
        ShopAdapter adapter = new ShopAdapter(upgrades);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setUpgrades(){
        upgrades.add((new Upgrades("Multi Cat","add a x1.5 multiplicator","20 points",CatPics[0],20)));
        upgrades.add((new Upgrades("Funny cat","helps with clicking the cat, +5 points per click","50 points",CatPics[1],50)));
        upgrades.add((new Upgrades("Silly Cat","Autoclicks for you, bleh","100 points",CatPics[2],100)));
    }
}
