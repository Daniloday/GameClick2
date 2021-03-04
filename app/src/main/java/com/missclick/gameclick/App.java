package com.missclick.gameclick;

import android.app.Application;

import com.missclick.gameclick.dagger2.AppComponent;
import com.missclick.gameclick.dagger2.AppModule;
import com.missclick.gameclick.dagger2.DaggerAppComponent;


public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
