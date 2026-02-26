package com.google.android.gms.games.internal.v2.resolution;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzc {
    private final boolean zza;
    private final Intent zzb;

    private zzc(boolean z10, Intent intent) {
        this.zza = z10;
        this.zzb = intent;
    }

    public static zzc zzb(Intent intent) {
        return new zzc(false, intent);
    }

    public static zzc zzc(Intent intent) {
        return new zzc(true, intent);
    }

    public final Intent zza() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza;
    }
}
