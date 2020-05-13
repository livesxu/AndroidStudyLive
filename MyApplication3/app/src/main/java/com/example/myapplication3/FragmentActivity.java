package com.example.myapplication3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentActivity extends AppCompatActivity {

    private ArrayList<TextView> textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

//        textViews = new ArrayList<>();
//        for (int i = 0 ;i< 10;i++){
//
//            TextView textView = new TextView(getApplicationContext());
//            textView.setTextColor(Color.RED);
//            textView.setText(String.format("第%d个页面",i));
//            textViews.add(textView);
//        }
//
//        ViewPager viewPager = findViewById(R.id.viewpager1);
//        viewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return textViews.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//                return view == object;
//            }
//
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//                TextView view = textViews.get(position);
//                container.addView(view);
//
//                return view;
//            }
//
//            @Override
//            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//
//                container.removeView((View)object);
//            }
//        });


        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString("key","传输的文本内容展示");
        fragment1.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragemt_test,fragment1,"f1").commit();
    }

    public void f1ButtonAction() {

        Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentByTag("f1");
        fragment1.onData(new Fragment1.CallBack() {
            @Override
            public void getResult(String string) {

                Log.v("zzz",string);
            }
        });
    }

    public void clickAction(View view) {

        Fragment2 fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragemt_test,fragment2,"f2").commit();
    }
}
