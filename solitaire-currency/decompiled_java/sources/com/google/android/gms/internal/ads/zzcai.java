package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcai implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcao zzc;

    zzcai(zzcao zzcaoVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zzc;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzb(this.zza, this.zzb);
        }
    }
}
