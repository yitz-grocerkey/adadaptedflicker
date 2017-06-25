package com.grocerkey.adapadapted.adadaptedflicker;

import android.app.Application;

import com.adadapted.android.sdk.AdAdapted;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yitz on 6/25/2017.
 */

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        Map<String, String> params = new HashMap<>();
        params.put("store_id", "18682f17-b953-4466-9083-41a26141f864");

        AdAdapted.init()
                .withAppId(getString(R.string.ad_adapted_app_id))
                .inEnv(BuildConfig.DEBUG ? AdAdapted.Env.DEV : AdAdapted.Env.PROD)
                .withParams(params)
                .start(getApplicationContext());
    }
}
