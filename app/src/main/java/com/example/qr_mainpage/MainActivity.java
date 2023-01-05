package com.example.qr_mainpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.qr_mainpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item-> {

            switch(item.getItemId()){

                case R.id.studenthome:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.studentsearch:
                    replaceFragment(new SearchFragment());
                    break;

                case R.id.studentQR:
                    replaceFragment(new QRFragment());
                    break;

                case R.id.studentHistory:
                    replaceFragment(new HistoryFragment());
                    break;

                case R.id.studentAccount:
                    replaceFragment(new AccountFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentmanager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}