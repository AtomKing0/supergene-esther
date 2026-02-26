package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfnq implements Runnable {
    zzfnq() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfnt.zzc != null) {
            zzfnt.zzc.post(zzfnt.zzd);
            zzfnt.zzc.postDelayed(zzfnt.zze, 200L);
        }
    }
}
