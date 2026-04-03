package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxz extends zzbut {
    final /* synthetic */ zzdya zza;

    protected zzdxz(zzdya zzdyaVar) {
        this.zza = zzdyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        this.zza.zza.zzd(zzbbVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdya zzdyaVar = this.zza;
        zzdyaVar.zza.zzc(new zzdyq(autoCloseInputStream, zzdyaVar.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvb zzbvbVar) {
        this.zza.zza.zzc(new zzdyq(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvbVar));
    }
}
