package com.lab.catclicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickerActivity extends Activity {
    Button clickerbutton,shopbutton,optionbutton;
    TextView pointCounter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_main);
        clickerbutton = findViewById(R.id.ClickerButton);
        shopbutton = findViewById(R.id.ButtonShop);
        optionbutton = findViewById(R.id.ButtonOptions);
        pointCounter = findViewById(R.id.PointCount);
        clickerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
