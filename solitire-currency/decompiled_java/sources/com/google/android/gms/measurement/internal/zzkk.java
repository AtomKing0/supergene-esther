package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkk implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzkl zze;

    zzkk(zzkl zzklVar, boolean z10, Uri uri, String str, String str2) {
        this.zza = z10;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzklVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkl.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
