package com.hq.hsmwan.ordercommentpage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created with Android Studio.
 *
 * @time: 2017/4/17 14:51
 * @author: Qiao He (hexianqiao3755@gmail.com)
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco初始化
        Fresco.initialize(this);
    }
}
