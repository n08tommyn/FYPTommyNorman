package com.example.fyptommynorman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fyptommynorman.databinding.ActivityBottomNavBarBinding;
import com.example.fyptommynorman.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavBar extends AppCompatActivity {
    private ActivityBottomNavBarBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFrag(new HomeFragment());
        binding.navigationBar.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.homeIc:
                    replaceFrag(new HomeFragment());
                    break;
                case R.id.moneyIc:
                    replaceFrag(new MoneyFragment());
                    break;
                case R.id.tipsIc:
                    replaceFrag(new TipsFragment());
                    break;

                case R.id.billsIc:
                    replaceFrag(new BillsFragment());
                    break;

                case R.id.messageIc:
                    replaceFrag(new MessageFragment());
                    break;

            }
            return true;

        });
    }

    private void replaceFrag(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }


}