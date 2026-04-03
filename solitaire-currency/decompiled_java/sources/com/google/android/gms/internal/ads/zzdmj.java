package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmj {
    private final Executor zza;
    private final zzdme zzb;

    public zzdmj(Executor executor, zzdme zzdmeVar) {
        this.zza = executor;
        this.zzb = zzdmeVar;
    }

    public final m zza(JSONObject jSONObject, String str) {
        m mVarZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgcj.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject == null) {
                mVarZzh = zzgcj.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    mVarZzh = zzgcj.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    mVarZzh = TypedValues.Custom.S_STRING.equals(strOptString2) ? zzgcj.zzh(new zzdmi(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgcj.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value"), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmg
                        @Override // com.google.android.gms.internal.ads.zzful
                        public final Object apply(Object obj) {
                            return new zzdmi(strOptString, (zzbeq) obj);
                        }
                    }, this.zza) : zzgcj.zzh(null);
                }
            }
            arrayList.add(mVarZzh);
        }
        return zzgcj.zzm(zzgcj.zzd(arrayList), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmh
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdmi zzdmiVar : (List) obj) {
                    if (zzdmiVar != null) {
                        arrayList2.add(zzdmiVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
