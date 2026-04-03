package com.vungle.ads;

import android.content.Context;
import androidx.compose.animation.core.AnimationConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdSize.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class z1 {
    private final int height;
    private boolean isAdaptiveHeight;
    private boolean isAdaptiveWidth;
    private final int width;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final z1 BANNER = new z1(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50);

    @NotNull
    public static final z1 BANNER_SHORT = new z1(AnimationConstants.DefaultDurationMillis, 50);

    @NotNull
    public static final z1 BANNER_LEADERBOARD = new z1(728, 90);

    @NotNull
    public static final z1 MREC = new z1(AnimationConstants.DefaultDurationMillis, 250);

    /* JADX INFO: compiled from: AdSize.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final z1 getAdSizeWithWidth(@NotNull Context context, int i10) {
            kotlin.jvm.internal.t.i(context, "context");
            int iIntValue = com.vungle.ads.internal.util.x.INSTANCE.getDeviceWidthAndHeightWithOrientation(context, 0).b().intValue();
            if (i10 < 0) {
                i10 = 0;
            }
            z1 z1Var = new z1(i10, iIntValue);
            if (z1Var.getWidth() == 0) {
                z1Var.setAdaptiveWidth$vungle_ads_release(true);
            }
            z1Var.setAdaptiveHeight$vungle_ads_release(true);
            return z1Var;
        }

        @NotNull
        public final z1 getAdSizeWithWidthAndHeight(int i10, int i11) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            z1 z1Var = new z1(i10, i11);
            if (z1Var.getWidth() == 0) {
                z1Var.setAdaptiveWidth$vungle_ads_release(true);
            }
            if (z1Var.getHeight() == 0) {
                z1Var.setAdaptiveHeight$vungle_ads_release(true);
            }
            return z1Var;
        }

        @NotNull
        public final z1 getAdSizeWithWidthAndMaxHeight(int i10, int i11) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            z1 z1Var = new z1(i10, i11);
            if (z1Var.getWidth() == 0) {
                z1Var.setAdaptiveWidth$vungle_ads_release(true);
            }
            z1Var.setAdaptiveHeight$vungle_ads_release(true);
            return z1Var;
        }

        @NotNull
        public final z1 getValidAdSizeFromSize(int i10, int i11, @NotNull String placementId) {
            kotlin.jvm.internal.t.i(placementId, "placementId");
            com.vungle.ads.internal.model.j placement = com.vungle.ads.internal.k.INSTANCE.getPlacement(placementId);
            if (placement != null) {
                if (!placement.isInline()) {
                    placement = null;
                }
                if (placement != null) {
                    return z1.Companion.getAdSizeWithWidthAndHeight(i10, i11);
                }
            }
            z1 z1Var = z1.MREC;
            if (i10 >= z1Var.getWidth() && i11 >= z1Var.getHeight()) {
                return z1Var;
            }
            z1 z1Var2 = z1.BANNER_LEADERBOARD;
            if (i10 >= z1Var2.getWidth() && i11 >= z1Var2.getHeight()) {
                return z1Var2;
            }
            z1 z1Var3 = z1.BANNER;
            if (i10 >= z1Var3.getWidth() && i11 >= z1Var3.getHeight()) {
                return z1Var3;
            }
            z1 z1Var4 = z1.BANNER_SHORT;
            return (i10 < z1Var4.getWidth() || i11 < z1Var4.getHeight()) ? getAdSizeWithWidthAndHeight(i10, i11) : z1Var4;
        }
    }

    public z1(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    @NotNull
    public static final z1 getAdSizeWithWidth(@NotNull Context context, int i10) {
        return Companion.getAdSizeWithWidth(context, i10);
    }

    @NotNull
    public static final z1 getAdSizeWithWidthAndHeight(int i10, int i11) {
        return Companion.getAdSizeWithWidthAndHeight(i10, i11);
    }

    @NotNull
    public static final z1 getAdSizeWithWidthAndMaxHeight(int i10, int i11) {
        return Companion.getAdSizeWithWidthAndMaxHeight(i10, i11);
    }

    @NotNull
    public static final z1 getValidAdSizeFromSize(int i10, int i11, @NotNull String str) {
        return Companion.getValidAdSizeFromSize(i10, i11, str);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAdaptiveHeight$vungle_ads_release() {
        return this.isAdaptiveHeight;
    }

    public final boolean isAdaptiveWidth$vungle_ads_release() {
        return this.isAdaptiveWidth;
    }

    public final boolean isValidSize$vungle_ads_release() {
        return this.width >= 0 && this.height >= 0;
    }

    public final void setAdaptiveHeight$vungle_ads_release(boolean z10) {
        this.isAdaptiveHeight = z10;
    }

    public final void setAdaptiveWidth$vungle_ads_release(boolean z10) {
        this.isAdaptiveWidth = z10;
    }

    @NotNull
    public String toString() {
        return "VungleAdSize(width=" + this.width + ", height=" + this.height + ')';
    }
}
