package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccm implements Runnable {
    final /* synthetic */ zzccn zza;

    zzccm(zzccn zzccnVar) {
        this.zza = zzccnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzu.zzy().zzc(this.zza);
    }
}
