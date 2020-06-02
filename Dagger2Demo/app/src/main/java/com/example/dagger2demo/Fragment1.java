package com.example.dagger2demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dagger2demo.databinding.Fragment1Binding;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

//要注入的的类，一般的解耦对象，对实例方法Inject,生成一个Fragment1_Factory

public class Fragment1 extends Fragment {

    TextView textView;
    Button button;

    @Inject
    public Fragment1(TextView textView,Button button){

        this.textView = textView;
        this.button = button;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Fragment1Binding fragment1Binding = Fragment1Binding.inflate(inflater,container,false);

        ConstraintLayout constraintLayout = (ConstraintLayout)fragment1Binding.getRoot();

        if (textView != null) {

            //右下角
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.rightToRight = R.id.content;//fragment1的ConstraintLayout id 就是 content
            layoutParams.bottomToBottom = R.id.content;
            textView.setLayoutParams(layoutParams);
            constraintLayout.addView(textView);
        }

        if (button != null) {

            //左下角
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftToLeft = R.id.content;//fragment1的ConstraintLayout id 就是 content
            layoutParams.bottomToBottom = R.id.content;
            button.setLayoutParams(layoutParams);
            constraintLayout.addView(button);
        }

        return fragment1Binding.getRoot();
    }
}
