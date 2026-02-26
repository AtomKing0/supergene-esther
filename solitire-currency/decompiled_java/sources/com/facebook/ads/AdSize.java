package com.facebook.ads;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class AdSize implements Serializable {
    private final int UNDEFINED;

    @Nullable
    private AdSizeApi mAdSizeApi;
    private final int mInitHeight;
    private final int mInitSizeType;
    private final int mInitWidth;

    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(4);
    public static final AdSize INTERSTITIAL = new AdSize(100);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(5);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(6);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(7);

    public AdSize(int i10, int i11) {
        this.UNDEFINED = -1;
        this.mInitSizeType = -1;
        this.mInitWidth = i10;
        this.mInitHeight = i11;
    }

    public static AdSize fromWidthAndHeight(int i10, int i11) {
        AdSize adSize = INTERSTITIAL;
        if (adSize.getHeight() == i11 && adSize.getWidth() == i10) {
            return adSize;
        }
        AdSize adSize2 = BANNER_320_50;
        if (adSize2.getHeight() == i11 && adSize2.getWidth() == i10) {
            return adSize2;
        }
        AdSize adSize3 = BANNER_HEIGHT_50;
        if (adSize3.getHeight() == i11 && adSize3.getWidth() == i10) {
            return adSize3;
        }
        AdSize adSize4 = BANNER_HEIGHT_90;
        if (adSize4.getHeight() == i11 && adSize4.getWidth() == i10) {
            return adSize4;
        }
        AdSize adSize5 = RECTANGLE_HEIGHT_250;
        if (adSize5.getHeight() == i11 && adSize5.getWidth() == i10) {
            return adSize5;
        }
        throw new IllegalArgumentException("Can't create AdSize using this width = " + i10 + " && height = " + i11);
    }

    private AdSizeApi getAdSizeApi(int i10) {
        if (this.mAdSizeApi == null) {
            this.mAdSizeApi = DynamicLoaderFactory.makeLoaderUnsafe().createAdSizeApi(i10);
        }
        return this.mAdSizeApi;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return getWidth() == adSize.getWidth() && getHeight() == adSize.getHeight();
    }

    public int getHeight() {
        int i10 = this.mInitSizeType;
        return i10 != -1 ? getAdSizeApi(i10).getHeight() : this.mInitHeight;
    }

    public int getWidth() {
        int i10 = this.mInitSizeType;
        return i10 != -1 ? getAdSizeApi(i10).getWidth() : this.mInitWidth;
    }

    public int hashCode() {
        return (getWidth() * 31) + getHeight();
    }

    private AdSize(int i10) {
        this.UNDEFINED = -1;
        this.mInitSizeType = i10;
        this.mInitWidth = -1;
        this.mInitHeight = -1;
    }
}
