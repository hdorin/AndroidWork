package com.example.lab2;

import android.widget.ListView;
import android.content.Context;

public class newListView extends ListView{

        public newListView(Context context) {
            super(context);
        }

        @Override
        public void setOnItemClickListener(
                android.widget.AdapterView.OnItemClickListener listener) {
            super.setOnItemClickListener(listener);
            //do something when item is clicked

        }

}

