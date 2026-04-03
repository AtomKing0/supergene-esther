package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.services.UnityAdsConstants;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo {
    public static final zzo zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;

    @Nullable
    public final byte[] zze;
    public final int zzf;
    public final int zzg;
    private int zzh;

    static {
        zzm zzmVar = new zzm();
        zzmVar.zzc(1);
        zzmVar.zzb(2);
        zzmVar.zzd(3);
        zza = zzmVar.zzg();
        zzm zzmVar2 = new zzm();
        zzmVar2.zzc(1);
        zzmVar2.zzb(1);
        zzmVar2.zzd(2);
        zzmVar2.zzg();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzo(int i10, int i11, int i12, byte[] bArr, int i13, int i14, zzn zznVar) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = bArr;
        this.zzf = i13;
        this.zzg = i14;
    }

    public static int zza(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int zzb(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 4) {
            return 10;
        }
        if (i10 == 13) {
            return 2;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static boolean zzg(@Nullable zzo zzoVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (zzoVar == null) {
            return true;
        }
        int i14 = zzoVar.zzb;
        return (i14 == -1 || i14 == 1 || i14 == 2) && ((i10 = zzoVar.zzc) == -1 || i10 == 2) && (((i11 = zzoVar.zzd) == -1 || i11 == 3) && zzoVar.zze == null && (((i12 = zzoVar.zzg) == -1 || i12 == 8) && ((i13 = zzoVar.zzf) == -1 || i13 == 8)));
    }

    private static String zzh(int i10) {
        if (i10 == -1) {
            return "Unset color range";
        }
        if (i10 == 1) {
            return "Full range";
        }
        if (i10 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i10;
    }

    private static String zzi(int i10) {
        if (i10 == -1) {
            return "Unset color space";
        }
        if (i10 == 6) {
            return "BT2020";
        }
        if (i10 == 1) {
            return "BT709";
        }
        if (i10 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i10;
    }

    private static String zzj(int i10) {
        if (i10 == -1) {
            return "Unset color transfer";
        }
        if (i10 == 10) {
            return "Gamma 2.2";
        }
        if (i10 == 1) {
            return "Linear";
        }
        if (i10 == 2) {
            return "sRGB";
        }
        if (i10 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i10 == 6) {
            return "ST2084 PQ";
        }
        if (i10 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzo.class == obj.getClass()) {
            zzo zzoVar = (zzo) obj;
            if (this.zzb == zzoVar.zzb && this.zzc == zzoVar.zzc && this.zzd == zzoVar.zzd && Arrays.equals(this.zze, zzoVar.zze) && this.zzf == zzoVar.zzf && this.zzg == zzoVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzh;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = ((((((((((this.zzb + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzc) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze)) * 31) + this.zzf) * 31) + this.zzg;
        this.zzh = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String str;
        int i10 = this.zzf;
        int i11 = this.zzd;
        int i12 = this.zzc;
        String strZzi = zzi(this.zzb);
        String strZzh = zzh(i12);
        String strZzj = zzj(i11);
        String str2 = "NA";
        if (i10 != -1) {
            str = i10 + "bit Luma";
        } else {
            str = "NA";
        }
        int i13 = this.zzg;
        if (i13 != -1) {
            str2 = i13 + "bit Chroma";
        }
        return "ColorInfo(" + strZzi + ", " + strZzh + ", " + strZzj + ", " + (this.zze != null) + ", " + str + ", " + str2 + ")";
    }

    public final zzm zzc() {
        return new zzm(this, null);
    }

    public final String zzd() {
        String str;
        String str2 = zzf() ? String.format(Locale.US, "%s/%s/%s", zzi(this.zzb), zzh(this.zzc), zzj(this.zzd)) : "NA/NA/NA";
        if (zze()) {
            str = this.zzf + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + this.zzg;
        } else {
            str = "NA/NA";
        }
        return str2 + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + str;
    }

    public final boolean zze() {
        return (this.zzf == -1 || this.zzg == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzb == -1 || this.zzc == -1 || this.zzd == -1) ? false : true;
    }
}
