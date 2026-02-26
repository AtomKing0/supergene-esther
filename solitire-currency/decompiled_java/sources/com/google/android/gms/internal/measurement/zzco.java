package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzco {
    public static final int zza;
    private static final int zzb;

    static {
        int i10 = Build.VERSION.SDK_INT;
        zzb = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zza = i10 >= 31 ? 33554432 : 0;
    }

    public static PendingIntent zza(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getBroadcast(context, 0, intent, i11);
    }
}
