package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbjl implements zzbjm {
    final /* synthetic */ zzbzt zza;

    zzbjl(zzbjn zzbjnVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zza(@Nullable String str) {
        this.zza.zzd(new zzbnd(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
