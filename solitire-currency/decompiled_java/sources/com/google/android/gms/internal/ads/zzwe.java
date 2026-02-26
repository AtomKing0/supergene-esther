package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwe implements zzvx {
    private final zzvx zza;
    private final long zzb;

    public zzwe(zzvx zzvxVar, long j10) {
        this.zza = zzvxVar;
        this.zzb = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zza(zzjz zzjzVar, zzhd zzhdVar, int i10) {
        int iZza = this.zza.zza(zzjzVar, zzhdVar, i10);
        if (iZza != -4) {
            return iZza;
        }
        zzhdVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zzb(long j10) {
        return this.zza.zzb(j10 - this.zzb);
    }

    public final zzvx zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final boolean zze() {
        return this.zza.zze();
    }
}
