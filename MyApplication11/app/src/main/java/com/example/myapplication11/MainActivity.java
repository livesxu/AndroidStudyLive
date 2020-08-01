package com.example.myapplication11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.account.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                view.setSelected(b);
            }
        });

        activityMainBinding.password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                view.setSelected(b);
            }
        });

        activityMainBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.setSelected(!view.isSelected());
            }
        });

        TextView textView = activityMainBinding.text1;

//        https://www.jianshu.com/p/e986bc1a6b62
        //富文本
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("我的测试富文本i");
        //设置前景色
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.RED),0,2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE),2,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.GREEN),4,7, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        //设置背景色
//        spannableStringBuilder.setSpan(new BackgroundColorSpan(Color.CYAN),2,4,Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        //设置点击效果
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Toast.makeText(MainActivity.this,"12345",Toast.LENGTH_LONG).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                //去除下划线
                ds.setUnderlineText(false);
            }
        },2,4,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        //这个必须有，API对ClickableSpan类的解释里面便提到了：在TextView设置了此方法的前提下，才能选择受影响的文本范围。
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setTextSize(20);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.icon10);
        spannableStringBuilder.setSpan(new ImageSpan(this, bitmap),7,8,Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        textView.setText(spannableStringBuilder);

    }
}
