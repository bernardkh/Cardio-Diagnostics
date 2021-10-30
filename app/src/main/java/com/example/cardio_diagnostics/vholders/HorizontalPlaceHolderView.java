package com.example.cardio_diagnostics.vholders;

import android.content.Context;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.beans.TaskClass;
import com.example.cardio_diagnostics.beans.TaskItem;
import com.example.cardio_diagnostics.interfaces.ParentCallback;
import com.example.cardio_diagnostics.listeners.OnItemClickListener;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import com.example.cardio_diagnostics.utils.recyclerview.DividerDecoration;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;
import java.util.List;

@NonReusable
@Layout(R.layout.item_horizontal_placeholder_view)
public class HorizontalPlaceHolderView implements OnItemClickListener {
    private final TaskClass taskClass;
    private final ParentCallback mCallback;

    @Position
    int position;

    private Context context;

    @View(R.id.tx_title)
    TextView txTitle;

    @View(R.id.tasks_list)
    PHV phv;



    private List<Object> mList;



    public HorizontalPlaceHolderView(Context context, TaskClass _taskClass, ParentCallback _mCallback) {
        this.context = context;
        this.taskClass = _taskClass;
        this.mCallback = _mCallback;
    }

    /*
     * This method is called when the view is rendered
     * onResolved method could be named anything, Example: onAttach
     */
    @Resolve
    public void onResolved() {
        if(taskClass == null)return;
        if(mList != null && mList.size() > 0){
            phv.refresh();
            return;
        }

        phv.getBuilder()
                .setHasFixedSize(false)
                .setLayoutManager(new LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        phv.addItemDecoration(new DividerDecoration(phv.getContext(), DividerDecoration.HORIZONTAL, R.drawable.divider_horizontal_16dp,true));
        //phv.setNestedScrollingEnabled(true);

        if(taskClass.getTitle() != null){
            txTitle.setText(taskClass.getTitle());
        }
        if(taskClass.getItems() != null){
            mList = new ArrayList<>();
            for (TaskItem taskItem : taskClass.getItems()) {
                mList.add(new ItemTaskView(context, taskItem, mCallback));//, mCallback
            }
            if(mList.size() > 0){
                phv.addAll(mList);
            }
        }
    }

    @Override
    public void onAdFavorites(Object object) {
        if(mList != null && mList.size() > 0){
            phv.refresh();
        }
    }

    @Override
    public void onRemoveFromFavorites(Object object) {
        if(mList != null && mList.size() > 0){
            phv.refresh();
        }
    }

    @Override
    public void onItemClick(Object item) {

    }
}