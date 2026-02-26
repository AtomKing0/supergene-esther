package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhg implements zzfhe {
    private final String zza;

    public zzfhg(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfhe
    public final boolean equals(Object obj) {
        if (obj instanceof zzfhg) {
            return this.zza.equals(((zzfhg) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfhe
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
