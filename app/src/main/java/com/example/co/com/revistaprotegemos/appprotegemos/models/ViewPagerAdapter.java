package com.example.co.com.revistaprotegemos.appprotegemos.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASPIRE VX15 on 26/02/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

private final List<Fragment> lstFragment = new ArrayList<>();
private final List<String> lsTitles=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lsTitles.size();
    }
    public CharSequence getPageTitle(int position)
    {
        return super.getPageTitle(position);
    }
    public void AddFragment(Fragment fragment,String title)
    {
        lstFragment.add(fragment);
        lsTitles.add(title);
    }

}
