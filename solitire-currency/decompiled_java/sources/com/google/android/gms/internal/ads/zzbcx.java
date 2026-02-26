package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbcx {
    private final ScheduledExecutorService zza;
    private final com.google.android.gms.ads.nonagon.signalgeneration.zze zzb;
    private Runnable zzc;
    private zzbcu zzd;
    private CustomTabsSession zze;
    private String zzf;
    private long zzg = 0;
    private long zzh;
    private JSONArray zzi;
    private Context zzj;

    @VisibleForTesting
    public zzbcx(ScheduledExecutorService scheduledExecutorService, com.google.android.gms.ads.nonagon.signalgeneration.zze zzeVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zziT)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbcu r0 = r5.zzd
            if (r0 != 0) goto La
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            return
        La:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L15
            return
        L15:
            java.lang.String r0 = r5.zzf
            if (r0 == 0) goto L70
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zze
            if (r0 == 0) goto L70
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            if (r0 == 0) goto L70
            long r0 = r5.zzg
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L2a
            goto L39
        L2a:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r0 = r0.elapsedRealtime()
            long r2 = r5.zzg
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L39
            goto L4b
        L39:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zziT
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L70
        L4b:
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zze
            java.lang.String r1 = r5.zzf
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.requestPostMessageChannel(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            java.lang.Runnable r1 = r5.zzc
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zziU
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L70:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzi == null) {
                this.zzi = new JSONArray((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziW));
            }
            jSONObject.put("eids", this.zzi);
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error fetching the PACT active eids JSON: ", e10);
        }
    }

    public final CustomTabsSession zzb() {
        return this.zze;
    }

    @VisibleForTesting
    final JSONObject zzc(String str, String str2) throws JSONException {
        long jLongValue;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            jLongValue = 0;
        }
        jSONObject.put("sdk_ttl_ms", jLongValue);
        zzk(jSONObject);
        return jSONObject;
    }

    @VisibleForTesting
    final JSONObject zzd(String str, String str2) throws JSONException {
        long jLongValue;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            jLongValue = 0;
        }
        jSONObject.put("sdk_ttl_ms", jLongValue);
        zzk(jSONObject);
        return jSONObject;
    }

    final void zzf() {
        this.zzg = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziS)).intValue());
        if (this.zzc == null) {
            this.zzc = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbcv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj();
                }
            };
        }
        zzj();
    }

    public final void zzg(Context context, CustomTabsClient customTabsClient, String str, CustomTabsCallback customTabsCallback) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        }
        if (customTabsClient == null) {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
        this.zzj = context;
        this.zzf = str;
        zzbcu zzbcuVar = new zzbcu(this, customTabsCallback);
        this.zzd = zzbcuVar;
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(zzbcuVar);
        this.zze = customTabsSessionNewSession;
        if (customTabsSessionNewSession == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("CustomTabsClient failed to create new session.");
        }
    }

    final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zze;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzh).toString());
            zzk(jSONObject);
            customTabsSession.postMessage(jSONObject.toString(), null);
            zzbcw zzbcwVar = new zzbcw(this, str);
            if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
                this.zzb.zzg(this.zze, zzbcwVar);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzj, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), zzbcwVar);
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error creating JSON: ", e10);
        }
    }

    public final void zzi(long j10) {
        this.zzh = j10;
    }
}
