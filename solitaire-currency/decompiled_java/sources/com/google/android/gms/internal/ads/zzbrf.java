package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrf implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrh zza;

    zzbrf(zzbrh zzbrhVar) {
        this.zza = zzbrhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        zzbrh zzbrhVar = this.zza;
        Intent intentZzb = zzbrhVar.zzb();
        com.google.android.gms.ads.internal.zzu.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzT(zzbrhVar.zzb, intentZzb);
    }
}
