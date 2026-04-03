package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlm extends zzav {
    private final /* synthetic */ zzla zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlm(zzla zzlaVar, zzio zzioVar) {
        super(zzioVar);
        this.zza = zzlaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        this.zza.zzj().zzu().zza("Tasks have been queued for a long time");
    }
}
