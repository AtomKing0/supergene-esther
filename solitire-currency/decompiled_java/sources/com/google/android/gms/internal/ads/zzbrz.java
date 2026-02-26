package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrz extends zzbgj {
    final /* synthetic */ zzbsa zza;

    /* synthetic */ zzbrz(zzbsa zzbsaVar, zzbry zzbryVar) {
        this.zza = zzbsaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgk
    public final void zze(zzbfx zzbfxVar) {
        zzbsa zzbsaVar = this.zza;
        zzbsaVar.zza.onCustomFormatAdLoaded(zzbsaVar.zzf(zzbfxVar));
    }
}
