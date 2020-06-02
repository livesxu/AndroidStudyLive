package com.example.dagger2demo;

import dagger.Component;

//组分,表达这个组分加到哪的,这个方法相当于一个启动器,结果会生成一个DaggerF1Component

//添加绑定模块ModuleForTextView,添加绑定了button
@Component(modules = {ModuleForTextView.class,ModuleForButton.class})
public interface F1Component {

    void inject(MainActivity mainActivity);
}
