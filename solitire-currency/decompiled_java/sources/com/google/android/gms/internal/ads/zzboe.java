package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboe {
    private static zzboe zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    @VisibleForTesting
    zzboe() {
    }

    public static zzboe zza() {
        if (zza == null) {
            zza = new zzboe();
        }
        return zza;
    }

    @Nullable
    public final Thread zzb(final Context context, @Nullable final String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbod
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                zzbbw.zza(context2);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzan)).booleanValue()) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzac)).booleanValue());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaj)).booleanValue()) {
                    bundle.putString("ad_storage", "denied");
                    bundle.putString("analytics_storage", "denied");
                }
                try {
                    ((zzcgi) com.google.android.gms.ads.internal.util.client.zzq.zzb(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new com.google.android.gms.ads.internal.util.client.zzo() { // from class: com.google.android.gms.internal.ads.zzboc
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.android.gms.ads.internal.util.client.zzo
                        public final Object zza(Object obj) {
                            return zzcgh.zzb(obj);
                        }
                    })).zze(ObjectWrapper.wrap(context2), new zzbob(AppMeasurementSdk.getInstance(context2, "FA-Ads", "am", str, bundle)));
                } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzp | NullPointerException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
                }
            }
        });
        thread.start();
        return thread;
    }
}
