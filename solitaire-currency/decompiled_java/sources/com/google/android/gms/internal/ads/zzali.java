package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzali {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzek zzc = new zzek();
    private final StringBuilder zzd = new StringBuilder();

    @Nullable
    static String zza(zzek zzekVar, StringBuilder sb) {
        zzc(zzekVar);
        if (zzekVar.zzb() == 0) {
            return null;
        }
        String strZzd = zzd(zzekVar, sb);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzekVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cZzm);
        return sb2.toString();
    }

    static void zzc(zzek zzekVar) {
        while (true) {
            for (boolean z10 = true; zzekVar.zzb() > 0 && z10; z10 = false) {
                char c10 = (char) zzekVar.zzM()[zzekVar.zzd()];
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    zzekVar.zzL(1);
                } else {
                    int iZzd = zzekVar.zzd();
                    int iZze = zzekVar.zze();
                    byte[] bArrZzM = zzekVar.zzM();
                    if (iZzd + 2 <= iZze) {
                        int i10 = iZzd + 1;
                        if (bArrZzM[iZzd] == 47) {
                            int i11 = i10 + 1;
                            if (bArrZzM[i10] == 42) {
                                while (true) {
                                    int i12 = i11 + 1;
                                    if (i12 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzM[i11]) == '*' && ((char) bArrZzM[i12]) == '/') {
                                        iZze = i12 + 1;
                                        i11 = iZze;
                                    } else {
                                        i11 = i12;
                                    }
                                }
                                zzekVar.zzL(iZze - zzekVar.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzek zzekVar, StringBuilder sb) {
        boolean z10;
        char c10;
        sb.setLength(0);
        int iZzd = zzekVar.zzd();
        int iZze = zzekVar.zze();
        loop0: while (true) {
            for (false; iZzd < iZze && !z10; true) {
                c10 = (char) zzekVar.zzM()[iZzd];
                z10 = (c10 < 'A' || c10 > 'Z') && (c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_');
            }
            sb.append(c10);
            iZzd++;
        }
        zzekVar.zzL(iZzd - zzekVar.zzd());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x031a, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzb(com.google.android.gms.internal.ads.zzek r18) {
        /*
            Method dump skipped, instruction units count: 795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzb(com.google.android.gms.internal.ads.zzek):java.util.List");
    }
}
