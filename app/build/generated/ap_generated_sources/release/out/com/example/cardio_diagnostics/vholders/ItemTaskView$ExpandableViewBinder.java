package com.example.cardio_diagnostics.vholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mindorks.placeholderview.$.R;
import com.mindorks.placeholderview.ExpandableViewBinder;
import com.mindorks.placeholderview.annotations.Keep;
import java.lang.Deprecated;
import java.lang.Override;

@Keep
public class ItemTaskView$ExpandableViewBinder extends ExpandableViewBinder<ItemTaskView, View> {
  public ItemTaskView$ExpandableViewBinder(ItemTaskView resolver) {
    super(resolver, R.layout.ItemTaskView, true, false, false);
  }

  @Override
  protected void resolveView(ItemTaskView resolver) {
    resolver.onResolved();
  }

  @Override
  protected void recycleView() {
    ItemTaskView resolver = getResolver();
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
  protected void bindViewPosition(ItemTaskView resolver, int position) {
  }

  @Override
  protected void bindViews(ItemTaskView resolver, View itemView) {
    resolver.imgHolder = (ImageView)itemView.findViewById(R.id.imgHolder);
    resolver.txTitle = (TextView)itemView.findViewById(R.id.txTitle);
    resolver.txInfo = (TextView)itemView.findViewById(R.id.txInfo);
    resolver.txTime = (TextView)itemView.findViewById(R.id.txTime);
    resolver.progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    resolver.ivFavorite = (ImageView)itemView.findViewById(R.id.ivFavorite);
    resolver.removeFavorite = (ImageView)itemView.findViewById(R.id.removeFavorite);
  }

  @Override
  protected void bindClick(final ItemTaskView resolver, View itemView) {
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
  protected void bindLongClick(final ItemTaskView resolver, View itemView) {
  }

  @Override
  protected void bindParentPosition(int position) {
  }

  @Override
  protected void bindChildPosition(int position) {
  }

  @Override
  protected void bindToggle(final ItemTaskView resolver, View itemView) {
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (isExpanded()) collapse();
        else expand();
      }
    });
  }

  @Override
  protected void bindExpand(ItemTaskView resolver) {
  }

  @Override
  protected void bindCollapse(ItemTaskView resolver) {
  }
}
