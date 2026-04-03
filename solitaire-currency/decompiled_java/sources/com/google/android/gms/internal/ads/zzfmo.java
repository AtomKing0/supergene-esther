package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmo {
    private final zzfoa zza;
    private final String zzb;
    private final zzflx zzc;
    private final String zzd = "Ad overlay";

    public zzfmo(View view, zzflx zzflxVar, @Nullable String str) {
        this.zza = new zzfoa(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzflxVar;
    }

    public final zzflx zza() {
        return this.zzc;
    }

    public final zzfoa zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
