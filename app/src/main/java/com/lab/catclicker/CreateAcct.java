package com.lab.catclicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateAcct extends AppCompatActivity {

    EditText username;
    EditText password;

    Button submit;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_acct);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.editTextText3);
        password = findViewById(R.id.editTextText4);

        submit = findViewById(R.id.button3);
        back = findViewById(R.id.button5);

        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", name);
                editor.putString("password", pass);

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
                editor.putString("points", pointsString);
                editor.putString("health", healthString);
                editor.putString("itemA", itemAString);
                editor.putString("itemB", itemBString);
                editor.putString("itemC", itemCString);
                editor.putString("hasAuto", hasAuto);
                editor.putString("thinker", thinkerCount);

                editor.apply();
                editor.apply();
                Toast.makeText(getApplicationContext(), "Account details saved!", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}