package com.example.zapcanteen_rev.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zapcanteen_rev.R;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zapcanteen_rev.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFragment extends Fragment {

    ListView lv;
    ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ListView) view.findViewById(R.id.lv);

        Pil = new String[]{"Seblak", "Mie Ayam", "Batagor", "Es buah", "Nasi Kuning","Lontong Sayur"};
        Ltn = new String[]{"Rp 5000", "Rp 5000", "Rp 5000", "Rp 5000", "Rp 5000", "Rp 5000"};
        Gbr = new String[]{Integer.toString(R.drawable.seblak),
                Integer.toString(R.drawable.mie),
                Integer.toString(R.drawable.batagor),
                Integer.toString(R.drawable.jus),
                Integer.toString(R.drawable.naskun),
                Integer.toString(R.drawable.lontong)};

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Pil.length; i++) {
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("latin", Ltn[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(getContext(), mylist, R.layout.isi_listview,
                new String[]{"list", "latin", "gbr"}, new int[]{R.id.tv_nama, R.id.tv_ltn, R.id.imV});
        lv.setAdapter(Adapter);
    }
}