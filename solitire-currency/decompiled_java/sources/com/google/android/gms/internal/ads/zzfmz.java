package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.sentry.protocol.App;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzfmz {
    private final String zza;
    private zzfob zzb;
    private long zzc;
    private int zzd;

    public zzfmz(String str) {
        zzb();
        this.zza = str;
        this.zzb = new zzfob(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j10) {
        if (j10 < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfms.zza().zzg(zza(), this.zza, str);
    }

    public final void zze() {
        zzfms.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzflr zzflrVar) {
        zzfms.zza().zzd(zza(), this.zza, zzflrVar.zzb());
    }

    public final void zzg(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfnf.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfms.zza().zzf(zza(), jSONObject);
    }

    public final void zzh(String str, long j10) {
        if (j10 >= this.zzc) {
            this.zzd = 2;
            zzfms.zza().zzg(zza(), this.zza, str);
        }
    }

    public void zzi(zzflu zzfluVar, zzfls zzflsVar) {
        zzj(zzfluVar, zzflsVar, null);
    }

    protected final void zzj(zzflu zzfluVar, zzfls zzflsVar, JSONObject jSONObject) {
        String strZzh = zzfluVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfnf.zze(jSONObject2, "environment", App.TYPE);
        zzfnf.zze(jSONObject2, "adSessionType", zzflsVar.zzd());
        JSONObject jSONObject3 = new JSONObject();
        zzfnf.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzfnf.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfnf.zze(jSONObject3, "os", v8.f15653d);
        zzfnf.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfnf.zze(jSONObject2, "deviceCategory", zzfne.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfnf.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfnf.zze(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, zzflsVar.zze().zzb());
        zzfnf.zze(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, zzflsVar.zze().zzc());
        zzfnf.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfnf.zze(jSONObject5, "libraryVersion", "1.4.10-google_20240110");
        zzfnf.zze(jSONObject5, "appId", zzfmq.zzb().zza().getApplicationContext().getPackageName());
        zzfnf.zze(jSONObject2, App.TYPE, jSONObject5);
        if (zzflsVar.zzf() != null) {
            zzfnf.zze(jSONObject2, "contentUrl", zzflsVar.zzf());
        }
        if (zzflsVar.zzg() != null) {
            zzfnf.zze(jSONObject2, "customReferenceData", zzflsVar.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzflsVar.zzh().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfms.zza().zzi(zza(), strZzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzk(boolean z10) {
        if (this.zzb.get() != 0) {
            zzfms.zza().zzh(zza(), this.zza, true != z10 ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzl(float f10) {
        zzfms.zza().zze(zza(), this.zza, f10);
    }

    final void zzm(WebView webView) {
        this.zzb = new zzfob(webView);
    }

    public void zzn() {
    }
}
