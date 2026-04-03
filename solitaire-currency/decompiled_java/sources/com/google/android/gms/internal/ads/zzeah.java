package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeah extends zzbuq {
    final /* synthetic */ zzeai zza;

    protected zzeah(zzeai zzeaiVar) {
        this.zza = zzeaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        this.zza.zza.zzd(zzbbVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
