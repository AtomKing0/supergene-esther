package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbmd implements zzblv, zzblu {
    private final zzcej zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzbmd(Context context, VersionInfoParcel versionInfoParcel, @Nullable zzauo zzauoVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzcev {
        com.google.android.gms.ads.internal.zzu.zzz();
        zzcej zzcejVarZza = zzcew.zza(context, zzcgd.zza(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbav.zza(), null, null, null, null);
        this.zza = zzcejVarZza;
        ((View) zzcejVarZza).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzv()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzt.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzm.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzblz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzm(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzb(String str, String str2) {
        zzblt.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zzd(String str, Map map) {
        zzblt.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzblt.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzf(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbma
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzn(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzblx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzh(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp(str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final boolean zzi() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final zzbnc zzj() {
        return new zzbnc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzk(final zzbmj zzbmjVar) {
        zzcgb zzcgbVarZzN = this.zza.zzN();
        Objects.requireNonNull(zzbmjVar);
        zzcgbVarZzN.zzH(new zzcga() { // from class: com.google.android.gms.internal.ads.zzbly
            @Override // com.google.android.gms.internal.ads.zzcga
            public final void zza() {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
                zzbmj zzbmjVar2 = zzbmjVar;
                final long j10 = zzbmjVar2.zzc;
                final ArrayList arrayList = zzbmjVar2.zzb;
                arrayList.add(Long.valueOf(jCurrentTimeMillis - j10));
                com.google.android.gms.ads.internal.util.zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                zzfru zzfruVar = com.google.android.gms.ads.internal.util.zzt.zza;
                final zzbna zzbnaVar = zzbmjVar2.zza;
                final zzbmz zzbmzVar = zzbmjVar2.zzd;
                final zzblv zzblvVar = zzbmjVar2.zze;
                zzfruVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmf
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbnaVar.zzi(zzbmzVar, zzblvVar, arrayList, j10);
                    }
                }, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzb)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzblt.zzd(this, str, jSONObject);
    }

    final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzq(String str, zzbix zzbixVar) {
        this.zza.zzag(str, new zzbmc(this, zzbixVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzr(String str, final zzbix zzbixVar) {
        this.zza.zzaA(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzblw
            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzbix zzbixVar2 = (zzbix) obj;
                if (zzbixVar2 instanceof zzbmc) {
                    return ((zzbmc) zzbixVar2).zzb.equals(zzbixVar);
                }
                return false;
            }
        });
    }
}
