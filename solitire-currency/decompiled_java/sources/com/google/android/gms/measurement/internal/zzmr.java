package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmr extends zzav {
    private final /* synthetic */ zzmo zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmr(zzmo zzmoVar, zzio zzioVar) {
        super(zzioVar);
        this.zza = zzmoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    @WorkerThread
    public final void zzb() {
        zzmo.zza(this.zza);
    }
}
