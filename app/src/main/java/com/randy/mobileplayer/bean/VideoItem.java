package com.randy.mobileplayer.bean;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/15
 * Time: 20:43
 * Description: video list item
 */

public class VideoItem implements Parcelable {

    private String path;
    private String title;
    private long duration;
    private long size;

    public static VideoItem getVideoItem(Cursor cursor) {
        // create video item
        VideoItem videoItem = new VideoItem();
        // check cursor
        if (cursor == null || cursor.getCount() == 0) {
            return videoItem;
        }
        videoItem.path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        videoItem.title = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE));
        videoItem.duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
        videoItem.size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.SIZE));
        return videoItem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.path);
        dest.writeString(this.title);
        dest.writeLong(this.duration);
        dest.writeLong(this.size);
    }

    public VideoItem() {
    }

    protected VideoItem(Parcel in) {
        this.path = in.readString();
        this.title = in.readString();
        this.duration = in.readLong();
        this.size = in.readLong();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public static final Creator<VideoItem> CREATOR = new Creator<VideoItem>() {
        @Override
        public VideoItem createFromParcel(Parcel source) {
            return new VideoItem(source);
        }

        @Override
        public VideoItem[] newArray(int size) {
            return new VideoItem[size];
        }
    };
}
