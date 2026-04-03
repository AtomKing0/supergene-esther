package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfnc implements Runnable {
    final /* synthetic */ zzfnd zza;
    private final WebView zzb;

    zzfnc(zzfnd zzfndVar) {
        this.zza = zzfndVar;
        this.zzb = zzfndVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
