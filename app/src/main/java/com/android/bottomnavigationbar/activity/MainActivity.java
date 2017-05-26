package com.android.bottomnavigationbar.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.bottomnavigationbar.R;
import com.android.bottomnavigationbar.fragment.HomeFragment;
import com.android.bottomnavigationbar.fragment.OffersFragment;
import com.android.bottomnavigationbar.fragment.ProfileFragment;
import com.android.bottomnavigationbar.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, OffersFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, HomeFragment.newInstance());
        fragmentTransaction.commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        fragment = HomeFragment.newInstance();
                        break;
                    case R.id.menu_offers:
                        fragment = OffersFragment.newInstance();
                        break;
                    case R.id.menu_search:
                        fragment = SearchFragment.newInstance();
                        break;
                    case R.id.menu_profile:
                        fragment = ProfileFragment.newInstance();
                        break;
                }
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }
}
