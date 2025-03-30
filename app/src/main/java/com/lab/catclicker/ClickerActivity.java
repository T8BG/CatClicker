package com.lab.catclicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClickerActivity extends AppCompatActivity {
    Button shopbutton,optionbutton;
    public static TextView pointCounter;
    public static TextView healthCounter;
    boolean startLoop = true;
    ViewPager2 viewPager2;

    ExecutorService executor = Executors.newFixedThreadPool(2);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_main);
        viewPager2 = findViewById(R.id.ClickToShop);
        shopbutton = findViewById(R.id.ButtonShop);
        optionbutton = findViewById(R.id.ButtonOptions);
        pointCounter = findViewById(R.id.PointCount);
        healthCounter = findViewById(R.id.HealthCount);

        SharedPreferences reader;

        ShopFragmentAdapter shopFragmentAdapter = new ShopFragmentAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(shopFragmentAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });

        reader = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String pointsValue = reader.getString("points", "");
        UserInfo.points = Integer.parseInt(pointsValue);
        String healthValue = reader.getString("health", "");
        UserInfo.health = Integer.parseInt(healthValue);
        String itemAValue = reader.getString("itemA", "");
        UserInfo.itemAQuantity = Integer.parseInt(itemAValue);
        String itemBValue = reader.getString("itemB", "");
        UserInfo.itemBQuantity = Integer.parseInt(itemBValue);
        String itemCValue = reader.getString("itemC", "");
        UserInfo.itemCQuantity = Integer.parseInt(itemCValue);
        String autoValue = reader.getString("hasAuto", "");
        if(autoValue.contains("true"))
        {
            UserInfo.autoBuy();
        }
        String thinkerValue = reader.getString("thinker", "");
        UserInfo.thoughts = Integer.parseInt(thinkerValue);
        shopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(1);
            }
        });
        optionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(i);
            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(startLoop)
                {
                    try {
                        Thread.sleep(1000);
                        if(UserInfo.isAutoActive())
                        {
                            UserInfo.setPoints();
                        }
                        pointCounter.setText("Points: " + UserInfo.getPoints());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        executor.submit(runnable);
        //Health point go down
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    while(startLoop)
                    {
                        Thread.sleep(5000);
                        UserInfo.lowerHealth();
                        healthCounter.setText("Health: " + UserInfo.getHealth());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        executor.submit(runnable2);
        executor.shutdown();
    }
}
