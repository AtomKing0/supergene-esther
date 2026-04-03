package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbid implements zzbix {
    zzbid() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcej zzcejVar = (zzcej) obj;
        zzber zzberVarZzK = zzcejVar.zzK();
        if (zzberVarZzK == null || (jSONObjectZzb = zzberVarZzK.zzb()) == null) {
            zzcejVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcejVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
