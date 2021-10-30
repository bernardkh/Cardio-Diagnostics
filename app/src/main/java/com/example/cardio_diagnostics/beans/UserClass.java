package com.example.cardio_diagnostics.beans;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.ViewModel;

public class UserClass extends ViewModel implements Parcelable {

    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
    private String complete;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getComplete() {
        return this.completed?"Completed":"Not Completed";
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.userId);
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeValue(this.completed);
        dest.writeString(this.complete);
    }

    public void readFromParcel(Parcel source) {
        this.userId = (Integer) source.readValue(Integer.class.getClassLoader());
        this.id = (Integer) source.readValue(Integer.class.getClassLoader());
        this.title = source.readString();
        this.completed = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.complete = source.readString();
    }

    public UserClass() {
    }

    protected UserClass(Parcel in) {
        this.userId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.completed = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.complete = in.readString();
    }

    public static final Parcelable.Creator<UserClass> CREATOR = new Parcelable.Creator<UserClass>() {
        @Override
        public UserClass createFromParcel(Parcel source) {
            return new UserClass(source);
        }

        @Override
        public UserClass[] newArray(int size) {
            return new UserClass[size];
        }
    };
}
