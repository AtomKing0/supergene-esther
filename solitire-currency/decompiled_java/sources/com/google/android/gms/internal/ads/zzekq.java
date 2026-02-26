package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzekq implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzfex zzb;
    final /* synthetic */ zzfel zzc;
    final /* synthetic */ zzekw zzd;
    final /* synthetic */ zzekr zze;

    zzekq(zzekr zzekrVar, zzbzt zzbztVar, zzfex zzfexVar, zzfel zzfelVar, zzekw zzekwVar) {
        this.zza = zzbztVar;
        this.zzb = zzfexVar;
        this.zzc = zzfelVar;
        this.zzd = zzekwVar;
        this.zze = zzekrVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        this.zza.zzc(this.zze.zzd.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}
