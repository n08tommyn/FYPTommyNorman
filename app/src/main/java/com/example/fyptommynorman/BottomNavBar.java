package com.example.fyptommynorman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.FrameLayout;

import android.os.Bundle;

import com.example.fyptommynorman.databinding.ActivityBottomNavBarBinding;
import com.example.fyptommynorman.databinding.ActivityMainBinding;

public class BottomNavBar extends AppCompatActivity {

    ActivityBottomNavBarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.calender:
                    replaceFragment(new CalenderFragment());
                    break;
                case R.id.expenses:
                    replaceFragment(new ExpensesFragment());
                    break;
                case R.id.message:
                    replaceFragment(new MessageFragment());
                    break;
                case R.id.tips:
                    replaceFragment(new TipsFragment());
                    break;

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNavView, fragment);
        fragmentTransaction.commit();
    }
}