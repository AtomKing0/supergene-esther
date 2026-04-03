package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrw implements zzcrx {
    private final Map zza;

    zzcrw(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcrx
    @Nullable
    public final zzeet zza(int i10, String str) {
        return (zzeet) this.zza.get(str);
    }
}
