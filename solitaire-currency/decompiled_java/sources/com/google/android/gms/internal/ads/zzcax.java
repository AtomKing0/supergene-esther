package com.google.android.gms.internal.ads;

import com.ironsource.Cif;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcax implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcay zzb;

    zzcax(zzcay zzcayVar, boolean z10) {
        this.zza = z10;
        this.zzb = zzcayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", Cif.f12602k, String.valueOf(this.zza));
    }
}
