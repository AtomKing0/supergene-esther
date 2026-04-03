package com.google.android.gms.internal.measurement;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgi {

    @Nullable
    @GuardedBy("GservicesDelegateSupplier.class")
    private static zzgh zza;

    public static synchronized zzgh zza() {
        if (zza == null) {
            zza(new zzgk());
        }
        return zza;
    }

    private static synchronized void zza(zzgh zzghVar) {
        if (zza == null) {
            zza = zzghVar;
        } else {
            throw new IllegalStateException("init() already called");
        }
    }
}
