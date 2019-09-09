package com.example.zapcanteen_rev;

import android.os.Bundle;
import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class MainListView extends Activity {

    ListView lv;
    ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu);

        lv = (ListView) findViewById(R.id.lv);

        Pil = new String[]{"Seblak", "Mie Ayam", "Batagor"};
        Ltn = new String[]{"Rp 5000", "Rp 5000", "Rp 5000"};
        Gbr = new String[]{Integer.toString(R.drawable.mie),
                Integer.toString(R.drawable.mie),
                Integer.toString(R.drawable.ic_restaurant_menu_black_24dp)};

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Pil.length; i++) {
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("latin", Ltn[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(this, mylist, R.layout.isi_listview,
                new String[]{"list", "latin", "gbr"}, new int[]{R.id.tv_nama, R.id.tv_ltn, R.id.imV});
        lv.setAdapter(Adapter);
    }

}
