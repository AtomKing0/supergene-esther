package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbs implements zzfcc {
    private final zzfcc zza;

    @Nullable
    private zzcvx zzb;

    public zzfbs(zzfcc zzfccVar) {
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcvx zzd() {
        return this.zzb;
    }

    public final synchronized m zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable zzcvx zzcvxVar) {
        this.zzb = zzcvxVar;
        if (zzfcdVar.zza == null) {
            return ((zzfbr) this.zza).zzb(zzfcdVar, zzfcbVar, zzcvxVar);
        }
        zzctc zzctcVarZzb = zzcvxVar.zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzk(zzgcj.zzh(zzfcdVar.zza)));
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ m zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }
}
