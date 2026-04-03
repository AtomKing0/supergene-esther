package com.facebook.ads.internal.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView {

    @Nullable
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    public AdNativeComponentView(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i10, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i10, int i11) {
                AdNativeComponentView.super.onMeasure(i10, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i10) {
                AdNativeComponentView.super.onVisibilityChanged(view, i10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z10) {
                AdNativeComponentView.super.onWindowFocusChanged(z10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i10, int i11) {
                AdNativeComponentView.super.setMeasuredDimension(i10, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10) {
                AdNativeComponentView.super.addView(view, i10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10, int i11) {
                AdNativeComponentView.super.addView(view, i10, i11);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view);
        } else {
            super.addView(view);
        }
    }

    protected void attachAdComponentViewApi(AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi != null) {
            throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
        }
        adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
        this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.bringChildToFront(view);
        } else {
            super.bringChildToFront(view);
        }
    }

    public abstract View getAdContentsView();

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onAttachedToWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onDetachedFromWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onMeasure(i10, i11);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onVisibilityChanged(view, i10);
        } else {
            super.onVisibilityChanged(view, i10);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void onWindowFocusChanged(boolean z10) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onWindowFocusChanged(z10);
        } else {
            super.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(layoutParams);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i10, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i10, int i11) {
                AdNativeComponentView.super.onMeasure(i10, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i10) {
                AdNativeComponentView.super.onVisibilityChanged(view, i10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z10) {
                AdNativeComponentView.super.onWindowFocusChanged(z10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i10, int i11) {
                AdNativeComponentView.super.setMeasuredDimension(i10, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10) {
                AdNativeComponentView.super.addView(view, i10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i10, int i11) {
                AdNativeComponentView.super.addView(view, i10, i11);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i10) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i10);
        } else {
            super.addView(view, i10);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i102, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i102, int i11) {
                AdNativeComponentView.super.onMeasure(i102, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i102) {
                AdNativeComponentView.super.onVisibilityChanged(view, i102);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z10) {
                AdNativeComponentView.super.onWindowFocusChanged(z10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i102, int i11) {
                AdNativeComponentView.super.setMeasuredDimension(i102, i11);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102) {
                AdNativeComponentView.super.addView(view, i102);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102, int i11) {
                AdNativeComponentView.super.addView(view, i102, i11);
            }
        };
    }

    @RequiresApi(api = 21)
    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i102, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i102, int i112) {
                AdNativeComponentView.super.onMeasure(i102, i112);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i102) {
                AdNativeComponentView.super.onVisibilityChanged(view, i102);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z10) {
                AdNativeComponentView.super.onWindowFocusChanged(z10);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i102, int i112) {
                AdNativeComponentView.super.setMeasuredDimension(i102, i112);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102) {
                AdNativeComponentView.super.addView(view, i102);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i102, int i112) {
                AdNativeComponentView.super.addView(view, i102, i112);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.ViewManager, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i10, int i11) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i10, i11);
        } else {
            super.addView(view, i10, i11);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }
}
