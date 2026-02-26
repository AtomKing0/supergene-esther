package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxe implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxe(zzaf zzafVar, int i10) {
        this.zza = 1 == (zzafVar.zze & 1);
        this.zzb = zzlf.zza(i10, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxe zzxeVar) {
        return zzfxg.zzj().zzd(this.zzb, zzxeVar.zzb).zzd(this.zza, zzxeVar.zza).zza();
    }
}
