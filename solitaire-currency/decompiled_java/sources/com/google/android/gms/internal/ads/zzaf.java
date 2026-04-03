package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaf {
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    public final int zzG;
    private int zzH;

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final List zzc;

    @Nullable
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;

    @Nullable
    public final String zzj;

    @Nullable
    public final zzbk zzk;

    @Nullable
    public final String zzl;

    @Nullable
    public final String zzm;
    public final int zzn;
    public final List zzo;

    @Nullable
    public final zzy zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;

    @Nullable
    public final byte[] zzw;
    public final int zzx;

    @Nullable
    public final zzo zzy;
    public final int zzz;

    static {
        new zzaf(new zzad());
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
    }

    public final boolean equals(@Nullable Object obj) {
        int i10;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaf.class == obj.getClass()) {
            zzaf zzafVar = (zzaf) obj;
            int i11 = this.zzH;
            if ((i11 == 0 || (i10 = zzafVar.zzH) == 0 || i11 == i10) && this.zze == zzafVar.zze && this.zzf == zzafVar.zzf && this.zzg == zzafVar.zzg && this.zzh == zzafVar.zzh && this.zzn == zzafVar.zzn && this.zzq == zzafVar.zzq && this.zzr == zzafVar.zzr && this.zzs == zzafVar.zzs && this.zzu == zzafVar.zzu && this.zzx == zzafVar.zzx && this.zzz == zzafVar.zzz && this.zzA == zzafVar.zzA && this.zzB == zzafVar.zzB && this.zzC == zzafVar.zzC && this.zzD == zzafVar.zzD && this.zzE == zzafVar.zzE && this.zzG == zzafVar.zzG && Float.compare(this.zzt, zzafVar.zzt) == 0 && Float.compare(this.zzv, zzafVar.zzv) == 0 && zzet.zzG(this.zza, zzafVar.zza) && zzet.zzG(this.zzb, zzafVar.zzb) && this.zzc.equals(zzafVar.zzc) && zzet.zzG(this.zzj, zzafVar.zzj) && zzet.zzG(this.zzl, zzafVar.zzl) && zzet.zzG(this.zzm, zzafVar.zzm) && zzet.zzG(this.zzd, zzafVar.zzd) && Arrays.equals(this.zzw, zzafVar.zzw) && zzet.zzG(this.zzk, zzafVar.zzk) && zzet.zzG(this.zzy, zzafVar.zzy) && zzet.zzG(this.zzp, zzafVar.zzp) && zzd(zzafVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzH;
        if (i10 != 0) {
            return i10;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = ((((iHashCode + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31) + this.zzc.hashCode();
        String str3 = this.zzd;
        int iHashCode3 = ((((((((((iHashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31;
        String str4 = this.zzj;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzbk zzbkVar = this.zzk;
        int iHashCode5 = (iHashCode4 + (zzbkVar == null ? 0 : zzbkVar.hashCode())) * 31;
        String str5 = this.zzl;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        int iHashCode7 = ((((((((((((((((((((((((((((((((((iHashCode6 + (this.zzm != null ? r2.hashCode() : 0)) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31) + Float.floatToIntBits(this.zzt)) * 31) + this.zzu) * 31) + Float.floatToIntBits(this.zzv)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) - 1) * 31) - 1) * 31) + this.zzG;
        this.zzH = iHashCode7;
        return iHashCode7;
    }

    public final String toString() {
        return "Format(" + this.zza + ", " + this.zzb + ", " + this.zzl + ", " + this.zzm + ", " + this.zzj + ", " + this.zzi + ", " + this.zzd + ", [" + this.zzr + ", " + this.zzs + ", " + this.zzt + ", " + String.valueOf(this.zzy) + "], [" + this.zzz + ", " + this.zzA + "])";
    }

    public final int zza() {
        int i10;
        int i11 = this.zzr;
        if (i11 == -1 || (i10 = this.zzs) == -1) {
            return -1;
        }
        return i11 * i10;
    }

    public final zzad zzb() {
        return new zzad(this, null);
    }

    public final zzaf zzc(int i10) {
        zzad zzadVar = new zzad(this, null);
        zzadVar.zzC(i10);
        return new zzaf(zzadVar);
    }

    public final boolean zzd(zzaf zzafVar) {
        if (this.zzo.size() != zzafVar.zzo.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.zzo.size(); i10++) {
            if (!Arrays.equals((byte[]) this.zzo.get(i10), (byte[]) zzafVar.zzo.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private zzaf(zzad zzadVar) {
        boolean z10;
        String str;
        this.zza = zzadVar.zza;
        String strZzD = zzet.zzD(zzadVar.zzd);
        this.zzd = strZzD;
        if (zzadVar.zzc.isEmpty() && zzadVar.zzb != null) {
            this.zzc = zzfxr.zzn(new zzak(strZzD, zzadVar.zzb));
            this.zzb = zzadVar.zzb;
        } else if (!zzadVar.zzc.isEmpty() && zzadVar.zzb == null) {
            this.zzc = zzadVar.zzc;
            List list = zzadVar.zzc;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzak) list.get(0)).zzb;
                    break;
                }
                zzak zzakVar = (zzak) it.next();
                if (TextUtils.equals(zzakVar.zza, strZzD)) {
                    str = zzakVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        } else if (zzadVar.zzc.isEmpty() && zzadVar.zzb == null) {
            z10 = true;
            zzdi.zzf(z10);
            this.zzc = zzadVar.zzc;
            this.zzb = zzadVar.zzb;
        } else {
            for (int i10 = 0; i10 < zzadVar.zzc.size(); i10++) {
                if (((zzak) zzadVar.zzc.get(i10)).zzb.equals(zzadVar.zzb)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            zzdi.zzf(z10);
            this.zzc = zzadVar.zzc;
            this.zzb = zzadVar.zzb;
        }
        this.zze = zzadVar.zze;
        this.zzf = zzadVar.zzf;
        int i11 = zzadVar.zzg;
        this.zzg = i11;
        int i12 = zzadVar.zzh;
        this.zzh = i12;
        this.zzi = i12 != -1 ? i12 : i11;
        this.zzj = zzadVar.zzi;
        this.zzk = zzadVar.zzj;
        this.zzl = zzadVar.zzk;
        this.zzm = zzadVar.zzl;
        this.zzn = zzadVar.zzm;
        this.zzo = zzadVar.zzn == null ? Collections.emptyList() : zzadVar.zzn;
        zzy zzyVar = zzadVar.zzo;
        this.zzp = zzyVar;
        this.zzq = zzadVar.zzp;
        this.zzr = zzadVar.zzq;
        this.zzs = zzadVar.zzr;
        this.zzt = zzadVar.zzs;
        this.zzu = zzadVar.zzt == -1 ? 0 : zzadVar.zzt;
        this.zzv = zzadVar.zzu == -1.0f ? 1.0f : zzadVar.zzu;
        this.zzw = zzadVar.zzv;
        this.zzx = zzadVar.zzw;
        this.zzy = zzadVar.zzx;
        this.zzz = zzadVar.zzy;
        this.zzA = zzadVar.zzz;
        this.zzB = zzadVar.zzA;
        this.zzC = zzadVar.zzB == -1 ? 0 : zzadVar.zzB;
        this.zzD = zzadVar.zzC != -1 ? zzadVar.zzC : 0;
        this.zzE = zzadVar.zzD;
        this.zzF = zzadVar.zzE;
        if (zzadVar.zzF != 0 || zzyVar == null) {
            this.zzG = zzadVar.zzF;
        } else {
            this.zzG = 1;
        }
    }
}
