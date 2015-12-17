package com.higo.zhangyp.gotoactivity;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by zhangyipeng on 15/12/17.
 */

public class GoToActivityModule extends ReactContextBaseJavaModule {

    //...
    private Activity activity;
    private Class classes;

    public GoToActivityModule(ReactApplicationContext reactContext, Activity activity, Class classes) {
        super(reactContext);
        this.activity = activity;
        this.classes = classes;
    }

    @ReactMethod
    public void gotoActivityFunc(Callback callback) {

        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, classes);
        activity.startActivity(intent);
        callback.invoke("success");


    }

    @ReactMethod
    public void gotoActivity() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, classes);
        activity.startActivity(intent);

    }


    @Override
    public String getName() {
        return "GoToActivity";
    }
}