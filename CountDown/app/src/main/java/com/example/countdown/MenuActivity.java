package com.example.countdown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void newGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void showHighScore(View view){
        Intent intent = new Intent(this, HighScoreActivity.class);
        startActivity(intent);
    }
}
