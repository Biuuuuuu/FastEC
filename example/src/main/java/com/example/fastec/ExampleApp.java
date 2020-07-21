package com.example.fastec;

import android.app.Application;
import com.example.latte_core.app.Latte;

/**
 * @author 田纪元
 */
public class ExampleApp extends Application {

    @Override
    public  void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
