package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(31)
final class zzjd {
    @DoNotInline
    public static zznz zza(Context context, zzjm zzjmVar, boolean z10, String str) {
        zznv zznvVarZzb = zznv.zzb(context);
        if (zznvVarZzb == null) {
            zzea.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zznz(LogSessionId.LOG_SESSION_ID_NONE, str);
        }
        if (z10) {
            zzjmVar.zzy(zznvVarZzb);
        }
        return new zznz(zznvVarZzb.zza(), str);
    }
}
