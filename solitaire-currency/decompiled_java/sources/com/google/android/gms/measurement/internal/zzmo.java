package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.internal.measurement.zzpa;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmo {

    @VisibleForTesting
    protected long zza;
    final /* synthetic */ zzmi zzb;

    @VisibleForTesting
    private long zzc;
    private final zzav zzd;

    public zzmo(zzmi zzmiVar) {
        this.zzb = zzmiVar;
        this.zzd = new zzmr(this, zzmiVar.zzu);
        long jElapsedRealtime = zzmiVar.zzb().elapsedRealtime();
        this.zzc = jElapsedRealtime;
        this.zza = jElapsedRealtime;
    }

    @VisibleForTesting
    @WorkerThread
    final long zza(long j10) {
        long j11 = j10 - this.zza;
        this.zza = j10;
        return j11;
    }

    @WorkerThread
    final void zzb(long j10) {
        this.zzd.zza();
    }

    @WorkerThread
    final void zzc(long j10) {
        this.zzb.zzt();
        this.zzd.zza();
        this.zzc = j10;
        this.zza = j10;
    }

    static /* synthetic */ void zza(zzmo zzmoVar) {
        zzmoVar.zzb.zzt();
        zzmoVar.zza(false, false, zzmoVar.zzb.zzb().elapsedRealtime());
        zzmoVar.zzb.zzc().zza(zzmoVar.zzb.zzb().elapsedRealtime());
    }

    final void zza() {
        this.zzd.zza();
        this.zzc = 0L;
        this.zza = 0L;
    }

    @WorkerThread
    public final boolean zza(boolean z10, boolean z11, long j10) {
        this.zzb.zzt();
        this.zzb.zzu();
        if (!zzpa.zza() || !this.zzb.zze().zza(zzbh.zzbm) || this.zzb.zzu.zzac()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long jZza = j10 - this.zzc;
        if (!z10 && jZza < 1000) {
            this.zzb.zzj().zzp().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZza));
            return false;
        }
        if (!z11) {
            jZza = zza(j10);
        }
        this.zzb.zzj().zzp().zza("Recording user engagement, ms", Long.valueOf(jZza));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZza);
        zznt.zza(this.zzb.zzn().zza(!this.zzb.zze().zzv()), bundle, true);
        if (!z11) {
            this.zzb.zzm().zzc(TtmlNode.TEXT_EMPHASIS_AUTO, "_e", bundle);
        }
        this.zzc = j10;
        this.zzd.zza();
        this.zzd.zza(3600000L);
        return true;
    }
}
