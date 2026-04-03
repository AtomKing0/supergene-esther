package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakq {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzakq(int i10, int i11, int i12, int i13, int i14) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static zzakq zza(String str) {
        byte b10;
        zzdi.zzd(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i10 >= length) {
                if (i11 == -1 || i12 == -1 || i14 == -1) {
                    return null;
                }
                return new zzakq(i11, i12, i13, i14, length);
            }
            String strZza = zzfuf.zza(strArrSplit[i10].trim());
            switch (strZza.hashCode()) {
                case 100571:
                    b10 = !strZza.equals(TtmlNode.END) ? (byte) -1 : (byte) 1;
                    break;
                case 3556653:
                    b10 = !strZza.equals("text") ? (byte) -1 : (byte) 3;
                    break;
                case 109757538:
                    b10 = !strZza.equals(TtmlNode.START) ? (byte) -1 : (byte) 0;
                    break;
                case 109780401:
                    b10 = !strZza.equals(TtmlNode.TAG_STYLE) ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b10 = -1;
                    break;
            }
            if (b10 == 0) {
                i11 = i10;
            } else if (b10 == 1) {
                i12 = i10;
            } else if (b10 == 2) {
                i13 = i10;
            } else if (b10 == 3) {
                i14 = i10;
            }
            i10++;
        }
    }
}
