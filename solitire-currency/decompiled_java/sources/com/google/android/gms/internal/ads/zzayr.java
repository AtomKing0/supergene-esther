package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzayr implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzayv zzb;

    zzayr(zzayv zzayvVar, View view) {
        this.zza = view;
        this.zzb = zzayvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
