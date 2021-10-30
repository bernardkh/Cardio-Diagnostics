package com.example.cardio_diagnostics.vholders;

import android.view.View;
import android.widget.TextView;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import com.mindorks.placeholderview.$.R;
import com.mindorks.placeholderview.ViewBinder;
import com.mindorks.placeholderview.annotations.Keep;
import java.lang.Override;

@Keep
public class HorizontalPlaceHolderView$ViewBinder extends ViewBinder<HorizontalPlaceHolderView, View> {
  public HorizontalPlaceHolderView$ViewBinder(HorizontalPlaceHolderView resolver) {
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
}
