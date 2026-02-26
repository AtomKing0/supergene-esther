package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjn implements zzbix {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get(v8.f.f15748e);
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            zzbjm zzbjmVar = (zzbjm) this.zzb.remove(str);
            if (zzbjmVar == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Received result for unexpected method invocation: " + str);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                zzbjmVar.zza(str3 + strConcat);
                return;
            }
            if (str5 == null) {
                zzbjmVar.zzb(null);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Result GMSG: " + jSONObject.toString(2));
                }
                zzbjmVar.zzb(jSONObject);
            } catch (JSONException e10) {
                zzbjmVar.zza(e10.getMessage());
            }
        }
    }

    public final m zzb(zzbme zzbmeVar, String str, JSONObject jSONObject) {
        zzbzt zzbztVar = new zzbzt();
        com.google.android.gms.ads.internal.zzu.zzp();
        String string = UUID.randomUUID().toString();
        zzc(string, new zzbjl(this, zzbztVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbmeVar.zzl(str, jSONObject2);
        } catch (Exception e10) {
            zzbztVar.zzd(e10);
        }
        return zzbztVar;
    }

    public final void zzc(String str, zzbjm zzbjmVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbjmVar);
        }
    }
}
