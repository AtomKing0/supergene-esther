package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzghh extends zzgex {
    private final zzghg zza;

    private zzghh(zzghg zzghgVar) {
        this.zza = zzghgVar;
    }

    public static zzghh zzc(zzghg zzghgVar) {
        return new zzghh(zzghgVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzghh) && ((zzghh) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzghh.class, this.zza);
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zza != zzghg.zzc;
    }

    public final zzghg zzb() {
        return this.zza;
    }
}
