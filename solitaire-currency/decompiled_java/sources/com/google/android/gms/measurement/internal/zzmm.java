package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.internal.measurement.zzqe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmm implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzmn zzc;

    zzmm(zzmn zzmnVar, long j10, long j11) {
        this.zzc = zzmnVar;
        this.zza = j10;
        this.zzb = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmp
            @Override // java.lang.Runnable
            public final void run() {
                zzmm zzmmVar = this.zza;
                zzmn zzmnVar = zzmmVar.zzc;
                long j10 = zzmmVar.zza;
                long j11 = zzmmVar.zzb;
                zzmnVar.zza.zzt();
                zzmnVar.zza.zzj().zzc().zza("Application going to the background");
                zzmnVar.zza.zzk().zzn.zza(true);
                zzmnVar.zza.zza(true);
                if (!zzmnVar.zza.zze().zzv()) {
                    zzmnVar.zza.zzb.zzb(j11);
                    zzmnVar.zza.zza(false, false, j11);
                }
                if (zzqe.zza() && zzmnVar.zza.zze().zza(zzbh.zzcf)) {
                    zzmnVar.zza.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
                } else {
                    zzmnVar.zza.zzm().zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_ab", j10, new Bundle());
                }
            }
        });
    }
}
