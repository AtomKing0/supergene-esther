package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzaet {
    protected final zzadp zza;

    protected zzaet(zzadp zzadpVar) {
        this.zza = zzadpVar;
    }

    protected abstract boolean zza(zzek zzekVar) throws zzbo;

    protected abstract boolean zzb(zzek zzekVar, long j10) throws zzbo;

    public final boolean zzf(zzek zzekVar, long j10) throws zzbo {
        return zza(zzekVar) && zzb(zzekVar, j10);
    }
}
