package com.example.lab2_new;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    }
    public void savePreferences(View view){
        Switch optiunea1= findViewById(R.id.optiunea1);
        Switch optiunea2= findViewById(R.id.optiunea2);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("optiunea1", optiunea1.isChecked());
        editor.putBoolean("optiunea2", optiunea2.isChecked());
        editor.commit();

    }
    public void savePreferencesCache(View view) throws IOException {
        Switch optiunea1 = findViewById(R.id.optiunea1);
        Switch optiunea2 = findViewById(R.id.optiunea2);

        File chache = new File(getCacheDir(), "options");

        FileWriter fw = new FileWriter(chache.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("optiunea1: "+optiunea1.isChecked()+"\n");
        bw.write("optiunea2: "+optiunea2.isChecked());
        bw.close();

        FileReader fr = new FileReader(chache.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.readLine());
        System.out.println(br.readLine());

        br.close();
    }
}
