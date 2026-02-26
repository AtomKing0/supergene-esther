package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcyz extends zzdch implements zzcxk, zzcyp {
    private final zzfel zzb;
    private final AtomicBoolean zzc;

    public zzcyz(Set set, zzfel zzfelVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfelVar;
    }

    private final void zzb() {
        com.google.android.gms.ads.internal.client.zzs zzsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgY)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzsVar = this.zzb.zzae) != null && zzsVar.zza == 3) {
            zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcyy
                @Override // com.google.android.gms.internal.ads.zzdcg
                public final void zza(Object obj) throws Exception {
                    this.zza.zza((zzczb) obj);
                }
            });
        }
    }

    final /* synthetic */ void zza(zzczb zzczbVar) throws Exception {
        zzczbVar.zzh(this.zzb.zzae);
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        int i10 = this.zzb.zzb;
        if (i10 == 2 || i10 == 5 || i10 == 4 || i10 == 6 || i10 == 7) {
            zzb();
        }
    }
}
