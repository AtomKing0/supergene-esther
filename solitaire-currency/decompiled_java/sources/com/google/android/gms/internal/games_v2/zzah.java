package com.google.android.gms.internal.games_v2;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzah {
    public static String zza(int i10) {
        if (i10 == 0) {
            return "DAILY";
        }
        if (i10 == 1) {
            return "WEEKLY";
        }
        if (i10 == 2) {
            return "ALL_TIME";
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Unknown time span ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }
}
