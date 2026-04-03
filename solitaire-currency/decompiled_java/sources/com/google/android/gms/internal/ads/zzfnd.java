package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnd extends zzfmz {
    private WebView zza;
    private Long zzb;
    private final Map zzc;

    public zzfnd(String str, Map map, String str2) {
        super(str);
        this.zzb = null;
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final void zzc() {
        super.zzc();
        new Handler().postDelayed(new zzfnc(this), Math.max(4000 - (this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final void zzi(zzflu zzfluVar, zzfls zzflsVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZzi = zzflsVar.zzi();
        Iterator it = mapZzi.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzj(zzfluVar, zzflsVar, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final void zzn() {
        WebView webView = new WebView(zzfmq.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfnb(this));
        zzm(this.zza);
        zzfms.zzj(this.zza, null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
        } else {
            throw null;
        }
    }
}
