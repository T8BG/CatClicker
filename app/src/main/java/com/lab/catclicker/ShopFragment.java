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
    int[] CatPics = {R.drawable.mio, R.drawable.funny_cat, R.drawable.doudou, R.drawable.xiaojie, R.drawable.uni, R.drawable.leroy};
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
        upgrades.add(new Upgrades("Multi-Cat","Clicks are doubled!",CatPics[0],UserInfo.getItemAQuantity(100)));
        upgrades.add(new Upgrades("Gentle-Cat", "Get 4x to your clicks :0!!!", CatPics[4],UserInfo.getItemBQuantity(350)));
        upgrades.add(new Upgrades("Funny-Cat","Clicks are worth 5 times more!!",CatPics[1],UserInfo.getItemCQuantity(1000)));
        upgrades.add(new Upgrades("Lazy-Cat","Gain a point automatically every second.",CatPics[2],UserInfo.getAutoBuy(700)));
        upgrades.add(new Upgrades("Hungry-Cat", "Gain +5 hunger points.", CatPics[3], UserInfo.getHowHungry(100)));
        upgrades.add(new Upgrades("The Thinker", "Does nothing, helps him think", CatPics[5], UserInfo.getThoughtsPrice()));
    }
}
