package com.example.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.dagger2demo.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //对属性注入,会根据这个属性的实例方法去创建对象,生成MainActivity_MembersInjector

    @Inject
    Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        //变动 ----->
        //创建一个TextView
        TextView textView = new TextView(this);
        textView.setText("我是要传输显示的文本");

        //创建button
        Button button = new Button(this);
        button.setText("传输过去的按钮");

        DaggerF1Component.builder().moduleForTextView(new ModuleForTextView(textView)).moduleForButton(new ModuleForButton(button)).build().inject(this);

        //变动 <-----

        //把fragment1加载到id:fragment上
        getSupportFragmentManager().beginTransaction().add(mainBinding.fragment.getId(),fragment1,"tag1").commit();

    }
}
