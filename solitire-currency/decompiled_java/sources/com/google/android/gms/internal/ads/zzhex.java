package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v8;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhex {
    final LinkedHashMap zza;

    zzhex(int i10) {
        this.zza = zzhez.zzb(i10);
    }

    final zzhex zza(Object obj, zzhfl zzhflVar) {
        zzhfk.zza(obj, v8.h.W);
        zzhfk.zza(zzhflVar, IronSourceConstants.EVENTS_PROVIDER);
        this.zza.put(obj, zzhflVar);
        return this;
    }
}
