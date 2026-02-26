package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.internal.measurement.zzqk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmq {
    final /* synthetic */ zzmi zza;

    zzmq(zzmi zzmiVar) {
        this.zza = zzmiVar;
    }

    @VisibleForTesting
    @WorkerThread
    private final void zzb(long j10, boolean z10) {
        this.zza.zzt();
        if (this.zza.zzu.zzac()) {
            this.zza.zzk().zzk.zza(j10);
            this.zza.zzj().zzp().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            Long lValueOf = Long.valueOf(j10 / 1000);
            this.zza.zzm().zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_sid", lValueOf, j10);
            this.zza.zzk().zzl.zza(lValueOf.longValue());
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            this.zza.zzm().zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_s", j10, bundle);
            String strZza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(strZza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strZza);
            this.zza.zzm().zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_ssr", j10, bundle2);
        }
    }

    @WorkerThread
    final void zza() {
        this.zza.zzt();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzp().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    @WorkerThread
    final void zza(long j10, boolean z10) {
        this.zza.zzt();
        this.zza.zzab();
        if (this.zza.zzk().zza(j10)) {
            this.zza.zzk().zzg.zza(true);
            if (zzqk.zza() && this.zza.zze().zza(zzbh.zzbr)) {
                this.zza.zzg().zzag();
            }
        }
        this.zza.zzk().zzk.zza(j10);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j10, z10);
        }
    }
}
