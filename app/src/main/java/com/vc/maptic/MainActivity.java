package com.vc.maptic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //---------------------------------code attribution---------------------------------
    //Author:   Technical Skillz
    //Link:     https://www.youtube.com/watch?v=JT8jKshHVXU

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView mainBottomNav = findViewById(R.id.bottom_navigation);
        mainBottomNav.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapFragment()).commit();

    }


    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = item -> {
        Fragment frag = null;

        if (item.getItemId() == R.id.map) {
            frag = new MapFragment();
        }
        else if (item.getItemId() == R.id.filters) {
            frag = new FiltersFragment();
        }
        else if (item.getItemId() == R.id.settings) {
            frag = new SettingsFragment();
        }
        else if (item.getItemId() == R.id.favourites) {
            frag = new FavouritesFragment();
        }
        assert frag != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag).commit();

        return true;
    };

    //--------------------------------------end-----------------------------------------

}