package com.google.android.gms.ads.internal.util;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbx {
    private long zza;
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzbx(long j10) {
        this.zza = j10;
    }

    public final void zza(long j10) {
        synchronized (this.zzc) {
            this.zza = j10;
        }
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
            if (this.zzb + this.zza > jElapsedRealtime) {
                return false;
            }
            this.zzb = jElapsedRealtime;
            return true;
        }
    }
}
