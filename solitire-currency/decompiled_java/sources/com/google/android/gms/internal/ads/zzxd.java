package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxd extends zzxp implements Comparable {
    private final int zze;
    private final int zzf;

    public zzxd(int i10, zzcd zzcdVar, int i11, zzxi zzxiVar, int i12) {
        super(i10, zzcdVar, i11);
        this.zze = zzlf.zza(i12, zzxiVar.zzN) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxd zzxdVar) {
        return Integer.compare(this.zzf, zzxdVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        return false;
    }
}
