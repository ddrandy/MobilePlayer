package com.randy.mobileplayer.ui.fragment;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.randy.mobileplayer.R;
import com.randy.mobileplayer.adapter.VideoListAdapter;
import com.randy.mobileplayer.bean.VideoItem;
import com.randy.mobileplayer.ui.activity.VideoPlayActivity;
import com.randy.mobileplayer.util.Constants;

import butterknife.BindView;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/14
 * Time: 13:45
 * Description: TODO
 */

public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.lv_video_list)
    ListView mLvVideoList;
    private VideoListAdapter mAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        mAdapter = new VideoListAdapter(getContext(), null);
    }

    @Override
    protected void initData() {
        ContentResolver contentResolver = getContext().getContentResolver();
        AsyncQueryHandler handler = new MyQueryHandler(contentResolver);
        handler.startQuery(0, mAdapter, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.SIZE
        }, null, null, null);
    }

    @Override
    protected void initListener() {
        mLvVideoList.setAdapter(mAdapter);
        mLvVideoList.setOnItemClickListener(this);
    }

    @Override
    public void onDestroy() {
        mAdapter.changeCursor(null);
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        VideoItem videoItem = VideoItem.getVideoItem((Cursor) parent.getItemAtPosition(position));
        Intent intent = new Intent(getContext(), VideoPlayActivity.class);
        intent.putExtra(Constants.KEY_VIDEO_ITEM, videoItem);
        startActivity(intent);
    }

    static class MyQueryHandler extends AsyncQueryHandler {
        MyQueryHandler(ContentResolver cr) {
            super(cr);
        }

        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            // 设置数据
            // 刷新
            ((VideoListAdapter) cookie).swapCursor(cursor);
        }
    }

}
