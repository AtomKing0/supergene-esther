package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzceo implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbxl zza;
    final /* synthetic */ zzcer zzb;

    zzceo(zzcer zzcerVar, zzbxl zzbxlVar) {
        this.zza = zzbxlVar;
        this.zzb = zzcerVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzW(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
