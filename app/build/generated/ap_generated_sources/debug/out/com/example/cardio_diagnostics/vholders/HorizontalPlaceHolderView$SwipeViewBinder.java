package com.example.cardio_diagnostics.vholders;

import android.widget.TextView;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import com.mindorks.placeholderview.$.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.SwipeViewBinder;
import com.mindorks.placeholderview.annotations.Keep;
import java.lang.Override;

@Keep
public class HorizontalPlaceHolderView$SwipeViewBinder extends SwipeViewBinder<HorizontalPlaceHolderView, SwipePlaceHolderView.FrameView, SwipePlaceHolderView.SwipeOption, SwipeDecor> {
  public HorizontalPlaceHolderView$SwipeViewBinder(HorizontalPlaceHolderView resolver) {
    super(resolver, R.layout.HorizontalPlaceHolderView, true);
  }

  @Override
  protected void resolveView(HorizontalPlaceHolderView resolver) {
    resolver.onResolved();
  }

  @Override
  protected void recycleView() {
    HorizontalPlaceHolderView resolver = getResolver();
  }

  @Override
  protected void unbind() {
    HorizontalPlaceHolderView resolver = getResolver();
    boolean nullable = isNullable();
    if (resolver != null && nullable) {
      resolver.txTitle = null;
      resolver.phv = null;
      setResolver(null);
      setAnimationResolver(null);
    }
  }

  @Override
  protected void bindViewPosition(HorizontalPlaceHolderView resolver, int position) {
    resolver.position = position;
  }

  @Override
  protected void bindViews(HorizontalPlaceHolderView resolver,
      SwipePlaceHolderView.FrameView itemView) {
    resolver.txTitle = (TextView)itemView.findViewById(R.id.txTitle);
    resolver.phv = (PHV)itemView.findViewById(R.id.phv);
  }

  @Override
  protected void bindClick(final HorizontalPlaceHolderView resolver,
      SwipePlaceHolderView.FrameView itemView) {
  }

  @Override
  protected void bindLongClick(final HorizontalPlaceHolderView resolver,
      SwipePlaceHolderView.FrameView itemView) {
  }

  @Override
  protected void bindSwipeView(SwipePlaceHolderView.FrameView itemView) {
  }

  @Override
  protected void bindSwipeIn(HorizontalPlaceHolderView resolver) {
  }

  @Override
  protected void bindSwipeOut(HorizontalPlaceHolderView resolver) {
  }

  @Override
  protected void bindSwipeInState() {
  }

  @Override
  protected void bindSwipeOutState() {
  }

  @Override
  protected void bindSwipeCancelState() {
  }

  @Override
  protected void bindSwipeHead(HorizontalPlaceHolderView resolver) {
  }
}
