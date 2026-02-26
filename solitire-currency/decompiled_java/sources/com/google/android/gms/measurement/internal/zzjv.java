package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjv extends zzav {
    private final /* synthetic */ zziy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjv(zziy zziyVar, zzio zzioVar) {
        super(zzioVar);
        this.zza = zziyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    @WorkerThread
    public final void zzb() {
        if (this.zza.zzu.zzah()) {
            this.zza.zzn.zza(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }
}
