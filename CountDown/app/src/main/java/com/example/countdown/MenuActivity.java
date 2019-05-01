package com.example.countdown;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    public void socialMediaShare(View view){
        SharedPreferences sharedPref = this.getSharedPreferences("score", Context.MODE_PRIVATE);
        int score = sharedPref.getInt("score", 0);
        String message;
        if(score==0) {
            message = "I didn't score any points in CountDown!";
        }else if(score==1){
            message = "I scored " + score + " point in CountDown!";
        }else{
            message = "I scored " + score + " points in CountDown!";
        }
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(share, "Share you highscore!"));
    }
}
