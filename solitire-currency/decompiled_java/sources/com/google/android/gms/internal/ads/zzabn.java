package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabn {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;

    @Nullable
    public final String zzk;

    private zzabn(List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f10, @Nullable String str) {
        this.zza = list;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = i15;
        this.zzh = i16;
        this.zzi = i17;
        this.zzj = f10;
        this.zzk = str;
    }

    public static zzabn zza(zzek zzekVar) throws zzbo {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String strZza;
        float f10;
        try {
            zzekVar.zzL(4);
            int iZzm = (zzekVar.zzm() & 3) + 1;
            if (iZzm == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzm2 = zzekVar.zzm() & 31;
            for (int i17 = 0; i17 < iZzm2; i17++) {
                arrayList.add(zzb(zzekVar));
            }
            int iZzm3 = zzekVar.zzm();
            for (int i18 = 0; i18 < iZzm3; i18++) {
                arrayList.add(zzb(zzekVar));
            }
            if (iZzm2 > 0) {
                zzfg zzfgVarZze = zzfh.zze((byte[]) arrayList.get(0), iZzm + 1, ((byte[]) arrayList.get(0)).length);
                int i19 = zzfgVarZze.zze;
                int i20 = zzfgVarZze.zzf;
                int i21 = zzfgVarZze.zzh + 8;
                int i22 = zzfgVarZze.zzi + 8;
                int i23 = zzfgVarZze.zzj;
                int i24 = zzfgVarZze.zzk;
                int i25 = zzfgVarZze.zzl;
                float f11 = zzfgVarZze.zzg;
                strZza = zzdk.zza(zzfgVarZze.zza, zzfgVarZze.zzb, zzfgVarZze.zzc);
                i15 = i24;
                i16 = i25;
                f10 = f11;
                i12 = i21;
                i13 = i22;
                i14 = i23;
                i10 = i19;
                i11 = i20;
            } else {
                i10 = -1;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = -1;
                i16 = -1;
                strZza = null;
                f10 = 1.0f;
            }
            return new zzabn(arrayList, iZzm, i10, i11, i12, i13, i14, i15, i16, f10, strZza);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw zzbo.zza("Error parsing AVC config", e10);
        }
    }

    private static byte[] zzb(zzek zzekVar) {
        int iZzq = zzekVar.zzq();
        int iZzd = zzekVar.zzd();
        zzekVar.zzL(iZzq);
        return zzdk.zzc(zzekVar.zzM(), iZzd, iZzq);
    }
}
