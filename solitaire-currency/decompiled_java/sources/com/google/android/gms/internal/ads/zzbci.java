package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzbci {
    private final long zza;

    @Nullable
    private final String zzb;

    @Nullable
    private final zzbci zzc;

    public zzbci(long j10, @Nullable String str, @Nullable zzbci zzbciVar) {
        this.zza = j10;
        this.zzb = str;
        this.zzc = zzbciVar;
    }

    public final long zza() {
        return this.zza;
    }

    @Nullable
    public final zzbci zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzb;
    }
}
