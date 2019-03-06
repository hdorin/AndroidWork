package com.example.lab2_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Context;
import android.app.Activity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int selected_option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> info = new ArrayList<String>();

        info.add("Cheese - 100$/kg");
        info.add("Milk - 50$/kg");

        final TextView textView = (TextView) findViewById(R.id.mytextview);

        if(savedInstanceState != null){
            selected_option=savedInstanceState.getInt("selected_option");
            if(selected_option==0){
                textView.setText("The best cheese in town");
            }else if(selected_option==1){
                textView.setText("What cheese is made of");
            }
        }else{
            textView.setText("Select a product");
        }



        ArrayAdapter<String> info_list=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, info);
        ListView listView = (ListView) findViewById(R.id._mylistview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id==0) {
                    textView.setText("The best cheese in town");
                    selected_option=0;
                }else if(id==1){
                    textView.setText("What cheese is made of");
                    selected_option=1;
                }
            }
        });
        listView.setAdapter(info_list);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("selected_optio", selected_option);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

}
