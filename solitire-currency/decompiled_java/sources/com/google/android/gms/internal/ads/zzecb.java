package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecb implements zzcye, zzcwt {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzecl zzd;

    public zzecb(zzecl zzeclVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzeclVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z10) {
        int i10;
        int iIntValue;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && !this.zzc.zzS()) {
            Object obj = zza;
            synchronized (obj) {
                i10 = zzb;
                iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfC)).intValue();
            }
            if (i10 < iIntValue) {
                this.zzd.zzd(z10);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzb(true);
    }
}
