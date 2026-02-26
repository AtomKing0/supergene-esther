package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzafa extends zzacw {
    private final long zza;

    public zzafa(zzacl zzaclVar, long j10) {
        super(zzaclVar);
        zzdi.zzd(zzaclVar.zzf() >= j10);
        this.zza = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
