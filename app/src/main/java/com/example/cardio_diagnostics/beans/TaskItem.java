package com.example.cardio_diagnostics.beans;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.core.content.ContextCompat;

import com.example.cardio_diagnostics.R;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class TaskItem implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("info")
    private String info;
    @SerializedName("time")
    private String time;
    @SerializedName("progress")
    private String progress;
    @SerializedName("image")
    private String image;
    @SerializedName("videoURL")
    private String videoURL;
    @SerializedName("pdfURL")
    private String pdfURL;

    private boolean in_favorite = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIn_favorite() {
        return in_favorite;
    }

    public void setIn_favorite(boolean in_favorite) {
        this.in_favorite = in_favorite;
    }

    public String getPdfURL() {
        return pdfURL;
    }

    public void setPdfURL(String pdfURL) {
        this.pdfURL = pdfURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public void parseJson(JSONObject MyJson){
        id = MyJson.optInt("id");
        title = MyJson.optString("title");
        info = MyJson.optString("info");
        time = MyJson.optString("time");
        progress = MyJson.optString("progress");
        image = MyJson.optString("image");
        videoURL = MyJson.optString("videoURL");
        pdfURL = MyJson.optString("pdfURL");
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.info);
        dest.writeString(this.time);
        dest.writeString(this.progress);
        dest.writeString(this.image);
        dest.writeString(this.videoURL);
        dest.writeString(this.pdfURL);
        dest.writeByte(this.in_favorite ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.title = source.readString();
        this.info = source.readString();
        this.time = source.readString();
        this.progress = source.readString();
        this.image = source.readString();
        this.videoURL = source.readString();
        this.pdfURL = source.readString();
        this.in_favorite = source.readByte() != 0;
    }

    public TaskItem() {
    }

    protected TaskItem(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.info = in.readString();
        this.time = in.readString();
        this.progress = in.readString();
        this.image = in.readString();
        this.videoURL = in.readString();
        this.pdfURL = in.readString();
        this.in_favorite = in.readByte() != 0;
    }

    public static final Creator<TaskItem> CREATOR = new Creator<TaskItem>() {
        @Override
        public TaskItem createFromParcel(Parcel source) {
            return new TaskItem(source);
        }

        @Override
        public TaskItem[] newArray(int size) {
            return new TaskItem[size];
        }
    };
}
