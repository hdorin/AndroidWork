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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> info = new ArrayList<String>();

        info.add("Cheese - 100$/kg");
        info.add("Milk - 50$/kg");

        final TextView textView = (TextView) findViewById(R.id.mytextview);
        textView.setText("Select a product");


        ArrayAdapter<String> info_list=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, info);
        ListView listView = (ListView) findViewById(R.id._mylistview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id==0) {
                    textView.setText("The best cheese in town");
                }else if(id==1){
                    textView.setText("What cheese is made of");
                }
            }
        });
        listView.setAdapter(info_list);


    }

}
