package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbit implements zzbix {
    zzbit() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcejVar.zzdg();
        } else if ("resume".equals(str)) {
            zzcejVar.zzdh();
        }
    }
}
