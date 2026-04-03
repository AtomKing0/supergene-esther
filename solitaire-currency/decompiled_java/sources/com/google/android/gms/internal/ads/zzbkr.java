package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbkr implements Runnable {
    final /* synthetic */ zzbku zza;

    zzbkr(zzbku zzbkuVar) {
        this.zza = zzbkuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbku.zzc(this.zza);
    }
}
