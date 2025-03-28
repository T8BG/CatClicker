package com.lab.catclicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ClickerFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.clicker_fragment, container, false);
        ImageButton mainButton = view.findViewById(R.id.button4);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "test", Toast.LENGTH_LONG).show();
                //UserInfo.points++;
                UserInfo.setPoints();
                ClickerActivity.pointCounter.setText("Points: " + UserInfo.getPoints());
            }
        });
        return view;
    }
}
