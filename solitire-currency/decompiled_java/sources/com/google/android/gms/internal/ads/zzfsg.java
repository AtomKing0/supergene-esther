package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsg {
    public static final int zza = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    public static final ClipData zzb = ClipData.newIntent("", new Intent());

    public static PendingIntent zza(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getActivity(context, 0, zzc(intent, 201326592, 0), 201326592);
    }

    public static PendingIntent zzb(Context context, int i10, Intent intent, int i11, int i12) {
        return PendingIntent.getService(context, 0, zzc(intent, i11, 0), i11);
    }

    private static Intent zzc(Intent intent, int i10, int i11) {
        zzfuu.zzf((i10 & 88) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        zzfuu.zzf((i10 & 1) == 0 || zzd(0, 3), "Cannot use Intent.FILL_IN_ACTION unless the action is marked as mutable.");
        zzfuu.zzf((i10 & 2) == 0 || zzd(0, 5), "Cannot use Intent.FILL_IN_DATA unless the data is marked as mutable.");
        zzfuu.zzf((i10 & 4) == 0 || zzd(0, 9), "Cannot use Intent.FILL_IN_CATEGORIES unless the category is marked as mutable.");
        zzfuu.zzf((i10 & 128) == 0 || zzd(0, 17), "Cannot use Intent.FILL_IN_CLIP_DATA unless the clip data is marked as mutable.");
        zzfuu.zzf(intent.getComponent() != null, "Must set component on Intent.");
        if (zzd(0, 1)) {
            zzfuu.zzf(!zzd(i10, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            zzfuu.zzf(zzd(i10, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (!zzd(i10, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzd(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzd(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzd(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzd(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzb);
            }
        }
        return intent2;
    }

    private static boolean zzd(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
