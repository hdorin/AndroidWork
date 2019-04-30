package com.example.countdown;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor sharedPrefeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        sharedPref = this.getSharedPreferences("score", Context.MODE_PRIVATE);
        sharedPrefeditor=sharedPref.edit();
        TextView high_score_view = (TextView) findViewById(R.id.high_score_view);
        int score = sharedPref.getInt("score", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(score);
        String score_string = sb.toString();
        high_score_view.setText(score_string);
    }
    public void resetScore(View view){
        TextView high_score_view = (TextView) findViewById(R.id.high_score_view);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(0);
        String score_string = sb.toString();
        high_score_view.setText(score_string);
        sharedPrefeditor.putInt("score",0);
        sharedPrefeditor.commit();
    }
}
