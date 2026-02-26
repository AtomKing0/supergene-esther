package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzace {
    public final String zza;

    private zzace(int i10, int i11, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzace zza(zzek zzekVar) {
        String str;
        zzekVar.zzL(2);
        int iZzm = zzekVar.zzm();
        int i10 = iZzm >> 1;
        int i11 = iZzm & 1;
        int iZzm2 = zzekVar.zzm() >> 3;
        if (i10 == 4 || i10 == 5 || i10 == 7) {
            str = "dvhe";
        } else if (i10 == 8) {
            str = "hev1";
        } else {
            if (i10 != 9) {
                return null;
            }
            str = "avc3";
        }
        int i12 = iZzm2 | (i11 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i10);
        sb.append(i12 >= 10 ? "." : ".0");
        sb.append(i12);
        return new zzace(i10, i12, sb.toString());
    }
}
