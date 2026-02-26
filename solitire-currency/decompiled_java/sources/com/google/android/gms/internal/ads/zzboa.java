package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboa implements zzgbq {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final m zzb;

    zzboa(m mVar, String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        this.zzb = mVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final m zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final m zzb(final Object obj) {
        return zzgcj.zzn(this.zzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbny
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj2) {
                return this.zza.zzc(obj, (zzbnb) obj2);
            }
        }, zzbzo.zzf);
    }

    final /* synthetic */ m zzc(Object obj, zzbnb zzbnbVar) throws Exception {
        zzbzt zzbztVar = new zzbzt();
        com.google.android.gms.ads.internal.zzu.zzp();
        String string = UUID.randomUUID().toString();
        zzbiw.zzo.zzc(string, new zzbnz(this, zzbztVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbnbVar.zzl(this.zza, jSONObject);
        return zzbztVar;
    }
}
