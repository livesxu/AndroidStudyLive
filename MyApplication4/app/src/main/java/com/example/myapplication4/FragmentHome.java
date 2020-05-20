package com.example.myapplication4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_home,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
//                .add("第一个页面", TestFragment.class)
//                .add("第二个页面", TestFragment.class)
//                .create());

        HomePagerAdapter adapter = new HomePagerAdapter(getActivity().getSupportFragmentManager(),0);

        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) getActivity().findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        viewPagerTab.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                Log.v("zzz","" + position);
            }
        });
    }
}
