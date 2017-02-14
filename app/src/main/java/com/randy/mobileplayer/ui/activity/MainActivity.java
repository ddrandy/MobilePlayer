package com.randy.mobileplayer.ui.activity;

import android.graphics.Point;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.randy.mobileplayer.R;
import com.randy.mobileplayer.adapter.MainAdapter;
import com.randy.mobileplayer.ui.fragment.AudioFragment;
import com.randy.mobileplayer.ui.fragment.BaseFragment;
import com.randy.mobileplayer.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/13
 * Time: 14:32
 * Description: main activity
 */

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.main_indicator)
    View mIndicator;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.main_video)
    TextView mMainVideo;
    @BindView(R.id.main_audio)
    TextView mMainAudio;
    private MainAdapter mAdapter;

    List<BaseFragment> mFragments = new ArrayList<>();
    private int mWindowWidth;
    private int mColorGreen;
    private int mColorLight;

    @Override
    protected void initView() {
        // 初始化指示器宽度
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        mWindowWidth = point.x;
        mIndicator.getLayoutParams().width = mWindowWidth / 2;
        mIndicator.requestLayout();

    }


    @Override
    protected void initData() {
        logD("initData");
        toast("initData");
        mAdapter = new MainAdapter(getSupportFragmentManager());
        mFragments.add(new VideoFragment());
        mFragments.add(new AudioFragment());
//        mAdapter
        mAdapter.updateFragments(mFragments);
        mViewPager.setAdapter(mAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mColorGreen = getResources().getColor(R.color.colorGreen, null);
            mColorLight = getResources().getColor(R.color.colorLight, null);
        } else {
            mColorGreen = getResources().getColor(R.color.colorGreen);
            mColorLight = getResources().getColor(R.color.colorLight);
        }

        handleTitle(0);
    }

    @Override
    protected void initListener() {
        mViewPager.removeOnPageChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.main_video, R.id.main_audio})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_video:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.main_audio:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    /**
     * 处理标题动画
     *
     * @param position index of title
     */
    private void handleTitle(int position) {
        switch (position) {
            case 0:
                mMainVideo.setTextColor(mColorGreen);
                mMainAudio.setTextColor(mColorLight);

                ViewCompat.animate(mMainVideo).scaleX(1.2f).scaleY(1.2f);
                ViewCompat.animate(mMainAudio).scaleX(1).scaleY(1);

                break;
            case 1:
                mMainVideo.setTextColor(mColorLight);
                mMainAudio.setTextColor(mColorGreen);

                ViewCompat.animate(mMainAudio).scaleX(1.2f).scaleY(1.2f);
                ViewCompat.animate(mMainVideo).scaleX(1).scaleY(1);

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float percent = positionOffsetPixels / (float) mWindowWidth;
        float finalX = (percent + position) * mIndicator.getWidth();
        ViewCompat.setTranslationX(mIndicator, finalX);
    }

    @Override
    public void onPageSelected(int position) {
        handleTitle(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
