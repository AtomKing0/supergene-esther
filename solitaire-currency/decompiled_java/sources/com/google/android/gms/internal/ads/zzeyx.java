package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzeyx implements zzevo {
    @Override // com.google.android.gms.internal.ads.zzevo
    public final /* synthetic */ int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzeyy
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                try {
                    ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451000);
                } catch (JSONException unused) {
                }
            }
        });
    }
}
