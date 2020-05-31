package com.example.myapplication4;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentStatePagerAdapterNewTest extends FragmentStatePagerAdapter {

    public List<NewTestPageTitleModel.AlbumBean> pageModels;

    public List<NewTestPageTitleModel.AlbumBean> getPageModels() {

        if (pageModels == null) {

            pageModels = new ArrayList<>();
        }
        return pageModels;
    }

    public FragmentStatePagerAdapterNewTest(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new NewTestFragment(getPageModels().get(position).getId());
    }

    @Override
    public int getCount() {
        return getPageModels().size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return getPageModels().get(position).getTitle();
    }
}
