package com.appstandbybuckets;

import android.app.usage.UsageStatsManager;
import android.os.Build;
import android.util.Log;
import android.content.Context;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AppstandbyBucketsModule.NAME)
public class AppstandbyBucketsModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AppstandbyBuckets";
  ReactApplicationContext context;

  public AppstandbyBucketsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    context = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  public String getAppStandbyBucketString(int value){
        switch (value){
            case 10: return "active";
            case 30: return "frequent";
            case 40: return "rare";
            case 45: return "restricted";
            case 20: return "working set";
            default: return "not available";
        }
    }

    @ReactMethod
    public void getAppStandbyBucket(Promise promise) {
        String str = "not available";
        if (Build.VERSION.SDK_INT >= 28) {
            UsageStatsManager statsManager = (UsageStatsManager)context.getSystemService(Context.USAGE_STATS_SERVICE);
            int value = statsManager.getAppStandbyBucket();
            Log.d("AppStandbyModule", "App Standy Status: " + value);
            str = getAppStandbyBucketString(value);
        } 
        promise.resolve(str);
    }
}
