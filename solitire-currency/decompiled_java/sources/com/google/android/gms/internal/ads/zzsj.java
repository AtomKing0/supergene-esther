package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(31)
final class zzsj {
    @DoNotInline
    public static void zza(zzrz zzrzVar, zznz zznzVar) {
        LogSessionId logSessionIdZza = zznzVar.zza();
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        zzrzVar.zzb.setString("log-session-id", logSessionIdZza.getStringId());
    }
}
