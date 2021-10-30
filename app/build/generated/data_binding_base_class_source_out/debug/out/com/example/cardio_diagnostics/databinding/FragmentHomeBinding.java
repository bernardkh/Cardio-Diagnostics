// Generated by view binder compiler. Do not edit!
package com.example.cardio_diagnostics.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final NestedScrollView nestedScrollViewParent;

  @NonNull
  public final PHV placeHolder;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final AppCompatTextView txInfo;

  @NonNull
  public final AppCompatTextView txScore;

  @NonNull
  public final AppCompatTextView txTitle;

  private FragmentHomeBinding(@NonNull NestedScrollView rootView, @NonNull CardView cardView,
      @NonNull CardView cardView2, @NonNull NestedScrollView nestedScrollViewParent,
      @NonNull PHV placeHolder, @NonNull ProgressBar progressBar, @NonNull AppCompatTextView txInfo,
      @NonNull AppCompatTextView txScore, @NonNull AppCompatTextView txTitle) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.cardView2 = cardView2;
    this.nestedScrollViewParent = nestedScrollViewParent;
    this.placeHolder = placeHolder;
    this.progressBar = progressBar;
    this.txInfo = txInfo;
    this.txScore = txScore;
    this.txTitle = txTitle;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = rootView.findViewById(id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.cardView2;
      CardView cardView2 = rootView.findViewById(id);
      if (cardView2 == null) {
        break missingId;
      }

      NestedScrollView nestedScrollViewParent = (NestedScrollView) rootView;

      id = R.id.placeHolder;
      PHV placeHolder = rootView.findViewById(id);
      if (placeHolder == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = rootView.findViewById(id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.tx_info;
      AppCompatTextView txInfo = rootView.findViewById(id);
      if (txInfo == null) {
        break missingId;
      }

      id = R.id.tx_score;
      AppCompatTextView txScore = rootView.findViewById(id);
      if (txScore == null) {
        break missingId;
      }

      id = R.id.tx_title;
      AppCompatTextView txTitle = rootView.findViewById(id);
      if (txTitle == null) {
        break missingId;
      }

      return new FragmentHomeBinding((NestedScrollView) rootView, cardView, cardView2,
          nestedScrollViewParent, placeHolder, progressBar, txInfo, txScore, txTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}