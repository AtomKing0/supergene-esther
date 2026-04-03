package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbiz implements zzbix {
    private final zzbja zza;

    public zzbiz(zzbja zzbjaVar) {
        this.zza = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f10 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f10 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Fail to parse float", e10);
        }
        this.zza.zzc(zEquals);
        this.zza.zzb(zEquals2, f10);
        zzcejVar.zzay(zEquals);
    }
}
