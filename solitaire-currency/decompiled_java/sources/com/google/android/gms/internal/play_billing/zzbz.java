package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbz implements zzfx {
    private final zzby zza;

    private zzbz(zzby zzbyVar) {
        byte[] bArr = zzda.zzd;
        this.zza = zzbyVar;
        zzbyVar.zza = this;
    }

    public static zzbz zza(zzby zzbyVar) {
        zzbz zzbzVar = zzbyVar.zza;
        return zzbzVar != null ? zzbzVar : new zzbz(zzbyVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzA(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdr)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z10) {
            while (i11 < zzdrVar.size()) {
                this.zza.zzh(i10, zzdrVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzdrVar.size(); i15++) {
            zzdrVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzq(i14);
        while (i11 < zzdrVar.size()) {
            this.zza.zzi(zzdrVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzB(int i10, int i11) throws IOException {
        this.zza.zzp(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzC(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzby zzbyVar = this.zza;
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    zzbyVar.zzp(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzw = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iZzw += zzby.zzw((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzq(iZzw);
            while (i11 < list.size()) {
                zzby zzbyVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                zzbyVar2.zzq((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                zzby zzbyVar3 = this.zza;
                int iZze = zzctVar.zze(i11);
                zzbyVar3.zzp(i10, (iZze >> 31) ^ (iZze + iZze));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzw2 = 0;
        for (int i13 = 0; i13 < zzctVar.size(); i13++) {
            int iZze2 = zzctVar.zze(i13);
            iZzw2 += zzby.zzw((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzq(iZzw2);
        while (i11 < zzctVar.size()) {
            zzby zzbyVar4 = this.zza;
            int iZze3 = zzctVar.zze(i11);
            zzbyVar4.zzq((iZze3 >> 31) ^ (iZze3 + iZze3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzD(int i10, long j10) throws IOException {
        this.zza.zzr(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzE(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdr)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzby zzbyVar = this.zza;
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    zzbyVar.zzr(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzx = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iZzx += zzby.zzx((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzq(iZzx);
            while (i11 < list.size()) {
                zzby zzbyVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                zzbyVar2.zzs((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z10) {
            while (i11 < zzdrVar.size()) {
                zzby zzbyVar3 = this.zza;
                long jZze = zzdrVar.zze(i11);
                zzbyVar3.zzr(i10, (jZze >> 63) ^ (jZze + jZze));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzx2 = 0;
        for (int i13 = 0; i13 < zzdrVar.size(); i13++) {
            long jZze2 = zzdrVar.zze(i13);
            iZzx2 += zzby.zzx((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzq(iZzx2);
        while (i11 < zzdrVar.size()) {
            zzby zzbyVar4 = this.zza;
            long jZze3 = zzdrVar.zze(i11);
            zzbyVar4.zzs((jZze3 >> 63) ^ (jZze3 + jZze3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzF(int i10) throws IOException {
        this.zza.zzo(i10, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzG(int i10, String str) throws IOException {
        this.zza.zzm(i10, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzH(int i10, List list) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdk)) {
            while (i11 < list.size()) {
                this.zza.zzm(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        zzdk zzdkVar = (zzdk) list;
        while (i11 < list.size()) {
            Object objZzf = zzdkVar.zzf(i11);
            if (objZzf instanceof String) {
                this.zza.zzm(i10, (String) objZzf);
            } else {
                this.zza.zze(i10, (zzbq) objZzf);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzI(int i10, int i11) throws IOException {
        this.zza.zzp(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzJ(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzp(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzw = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzw += zzby.zzw(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzq(iZzw);
            while (i11 < list.size()) {
                this.zza.zzq(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                this.zza.zzp(i10, zzctVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzw2 = 0;
        for (int i13 = 0; i13 < zzctVar.size(); i13++) {
            iZzw2 += zzby.zzw(zzctVar.zze(i13));
        }
        this.zza.zzq(iZzw2);
        while (i11 < zzctVar.size()) {
            this.zza.zzq(zzctVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzK(int i10, long j10) throws IOException {
        this.zza.zzr(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzL(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdr)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzr(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzx = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzx += zzby.zzx(((Long) list.get(i12)).longValue());
            }
            this.zza.zzq(iZzx);
            while (i11 < list.size()) {
                this.zza.zzs(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z10) {
            while (i11 < zzdrVar.size()) {
                this.zza.zzr(i10, zzdrVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzx2 = 0;
        for (int i13 = 0; i13 < zzdrVar.size(); i13++) {
            iZzx2 += zzby.zzx(zzdrVar.zze(i13));
        }
        this.zza.zzq(iZzx2);
        while (i11 < zzdrVar.size()) {
            this.zza.zzs(zzdrVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzb(int i10, boolean z10) throws IOException {
        this.zza.zzd(i10, z10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzc(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzbe)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzd(i10, ((Boolean) list.get(i11)).booleanValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).booleanValue();
                i12++;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        zzbe zzbeVar = (zzbe) list;
        if (!z10) {
            while (i11 < zzbeVar.size()) {
                this.zza.zzd(i10, zzbeVar.zzf(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzbeVar.size(); i15++) {
            zzbeVar.zzf(i15);
            i14++;
        }
        this.zza.zzq(i14);
        while (i11 < zzbeVar.size()) {
            this.zza.zzb(zzbeVar.zzf(i11) ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzd(int i10, zzbq zzbqVar) throws IOException {
        this.zza.zze(i10, zzbqVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zze(int i10, List list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zze(i10, (zzbq) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzf(int i10, double d10) throws IOException {
        this.zza.zzh(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzg(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzca)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).doubleValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        zzca zzcaVar = (zzca) list;
        if (!z10) {
            while (i11 < zzcaVar.size()) {
                this.zza.zzh(i10, Double.doubleToRawLongBits(zzcaVar.zze(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzcaVar.size(); i15++) {
            zzcaVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzq(i14);
        while (i11 < zzcaVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzcaVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzh(int i10) throws IOException {
        this.zza.zzo(i10, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzi(int i10, int i11) throws IOException {
        this.zza.zzj(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzj(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzx = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzx += zzby.zzx(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzq(iZzx);
            while (i11 < list.size()) {
                this.zza.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                this.zza.zzj(i10, zzctVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzx2 = 0;
        for (int i13 = 0; i13 < zzctVar.size(); i13++) {
            iZzx2 += zzby.zzx(zzctVar.zze(i13));
        }
        this.zza.zzq(iZzx2);
        while (i11 < zzctVar.size()) {
            this.zza.zzk(zzctVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzk(int i10, int i11) throws IOException {
        this.zza.zzf(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzl(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                this.zza.zzf(i10, zzctVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzctVar.size(); i15++) {
            zzctVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzq(i14);
        while (i11 < zzctVar.size()) {
            this.zza.zzg(zzctVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzm(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzn(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdr)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z10) {
            while (i11 < zzdrVar.size()) {
                this.zza.zzh(i10, zzdrVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzdrVar.size(); i15++) {
            zzdrVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzq(i14);
        while (i11 < zzdrVar.size()) {
            this.zza.zzi(zzdrVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzo(int i10, float f10) throws IOException {
        this.zza.zzf(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzp(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzck)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).floatValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        zzck zzckVar = (zzck) list;
        if (!z10) {
            while (i11 < zzckVar.size()) {
                this.zza.zzf(i10, Float.floatToRawIntBits(zzckVar.zze(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzckVar.size(); i15++) {
            zzckVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzq(i14);
        while (i11 < zzckVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzckVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzq(int i10, Object obj, zzeo zzeoVar) throws IOException {
        zzby zzbyVar = this.zza;
        zzbyVar.zzo(i10, 3);
        zzeoVar.zzi((zzec) obj, zzbyVar.zza);
        zzbyVar.zzo(i10, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzr(int i10, int i11) throws IOException {
        this.zza.zzj(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzs(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzx = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzx += zzby.zzx(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzq(iZzx);
            while (i11 < list.size()) {
                this.zza.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                this.zza.zzj(i10, zzctVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzx2 = 0;
        for (int i13 = 0; i13 < zzctVar.size(); i13++) {
            iZzx2 += zzby.zzx(zzctVar.zze(i13));
        }
        this.zza.zzq(iZzx2);
        while (i11 < zzctVar.size()) {
            this.zza.zzk(zzctVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzt(int i10, long j10) throws IOException {
        this.zza.zzr(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzu(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzdr)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzr(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int iZzx = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzx += zzby.zzx(((Long) list.get(i12)).longValue());
            }
            this.zza.zzq(iZzx);
            while (i11 < list.size()) {
                this.zza.zzs(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z10) {
            while (i11 < zzdrVar.size()) {
                this.zza.zzr(i10, zzdrVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int iZzx2 = 0;
        for (int i13 = 0; i13 < zzdrVar.size(); i13++) {
            iZzx2 += zzby.zzx(zzdrVar.zze(i13));
        }
        this.zza.zzq(iZzx2);
        while (i11 < zzdrVar.size()) {
            this.zza.zzs(zzdrVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzv(int i10, Object obj, zzeo zzeoVar) throws IOException {
        zzec zzecVar = (zzec) obj;
        zzbv zzbvVar = (zzbv) this.zza;
        zzbvVar.zzq((i10 << 3) | 2);
        zzbvVar.zzq(((zzay) zzecVar).zza(zzeoVar));
        zzeoVar.zzi(zzecVar, zzbvVar.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzw(int i10, Object obj) throws IOException {
        if (obj instanceof zzbq) {
            zzbv zzbvVar = (zzbv) this.zza;
            zzbvVar.zzq(11);
            zzbvVar.zzp(2, i10);
            zzbvVar.zze(3, (zzbq) obj);
            zzbvVar.zzq(12);
            return;
        }
        zzby zzbyVar = this.zza;
        zzec zzecVar = (zzec) obj;
        zzbv zzbvVar2 = (zzbv) zzbyVar;
        zzbvVar2.zzq(11);
        zzbvVar2.zzp(2, i10);
        zzbvVar2.zzq(26);
        zzbvVar2.zzq(zzecVar.zzf());
        zzecVar.zze(zzbyVar);
        zzbvVar2.zzq(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzx(int i10, int i11) throws IOException {
        this.zza.zzf(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzy(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof zzct)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z10) {
            while (i11 < zzctVar.size()) {
                this.zza.zzf(i10, zzctVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzo(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzctVar.size(); i15++) {
            zzctVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzq(i14);
        while (i11 < zzctVar.size()) {
            this.zza.zzg(zzctVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzz(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }
}
