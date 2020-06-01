package com.example.myapplication;

public class MainPresenter {

    MainView mainView;

    public MainPresenter(MainView view) {

        this.mainView = view;
    }

    public void doClick() {

        mainView.changeText("MVP传递文字");
    }
}
