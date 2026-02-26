package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzg {

    @Nullable
    private final QueryInfo zza;
    private final String zzb;
    private final long zzc;
    private final int zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);

    public zzg(@Nullable QueryInfo queryInfo, String str, long j10, int i10) {
        this.zza = queryInfo;
        this.zzb = str;
        this.zzc = j10;
        this.zzd = i10;
    }

    public final int zza() {
        return this.zzd;
    }

    @Nullable
    public final QueryInfo zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final void zzd() {
        this.zze.set(true);
    }

    public final boolean zze() {
        return this.zzc <= com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
    }

    public final boolean zzf() {
        return this.zze.get();
    }
}
