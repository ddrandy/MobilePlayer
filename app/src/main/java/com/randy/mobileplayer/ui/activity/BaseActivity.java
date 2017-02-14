package com.randy.mobileplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.randy.mobileplayer.util.LogUtil;
import com.randy.mobileplayer.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 14:02
 * Description: base abstract activity
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnBinder;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnBinder = ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        mUnBinder.unbind();
        super.onDestroy();
    }

    /**
     * @param cls      activity to start
     * @param isFinish is finish self
     */
    protected void startNewActivity(Class<?> cls, boolean isFinish) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.setClass(this, cls);
        startActivity(mIntent);
        if (isFinish) {
            finish();
        }
    }

    /**
     * print log in debug level
     *
     * @param msg
     */
    protected void logD(String msg) {
        LogUtil.logD(getClass().getSimpleName(), msg);
    }

    /**
     * toast message
     *
     * @param msg message to toast
     */
    protected void toast(String msg) {
        ToastUtil.showS(msg);
    }

    /**
     * init view
     */
    protected abstract void initView();

    /**
     * init data
     */
    protected abstract void initData();

    /**
     * init listener
     */
    protected abstract void initListener();

    /**
     * get content view res id
     *
     * @return content view res id
     */
    protected abstract int getLayoutResID();
}
