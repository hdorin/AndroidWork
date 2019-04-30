package com.example.countdown;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private static int SPLASH_TME_OUT;
    private static int SPLASH_TME_OUT_LAST;
    private static int global_value;
    private static long start_millis,stop_millis;
    private static int score=0;
    SharedPreferences sharedPref;
    SharedPreferences.Editor sharedPrefeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        sharedPref = this.getSharedPreferences("score",Context.MODE_PRIVATE);
        sharedPrefeditor = sharedPref.edit();
    }
    public void buttonPressed(View view) {
        Button button = (Button) findViewById(R.id.button);
        TextView countdown_view = (TextView) findViewById(R.id.countdown_view);
        TextView score_view = (TextView) findViewById(R.id.score_view);

        if(button.getText().equals("START")) {
            button.getBackground().setColorFilter(new LightingColorFilter(0, 0xFF0000));
            button.setText("STOP");
            Random rand=new Random();

            SPLASH_TME_OUT = rand.nextInt(1500)+500;
            SPLASH_TME_OUT_LAST = SPLASH_TME_OUT/4;
             start_millis = System.currentTimeMillis();

            countdown_view.setText("5");
            global_value=4;
            countDown(4);


        }else{
            stop_millis= System.currentTimeMillis();
            /*System.out.println("--------------");
            System.out.println(start_millis);
            System.out.println(start_millis + 5*SPLASH_TME_OUT+SPLASH_TME_OUT_LAST);
            System.out.println(stop_millis);
            System.out.println("--------------");*/
            if(start_millis + 5*SPLASH_TME_OUT-SPLASH_TME_OUT_LAST <= stop_millis){
                countdown_view.setText("You won!");
                score+=1;
                if(sharedPref.getInt("score",0)<score){
                    sharedPrefeditor.putInt("score",score);
                    sharedPrefeditor.commit();
                }
            }else{
                countdown_view.setText("You failed!");
                score=0;
            }
            score_view.setText("Score: " + score);
            button.getBackground().setColorFilter(new LightingColorFilter(0, 0x669900));
            button.setText("START");


        }
    }
    private void countDown(final int value){
        Button button = (Button) findViewById(R.id.button);
        if(value>=global_value&&button.getText()=="STOP"){
            if (value >= 0) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Button button = (Button) findViewById(R.id.button);
                        TextView countdown_view = (TextView) findViewById(R.id.countdown_view);
                        if(value>=global_value&&button.getText()=="STOP") {

                            String string_value;
                            if (value >= 2) {
                                string_value = Integer.toString(value);
                            } else {
                                string_value = "-";
                            }
                            countdown_view.setText(string_value);
                            global_value = global_value - 1;
                            countDown(value - 1);
                        }
                    }
                }, SPLASH_TME_OUT);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Button button = (Button) findViewById(R.id.button);
                        TextView countdown_view = (TextView) findViewById(R.id.countdown_view);
                        TextView score_view = (TextView) findViewById(R.id.score_view);
                        if(value>=global_value&&button.getText()=="STOP") {
                            score=0;
                            score_view.setText("Score: " + score);
                            countdown_view.setText("You failed!");
                            button.getBackground().setColorFilter(new LightingColorFilter(0, 0x669900));
                            button.setText("START");
                        }
                    }
                }, SPLASH_TME_OUT_LAST);
            }
        }
    }
}
