package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzblt {
    public static void zza(zzblu zzbluVar, String str, Map map) {
        try {
            zzbluVar.zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzj(map));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzblu zzbluVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        com.google.android.gms.ads.internal.util.client.zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbluVar.zza(sb.toString());
    }

    public static void zzc(zzblu zzbluVar, String str, String str2) {
        zzbluVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzblu zzbluVar, String str, JSONObject jSONObject) {
        zzbluVar.zzb(str, jSONObject.toString());
    }
}
