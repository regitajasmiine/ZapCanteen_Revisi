package com.example.zapcanteen_rev.ui.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zapcanteen_rev.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MoreFragment extends Fragment {

    ListView lv;
    ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Gbr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ListView) view.findViewById(R.id.lvl);

        Pil = new String[]{"Notifikasi", "Feedback", "Pengaturan", "Logout"};
        Gbr = new String[]{Integer.toString(R.drawable.ic_notifications_black_24dp),
                Integer.toString(R.drawable.ic_feedback_black_24dp),
                Integer.toString(R.drawable.ic_settings_black_24dp),
                Integer.toString(R.drawable.ic_error_black_24dp)};

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Pil.length; i++) {
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(getContext(), mylist, R.layout.isi_listmore,
                new String[]{"list","gbr"}, new int[]{R.id.tv_nama, R.id.imV});
        lv.setAdapter(Adapter);
    }
}