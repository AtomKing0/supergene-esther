package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbik implements zzbix {
    zzbik() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfuf.zzc(com.ironsource.mediationsdk.metadata.a.f13688g, str) && !zzfuf.zzc("false", str)) {
                return;
            }
            zzfsc.zzi(zzcejVar.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
