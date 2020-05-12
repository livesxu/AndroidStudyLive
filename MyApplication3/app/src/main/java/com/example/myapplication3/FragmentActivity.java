package com.example.myapplication3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class FragmentActivity extends AppCompatActivity {

    private ArrayList<TextView> textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        textViews = new ArrayList<>();
        for (int i = 0 ;i< 10;i++){

            TextView textView = new TextView(getApplicationContext());
            textView.setTextColor(Color.RED);
            textView.setText(String.format("第%d个页面",i));
            textViews.add(textView);
        }

        ViewPager viewPager = findViewById(R.id.viewpager1);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return textViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                TextView view = textViews.get(position);
                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

                container.removeView((View)object);
            }
        });


        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.fragemt_test,fragment1,"f1").commit();
    }

    public void clickAction(View view) {

        Fragment2 fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragemt_test,fragment2,"f2").commit();
    }
}
