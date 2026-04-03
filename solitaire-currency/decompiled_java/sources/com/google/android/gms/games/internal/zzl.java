package com.google.android.gms.games.internal;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzl {
    public static final zzl zza = new zzl(new zzj(null));
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;

    private zzl(zzj zzjVar) {
        this.zzb = zzjVar.zza;
        this.zzc = zzjVar.zzb;
        this.zzd = zzjVar.zzc;
    }

    public static zzj zza() {
        return new zzj(null);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzl.class == obj.getClass()) {
            zzl zzlVar = (zzl) obj;
            if (this.zzb == zzlVar.zzb && this.zzc == zzlVar.zzc && this.zzd == zzlVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzb ? 1 : 0) * 31) + (this.zzc ? 1 : 0)) * 31) + (this.zzd ? 1 : 0);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
