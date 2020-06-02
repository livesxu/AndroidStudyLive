package com.example.dagger2demo;

import android.widget.Button;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleForButton {

    Button button;

    public ModuleForButton(Button button) {
        this.button = button;
    }

    @Provides
    Button provideButton(){

        return this.button;
    }
}
