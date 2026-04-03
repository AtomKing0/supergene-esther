package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhw {
    private final zzfhp zza;
    private final m zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfhw(final zzfgu zzfguVar, final zzfho zzfhoVar, final zzfhp zzfhpVar) {
        this.zza = zzfhpVar;
        this.zzb = zzgcj.zzf(zzgcj.zzn(zzfhoVar.zza(zzfhpVar), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfhu
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb(zzfhoVar, zzfguVar, zzfhpVar, (zzfhd) obj);
            }
        }, zzfhpVar.zzb()), Exception.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfhv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(zzfhoVar, (Exception) obj);
            }
        }, zzfhpVar.zzb());
    }

    public final synchronized m zza(zzfhp zzfhpVar) {
        if (!this.zzd && !this.zzc && this.zza.zza() != null && zzfhpVar.zza() != null && this.zza.zza().equals(zzfhpVar.zza())) {
            this.zzc = true;
            return this.zzb;
        }
        return null;
    }

    final /* synthetic */ m zzb(zzfho zzfhoVar, zzfgu zzfguVar, zzfhp zzfhpVar, zzfhd zzfhdVar) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfhoVar.zzb(zzfhdVar);
            if (this.zzc) {
                return zzgcj.zzh(new zzfhn(zzfhdVar, zzfhpVar));
            }
            zzfguVar.zzd(zzfhpVar.zza(), zzfhdVar);
            return zzgcj.zzh(null);
        }
    }

    final /* synthetic */ m zzc(zzfho zzfhoVar, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzgcf zzgcfVar) {
        zzgcj.zzr(zzgcj.zzn(this.zzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfht
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzi();
            }
        }, this.zza.zzb()), zzgcfVar, this.zza.zzb());
    }
}
