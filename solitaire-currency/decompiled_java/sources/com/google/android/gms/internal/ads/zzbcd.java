package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzbcd {
    public static boolean zza(@Nullable zzbcl zzbclVar, @Nullable zzbci zzbciVar, String... strArr) {
        if (zzbciVar == null) {
            return false;
        }
        zzbclVar.zze(zzbciVar, com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
