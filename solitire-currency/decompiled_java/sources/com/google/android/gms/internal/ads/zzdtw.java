package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdtw implements zzdtk {
    private final long zza;
    private final zzems zzb;

    zzdtw(long j10, Context context, zzdtp zzdtpVar, zzcgj zzcgjVar, String str) {
        this.zza = j10;
        zzfcq zzfcqVarZzv = zzcgjVar.zzv();
        zzfcqVarZzv.zzc(context);
        zzfcqVarZzv.zza(new com.google.android.gms.ads.internal.client.zzq());
        zzfcqVarZzv.zzb(str);
        zzems zzemsVarZza = zzfcqVarZzv.zzd().zza();
        this.zzb = zzemsVarZza;
        zzemsVarZza.zzD(new zzdtv(this, zzdtpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzab(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
