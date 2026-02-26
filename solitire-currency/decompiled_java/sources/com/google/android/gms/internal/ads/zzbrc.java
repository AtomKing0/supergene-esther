package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrc implements com.google.android.gms.ads.internal.overlay.zzp {
    final /* synthetic */ zzbre zza;

    zzbrc(zzbre zzbreVar) {
        this.zza = zzbreVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdH() {
        com.google.android.gms.ads.internal.util.client.zzm.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdk() {
        com.google.android.gms.ads.internal.util.client.zzm.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdq() {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdr() {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbre zzbreVar = this.zza;
        zzbreVar.zzb.onAdOpened(zzbreVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdu(int i10) {
        com.google.android.gms.ads.internal.util.client.zzm.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbre zzbreVar = this.zza;
        zzbreVar.zzb.onAdClosed(zzbreVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdt() {
    }
}
