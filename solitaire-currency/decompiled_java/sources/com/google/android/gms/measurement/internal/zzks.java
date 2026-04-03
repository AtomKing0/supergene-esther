package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzks {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final long zzc;
    boolean zzd;
    public final boolean zze;
    public final long zzf;

    public zzks(@Nullable String str, @Nullable String str2, long j10) {
        this(str, str2, j10, false, 0L);
    }

    public zzks(@Nullable String str, @Nullable String str2, long j10, boolean z10, long j11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j10;
        this.zzd = false;
        this.zze = z10;
        this.zzf = j11;
    }
}
