package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbmo implements Runnable {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzblv zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbna zze;

    zzbmo(zzbna zzbnaVar, zzbmz zzbmzVar, zzblv zzblvVar, ArrayList arrayList, long j10) {
        this.zza = zzbmzVar;
        this.zzb = zzblvVar;
        this.zzc = arrayList;
        this.zzd = j10;
        this.zze = zzbnaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        synchronized (this.zze.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
            if (this.zza.zze() != -1 && this.zza.zze() != 1) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
                    this.zza.zzh(new TimeoutException("Unable to fully load JS engine."), "SdkJavascriptFactory.loadJavascriptEngine.Runnable");
                } else {
                    this.zza.zzg();
                }
                zzgcu zzgcuVar = zzbzo.zze;
                final zzblv zzblvVar = this.zzb;
                Objects.requireNonNull(zzblvVar);
                zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmn
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzblvVar.zzc();
                    }
                });
                String strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzc));
                int iZze = this.zza.zze();
                int i10 = this.zze.zzi;
                if (this.zzc.isEmpty()) {
                    str = ". Still waiting for the engine to be loaded";
                } else {
                    str = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is " + String.valueOf(this.zzc.get(0));
                }
                com.google.android.gms.ads.internal.util.zze.zza("Could not finish the full JS engine loading in " + strValueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + iZze + ". Update status(fullLoadTimeout) is " + i10 + str + " ms. Total latency(fullLoadTimeout) is " + (com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
        }
    }
}
