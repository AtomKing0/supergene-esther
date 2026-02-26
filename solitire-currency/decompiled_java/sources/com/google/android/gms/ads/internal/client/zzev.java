package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    zzev(zzew zzewVar) {
        this.zza = zzewVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzew zzewVar = this.zza;
        if (zzewVar.zza != null) {
            try {
                zzewVar.zza.zze(1);
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not notify onAdFailedToLoad event.", e10);
            }
        }
    }
}
