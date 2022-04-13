package com.mirea.lavrenov.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


public class MyLooper extends Thread {
    int delay;
    private int number = 0;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        delay = (int) System.currentTimeMillis();
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Log.d("MyLooper", (int) System.currentTimeMillis() - delay + " "+ msg.getData().getString("KEY"));
                number++;
            }
        };
        Looper.loop();
    }
}
