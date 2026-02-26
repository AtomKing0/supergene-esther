package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfo {
    final Unsafe zza;

    zzfo(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j10);

    public abstract float zzb(Object obj, long j10);

    public abstract void zzc(Object obj, long j10, boolean z10);

    public abstract void zzd(Object obj, long j10, byte b10);

    public abstract void zze(Object obj, long j10, double d10);

    public abstract void zzf(Object obj, long j10, float f10);

    public abstract boolean zzg(Object obj, long j10);
}
