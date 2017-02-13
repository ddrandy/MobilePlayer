package com.randy.mobileplayer.ui.activity;

import android.os.Handler;
import android.view.KeyEvent;

import com.randy.mobileplayer.R;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 14:36
 * Description: TODO
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new MyRunnable(), 2000);
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            startNewActivity(MainActivity.class, true);
        }
    }
}
