package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public class zzv extends zzu {
    @VisibleForTesting
    static final boolean zze(int i10, int i11, int i12) {
        return Math.abs(i10 - i11) <= i12;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final boolean zzd(Activity activity, Configuration configuration) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeo)).booleanValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeq)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        int iZzy = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, configuration.screenHeightDp);
        int iZzy2 = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzu.zzp();
        DisplayMetrics displayMetricsZzt = zzt.zzt(windowManager);
        int i10 = displayMetricsZzt.heightPixels;
        int i11 = displayMetricsZzt.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int iRound = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzem)).intValue();
        return (zze(i10, iZzy + dimensionPixelSize, iRound) && zze(i11, iZzy2, iRound)) ? false : true;
    }
}
