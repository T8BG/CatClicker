package com.lab.catclicker;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class ClickerActivity extends AppCompatActivity {
    Button shopbutton,optionbutton;
    TextView pointCounter;
    ViewPager2 viewPager2;
    UserInfo userInfo = new UserInfo();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_main);
        viewPager2 = findViewById(R.id.ClickToShop);
        shopbutton = findViewById(R.id.ButtonShop);
        optionbutton = findViewById(R.id.ButtonOptions);
        pointCounter = findViewById(R.id.PointCount);

        ShopFragmentAdapter shopFragmentAdapter = new ShopFragmentAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(shopFragmentAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });
    }


}
