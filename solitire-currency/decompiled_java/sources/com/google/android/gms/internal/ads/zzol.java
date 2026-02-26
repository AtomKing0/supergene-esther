package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzol extends BroadcastReceiver {
    final /* synthetic */ zzom zza;

    /* synthetic */ zzol(zzom zzomVar, zzok zzokVar) {
        this.zza = zzomVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzom zzomVar = this.zza;
        zzomVar.zzj(zzof.zzd(context, intent, zzomVar.zzh, zzomVar.zzg));
    }
}
