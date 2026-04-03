package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbiq implements zzbix {
    zzbiq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Received log message: ".concat(String.valueOf((String) map.get(TypedValues.Custom.S_STRING))));
    }
}
