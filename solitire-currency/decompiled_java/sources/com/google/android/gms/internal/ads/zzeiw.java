package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeiw {

    @Nullable
    private zzein zza;

    zzeiw() {
    }

    private zzeiw(zzein zzeinVar) {
        this.zza = zzeinVar;
    }

    public static zzeiw zzb(zzein zzeinVar) {
        return new zzeiw(zzeinVar);
    }

    public final zzein zza(Clock clock, zzeip zzeipVar, zzeey zzeeyVar, zzfll zzfllVar) {
        zzein zzeinVar = this.zza;
        return zzeinVar != null ? zzeinVar : new zzein(clock, zzeipVar, zzeeyVar, zzfllVar);
    }
}
