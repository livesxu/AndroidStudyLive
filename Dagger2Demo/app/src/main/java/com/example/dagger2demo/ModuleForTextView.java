package com.example.dagger2demo;

import android.widget.TextView;

import dagger.Module;
import dagger.Provides;

//一个模块

@Module
public class ModuleForTextView {

    TextView textView;

    public ModuleForTextView(TextView textView){

        this.textView = textView;
    }

    //依赖的传参，通过providexxx将其返回
    @Provides
    TextView provideTextView() {

        return this.textView;
    }
}
