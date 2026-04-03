package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgb implements zzfr {

    @Nullable
    private zzgu zzb;

    @Nullable
    private String zzc;
    private boolean zzf;
    private final zzgo zza = new zzgo();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzgb zzb(boolean z10) {
        this.zzf = true;
        return this;
    }

    public final zzgb zzc(int i10) {
        this.zzd = i10;
        return this;
    }

    public final zzgb zzd(int i10) {
        this.zze = i10;
        return this;
    }

    public final zzgb zze(@Nullable zzgu zzguVar) {
        this.zzb = zzguVar;
        return this;
    }

    public final zzgb zzf(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfr
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgg zza() {
        zzgg zzggVar = new zzgg(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzgu zzguVar = this.zzb;
        if (zzguVar != null) {
            zzggVar.zzf(zzguVar);
        }
        return zzggVar;
    }
}
