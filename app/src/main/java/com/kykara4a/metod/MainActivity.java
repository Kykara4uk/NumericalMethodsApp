package com.kykara4a.metod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.os.VibrationEffect;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar, toolbartab;
    TabLayout tablayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    SharedPreferences mSettings;
    int currentTab;
    ArrayList<Profile> profiles;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_PROFILE = "Nickname";
    Vibrator vibrator;
    int dayNightInt;
    String dayNight;
    Set<String> labs;
    ArrayList<String> labsArray;
    ArrayList<Fragment> fragments;
    int currentTabNew;
    int tabsCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mSettings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        dayNight = mSettings.getString("list_day_night", "2");
        dayNightInt = Integer.parseInt(dayNight);
        switch (dayNightInt) {
            case 0:
                if (AppCompatDelegate.getDefaultNightMode()!=AppCompatDelegate.MODE_NIGHT_NO) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                break;
            case 1:
                if (AppCompatDelegate.getDefaultNightMode()!=AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                break;
            case 2:
                if (AppCompatDelegate.getDefaultNightMode()!=AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
                break;
            case 3:
                if (AppCompatDelegate.getDefaultNightMode()!=AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                }
                break;
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        toolbartab = (Toolbar) findViewById(R.id.toolbartab);
        tablayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        profiles = new ArrayList<>();

        labs = mSettings.getStringSet("list_labs", null);
        labsArray = new ArrayList<String>();
        if (labs!=null) {
            for (String str : labs)
                labsArray.add(str);
        } else {
            labsArray.add("0");
            labsArray.add("1");
            labsArray.add("2");
            labsArray.add("3");
            labsArray.add("4");
            labsArray.add("5");
            labsArray.add("6");
        }

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        fragments = new ArrayList<>();
        tabsCounter = 0;
        if (labs!=null){
            if (labsArray.contains("0")){
                pageAdapter.addFragment(new FirstLabFragment(),"1");
                tabsCounter+=1;
            }
            if (labsArray.contains("1")){
                pageAdapter.addFragment(new SecondLabFragment(),"2");
                tabsCounter+=1;
            }
            if (labsArray.contains("2")){
                pageAdapter.addFragment(new ThirdLabFragment(),"3");
                tabsCounter+=1;
            }
            if (labsArray.contains("3")){
                pageAdapter.addFragment(new ForthLabFragment(),"4");
                tabsCounter+=1;
            }
            if (labsArray.contains("4")){
                pageAdapter.addFragment(new FivethLabFragment(),"5");
                tabsCounter+=1;
            }
            if (labsArray.contains("5")){
                pageAdapter.addFragment(new SixthLabFragment(),"6");
                tabsCounter+=1;
            }
            if (labsArray.contains("6")){
                pageAdapter.addFragment(new RGRFragment(),"РГР");
                tabsCounter+=1;
            }
        } else {
            pageAdapter.addFragment(new FirstLabFragment(), "1");
            pageAdapter.addFragment(new SecondLabFragment(), "2");
            pageAdapter.addFragment(new ThirdLabFragment(), "3");
            pageAdapter.addFragment(new ForthLabFragment(), "4");
            pageAdapter.addFragment(new FivethLabFragment(), "5");
            pageAdapter.addFragment(new SixthLabFragment(), "6");
            pageAdapter.addFragment(new RGRFragment(),"РГР");
            tabsCounter+=6;
        }
        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        tablayout.setupWithViewPager(viewPager);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentTab = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Profile profile = new Profile();
        if (labs != null&&labsArray.size()>0){
            currentTabNew = Integer.parseInt(labsArray.get(currentTab));
         } else

    {
        currentTabNew = currentTab;
    }
        if (labsArray.size()>0) {
            switch (currentTabNew) {
                case 0:
                    FirstLabFragment firstLabFragment = (FirstLabFragment) pageAdapter.getItem(currentTab);
                    profile = firstLabFragment.getData(profile);
                    //FirstLabFragment firstLabFragment1 = (FirstLabFragment) fragments.get(0);
                    //profile = firstLabFragment1.getData(profile);
                    break;
                case 1:
                    SecondLabFragment secondLabFragment = (SecondLabFragment) pageAdapter.getItem(currentTab);
                    profile = secondLabFragment.getData(profile);
                    break;

                case 2:
                    ThirdLabFragment thirdLabFragment = (ThirdLabFragment) pageAdapter.getItem(currentTab);
                    profile = thirdLabFragment.getData(profile);
                    break;

                case 3:
                    ForthLabFragment forthLabFragment = (ForthLabFragment) pageAdapter.getItem(currentTab);
                    profile = forthLabFragment.getData(profile);
                    break;

                case 4:
                    FivethLabFragment fivethLabFragment = (FivethLabFragment) pageAdapter.getItem(currentTab);
                    profile = fivethLabFragment.getData(profile);
                    break;

                case 5:
                    SixthLabFragment sixthLabFragment = (SixthLabFragment) pageAdapter.getItem(currentTab);
                    profile = sixthLabFragment.getData(profile);
                    break;
                case 6:
                    RGRFragment rgrFragment = (RGRFragment) pageAdapter.getItem(currentTab);
                    profile = rgrFragment.getData(profile);
                    break;



            }
        }
        int id = item.getItemId();
        if (id == R.id.save){
            Intent intent = new Intent(MainActivity.this, ProfilesActivity.class);
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(profile);
            intent.putExtra("profile", json1);
            intent.putExtra("TYPE", 0);
            SharedPreferences.Editor editor = mSettings.edit();
            intent.putExtra("currentTab", currentTab);
            editor.putString("currentProfile", json1);
            editor.apply();
            startActivity(intent);
        } else if (id == R.id.upload){
            if (loadData().size()!=0) {
                Intent intent = new Intent(MainActivity.this, ProfilesActivity.class);
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(profile);
                intent.putExtra("profile", json1);
                intent.putExtra("TYPE", 1);
                intent.putExtra("currentTab", currentTab);
                startActivity(intent);
            } else {
                vibro();
                Toast.makeText(MainActivity.this, getResources().getString(R.string.no_save_profiles), Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.settings){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            /*
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(profile);
            intent.putExtra("profile", json1);
            intent.putExtra("TYPE", 1);
            intent.putExtra("currentTab", currentTab);

             */
            startActivity(intent);
        }
        return true;
    }
    public ArrayList<Profile> loadData(){
        Gson gson = new Gson();
        String json = mSettings.getString("profiles", null);
        Type type = new TypeToken<ArrayList<Profile>>() {}.getType();
        ArrayList<Profile> profiles = gson.fromJson(json, type);
        if (profiles == null){
            profiles = new ArrayList<>();
        }
        return profiles;
    }
    public void vibro(){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(200);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("currentTab", currentTab);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();


        int currentTabTemp = mSettings.getInt("currentTab", -1);
        int childs = viewPager.getChildCount();
        if ((currentTabTemp != -1)&&(currentTabTemp<tabsCounter)) {
            viewPager.setCurrentItem(currentTabTemp);
        }
    }

}