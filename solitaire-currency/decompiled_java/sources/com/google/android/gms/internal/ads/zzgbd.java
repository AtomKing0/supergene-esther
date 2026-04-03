package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbd extends zzgbf {
    zzgbd(m mVar, zzgbq zzgbqVar) {
        super(mVar, zzgbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgbq zzgbqVar = (zzgbq) obj;
        m mVarZza = zzgbqVar.zza(obj2);
        zzfuu.zzd(mVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbqVar);
        return mVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    final /* synthetic */ void zzf(Object obj) {
        zzs((m) obj);
    }
}
