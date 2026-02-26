package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcd {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzaf[] zzd;
    private int zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzcd(String str, zzaf... zzafVarArr) {
        int length = zzafVarArr.length;
        int i10 = 1;
        zzdi.zzd(length > 0);
        this.zzb = str;
        this.zzd = zzafVarArr;
        this.zza = length;
        int iZzb = zzbn.zzb(zzafVarArr[0].zzm);
        this.zzc = iZzb == -1 ? zzbn.zzb(zzafVarArr[0].zzl) : iZzb;
        String strZzc = zzc(zzafVarArr[0].zzd);
        int i11 = zzafVarArr[0].zzf | 16384;
        while (true) {
            zzaf[] zzafVarArr2 = this.zzd;
            if (i10 >= zzafVarArr2.length) {
                return;
            }
            if (!strZzc.equals(zzc(zzafVarArr2[i10].zzd))) {
                zzaf[] zzafVarArr3 = this.zzd;
                zzd("languages", zzafVarArr3[0].zzd, zzafVarArr3[i10].zzd, i10);
                return;
            } else {
                zzaf[] zzafVarArr4 = this.zzd;
                if (i11 != (zzafVarArr4[i10].zzf | 16384)) {
                    zzd("role flags", Integer.toBinaryString(zzafVarArr4[0].zzf), Integer.toBinaryString(this.zzd[i10].zzf), i10);
                    return;
                }
                i10++;
            }
        }
    }

    private static String zzc(@Nullable String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static void zzd(String str, @Nullable String str2, @Nullable String str3, int i10) {
        zzea.zzd("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i10 + ")"));
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcd.class == obj.getClass()) {
            zzcd zzcdVar = (zzcd) obj;
            if (this.zzb.equals(zzcdVar.zzb) && Arrays.equals(this.zzd, zzcdVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zze;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = ((this.zzb.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Arrays.hashCode(this.zzd);
        this.zze = iHashCode;
        return iHashCode;
    }

    public final int zza(zzaf zzafVar) {
        int i10 = 0;
        while (true) {
            zzaf[] zzafVarArr = this.zzd;
            if (i10 >= zzafVarArr.length) {
                return -1;
            }
            if (zzafVar == zzafVarArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public final zzaf zzb(int i10) {
        return this.zzd[i10];
    }
}
