package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbns implements zzbne {
    private final zzbng zza;
    private final zzbnh zzb;
    private final zzbna zzc;
    private final String zzd;

    zzbns(zzbna zzbnaVar, String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        this.zzc = zzbnaVar;
        this.zzd = str;
        this.zzb = zzbnhVar;
        this.zza = zzbngVar;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbns zzbnsVar, zzbmu zzbmuVar, zzbnb zzbnbVar, Object obj, zzbzt zzbztVar) {
        try {
            com.google.android.gms.ads.internal.zzu.zzp();
            String string = UUID.randomUUID().toString();
            zzbiw.zzo.zzc(string, new zzbnr(zzbnsVar, zzbmuVar, zzbztVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzbnsVar.zzb.zzb(obj));
            zzbnbVar.zzl(zzbnsVar.zzd, jSONObject);
        } catch (Exception e10) {
            try {
                zzbztVar.zzd(e10);
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to invokeJavascript", e10);
            } finally {
                zzbmuVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final m zza(@Nullable Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final m zzb(Object obj) {
        zzbzt zzbztVar = new zzbzt();
        zzbmu zzbmuVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzbmuVarZzb.zzj(new zzbnp(this, zzbmuVarZzb, obj, zzbztVar), new zzbnq(this, zzbztVar, zzbmuVarZzb));
        return zzbztVar;
    }
}
