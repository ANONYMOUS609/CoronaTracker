package com.example.coronatracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.example.coronatracker.fragments.CountFragment;
import com.example.coronatracker.fragments.HomeFragment;
import com.example.coronatracker.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CoordinatorLayout coordinatorLayout;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
//        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
//        progressBar_main = (ProgressBar) findViewById(R.id.progress_bar_mainAct);
        bottomNavigationView.setItemIconTintList(null);


        final HomeFragment homeFragment = new HomeFragment();
        final SearchFragment searchFragment = new SearchFragment();
        final CountFragment countFragment = new CountFragment();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commit();

        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home:
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                fragment = homeFragment;
                            }
                        });

                        break;

                    case R.id.search:
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                fragment = searchFragment;
                            }
                        });

                        break;

                    case R.id.countries:
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                fragment = countFragment;
                            }
                        });

                        break;

                }
//                    assert fragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true;
            }

        });
    }

    @Override
    public void onBackPressed() {

        BottomNavigationView bottomNavigationView1 = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        int selectedItemId = bottomNavigationView1.getSelectedItemId();

        if (R.id.home != selectedItemId) {

            setHomeItem(MainActivity.this);
        } else {
            super.onBackPressed();
        }
    }

    public static void setHomeItem(Activity activity) {

        BottomNavigationView bottomNavigationView1 = (BottomNavigationView) activity.findViewById(R.id.bottomNavigation);
        bottomNavigationView1.setSelectedItemId(R.id.home);
    }

}
