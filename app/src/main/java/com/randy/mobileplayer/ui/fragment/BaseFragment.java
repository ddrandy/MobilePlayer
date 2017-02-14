package com.randy.mobileplayer.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randy.mobileplayer.util.LogUtil;
import com.randy.mobileplayer.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/14
 * Time: 13:35
 * Description: TODO
 */

public abstract class BaseFragment extends Fragment {

    private Context mContext;
    private Unbinder mUnBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        mUnBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDestroyView() {
        mUnBinder.unbind();
        super.onDestroyView();
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

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();
}
