package com.example.countdown;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public void buttonPressed(View view) {
        Button button = (Button) findViewById(R.id.button);
        TextView countdown_view = (TextView) findViewById(R.id.countdown_view);
        if(button.getText().equals("START")) {
            button.getBackground().setColorFilter(new LightingColorFilter(0, 0xFF0000));
            button.setText("STOP");
            countdown_view.setText("5");

        }else{
            button.getBackground().setColorFilter(new LightingColorFilter(0, 0x669900));
            button.setText("START");
            countdown_view.setText("You failed!");
        }
    }
}
