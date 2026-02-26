package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.AdComponentFrameLayout;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class AdOptionsView extends AdComponentFrameLayout {
    private final AdOptionsViewApi mAdOptionsViewApi;

    @Keep
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout) {
        super(context);
        AdOptionsViewApi adOptionsViewApiCreateAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, this);
        this.mAdOptionsViewApi = adOptionsViewApiCreateAdOptionsView;
        attachAdComponentViewApi(adOptionsViewApiCreateAdOptionsView);
    }

    public void setIconColor(int i10) {
        this.mAdOptionsViewApi.setIconColor(i10);
    }

    public void setIconSizeDp(int i10) {
        this.mAdOptionsViewApi.setIconSizeDp(i10);
    }

    public void setSingleIcon(boolean z10) {
        this.mAdOptionsViewApi.setSingleIcon(z10);
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, Orientation orientation, int i10) {
        super(context);
        AdOptionsViewApi adOptionsViewApiCreateAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, orientation, i10, this);
        this.mAdOptionsViewApi = adOptionsViewApiCreateAdOptionsView;
        attachAdComponentViewApi(adOptionsViewApiCreateAdOptionsView);
    }
}
