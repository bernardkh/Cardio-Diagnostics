package com.example.cardio_diagnostics.utils.placeHolderView;

import android.content.Context;
import android.util.AttributeSet;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class PHV extends InfinitePlaceHolderView {
    public PHV(Context context) {
        super(context);
    }

    public PHV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PHV(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void addAll(List<Object> items) {
        for (Object item : items) {
            addView(item);
        }
    }

    public void addAll(int index, List<Object> items) {
        int indexToAdd = index;
        for (int i = 0; i < items.size(); i++) {
            Object item = items.get(i);
            addView(indexToAdd, item);
            indexToAdd += 1;
        }
    }

    public void removeViewsFromList(int startIndex, int count) {
        for (int i = 0; i < count; i++) {
            removeView(startIndex);// We are deleting from the start, the second item will become the first and so on ...
            refresh();
        }
    }

    public void removeViewsFromList(int startIndex) {
        while(getChildCount() > (startIndex+1)){
            removeView(startIndex);
        }
        /*for (int i = 0; i < count; i++) {
            removeView(startIndex);// We are deleting from the start, the second item will become the first and so on ...
        }*/
    }
}
