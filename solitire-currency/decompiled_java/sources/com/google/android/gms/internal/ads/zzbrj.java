package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrj implements View.OnClickListener {
    final /* synthetic */ zzbrk zza;

    zzbrj(zzbrk zzbrkVar) {
        this.zza = zzbrkVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
