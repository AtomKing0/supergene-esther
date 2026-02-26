package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzg {
    private final Context zza;
    private final zzaah zzb;
    private zzcm zzc;
    private zzbx zzd;
    private boolean zze;

    public zzzg(Context context, zzaah zzaahVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzaahVar;
    }

    public final zzzt zzc() {
        zzdi.zzf(!this.zze);
        zzzs zzzsVar = null;
        if (this.zzd == null) {
            if (this.zzc == null) {
                this.zzc = new zzzm(null);
            }
            this.zzd = new zzzn(this.zzc);
        }
        zzzt zzztVar = new zzzt(this, zzzsVar);
        this.zze = true;
        return zzztVar;
    }
}
