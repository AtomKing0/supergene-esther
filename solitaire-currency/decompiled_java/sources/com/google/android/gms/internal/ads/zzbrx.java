package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrx extends zzbgg {
    final /* synthetic */ zzbsa zza;

    /* synthetic */ zzbrx(zzbsa zzbsaVar, zzbrw zzbrwVar) {
        this.zza = zzbsaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgh
    public final void zze(zzbfx zzbfxVar, String str) {
        zzbsa zzbsaVar = this.zza;
        if (zzbsaVar.zzb == null) {
            return;
        }
        zzbsaVar.zzb.onCustomClick(zzbsaVar.zzf(zzbfxVar), str);
    }
}
