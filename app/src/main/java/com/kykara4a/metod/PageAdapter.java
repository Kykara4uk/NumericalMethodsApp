package com.kykara4a.metod;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class PageAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mFragmentList;
    ArrayList<String> mFragmentTitileList;
    PageAdapter(FragmentManager fmng){
        super(fmng);
        mFragmentList=new ArrayList<>();
        mFragmentTitileList=new ArrayList<>();
    }
    @Override
    public Fragment getItem(int position){
        return mFragmentList.get(position);
    }
    @Override
    public int getItemPosition(Object object) {
// POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitileList.add(title);
    }
    public CharSequence getPageTitle(int position){
        return mFragmentTitileList.get(position);
    }
    private HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();
/*
    @Override
    public Fragment getItem(int position) {
        if (fragmentHashMap.get(position) != null) {
            return fragmentHashMap.get(position);
        }
        TabFragment tabFragment = new TabFragment();
        fragmentHashMap.put(position, tabFragment);
        return tabFragment;
    }

 */

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment ret = (Fragment) super.instantiateItem(container, position);
        mFragmentList.set(position, ret);
        return ret;
    }
}
