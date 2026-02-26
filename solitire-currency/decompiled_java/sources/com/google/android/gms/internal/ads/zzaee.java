package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaee {
    protected final zzadp zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzaee(int i10, int i11, long j10, int i12, zzadp zzadpVar) {
        i11 = i11 != 1 ? 2 : i11;
        this.zzd = j10;
        this.zze = i12;
        this.zza = zzadpVar;
        this.zzb = zzi(i10, i11 == 2 ? 1667497984 : 1651965952);
        this.zzc = i11 == 2 ? zzi(i10, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i10, int i11) {
        return (((i10 % 10) + 48) << 8) | ((i10 / 10) + 48) | i11;
    }

    private final long zzj(int i10) {
        return (this.zzd * ((long) i10)) / ((long) this.zze);
    }

    private final zzadj zzk(int i10) {
        return new zzadj(((long) this.zzl[i10]) * zzj(1), this.zzk[i10]);
    }

    public final zzadg zza(long j10) {
        int iZzj = (int) (j10 / zzj(1));
        int iZzb = zzet.zzb(this.zzl, iZzj, true, true);
        if (this.zzl[iZzb] == iZzj) {
            zzadj zzadjVarZzk = zzk(iZzb);
            return new zzadg(zzadjVarZzk, zzadjVarZzk);
        }
        zzadj zzadjVarZzk2 = zzk(iZzb);
        int i10 = iZzb + 1;
        return i10 < this.zzk.length ? new zzadg(zzadjVarZzk2, zzk(i10)) : new zzadg(zzadjVarZzk2, zzadjVarZzk2);
    }

    public final void zzb(long j10) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i10 = this.zzj;
        jArr2[i10] = j10;
        this.zzl[i10] = this.zzi;
        this.zzj = i10 + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i10) {
        this.zzf = i10;
        this.zzg = i10;
    }

    public final void zzf(long j10) {
        if (this.zzj == 0) {
            this.zzh = 0;
        } else {
            this.zzh = this.zzl[zzet.zzc(this.zzk, j10, true, true)];
        }
    }

    public final boolean zzg(int i10) {
        return this.zzb == i10 || this.zzc == i10;
    }

    public final boolean zzh(zzacl zzaclVar) throws IOException {
        int i10 = this.zzg;
        int iZzf = i10 - this.zza.zzf(zzaclVar, i10, false);
        this.zzg = iZzf;
        boolean z10 = iZzf == 0;
        if (z10) {
            if (this.zzf > 0) {
                this.zza.zzs(zzj(this.zzh), Arrays.binarySearch(this.zzl, this.zzh) >= 0 ? 1 : 0, this.zzf, 0, null);
            }
            this.zzh++;
        }
        return z10;
    }
}
