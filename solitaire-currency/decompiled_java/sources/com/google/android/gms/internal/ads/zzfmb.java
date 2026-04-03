package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmb {
    private final zzfmd zza;
    private final WebView zzb;
    private final HashMap zzc = new HashMap();
    private final zzfmp zzd = new zzfmp();

    private zzfmb(zzfmd zzfmdVar, WebView webView, boolean z10) {
        zzfnj.zza();
        this.zza = zzfmdVar;
        this.zzb = webView;
        if (!WebViewFeature.isFeatureSupported(WebViewFeature.WEB_MESSAGE_LISTENER)) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        zzg();
        WebViewCompat.addWebMessageListener(webView, "omidJsSessionService", new HashSet(Arrays.asList(ProxyConfig.MATCH_ALL_SCHEMES)), new zzfma(this));
    }

    public static zzfmb zza(zzfmd zzfmdVar, WebView webView, boolean z10) {
        return new zzfmb(zzfmdVar, webView, true);
    }

    static /* bridge */ /* synthetic */ void zzb(zzfmb zzfmbVar, String str) {
        zzflq zzflqVar = (zzflq) zzfmbVar.zzc.get(str);
        if (zzflqVar != null) {
            zzflqVar.zzc();
            zzfmbVar.zzc.remove(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* bridge */ /* synthetic */ void zzd(zzfmb zzfmbVar, String str) {
        zzflv zzflvVar = zzflv.DEFINED_BY_JAVASCRIPT;
        zzfly zzflyVar = zzfly.DEFINED_BY_JAVASCRIPT;
        zzfmc zzfmcVar = zzfmc.JAVASCRIPT;
        zzflu zzfluVar = new zzflu(zzflr.zza(zzflvVar, zzflyVar, zzfmcVar, zzfmcVar, false), zzfls.zzb(zzfmbVar.zza, zzfmbVar.zzb, null, null), str);
        zzfmbVar.zzc.put(str, zzfluVar);
        zzfluVar.zzd(zzfmbVar.zzb);
        for (zzfmo zzfmoVar : zzfmbVar.zzd.zza()) {
            zzfluVar.zzb((View) zzfmoVar.zzb().get(), zzfmoVar.zza(), zzfmoVar.zzc());
        }
        zzfluVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        WebViewCompat.removeWebMessageListener(this.zzb, "omidJsSessionService");
    }

    public final void zze(View view, zzflx zzflxVar, @Nullable String str) {
        Iterator it = this.zzc.values().iterator();
        while (it.hasNext()) {
            ((zzflq) it.next()).zzb(view, zzflxVar, "Ad overlay");
        }
        this.zzd.zzb(view, zzflxVar, "Ad overlay");
    }

    public final void zzf(zzcey zzceyVar) {
        Iterator it = this.zzc.values().iterator();
        while (it.hasNext()) {
            ((zzflq) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzflz(this, zzceyVar, timer), 1000L);
    }
}
