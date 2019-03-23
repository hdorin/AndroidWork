package com.example.lab2_new;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         sharedPref = this.getSharedPreferences("settings",Context.MODE_PRIVATE);
        setContentView(R.layout.activity_settings);
        Switch optiunea1= findViewById(R.id.optiunea1);
        Switch optiunea2= findViewById(R.id.optiunea2);

        optiunea1.setChecked(sharedPref.getBoolean("optiunea1",false));
        optiunea2.setChecked(sharedPref.getBoolean("optiunea2",false));
        System.out.println(sharedPref.getBoolean("optiunea1",false));
    }
    public void savePreferences(View view){
        Switch optiunea1= findViewById(R.id.optiunea1);
        Switch optiunea2= findViewById(R.id.optiunea2);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("optiunea1", optiunea1.isChecked());
        editor.putBoolean("optiunea2", optiunea2.isChecked());
        editor.commit();
        System.out.println("Saved" + optiunea1.isChecked());
    }
}
