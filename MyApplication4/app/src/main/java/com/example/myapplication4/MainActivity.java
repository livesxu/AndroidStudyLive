package com.example.myapplication4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        getRequest();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

    }

    public void getRequest() throws IOException {

        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589708949182&di=c8d330e5619d95a573af39a793a910df&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-10-30%2F59f68513a33ca.jpg");

        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = connection.getInputStream();

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = findViewById(R.id.imgV);
                imageView.setImageBitmap(bitmap);
            }
        });




//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder().url("http://192.168.200.103:8080/info").build();
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//
//                Log.v("zzz","请求失败：" + e.getMessage());
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, Response response) throws IOException {
//
//                if (response.isSuccessful()){
//
//                    String string = response.body().string();
//
//                    Log.v("zzz",string);
//                }
//            }
//        });
    }

}
