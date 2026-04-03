package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzag extends zza {
    private final BaseImplementation.ResultHolder zza;

    zzag(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
    }

    final void zzs(Object obj) {
        this.zza.setResult(obj);
    }
}
