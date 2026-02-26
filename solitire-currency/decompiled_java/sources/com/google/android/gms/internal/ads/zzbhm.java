package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhm implements zzbix {
    private final zzbhn zza;

    public zzbhm(zzbhn zzbhnVar) {
        this.zza = zzbhnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzi("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZza = null;
        if (map.containsKey("info")) {
            try {
                bundleZza = com.google.android.gms.ads.internal.util.zzbs.zza(new JSONObject((String) map.get("info")));
            } catch (JSONException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Failed to convert ad metadata to JSON.", e10);
            }
        }
        if (bundleZza == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to convert ad metadata to Bundle.");
        } else {
            this.zza.zza(str, bundleZza);
        }
    }
}
