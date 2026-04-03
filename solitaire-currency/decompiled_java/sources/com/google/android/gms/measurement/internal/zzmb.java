package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmb implements Runnable {
    private final /* synthetic */ zzlx zza;

    zzmb(zzlx zzlxVar) {
        this.zza = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzla.zza(this.zza.zza, new ComponentName(this.zza.zza.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
