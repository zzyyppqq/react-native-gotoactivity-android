package com.higo.zhangyp.gotoactivity;

import android.app.Activity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangyipeng on 15/12/17.
 */
// 实现跳转功能
public class GoToActivityPackage implements ReactPackage {

    //...
    private Activity activity;
    private Class classes;


    public GoToActivityPackage(Activity activity, Class classes) {
        this.activity = activity;
        this.classes = classes;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext context) {
        List<NativeModule> modules = new ArrayList<NativeModule>();
        modules.add(new GoToActivityModule(context,activity,classes));
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}


