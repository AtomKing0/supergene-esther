package com.google.android.gms.internal.games_v2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo {
    private int zza = 9;

    @Nullable
    private String zzb;

    /* synthetic */ zzo(zzn zznVar) {
    }

    public final zzo zza(int i10) {
        this.zza = 9;
        return this;
    }

    public final zzo zzb(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public final zzq zzc() {
        return new zzq(this.zza, this.zzb, null);
    }

    private zzo() {
    }
}
