package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbdx;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbf extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbf(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        this.zzb = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        long jLongValue;
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = this.zza;
        objArr[1] = str;
        zzbdc zzbdcVar = zzbdx.zza;
        if (((Boolean) zzbdcVar.zze()).booleanValue()) {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            jLongValue = 0;
        }
        objArr[2] = Long.valueOf(jLongValue);
        final String str2 = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'error': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", objArr);
        if (!((Boolean) zzbdcVar.zze()).booleanValue()) {
            this.zzb.zzb.evaluateJavascript(str2, null);
            return;
        }
        try {
            this.zzb.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbd
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb.zzb.evaluateJavascript(str2, null);
                }
            });
        } catch (RuntimeException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(e10, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        final String str;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbdx.zza.zze()).booleanValue() ? ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue() : 0L);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String str2 = this.zza;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = str2;
            objArr[1] = queryInfo.getQuery();
            objArr[2] = Long.valueOf(((Boolean) zzbdx.zza.zze()).booleanValue() ? ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue() : 0L);
            str = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'signal': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", objArr);
        }
        if (!((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzb.zzb.evaluateJavascript(str, null);
            return;
        }
        try {
            this.zzb.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbe
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb.zzb.evaluateJavascript(str, null);
                }
            });
        } catch (RuntimeException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(e10, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
        }
    }
}
