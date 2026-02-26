package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbml implements zzbix {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbmz zzb;
    final /* synthetic */ zzblv zzc;
    final /* synthetic */ zzbna zzd;

    zzbml(zzbna zzbnaVar, long j10, zzbmz zzbmzVar, zzblv zzblvVar) {
        this.zza = j10;
        this.zzb = zzbmzVar;
        this.zzc = zzblvVar;
        this.zzd = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + (com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - this.zza) + " ms.");
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1 && this.zzb.zze() != 1) {
                this.zzd.zzi = 0;
                zzblv zzblvVar = this.zzc;
                zzblvVar.zzq("/log", zzbiw.zzg);
                zzblvVar.zzq("/result", zzbiw.zzo);
                this.zzb.zzi(this.zzc);
                this.zzd.zzh = this.zzb;
                com.google.android.gms.ads.internal.util.zze.zza("Successfully loaded JS Engine.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
