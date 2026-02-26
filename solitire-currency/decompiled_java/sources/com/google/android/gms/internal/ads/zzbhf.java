package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhf extends zzbgg {
    final /* synthetic */ zzbhi zza;

    /* synthetic */ zzbhf(zzbhi zzbhiVar, zzbhe zzbheVar) {
        this.zza = zzbhiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgh
    public final void zze(zzbfx zzbfxVar, String str) {
        zzbhi zzbhiVar = this.zza;
        if (zzbhiVar.zzb == null) {
            return;
        }
        zzbhiVar.zzb.zzb(zzbhiVar.zzf(zzbfxVar), str);
    }
}
