package com.example.cardio_diagnostics.utils.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoratorNoLast extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private boolean mShowFirstDivider = false;
    private boolean mShowLastDivider = false;
    private boolean mSkipHeader = false;


    public DividerItemDecoratorNoLast(Context context, AttributeSet attrs) {
        final TypedArray a = context
                .obtainStyledAttributes(attrs, new int[]{android.R.attr.listDivider});
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    public DividerItemDecoratorNoLast(Context context, AttributeSet attrs, boolean showFirstDivider,
                                      boolean showLastDivider) {
        this(context, attrs);
        mShowFirstDivider = showFirstDivider;
        mShowLastDivider = showLastDivider;
    }

    public DividerItemDecoratorNoLast(Drawable divider) {
        mDivider = divider;
    }

    public DividerItemDecoratorNoLast(Drawable divider, boolean showFirstDivider,
                                      boolean showLastDivider) {
        this(divider);
        mShowFirstDivider = showFirstDivider;
        mShowLastDivider = showLastDivider;
    }

    public DividerItemDecoratorNoLast(Drawable divider, boolean skipHeader, boolean showFirstDivider,
                                      boolean showLastDivider) {
        this(divider);
        this.mSkipHeader = skipHeader;
        mShowFirstDivider = showFirstDivider;
        mShowLastDivider = showLastDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mDivider == null) {
            return;
        }
        if (parent.getChildPosition(view) < 1) {
            return;
        }

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.top = mDivider.getIntrinsicHeight();
        } else {
            outRect.left = mDivider.getIntrinsicWidth();
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        try{
            if (mDivider == null) {
                super.onDrawOver(c, parent, state);
                return;
            }

            int dividerLeft = parent.getPaddingLeft();
            int dividerRight = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = mShowFirstDivider ? 0 : (mSkipHeader ? 2 : 1); i <= (mShowLastDivider ? childCount - 1 : childCount - 2); i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int dividerTop = child.getBottom() + params.bottomMargin;
                int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();

                mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
                mDivider.draw(c);
            }
        }catch (Exception e){
            //TODO-----------------------
        }

    }

    private int getOrientation(RecyclerView parent) {
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
            return layoutManager.getOrientation();
        } else {
            throw new IllegalStateException(
                    "DividerItemDecoration can only be used with a LinearLayoutManager.");
        }
    }
}
