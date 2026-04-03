package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzer implements Runnable {
    final /* synthetic */ zzet zza;

    zzer(zzet zzetVar) {
        this.zza = zzetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeu zzeuVar = this.zza.zza;
        if (zzeuVar.zza != null) {
            try {
                zzeuVar.zza.zze(1);
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not notify onAdFailedToLoad event.", e10);
            }
        }
    }
}
