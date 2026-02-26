package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabv {
    public static void zza(long j10, zzek zzekVar, zzadp[] zzadpVarArr) {
        int iZzg;
        while (true) {
            if (zzekVar.zzb() <= 1) {
                return;
            }
            int iZzc = zzc(zzekVar);
            int iZzc2 = zzc(zzekVar);
            int iZzd = zzekVar.zzd() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzekVar.zzb()) {
                zzea.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzd = zzekVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzm = zzekVar.zzm();
                int iZzq = zzekVar.zzq();
                if (iZzq == 49) {
                    iZzg = zzekVar.zzg();
                    iZzq = 49;
                } else {
                    iZzg = 0;
                }
                int iZzm2 = zzekVar.zzm();
                if (iZzq == 47) {
                    zzekVar.zzL(1);
                    iZzq = 47;
                }
                boolean z10 = iZzm == 181 && (iZzq == 49 || iZzq == 47) && iZzm2 == 3;
                if (iZzq == 49) {
                    z10 &= iZzg == 1195456820;
                }
                if (z10) {
                    zzb(j10, zzekVar, zzadpVarArr);
                }
            }
            zzekVar.zzK(iZzd);
        }
    }

    public static void zzb(long j10, zzek zzekVar, zzadp[] zzadpVarArr) {
        int iZzm = zzekVar.zzm();
        if ((iZzm & 64) != 0) {
            int i10 = iZzm & 31;
            zzekVar.zzL(1);
            int iZzd = zzekVar.zzd();
            for (zzadp zzadpVar : zzadpVarArr) {
                int i11 = i10 * 3;
                zzekVar.zzK(iZzd);
                zzadpVar.zzq(zzekVar, i11);
                zzdi.zzf(j10 != C.TIME_UNSET);
                zzadpVar.zzs(j10, 1, i11, 0, null);
            }
        }
    }

    private static int zzc(zzek zzekVar) {
        int i10 = 0;
        while (zzekVar.zzb() != 0) {
            int iZzm = zzekVar.zzm();
            i10 += iZzm;
            if (iZzm != 255) {
                return i10;
            }
        }
        return -1;
    }
}
