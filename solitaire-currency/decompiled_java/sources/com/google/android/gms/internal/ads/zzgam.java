package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgam {
    public static char zza(long j10) {
        char c10 = (char) j10;
        zzfuu.zzg(((long) c10) == j10, "Out of range: %s", j10);
        return c10;
    }

    public static char zzb(byte b10, byte b11) {
        return (char) ((b10 << 8) | (b11 & 255));
    }
}
