package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaug implements Runnable {
    final /* synthetic */ zzauh zza;

    zzaug(zzauh zzauhVar) {
        this.zza = zzauhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzo) {
            if (this.zza.zzp) {
                return;
            }
            this.zza.zzp = true;
            try {
                zzauh.zzj(this.zza);
            } catch (Exception e10) {
                this.zza.zzh.zzc(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, -1L, e10);
            }
            synchronized (this.zza.zzo) {
                this.zza.zzp = false;
            }
        }
    }
}
