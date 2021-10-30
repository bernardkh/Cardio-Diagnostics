package com.example.cardio_diagnostics.beans;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.utils.LogUtils;
import com.example.cardio_diagnostics.utils.Methods;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TaskClass implements Parcelable {


    @SerializedName("title")
    private String title;
    @SerializedName("items")
    private List<TaskItem> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TaskItem> getItems() {
        return items;
    }

    public void setItems(List<TaskItem> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeTypedList(this.items);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.items = source.createTypedArrayList(TaskItem.CREATOR);
    }

    public TaskClass() {
    }

    protected TaskClass(Parcel in) {
        this.title = in.readString();
        this.items = in.createTypedArrayList(TaskItem.CREATOR);
    }

    public static final Parcelable.Creator<TaskClass> CREATOR = new Parcelable.Creator<TaskClass>() {
        @Override
        public TaskClass createFromParcel(Parcel source) {
            return new TaskClass(source);
        }

        @Override
        public TaskClass[] newArray(int size) {
            return new TaskClass[size];
        }
    };

    public void parseJson(Context mContext, JSONObject JsonObj){
        title = JsonObj.optString("title");
        items = new ArrayList<>();
        JSONArray MyJsonArray = JsonObj.optJSONArray("items");;
        if(MyJsonArray != null) {
            int i = -1;
            int Ln = MyJsonArray.length();
            TaskItem taskItem;
            JSONObject MyJson;
            while (++i < Ln) {
                MyJson = MyJsonArray.optJSONObject(i);
                taskItem = new TaskItem();
                taskItem.parseJson(MyJson);
                items.add(taskItem);
            }
        }
        LogUtils.print("items", String.valueOf(items));

    }
}
