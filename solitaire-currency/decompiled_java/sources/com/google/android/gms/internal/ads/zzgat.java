package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgat extends zzgav {
    zzgat(m mVar, Class cls, zzgbq zzgbqVar) {
        super(mVar, cls, zzgbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgav
    final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgbq zzgbqVar = (zzgbq) obj;
        m mVarZza = zzgbqVar.zza(th);
        zzfuu.zzd(mVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbqVar);
        return mVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgav
    final /* synthetic */ void zzf(Object obj) {
        zzs((m) obj);
    }
}
