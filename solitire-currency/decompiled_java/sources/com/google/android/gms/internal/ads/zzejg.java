package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzejg extends zzekh {
    private final zzdez zza;

    public zzejg(zzcwo zzcwoVar, zzdeo zzdeoVar, zzcxi zzcxiVar, zzcxx zzcxxVar, zzcyc zzcycVar, zzcxd zzcxdVar, zzdbn zzdbnVar, zzdfl zzdflVar, zzcyw zzcywVar, zzdez zzdezVar, zzdbj zzdbjVar) {
        super(zzcwoVar, zzdeoVar, zzcxiVar, zzcxxVar, zzcycVar, zzdbnVar, zzcywVar, zzdflVar, zzdbjVar, zzcxdVar);
        this.zza = zzdezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekh, com.google.android.gms.internal.ads.zzbos
    public final void zzs(zzbvz zzbvzVar) {
        this.zza.zza(zzbvzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh, com.google.android.gms.internal.ads.zzbos
    public final void zzt(zzbwd zzbwdVar) throws RemoteException {
        this.zza.zza(new zzbvz(zzbwdVar.zzf(), zzbwdVar.zze()));
    }

    @Override // com.google.android.gms.internal.ads.zzekh, com.google.android.gms.internal.ads.zzbos
    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzekh, com.google.android.gms.internal.ads.zzbos
    public final void zzv() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzekh, com.google.android.gms.internal.ads.zzbos
    public final void zzy() {
        this.zza.zzc();
    }
}
