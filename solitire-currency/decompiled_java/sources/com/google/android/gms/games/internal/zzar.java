package com.google.android.gms.games.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzar {
    private static final zzar zza = new zzar();
    private volatile boolean zzb = false;

    zzar() {
    }

    public static zzar zza() {
        return zza;
    }

    public final void zzb() {
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
