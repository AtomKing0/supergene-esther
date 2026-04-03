package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcfp {
    private final zzcfq zza;
    private final zzcfo zzb;

    public zzcfp(zzcfq zzcfqVar, zzcfo zzcfoVar) {
        this.zzb = zzcfoVar;
        this.zza = zzcfqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcfw] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ?? r02 = this.zza;
        zzauo zzauoVarZzI = r02.zzI();
        if (zzauoVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzaukVarZzc = zzauoVarZzI.zzc();
        if (zzaukVarZzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (r02.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        zzcfq zzcfqVar = this.zza;
        return zzaukVarZzc.zzf(zzcfqVar.getContext(), str, (View) zzcfqVar, zzcfqVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcfw] */
    @JavascriptInterface
    public String getViewSignals() {
        ?? r02 = this.zza;
        zzauo zzauoVarZzI = r02.zzI();
        if (zzauoVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzaukVarZzc = zzauoVarZzI.zzc();
        if (zzaukVarZzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (r02.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        zzcfq zzcfqVar = this.zza;
        return zzaukVarZzc.zzh(zzcfqVar.getContext(), (View) zzcfqVar, zzcfqVar.zzi());
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfn
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    final /* synthetic */ void zza(String str) {
        Uri uri = Uri.parse(str);
        zzcer zzcerVarZzaO = ((zzcfi) this.zzb.zza).zzaO();
        if (zzcerVarZzaO == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzcerVarZzaO.zzj(uri);
        }
    }
}
