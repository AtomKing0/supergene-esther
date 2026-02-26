package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfus implements Serializable {
    zzfus() {
    }

    public static zzfus zzc() {
        return zzfud.zza;
    }

    public static zzfus zzd(Object obj) {
        return obj == null ? zzfud.zza : new zzfuz(obj);
    }

    public abstract zzfus zza(zzful zzfulVar);

    public abstract Object zzb(Object obj);
}
