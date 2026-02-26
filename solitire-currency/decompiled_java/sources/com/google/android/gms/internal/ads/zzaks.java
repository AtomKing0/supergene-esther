package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaks {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzaks(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = i16;
        this.zzh = i17;
        this.zzi = i18;
        this.zzj = i19;
        this.zzk = i20;
    }

    @Nullable
    public static zzaks zza(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i10 >= length) {
                if (i11 != -1) {
                    return new zzaks(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, length);
                }
                return null;
            }
            switch (zzfuf.zza(strArrSplit[i10].trim())) {
                case "name":
                    i11 = i10;
                    break;
                case "alignment":
                    i12 = i10;
                    break;
                case "primarycolour":
                    i13 = i10;
                    break;
                case "outlinecolour":
                    i14 = i10;
                    break;
                case "fontsize":
                    i15 = i10;
                    break;
                case "bold":
                    i16 = i10;
                    break;
                case "italic":
                    i17 = i10;
                    break;
                case "underline":
                    i18 = i10;
                    break;
                case "strikeout":
                    i19 = i10;
                    break;
                case "borderstyle":
                    i20 = i10;
                    break;
            }
            i10++;
        }
    }
}
