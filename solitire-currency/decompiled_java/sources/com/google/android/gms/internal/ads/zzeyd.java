package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyd implements zzevo {
    public zzeyd(zzbys zzbysVar, zzgcu zzgcuVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        final m mVarZzh = zzgcj.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfi)).booleanValue()) {
            mVarZzh = zzgcj.zzh(null);
        }
        final m mVarZzh2 = zzgcj.zzh(null);
        return zzgcj.zzc(mVarZzh, mVarZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyc
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeye((String) mVarZzh.get(), (String) mVarZzh2.get());
            }
        }, zzbzo.zza);
    }
}
