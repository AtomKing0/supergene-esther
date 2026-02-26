package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfpk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzi implements zzfpk {
    final /* synthetic */ zzj zza;

    zzi(zzj zzjVar) {
        this.zza = zzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public final void zza(int i10, long j10) {
        this.zza.zzi.zzd(i10, System.currentTimeMillis() - j10);
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public final void zzb(int i10, long j10, String str) {
        this.zza.zzi.zze(i10, System.currentTimeMillis() - j10, str);
    }
}
