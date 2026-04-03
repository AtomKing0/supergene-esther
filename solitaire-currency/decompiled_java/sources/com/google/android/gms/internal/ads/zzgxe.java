package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxe implements zzhbh {
    private final zzgxd zza;

    private zzgxe(zzgxd zzgxdVar) {
        zzgyl.zzc(zzgxdVar, "output");
        this.zza = zzgxdVar;
        zzgxdVar.zze = this;
    }

    public static zzgxe zza(zzgxd zzgxdVar) {
        zzgxe zzgxeVar = zzgxdVar.zze;
        return zzgxeVar != null ? zzgxeVar : new zzgxe(zzgxdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzA(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzk(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z10) {
            while (i11 < zzgyyVar.size()) {
                this.zza.zzj(i10, zzgyyVar.zza(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgyyVar.size(); i15++) {
            zzgyyVar.zza(i15);
            i14 += 8;
        }
        this.zza.zzu(i14);
        while (i11 < zzgyyVar.size()) {
            this.zza.zzk(zzgyyVar.zza(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzB(int i10, int i11) throws IOException {
        this.zza.zzt(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzC(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzgxd zzgxdVar = this.zza;
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    zzgxdVar.zzt(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iZzD += zzgxd.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzu(iZzD);
            while (i11 < list.size()) {
                zzgxd zzgxdVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                zzgxdVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                zzgxd zzgxdVar3 = this.zza;
                int iZzd = zzgxzVar.zzd(i11);
                zzgxdVar3.zzt(i10, (iZzd >> 31) ^ (iZzd + iZzd));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzgxzVar.size(); i13++) {
            int iZzd2 = zzgxzVar.zzd(i13);
            iZzD2 += zzgxd.zzD((iZzd2 >> 31) ^ (iZzd2 + iZzd2));
        }
        this.zza.zzu(iZzD2);
        while (i11 < zzgxzVar.size()) {
            zzgxd zzgxdVar4 = this.zza;
            int iZzd3 = zzgxzVar.zzd(i11);
            zzgxdVar4.zzu((iZzd3 >> 31) ^ (iZzd3 + iZzd3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzD(int i10, long j10) throws IOException {
        this.zza.zzv(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzE(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzgxd zzgxdVar = this.zza;
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    zzgxdVar.zzv(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzE = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iZzE += zzgxd.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzu(iZzE);
            while (i11 < list.size()) {
                zzgxd zzgxdVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                zzgxdVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z10) {
            while (i11 < zzgyyVar.size()) {
                zzgxd zzgxdVar3 = this.zza;
                long jZza = zzgyyVar.zza(i11);
                zzgxdVar3.zzv(i10, (jZza >> 63) ^ (jZza + jZza));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzE2 = 0;
        for (int i13 = 0; i13 < zzgyyVar.size(); i13++) {
            long jZza2 = zzgyyVar.zza(i13);
            iZzE2 += zzgxd.zzE((jZza2 >> 63) ^ (jZza2 + jZza2));
        }
        this.zza.zzu(iZzE2);
        while (i11 < zzgyyVar.size()) {
            zzgxd zzgxdVar4 = this.zza;
            long jZza3 = zzgyyVar.zza(i11);
            zzgxdVar4.zzw((jZza3 >> 63) ^ (jZza3 + jZza3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    @Deprecated
    public final void zzF(int i10) throws IOException {
        this.zza.zzs(i10, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzG(int i10, String str) throws IOException {
        this.zza.zzq(i10, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzH(int i10, List list) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyv)) {
            while (i11 < list.size()) {
                this.zza.zzq(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        while (i11 < list.size()) {
            Object objZzc = zzgyvVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzq(i10, (String) objZzc);
            } else {
                this.zza.zzO(i10, (zzgwm) objZzc);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzI(int i10, int i11) throws IOException {
        this.zza.zzt(i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzJ(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzt(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzD += zzgxd.zzD(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzu(iZzD);
            while (i11 < list.size()) {
                this.zza.zzu(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                this.zza.zzt(i10, zzgxzVar.zzd(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzgxzVar.size(); i13++) {
            iZzD2 += zzgxd.zzD(zzgxzVar.zzd(i13));
        }
        this.zza.zzu(iZzD2);
        while (i11 < zzgxzVar.size()) {
            this.zza.zzu(zzgxzVar.zzd(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzK(int i10, long j10) throws IOException {
        this.zza.zzv(i10, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzL(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzv(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzE = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzE += zzgxd.zzE(((Long) list.get(i12)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i11 < list.size()) {
                this.zza.zzw(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z10) {
            while (i11 < zzgyyVar.size()) {
                this.zza.zzv(i10, zzgyyVar.zza(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzE2 = 0;
        for (int i13 = 0; i13 < zzgyyVar.size(); i13++) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i13));
        }
        this.zza.zzu(iZzE2);
        while (i11 < zzgyyVar.size()) {
            this.zza.zzw(zzgyyVar.zza(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzb(int i10, boolean z10) throws IOException {
        this.zza.zzN(i10, z10);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzc(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgwc)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzN(i10, ((Boolean) list.get(i11)).booleanValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).booleanValue();
                i12++;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzM(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        zzgwc zzgwcVar = (zzgwc) list;
        if (!z10) {
            while (i11 < zzgwcVar.size()) {
                this.zza.zzN(i10, zzgwcVar.zzh(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgwcVar.size(); i15++) {
            zzgwcVar.zzh(i15);
            i14++;
        }
        this.zza.zzu(i14);
        while (i11 < zzgwcVar.size()) {
            this.zza.zzM(zzgwcVar.zzh(i11) ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzd(int i10, zzgwm zzgwmVar) throws IOException {
        this.zza.zzO(i10, zzgwmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zze(int i10, List list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zzO(i10, (zzgwm) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzf(int i10, double d10) throws IOException {
        this.zza.zzj(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzg(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxf)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).doubleValue();
                i12 += 8;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        zzgxf zzgxfVar = (zzgxf) list;
        if (!z10) {
            while (i11 < zzgxfVar.size()) {
                this.zza.zzj(i10, Double.doubleToRawLongBits(zzgxfVar.zzd(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgxfVar.size(); i15++) {
            zzgxfVar.zzd(i15);
            i14 += 8;
        }
        this.zza.zzu(i14);
        while (i11 < zzgxfVar.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(zzgxfVar.zzd(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    @Deprecated
    public final void zzh(int i10) throws IOException {
        this.zza.zzs(i10, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzi(int i10, int i11) throws IOException {
        this.zza.zzl(i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzj(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzl(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzE = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzE += zzgxd.zzE(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i11 < list.size()) {
                this.zza.zzm(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                this.zza.zzl(i10, zzgxzVar.zzd(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzE2 = 0;
        for (int i13 = 0; i13 < zzgxzVar.size(); i13++) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i13));
        }
        this.zza.zzu(iZzE2);
        while (i11 < zzgxzVar.size()) {
            this.zza.zzm(zzgxzVar.zzd(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzk(int i10, int i11) throws IOException {
        this.zza.zzh(i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzl(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                this.zza.zzh(i10, zzgxzVar.zzd(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgxzVar.size(); i15++) {
            zzgxzVar.zzd(i15);
            i14 += 4;
        }
        this.zza.zzu(i14);
        while (i11 < zzgxzVar.size()) {
            this.zza.zzi(zzgxzVar.zzd(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzm(int i10, long j10) throws IOException {
        this.zza.zzj(i10, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzn(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzk(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z10) {
            while (i11 < zzgyyVar.size()) {
                this.zza.zzj(i10, zzgyyVar.zza(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgyyVar.size(); i15++) {
            zzgyyVar.zza(i15);
            i14 += 8;
        }
        this.zza.zzu(i14);
        while (i11 < zzgyyVar.size()) {
            this.zza.zzk(zzgyyVar.zza(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzo(int i10, float f10) throws IOException {
        this.zza.zzh(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzp(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxp)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).floatValue();
                i12 += 4;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        zzgxp zzgxpVar = (zzgxp) list;
        if (!z10) {
            while (i11 < zzgxpVar.size()) {
                this.zza.zzh(i10, Float.floatToRawIntBits(zzgxpVar.zzd(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgxpVar.size(); i15++) {
            zzgxpVar.zzd(i15);
            i14 += 4;
        }
        this.zza.zzu(i14);
        while (i11 < zzgxpVar.size()) {
            this.zza.zzi(Float.floatToRawIntBits(zzgxpVar.zzd(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzq(int i10, Object obj, zzhae zzhaeVar) throws IOException {
        zzgxd zzgxdVar = this.zza;
        zzgxdVar.zzs(i10, 3);
        zzhaeVar.zzj((zzgzj) obj, zzgxdVar.zze);
        zzgxdVar.zzs(i10, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzr(int i10, int i11) throws IOException {
        this.zza.zzl(i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzs(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzl(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzE = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzE += zzgxd.zzE(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i11 < list.size()) {
                this.zza.zzm(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                this.zza.zzl(i10, zzgxzVar.zzd(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzE2 = 0;
        for (int i13 = 0; i13 < zzgxzVar.size(); i13++) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i13));
        }
        this.zza.zzu(iZzE2);
        while (i11 < zzgxzVar.size()) {
            this.zza.zzm(zzgxzVar.zzd(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzt(int i10, long j10) throws IOException {
        this.zza.zzv(i10, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzu(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzv(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int iZzE = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzE += zzgxd.zzE(((Long) list.get(i12)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i11 < list.size()) {
                this.zza.zzw(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z10) {
            while (i11 < zzgyyVar.size()) {
                this.zza.zzv(i10, zzgyyVar.zza(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int iZzE2 = 0;
        for (int i13 = 0; i13 < zzgyyVar.size(); i13++) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i13));
        }
        this.zza.zzu(iZzE2);
        while (i11 < zzgyyVar.size()) {
            this.zza.zzw(zzgyyVar.zza(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzv(int i10, Object obj, zzhae zzhaeVar) throws IOException {
        this.zza.zzn(i10, (zzgzj) obj, zzhaeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzw(int i10, Object obj) throws IOException {
        if (obj instanceof zzgwm) {
            this.zza.zzp(i10, (zzgwm) obj);
        } else {
            this.zza.zzo(i10, (zzgzj) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzx(int i10, int i11) throws IOException {
        this.zza.zzh(i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzy(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzs(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.zza.zzu(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z10) {
            while (i11 < zzgxzVar.size()) {
                this.zza.zzh(i10, zzgxzVar.zzd(i11));
                i11++;
            }
            return;
        }
        this.zza.zzs(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgxzVar.size(); i15++) {
            zzgxzVar.zzd(i15);
            i14 += 4;
        }
        this.zza.zzu(i14);
        while (i11 < zzgxzVar.size()) {
            this.zza.zzi(zzgxzVar.zzd(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzz(int i10, long j10) throws IOException {
        this.zza.zzj(i10, j10);
    }
}
