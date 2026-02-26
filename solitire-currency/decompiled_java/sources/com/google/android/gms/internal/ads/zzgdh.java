package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdh extends zzgcs {
    final /* synthetic */ zzgdj zza;
    private final zzgbp zzb;

    zzgdh(zzgdj zzgdjVar, zzgbp zzgbpVar) {
        this.zza = zzgdjVar;
        this.zzb = zzgbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgbp zzgbpVar = this.zzb;
        m mVarZza = zzgbpVar.zza();
        zzfuu.zzd(mVarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbpVar);
        return mVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((m) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final boolean zzg() {
        return this.zza.isDone();
    }
}
