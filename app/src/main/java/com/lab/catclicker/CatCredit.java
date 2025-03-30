package com.lab.catclicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatCredit extends AppCompatActivity {
    public ArrayList<CreditInfo> creditInfos;
    Button back;
    RecyclerView recyclerView;
    int[] CatPics = {R.drawable.mio, R.drawable.funny_cat, R.drawable.doudou, R.drawable.xiaojie, R.drawable.uni, R.drawable.leroy, R.drawable.milly};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cat_credit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        creditInfos = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        setUpgrades();
        setAdapter();
        back = findViewById(R.id.button8);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatCredit.this.finish();
            }
        });

    }
    private void setAdapter() {
        CreditAdapter adapter = new CreditAdapter(creditInfos);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setUpgrades(){
        creditInfos.add(new CreditInfo("Mio", "Sasha's cat", CatPics[0]));
        creditInfos.add(new CreditInfo("Funny cat", "appears every time someone use jxtwitter", CatPics[1]));
        creditInfos.add(new CreditInfo("Doudou", "https://www.instagram.com/sansanmaoer/", CatPics[2]));
        creditInfos.add(new CreditInfo("Xiaojie", "https://www.instagram.com/xiaojie_milk/", CatPics[3]));
        creditInfos.add(new CreditInfo("Uni", "https://www.instagram.com/unico_uniuni/", CatPics[4]));
        creditInfos.add(new CreditInfo("Leroy", "https://www.instagram.com/leroy.dacat/", CatPics[5]));
        creditInfos.add(new CreditInfo("Milly", "https://www.instagram.com/fatfatmillycat/", CatPics[6]));
    }
}