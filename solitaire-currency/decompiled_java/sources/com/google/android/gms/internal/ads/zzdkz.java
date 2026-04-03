package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdkz implements zzgcf {
    final /* synthetic */ zzdla zza;

    zzdkz(zzdla zzdlaVar) {
        this.zza = zzdlaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcej zzcejVar = (zzcej) list.get(0);
            if (zzcejVar != null) {
                this.zza.zzb(zzcejVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e10) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "omid native display exp");
            }
        }
    }
}
