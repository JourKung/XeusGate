package com.example.nailamundev.xeusgate;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by BenZDeV on 4/8/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());


        // Initialize thins(s) here

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
