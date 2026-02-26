package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzafb extends zzacx {
    final /* synthetic */ zzadi zza;
    final /* synthetic */ zzafc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzafb(zzafc zzafcVar, zzadi zzadiVar, zzadi zzadiVar2) {
        super(zzadiVar);
        this.zza = zzadiVar2;
        this.zzb = zzafcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacx, com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        zzadg zzadgVarZzg = this.zza.zzg(j10);
        zzadj zzadjVar = zzadgVarZzg.zza;
        zzadj zzadjVar2 = new zzadj(zzadjVar.zzb, zzadjVar.zzc + this.zzb.zzb);
        zzadj zzadjVar3 = zzadgVarZzg.zzb;
        return new zzadg(zzadjVar2, new zzadj(zzadjVar3.zzb, zzadjVar3.zzc + this.zzb.zzb));
    }
}
