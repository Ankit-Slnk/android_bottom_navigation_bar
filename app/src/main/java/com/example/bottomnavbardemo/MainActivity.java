package com.example.bottomnavbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavbardemo.fragments.HomeFragment;
import com.example.bottomnavbardemo.fragments.PersonFragment;
import com.example.bottomnavbardemo.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);

        openFragment(PersonFragment.newInstance("",""));

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.person:
                        openFragment(PersonFragment.newInstance("",""));
                        return true;
                    case R.id.home:
                        openFragment(HomeFragment.newInstance("", ""));
                        return true;
                    case R.id.settings:
                        openFragment(SettingsFragment.newInstance("", ""));
                        return true;
                }
                return false;
            }
        });

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
