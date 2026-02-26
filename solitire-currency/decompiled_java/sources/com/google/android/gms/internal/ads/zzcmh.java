package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.m;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcmh implements zzcly {
    private final zzeer zza;

    zzcmh(zzeer zzeerVar) {
        this.zza = zzeerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjz)).booleanValue()) {
            zzgcj.zzf(zzgca.zzu(this.zza.zza(true)), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcmg
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    Throwable th = (Throwable) obj;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjA)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzu.zzo().zzx(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
                    } else {
                        com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "GetTopicsApiWithRecordObservationActionHandler");
                    }
                    return zzgcj.zzh(new GetTopicsResponse(zzfxr.zzm()));
                }
            }, zzbzo.zza);
        }
    }
}
