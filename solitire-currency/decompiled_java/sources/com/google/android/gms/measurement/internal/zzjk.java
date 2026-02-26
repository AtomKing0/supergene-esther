package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjk implements Executor {
    private final /* synthetic */ zziy zza;

    zzjk(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzl().zzb(runnable);
    }
}
