package com.lab.catclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        ShopFragmentAdapter shopFragmentAdapter = new ShopFragmentAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(shopFragmentAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });
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
                        if(UserInfo.autoAQuantity > 0)
                        {
                            UserInfo.setPoints();
                        }
                        if(UserInfo.autoBQuantity > 0)
                        {
                            UserInfo.setPoints();
                        }
                        if(UserInfo.autoCQuantity > 0)
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
