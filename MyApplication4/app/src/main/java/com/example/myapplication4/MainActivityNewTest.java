package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.io.IOException;

public class MainActivityNewTest extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    private FragmentStatePagerAdapterNewTest fragmentStatePagerAdapterNewTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new_test);

        smartTabLayout = findViewById(R.id.tablayout);

        viewPager = findViewById(R.id.pager);

        fragmentStatePagerAdapterNewTest = new FragmentStatePagerAdapterNewTest(getSupportFragmentManager(),0);

//        viewPager.setAdapter(fragmentStatePagerAdapterNewTest);
//
//        smartTabLayout.setViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Thread(new Runnable() {
            @Override
            public void run() {

                requests();
            }
        }).start();
    }

    private void requests(){

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://dili.bdatu.com/jiekou/mains/p1.html").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.v("zzz","请求失败" + call.request().url());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                NewTestPageTitleModel model = gson.fromJson(response.body().string(),NewTestPageTitleModel.class);
                fragmentStatePagerAdapterNewTest.pageModels = model.getAlbum();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        viewPager.setAdapter(fragmentStatePagerAdapterNewTest);
                        smartTabLayout.setViewPager(viewPager);
//                        fragmentStatePagerAdapterNewTest.notifyDataSetChanged();
                    }
                });
            }
        });
    }

}
