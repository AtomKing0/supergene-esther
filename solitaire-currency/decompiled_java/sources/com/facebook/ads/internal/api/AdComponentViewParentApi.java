package com.facebook.ads.internal.api;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@UiThread
public interface AdComponentViewParentApi extends AdComponentView {
    void bringChildToFront(View view);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onMeasure(int i10, int i11);

    void onVisibilityChanged(View view, int i10);

    void setMeasuredDimension(int i10, int i11);
}
