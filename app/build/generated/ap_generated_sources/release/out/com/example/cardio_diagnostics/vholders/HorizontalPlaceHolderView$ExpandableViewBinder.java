package com.example.cardio_diagnostics.vholders;

import android.view.View;
import android.widget.TextView;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import com.mindorks.placeholderview.$.R;
import com.mindorks.placeholderview.ExpandableViewBinder;
import com.mindorks.placeholderview.annotations.Keep;
import java.lang.Deprecated;
import java.lang.Override;

@Keep
public class HorizontalPlaceHolderView$ExpandableViewBinder extends ExpandableViewBinder<HorizontalPlaceHolderView, View> {
  public HorizontalPlaceHolderView$ExpandableViewBinder(HorizontalPlaceHolderView resolver) {
    super(resolver, R.layout.HorizontalPlaceHolderView, true, false, false);
  }

  @Override
  protected void resolveView(HorizontalPlaceHolderView resolver) {
    resolver.onResolved();
  }

  @Override
  protected void recycleView() {
    HorizontalPlaceHolderView resolver = getResolver();
  }

  @Deprecated
  @Override
  protected void unbind() {
  }

  @Deprecated
  @Override
  protected void bindAnimation(int deviceWidth, int deviceHeight, View view) {
  }

  @Override
  protected void bindViewPosition(HorizontalPlaceHolderView resolver, int position) {
    resolver.position = position;
  }

  @Override
  protected void bindViews(HorizontalPlaceHolderView resolver, View itemView) {
    resolver.txTitle = (TextView)itemView.findViewById(R.id.txTitle);
    resolver.phv = (PHV)itemView.findViewById(R.id.phv);
  }

  @Override
  protected void bindClick(final HorizontalPlaceHolderView resolver, View itemView) {
  }

  @Override
  protected void bindLongClick(final HorizontalPlaceHolderView resolver, View itemView) {
  }

  @Override
  protected void bindParentPosition(int position) {
  }

  @Override
  protected void bindChildPosition(int position) {
  }

  @Override
  protected void bindToggle(final HorizontalPlaceHolderView resolver, View itemView) {
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (isExpanded()) collapse();
        else expand();
      }
    });
  }

  @Override
  protected void bindExpand(HorizontalPlaceHolderView resolver) {
  }

  @Override
  protected void bindCollapse(HorizontalPlaceHolderView resolver) {
  }
}
