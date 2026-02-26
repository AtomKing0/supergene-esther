package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznh implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zznd zzb;

    zznh(zznd zzndVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzndVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzj() || !zziq.zzb(this.zza.zzt).zzj()) {
            this.zzb.zzj().zzp().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzf zzfVarZza = this.zzb.zza(this.zza);
        if (zzfVarZza != null) {
            return zzfVarZza.zzab();
        }
        this.zzb.zzj().zzu().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
