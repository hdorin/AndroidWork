package com.example.lab2_new;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Context;
import android.app.Activity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected static final String EXTRA_MESSAGE = "extra_message";
    private int selected_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> info = new ArrayList<String>();


        info.add("Cheese - 100$/kg");
        info.add("Milk - 50$/kg");

        final TextView textView = (TextView) findViewById(R.id.mytextview);


        if (savedInstanceState != null) {
            selected_option = savedInstanceState.getInt("selected_option");
            if (selected_option == 0) {
                textView.setText("The best cheese in town");
            } else if (selected_option == 1) {

            }
        } else{
            textView.setText("Select a product");
        }


        ArrayAdapter<String> info_list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info);
        ListView listView = (ListView) findViewById(R.id._mylistview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {
                    textView.setText("The best cheese in town");
                    selected_option = 0;

                } else if (id == 1) {
                    textView.setText("What cheese is made of");
                    selected_option = 1;

                }
            }
        });
        listView.setAdapter(info_list);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("selected_option", selected_option);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final TextView textView = (TextView) findViewById(R.id.mytextview);

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.sensors:
                intent = new Intent(this, SensorsActivity.class);
                startActivity(intent);
                return true;
            case R.id.login:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Connect");
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.alert_layout,null));
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) { System.out.println("You pressed OK"); }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return true;
            case R.id.camera:
                intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "You pressed the button!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
