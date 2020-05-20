package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Main2Activity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    FragmentHome fragmentHome;
    FragmentDashBoard fragmentDashBoard;
    FragmentNotifications fragmentNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(getFragmentHome());
                fragmentTransaction.hide(getFragmentDashBoard());
                fragmentTransaction.hide(getFragmentNotifications());
                if (item.getItemId() == R.id.navigation_home) {

                    fragmentTransaction.show(getFragmentHome());
                }

                if (item.getItemId() == R.id.navigation_dashboard) {

                    fragmentTransaction.show(getFragmentDashBoard());
                }

                if (item.getItemId() == R.id.navigation_notifications) {

                    fragmentTransaction.show(getFragmentNotifications());
                }
                fragmentTransaction.commit();

                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }

    public FragmentHome getFragmentHome() {

        if (fragmentHome == null) {

            fragmentHome = new FragmentHome();
            fragmentTransaction.add(R.id.fragment,fragmentHome,"home");
        }

        return fragmentHome;
    }

    public FragmentDashBoard getFragmentDashBoard() {

        if (fragmentDashBoard == null) {

            fragmentDashBoard = new FragmentDashBoard();
            fragmentTransaction.add(R.id.fragment,fragmentDashBoard,"dashboard");
        }
        return fragmentDashBoard;
    }

    public FragmentNotifications getFragmentNotifications() {

        if (fragmentNotifications == null) {

            fragmentNotifications = new FragmentNotifications();
            fragmentTransaction.add(R.id.fragment,fragmentNotifications,"notification");
        }

        return fragmentNotifications;
    }
}
