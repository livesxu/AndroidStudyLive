package com.example.myapplication1web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView web = findViewById(R.id.webview);

        web.loadUrl("https://www.baidu.com");

        /*在webview加载网页时，不调用第三方浏览器打开的办法：
         * 设置WebViewClient，并重写WebViewClient的shouldOverrideUrlLoading方法
         * 返回true为不调用，反之 false为调用第三方浏览器
         */
        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });

        //网页中包含JavaScript内容需调用以下方法，参数为true
        web.getSettings().setJavaScriptEnabled(true);



    }
//http://itindex.net/detail/53169-android-开发-webview
    //重写onKeyDown(keyCode, event)方法 改写物理按键 返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            WebView webView = findViewById(R.id.webview);

            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
