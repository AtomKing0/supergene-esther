package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcbe {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzx)).longValue());
    private boolean zzc = true;

    zzcbe() {
    }

    public final void zza(SurfaceTexture surfaceTexture, final zzcap zzcapVar) {
        if (zzcapVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j10 = timestamp - this.zzb;
            if (Math.abs(j10) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbd
            @Override // java.lang.Runnable
            public final void run() {
                zzcapVar.zzk();
            }
        });
    }

    public final void zzb() {
        this.zzc = true;
    }
}
