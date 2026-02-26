package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbnz implements zzbjm {
    private final zzbzt zza;

    public zzbnz(zzboa zzboaVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zza(@Nullable String str) {
        try {
            if (str == null) {
                this.zza.zzd(new zzbnd());
            } else {
                this.zza.zzd(new zzbnd(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zzb(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e10) {
            this.zza.zzd(e10);
        }
    }
}
