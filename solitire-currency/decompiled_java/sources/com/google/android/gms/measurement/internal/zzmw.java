package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmw extends zzav {
    private final /* synthetic */ zzmx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmw(zzmx zzmxVar, zzio zzioVar) {
        super(zzioVar);
        this.zza = zzmxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        this.zza.zzu();
        this.zza.zzj().zzp().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzw();
    }
}
