package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbbb {

    @VisibleForTesting
    zzaxr zza;

    @VisibleForTesting
    boolean zzb;
    private final ExecutorService zzc;

    public zzbbb() {
        this.zzc = com.google.android.gms.ads.internal.util.client.zzb.zzb;
    }

    public zzbbb(final Context context) {
        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbaw
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzet)).booleanValue();
                zzbbb zzbbbVar = this.zza;
                Context context2 = context;
                if (zBooleanValue) {
                    try {
                        zzbbbVar.zza = (zzaxr) com.google.android.gms.ads.internal.util.client.zzq.zzb(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new com.google.android.gms.ads.internal.util.client.zzo() { // from class: com.google.android.gms.internal.ads.zzbax
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.android.gms.ads.internal.util.client.zzo
                            public final Object zza(Object obj) {
                                return zzaxq.zzb(obj);
                            }
                        });
                        zzbbbVar.zza.zze(ObjectWrapper.wrap(context2), "GMA_SDK");
                        zzbbbVar.zzb = true;
                    } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzp | NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzm.zze("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}
