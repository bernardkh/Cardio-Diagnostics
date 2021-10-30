package com.example.cardio_diagnostics.vholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mindorks.placeholderview.$.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipeDirection;
import com.mindorks.placeholderview.SwipeDirectionalView;
import com.mindorks.placeholderview.SwipeDirectionalViewBinder;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Keep;
import java.lang.Override;

@Keep
public class ItemTaskView$DirectionalViewBinder extends SwipeDirectionalViewBinder<ItemTaskView, SwipePlaceHolderView.FrameView, SwipeDirectionalView.SwipeDirectionalOption, SwipeDecor> {
  public ItemTaskView$DirectionalViewBinder(ItemTaskView resolver) {
    super(resolver, R.layout.ItemTaskView, true);
  }

  @Override
  protected void resolveView(ItemTaskView resolver) {
    resolver.onResolved();
  }

  @Override
  protected void recycleView() {
    ItemTaskView resolver = getResolver();
  }

  @Override
  protected void unbind() {
    ItemTaskView resolver = getResolver();
    boolean nullable = isNullable();
    if (resolver != null && nullable) {
      resolver.imgHolder = null;
      resolver.txTitle = null;
      resolver.txInfo = null;
      resolver.txTime = null;
      resolver.progressBar = null;
      resolver.ivFavorite = null;
      resolver.removeFavorite = null;
      setResolver(null);
      setAnimationResolver(null);
    }
  }

  @Override
  protected void bindViewPosition(ItemTaskView resolver, int position) {
  }

  @Override
  protected void bindViews(ItemTaskView resolver, SwipePlaceHolderView.FrameView itemView) {
    resolver.imgHolder = (ImageView)itemView.findViewById(R.id.imgHolder);
    resolver.txTitle = (TextView)itemView.findViewById(R.id.txTitle);
    resolver.txInfo = (TextView)itemView.findViewById(R.id.txInfo);
    resolver.txTime = (TextView)itemView.findViewById(R.id.txTime);
    resolver.progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    resolver.ivFavorite = (ImageView)itemView.findViewById(R.id.ivFavorite);
    resolver.removeFavorite = (ImageView)itemView.findViewById(R.id.removeFavorite);
  }

  @Override
  protected void bindClick(final ItemTaskView resolver, SwipePlaceHolderView.FrameView itemView) {
    itemView.findViewById(R.id.onAdFavorites).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resolver.onAdFavorites();
      }
    });
    itemView.findViewById(R.id.onRemoveFromFavorites).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resolver.onRemoveFromFavorites();
      }
    });
    itemView.findViewById(R.id.onItemClicked).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resolver.onItemClicked();
      }
    });
  }

  @Override
  protected void bindLongClick(final ItemTaskView resolver,
      SwipePlaceHolderView.FrameView itemView) {
  }

  @Override
  protected void bindSwipeView(SwipePlaceHolderView.FrameView itemView) {
  }

  @Override
  protected void bindSwipeIn(ItemTaskView resolver) {
  }

  @Override
  protected void bindSwipeOut(ItemTaskView resolver) {
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
  protected void bindSwipeHead(ItemTaskView resolver) {
  }

  @Override
  protected void bindSwipingDirection(SwipeDirection direction) {
  }

  @Override
  protected void bindSwipeInDirectional(SwipeDirection direction) {
  }

  @Override
  protected void bindSwipeOutDirectional(SwipeDirection direction) {
  }

  @Override
  protected void bindSwipeTouch(float xStart, float yStart, float xCurrent, float yCurrent) {
  }
}
