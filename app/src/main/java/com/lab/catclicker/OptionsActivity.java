package com.lab.catclicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends Activity {
    TextView pointsGot, buttonClicked, uppies, statsTitle, audioTitle, accountTitle;
    Button returnGame;
    Button credits;
    Button saveGame;

    EditText newPass;

    Button resetPass;
    CheckBox chechRepublic;

    static boolean isPlaying = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        pointsGot = findViewById(R.id.pointsGained);
        buttonClicked = findViewById(R.id.buttonClicked);
        chechRepublic = findViewById(R.id.checkBox);
        statsTitle = findViewById(R.id.textView3);

        saveGame = findViewById(R.id.button10);

        newPass = findViewById(R.id.editTextText5);

        resetPass = findViewById(R.id.button9);

        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        credits = findViewById(R.id.button7);
        returnGame = findViewById(R.id.button6);

        if(!isPlaying)
        {
            chechRepublic.setChecked(true);
        }
        else
        {
            chechRepublic.setChecked(false);
        }
        chechRepublic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    isPlaying = false;
                }
                else
                {
                    isPlaying = true;
                }
            }
        });

        returnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ClickerActivity.class);
                startActivity(i);
            }
        });
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CatCredit.class);
                startActivity(i);
            }
        });

        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPass.getText().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                String pointsString = "" + UserInfo.getPoints();
                String healthString = "" + UserInfo.getHealth();
                String itemAString = "" + UserInfo.itemAQuantity;
                String itemBString = "" + UserInfo.itemBQuantity;
                String itemCString = "" + UserInfo.itemCQuantity;
                String hasAuto;
                if(UserInfo.isAutoActive())
                {
                    hasAuto = "true";
                }
                else
                {
                    hasAuto = "false";
                }
                String thinkerCount = "" + UserInfo.getThoughts();
                String usernameString = sharedPref.getString("username","");

                editor.putString("username", usernameString);
                editor.putString("password", newPassword);
                editor.putString("points", pointsString);
                editor.putString("health", healthString);
                editor.putString("itemA", itemAString);
                editor.putString("itemB", itemBString);
                editor.putString("itemC", itemCString);
                editor.putString("hasAuto", hasAuto);
                editor.putString("thinker", thinkerCount);

                editor.apply();
                Toast.makeText(getApplicationContext(), "Password changed!", Toast.LENGTH_LONG).show();
            }
        });

        saveGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                String pointsString = "" + UserInfo.getPoints();
                String healthString = "" + UserInfo.getHealth();
                String itemAString = "" + UserInfo.itemAQuantity;
                String itemBString = "" + UserInfo.itemBQuantity;
                String itemCString = "" + UserInfo.itemCQuantity;
                String hasAuto;
                if(UserInfo.isAutoActive())
                {
                    hasAuto = "true";
                }
                else
                {
                    hasAuto = "false";
                }
                String thinkerCount = "" + UserInfo.getThoughts();
                String usernameString = sharedPref.getString("username","");
                String passwordString = sharedPref.getString("password", "");

                editor.putString("username", usernameString);
                editor.putString("password", passwordString);
                editor.putString("points", pointsString);
                editor.putString("health", healthString);
                editor.putString("itemA", itemAString);
                editor.putString("itemB", itemBString);
                editor.putString("itemC", itemCString);
                editor.putString("hasAuto", hasAuto);
                editor.putString("thinker", thinkerCount);

                editor.apply();
                Toast.makeText(getApplicationContext(), "Game saved!", Toast.LENGTH_LONG).show();
            }
        });
    }
}