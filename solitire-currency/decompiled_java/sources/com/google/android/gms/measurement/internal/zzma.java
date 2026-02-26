package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzma implements Runnable {
    private final /* synthetic */ zzlx zza;

    zzma(zzlx zzlxVar) {
        this.zza = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzal();
    }
}
