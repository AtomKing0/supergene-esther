package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapn {

    @Nullable
    public final Object zza;

    @Nullable
    public final zzaoq zzb;

    @Nullable
    public final zzapq zzc;
    public boolean zzd;

    private zzapn(zzapq zzapqVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzapqVar;
    }

    public static zzapn zza(zzapq zzapqVar) {
        return new zzapn(zzapqVar);
    }

    public static zzapn zzb(@Nullable Object obj, @Nullable zzaoq zzaoqVar) {
        return new zzapn(obj, zzaoqVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }

    private zzapn(@Nullable Object obj, @Nullable zzaoq zzaoqVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaoqVar;
        this.zzc = null;
    }
}
