package com.lab.catclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class OptionsActivity extends Activity {
    TextView pointsGot, buttonClicked, uppies;
    CheckBox chechRepublic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        pointsGot = findViewById(R.id.pointsGained);
        buttonClicked = findViewById(R.id.buttonClicked);
        uppies = findViewById(R.id.upgradesBought);
        chechRepublic = findViewById(R.id.checkBox);
        if(chechRepublic.isActivated()){
            stopService(new Intent(this,BackgroundMusicService.class));
        }
        else if(!chechRepublic.isActivated()){
            startService(new Intent(this, BackgroundMusicService.class));
        }
    }
}
