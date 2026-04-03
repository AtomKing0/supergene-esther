package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabs {
    public static final zzabs zza = new zzabs(-3, C.TIME_UNSET, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzabs(int i10, long j10, long j11) {
        this.zzb = i10;
        this.zzc = j10;
        this.zzd = j11;
    }

    public static zzabs zzd(long j10, long j11) {
        return new zzabs(-1, j10, j11);
    }

    public static zzabs zze(long j10) {
        return new zzabs(0, C.TIME_UNSET, j10);
    }

    public static zzabs zzf(long j10, long j11) {
        return new zzabs(-2, j10, j11);
    }
}
