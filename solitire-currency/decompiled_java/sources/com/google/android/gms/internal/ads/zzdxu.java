package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxu {
    private final zzcgj zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfkf zzg;
    private final zzdsf zzh;
    private final Object zzi = new Object();

    public zzdxu(zzcgj zzcgjVar, Context context, VersionInfoParcel versionInfoParcel, zzffg zzffgVar, Executor executor, String str, zzfkf zzfkfVar, zzdsf zzdsfVar) {
        this.zza = zzcgjVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = zzffgVar;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfkfVar;
        zzcgjVar.zzx();
        this.zzh = zzdsfVar;
    }

    private final m zzc(final String str, final String str2) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zzb, 11);
        zzfjuVarZza.zzi();
        zzbno zzbnoVarZza = com.google.android.gms.ads.internal.zzu.zzf().zza(this.zzb, this.zzc, this.zza.zzz());
        zzbni zzbniVar = zzbnl.zza;
        final zzbne zzbneVarZza = zzbnoVarZza.zza("google.afma.response.normalize", zzbniVar, zzbniVar);
        m mVarZzn = zzgcj.zzn(zzgcj.zzn(zzgcj.zzn(zzgcj.zzh(""), new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzdxr
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str3 = str;
                String str4 = str2;
                try {
                    jSONObject3.put("headers", new JSONObject());
                    jSONObject3.put("body", str3);
                    jSONObject2.put("base_url", "");
                    jSONObject2.put("signals", new JSONObject(str4));
                    jSONObject.put(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, jSONObject2);
                    jSONObject.put("response", jSONObject3);
                    jSONObject.put("flags", new JSONObject());
                    return zzgcj.zzh(jSONObject);
                } catch (JSONException e10) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(e10.getCause())));
                }
            }
        }, this.zze), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxs
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzbneVarZza.zzb((JSONObject) obj);
            }
        }, this.zze), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxt
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb((JSONObject) obj);
            }
        }, this.zze);
        zzfke.zza(mVarZzn, this.zzg, zzfjuVarZza);
        return mVarZzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to update the ad types for rendering. ".concat(e10.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    private static final String zzf(String str, String str2, String str3, zzdsf zzdsfVar) {
        if (!TextUtils.isEmpty(str3)) {
            Boolean bool = new JSONObject(str3).optString("is_gbid").equals(com.ironsource.mediationsdk.metadata.a.f13688g) ? Boolean.TRUE : Boolean.FALSE;
            if (bool.booleanValue()) {
                int iLastIndexOf = str.lastIndexOf(v8.i.f15835c);
                String string = null;
                String strSubstring = iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : null;
                if (!TextUtils.isEmpty(strSubstring)) {
                    try {
                        byte[] bArrDecode = Base64.decode(strSubstring, 11);
                        byte[] bytes = str2.getBytes("UTF-8");
                        try {
                            string = new JSONObject(str3).getString("arek");
                        } catch (JSONException e10) {
                            com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e10.toString()));
                            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CryptoUtils.getKeyFromQueryJsonMap");
                        }
                        return zzffv.zzb(bArrDecode, bytes, string, zzdsfVar);
                    } catch (UnsupportedEncodingException e11) {
                        com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e11.toString()));
                        com.google.android.gms.ads.internal.zzu.zzo().zzw(e11, "PreloadedLoader.decryptAdResponseIfNecessary");
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0130 A[Catch: all -> 0x0135, TryCatch #1 {, blocks: (B:20:0x0063, B:22:0x007f, B:23:0x0085, B:24:0x008a, B:26:0x0095, B:29:0x009f, B:33:0x00c3, B:35:0x00d8, B:36:0x00eb, B:32:0x00ad, B:37:0x00f8, B:40:0x0115, B:42:0x011b, B:43:0x0128, B:45:0x012a, B:48:0x0133, B:47:0x0130), top: B:78:0x0063, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.m zza() {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxu.zza():com.google.common.util.concurrent.m");
    }

    final /* synthetic */ m zzb(JSONObject jSONObject) throws Exception {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zzd), zzfew.zza(new StringReader(jSONObject.toString()), null)));
    }
}
