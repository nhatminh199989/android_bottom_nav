package com.example.btvn_bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static androidx.viewpager.widget.ViewPager.*;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager();
        bottomNavigationView.setOnNavigationItemSelectedListener( (item) -> {
            switch (item.getItemId()){
                case R.id.nav_home:{
                    viewPager.setCurrentItem(0);
                    break;
                }
                case R.id.nav_list:{
                    viewPager.setCurrentItem(1);
                    break;
                }
            }
            return true;
        });
    }

    public void setupViewPager(){
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewpagerAdapter);
        viewPager.addOnPageChangeListener(new OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:{
                        bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    }
                    case 1:{
                        bottomNavigationView.getMenu().findItem(R.id.nav_list).setChecked(true);
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}