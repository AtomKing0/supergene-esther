package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeji implements zzeev {
    private final Map zza = new HashMap();
    private final zzdqb zzb;

    public zzeji(zzdqb zzdqbVar) {
        this.zzb = zzdqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    @Nullable
    public final zzeew zza(String str, JSONObject jSONObject) throws zzffn {
        zzeew zzeewVar;
        synchronized (this) {
            zzeewVar = (zzeew) this.zza.get(str);
            if (zzeewVar == null) {
                zzeewVar = new zzeew(this.zzb.zzc(str, jSONObject), new zzegq(), str);
                this.zza.put(str, zzeewVar);
            }
        }
        return zzeewVar;
    }
}
