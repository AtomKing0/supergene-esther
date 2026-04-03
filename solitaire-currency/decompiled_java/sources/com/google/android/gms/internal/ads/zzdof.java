package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdof {
    private final zzcwo zza;
    private final zzcxx zzb;
    private final zzcyk zzc;
    private final zzcyw zzd;
    private final zzdbn zze;
    private final zzdeo zzf;
    private final zzdsk zzg;
    private final zzfll zzh;
    private final zzedh zzi;
    private final zzcni zzj;

    zzdof(zzcwo zzcwoVar, zzcxx zzcxxVar, zzcyk zzcykVar, zzcyw zzcywVar, zzdbn zzdbnVar, zzdeo zzdeoVar, zzdsk zzdskVar, zzfll zzfllVar, zzedh zzedhVar, zzcni zzcniVar) {
        this.zza = zzcwoVar;
        this.zzb = zzcxxVar;
        this.zzc = zzcykVar;
        this.zzd = zzcywVar;
        this.zze = zzdbnVar;
        this.zzf = zzdeoVar;
        this.zzg = zzdskVar;
        this.zzh = zzfllVar;
        this.zzi = zzedhVar;
        this.zzj = zzcniVar;
    }

    public final void zza(zzdog zzdogVar, zzcej zzcejVar) {
        zzdod zzdodVar = zzdogVar.zza;
        final zzcxx zzcxxVar = this.zzb;
        Objects.requireNonNull(zzcxxVar);
        zzdodVar.zzi(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzaa() { // from class: com.google.android.gms.internal.ads.zzdoe
            @Override // com.google.android.gms.ads.internal.overlay.zzaa
            public final void zzg() {
                zzcxxVar.zzb();
            }
        }, this.zzf);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjm)).booleanValue() || zzcejVar == null || zzcejVar.zzN() == null) {
            return;
        }
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        zzcgbVarZzN.zzI(this.zzj, this.zzi, this.zzh);
        zzcgbVarZzN.zzK(this.zzj, this.zzi, this.zzg);
    }
}
