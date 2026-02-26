package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbr implements zzfcc {

    @Nullable
    private zzcvx zza;

    @Override // com.google.android.gms.internal.ads.zzfcc
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcvx zzd() {
        return this.zza;
    }

    public final synchronized m zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable zzcvx zzcvxVar) {
        zzctc zzctcVarZzb;
        if (zzcvxVar != null) {
            this.zza = zzcvxVar;
        } else {
            this.zza = (zzcvx) zzfcbVar.zza(zzfcdVar.zzb).zzh();
        }
        zzctcVarZzb = this.zza.zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ m zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }
}
