package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationConstants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import io.sentry.protocol.ViewHierarchyNode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    @NonNull
    public static final AdSize BANNER = new AdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50, "320x50_mb");

    @NonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");

    @NonNull
    public static final AdSize LARGE_BANNER = new AdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 100, "320x100_as");

    @NonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");

    @NonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(AnimationConstants.DefaultDurationMillis, 250, "300x250_as");

    @NonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    @NonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");

    @NonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");

    @NonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");

    @NonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");

    @NonNull
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    public AdSize(int i10, int i11) {
        this(i10, i11, (i10 == -1 ? "FULL" : String.valueOf(i10)) + ViewHierarchyNode.JsonKeys.X + (i11 == -2 ? "AUTO" : String.valueOf(i11)) + "_as");
    }

    @NonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        AdSize adSizeZzd = com.google.android.gms.ads.internal.util.client.zzf.zzd(context, i10, 50, 0);
        adSizeZzd.zze = true;
        return adSizeZzd;
    }

    @NonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        int iZza = com.google.android.gms.ads.internal.util.client.zzf.zza(context, 0);
        if (iZza == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i10, 0);
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getCurrentOrientationInterscrollerAdSize(@NonNull Context context, int i10) {
        return zzj(i10, com.google.android.gms.ads.internal.util.client.zzf.zza(context, 0));
    }

    @NonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i10, int i11) {
        AdSize adSize = new AdSize(i10, 0);
        adSize.zzg = i11;
        adSize.zzf = true;
        if (i11 < 32) {
            zzm.zzj("The maximum height set for the inline adaptive ad size was " + i11 + " dp, which is below the minimum recommended value of 32 dp.");
        }
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        AdSize adSizeZzd = com.google.android.gms.ads.internal.util.client.zzf.zzd(context, i10, 50, 2);
        adSizeZzd.zze = true;
        return adSizeZzd;
    }

    @NonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        int iZza = com.google.android.gms.ads.internal.util.client.zzf.zza(context, 2);
        AdSize adSize = new AdSize(i10, 0);
        if (iZza == -1) {
            return INVALID;
        }
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeInterscrollerAdSize(@NonNull Context context, int i10) {
        return zzj(i10, com.google.android.gms.ads.internal.util.client.zzf.zza(context, 2));
    }

    @NonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        AdSize adSizeZzd = com.google.android.gms.ads.internal.util.client.zzf.zzd(context, i10, 50, 1);
        adSizeZzd.zze = true;
        return adSizeZzd;
    }

    @NonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@NonNull Context context, int i10) {
        int iZza = com.google.android.gms.ads.internal.util.client.zzf.zza(context, 1);
        AdSize adSize = new AdSize(i10, 0);
        if (iZza == -1) {
            return INVALID;
        }
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getPortraitInterscrollerAdSize(@NonNull Context context, int i10) {
        return zzj(i10, com.google.android.gms.ads.internal.util.client.zzf.zza(context, 1));
    }

    private static AdSize zzj(int i10, int i11) {
        if (i11 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i10, 0);
        adSize.zzi = i11;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(@NonNull Context context) {
        int i10 = this.zzc;
        if (i10 == -4 || i10 == -3) {
            return -1;
        }
        if (i10 == -2) {
            return zzq.zza(context.getResources().getDisplayMetrics());
        }
        zzay.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzy(context, i10);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(@NonNull Context context) {
        int i10 = this.zzb;
        if (i10 == -3) {
            return -1;
        }
        if (i10 != -1) {
            zzay.zzb();
            return com.google.android.gms.ads.internal.util.client.zzf.zzy(context, i10);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzq> creator = zzq.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    @NonNull
    public String toString() {
        return this.zzd;
    }

    final int zza() {
        return this.zzi;
    }

    final int zzb() {
        return this.zzg;
    }

    final void zzc(int i10) {
        this.zzg = i10;
    }

    final void zzd(int i10) {
        this.zzi = i10;
    }

    final void zze(boolean z10) {
        this.zzf = true;
    }

    final void zzf(boolean z10) {
        this.zzh = true;
    }

    final boolean zzg() {
        return this.zze;
    }

    final boolean zzh() {
        return this.zzf;
    }

    final boolean zzi() {
        return this.zzh;
    }

    AdSize(int i10, int i11, String str) {
        if (i10 < 0 && i10 != -1 && i10 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i10);
        }
        if (i11 < 0 && i11 != -2 && i11 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i11);
        }
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = str;
    }
}
