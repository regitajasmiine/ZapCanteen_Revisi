package com.example.zapcanteen_rev;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.zapcanteen_rev.ui.favorite.FavoriteFragment;
import com.example.zapcanteen_rev.ui.home.HomeFragment;
import com.example.zapcanteen_rev.ui.menu.MenuFragment;
import com.example.zapcanteen_rev.ui.more.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new MenuFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new FavoriteFragment();
                break;

            case R.id.navigation_more:
                fragment = new MoreFragment();
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
