package com.randy.mobileplayer.ui.fragment;

import android.widget.ListView;

import com.randy.mobileplayer.R;

import butterknife.BindView;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/14
 * Time: 13:45
 * Description: TODO
 */

public class VideoFragment extends BaseFragment {
    @BindView(R.id.lv_video)
    ListView mLvVideo;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
