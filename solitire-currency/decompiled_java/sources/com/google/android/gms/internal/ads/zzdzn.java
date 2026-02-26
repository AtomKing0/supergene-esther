package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzn {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeaf zzc;

    zzdzn(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzeaf zzeafVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzeafVar;
    }

    final /* synthetic */ m zza(zzbuc zzbucVar) throws Exception {
        return this.zzc.zza(zzbucVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkG)).longValue());
    }

    public final m zzb(final zzbuc zzbucVar) {
        String str = zzbucVar.zzb;
        com.google.android.gms.ads.internal.zzu.zzp();
        return zzgcj.zzn(zzgcj.zzf(zzgca.zzu(com.google.android.gms.ads.internal.util.zzt.zzC(str) ? zzgcj.zzg(new zzdyp(1, "Ads signal service force local")) : zzgcj.zzf(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzdzj
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() {
                return this.zza.zza(zzbucVar);
            }
        }, this.zza), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzk
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgcj.zzg(cause);
            }
        }, this.zzb)), zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzl
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(null);
            }
        }, this.zzb), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzgcj.zzh(jSONObject);
                }
                try {
                    com.google.android.gms.ads.internal.zzu.zzp();
                    jSONObject = new JSONObject(com.google.android.gms.ads.internal.util.zzt.zzN(new InputStreamReader(inputStream)));
                } catch (IOException | JSONException e10) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                return zzgcj.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
