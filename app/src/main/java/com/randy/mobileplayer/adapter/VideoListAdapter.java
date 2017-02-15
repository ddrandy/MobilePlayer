package com.randy.mobileplayer.adapter;

import android.content.Context;
import android.database.Cursor;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.randy.mobileplayer.R;
import com.randy.mobileplayer.bean.VideoItem;
import com.randy.mobileplayer.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/14
 * Time: 15:36
 * Description: TODO
 */

public class VideoListAdapter extends CursorAdapter {
    public VideoListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public VideoListAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public VideoListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        VideoItem videoItem = VideoItem.getVideoItem(cursor);
        holder.setData(context, videoItem);
    }

    static class ViewHolder {
        @BindView(R.id.video_item_name)
        TextView mVideoItemName;
        @BindView(R.id.video_item_duration)
        TextView mVideoItemDuration;
        @BindView(R.id.video_item_size)
        TextView mVideoItemSize;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        void setData(Context context, VideoItem data) {
            mVideoItemName.setText(data.getTitle());
            mVideoItemDuration.setText(StringUtil.parseDuration(data.getDuration()));
            mVideoItemSize.setText(Formatter.formatFileSize(context, data.getSize()));
        }
    }
}
