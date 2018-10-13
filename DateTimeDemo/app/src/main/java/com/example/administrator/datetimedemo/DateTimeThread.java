package com.example.administrator.datetimedemo;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2018/10/13.
 */

public class DateTimeThread extends Thread{
    private OnDateTimelistener listener;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (listener !=null){
                        listener.onDateTime();
                    }
                    break;
            }
        }
    };
    public DateTimeThread(OnDateTimelistener listener) {
        this.listener = listener;
    }
    @Override
    public void run() {
        super.run();
        do {
            try {
                Thread.sleep(1000);
                Message msg = new Message();
                msg.what = 1;
                mHandler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);


    }
}
