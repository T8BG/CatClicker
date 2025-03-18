package com.lab.catclicker;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText enterName;
    EditText enterPass;

    Button login;
    Button createAcct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        enterName = findViewById(R.id.editTextText);
        enterPass = findViewById(R.id.editTextText2);

        login = findViewById(R.id.button);
        createAcct = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterName.getText().toString().toUpperCase().equals("ADMIN") && enterPass.getText().toString().toUpperCase().equals("ADMIN"))
                {
                    Intent i = new Intent(getApplicationContext(), ClickerActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}