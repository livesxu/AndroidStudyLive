package com.example.myapplication4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {

            Bitmap bitmap = (Bitmap)message.obj;
            ImageView imageView = findViewById(R.id.imgV);
            imageView.setImageBitmap(bitmap);
            return false;
        }
    });

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


//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
                        getRequest();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();

    }

    public void getRequest() {

        //加载图片
//        String imgString = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589708949182&di=c8d330e5619d95a573af39a793a910df&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-10-30%2F59f68513a33ca.jpg";
////        URL url = new URL(imgString);
//
//        //https://github.com/nostra13/Android-Universal-Image-Loader 三方库加载图片
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        imageLoader.init(imageLoaderConfiguration);
//        ImageView imageView = findViewById(R.id.imgV);
//        imageLoader.displayImage(imgString,imageView);

//        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//
//        InputStream inputStream = connection.getInputStream();
//
//        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//
////        Message message = new Message();
////        message.obj = bitmap;
////        handler.sendMessage(message);
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//
//                ImageView imageView = findViewById(R.id.imgV);
//                imageView.setImageBitmap(bitmap);
//            }
//        });

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                ImageView imageView = findViewById(R.id.imgV);
//                imageView.setImageBitmap(bitmap);
//            }
//        });



//         //网络请求
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
