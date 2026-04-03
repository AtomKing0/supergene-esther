package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeoo {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    @Nullable
    private zzeon zzb;

    @Nullable
    final zzeon zza() {
        return this.zzb;
    }

    final void zzb(zzeon zzeonVar) {
        this.zzb = zzeonVar;
    }

    public final void zzc(boolean z10) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
