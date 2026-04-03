package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzapf implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaph zzc;

    zzapf(zzaph zzaphVar, String str, long j10) {
        this.zza = str;
        this.zzb = j10;
        this.zzc = zzaphVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaph zzaphVar = this.zzc;
        zzaphVar.zza.zzb(zzaphVar.toString());
    }
}
