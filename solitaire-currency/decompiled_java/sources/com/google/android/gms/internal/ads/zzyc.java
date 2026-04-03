package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyc {
    public final int zza;
    public final zzli[] zzb;
    public final zzxv[] zzc;
    public final zzck zzd;

    @Nullable
    public final Object zze;

    public zzyc(zzli[] zzliVarArr, zzxv[] zzxvVarArr, zzck zzckVar, @Nullable Object obj) {
        this.zzb = zzliVarArr;
        this.zzc = (zzxv[]) zzxvVarArr.clone();
        this.zzd = zzckVar;
        this.zze = obj;
        this.zza = zzliVarArr.length;
    }

    public final boolean zza(@Nullable zzyc zzycVar, int i10) {
        return zzycVar != null && zzet.zzG(this.zzb[i10], zzycVar.zzb[i10]) && zzet.zzG(this.zzc[i10], zzycVar.zzc[i10]);
    }

    public final boolean zzb(int i10) {
        return this.zzb[i10] != null;
    }
}
