package com.example.myapplication4;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    public ArrayList<DiliModel> dilis;

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        DiliModel model = dilis.get(position);
        String requestUrl = String.format("http://dili.bdatu.com/jiekou/albums/a%s.html",model.id);
        return new TestFragment(requestUrl);//http://dili.bdatu.com/jiekou/albums/a2173.html
    }

    @Override
    public int getCount() {
        if (dilis == null) {
            return 0;
        }
        return dilis.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        DiliModel model = dilis.get(position);

        return model.title;
    }
}
