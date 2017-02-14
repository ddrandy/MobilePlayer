package com.randy.mobileplayer.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.randy.mobileplayer.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/14
 * Time: 13:31
 * Description: TODO
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments = new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void updateFragments(@NonNull List<BaseFragment> fragments) {
        mFragments.clear();
        mFragments.addAll(fragments);
        notifyDataSetChanged();
    }
}
