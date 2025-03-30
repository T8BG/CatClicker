package com.lab.catclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class OptionsActivity extends Activity {
    TextView pointsGot, buttonClicked, uppies;
    Button returnGame;
    Button credits;
    CheckBox chechRepublic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        pointsGot = findViewById(R.id.pointsGained);
        buttonClicked = findViewById(R.id.buttonClicked);
        uppies = findViewById(R.id.upgradesBought);
        chechRepublic = findViewById(R.id.checkBox);

        credits = findViewById(R.id.button7);
        returnGame = findViewById(R.id.button6);
        if(chechRepublic.isActivated()){
            stopService(new Intent(this,BackgroundMusicService.class));
        }
        else if(!chechRepublic.isActivated()){
            startService(new Intent(this, BackgroundMusicService.class));
        }

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CatCredit.class);
                startActivity(i);
            }
        });
    }
}
