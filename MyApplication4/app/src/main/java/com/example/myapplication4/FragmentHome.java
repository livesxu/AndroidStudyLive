package com.example.myapplication4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class DiliModel {

    public String id;
    public String title;
    public String url;
    public String addtime;
}

public class FragmentHome extends Fragment {


    private ViewPager viewPager;
    private HomePagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("zzz","home onCreate");
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessage (String event) {

        Log.v("zzz","收到event + " + event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void refreshTabs (ArrayList<DiliModel> dilis) {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.v("zzz","home onDestroy");

        EventBus.getDefault().unregister(this);
    }

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

        new Thread(new Runnable() {
            @Override
            public void run() {

                //地理示例
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("http://dili.bdatu.com/jiekou/mains/p1.html").build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(),"请求获取地理信息失败",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String string = response.body().string();

                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            JSONArray jsonArray = jsonObject.getJSONArray("album");
                            ArrayList<DiliModel> list1 = new ArrayList<>();
                            for (int i = 0;i < jsonArray.length(); i ++) {

                                JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
                                DiliModel model1 = new DiliModel();
                                model1.id = jsonObject1.getString("id");
                                model1.title = jsonObject1.getString("title");
                                model1.url = jsonObject1.getString("url");
                                model1.addtime = jsonObject1.getString("addtime");
                                list1.add(model1);
                            }
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    adapter = new HomePagerAdapter(getActivity().getSupportFragmentManager(),0);
                                    adapter.dilis = list1;

                                    viewPager = (ViewPager)getActivity().findViewById(R.id.viewpager);
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
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
    }
}
