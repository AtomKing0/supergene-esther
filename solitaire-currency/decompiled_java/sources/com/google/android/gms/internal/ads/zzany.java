package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzany implements zzanx {
    private final zzacn zza;
    private final zzadp zzb;
    private final zzaoa zzc;
    private final zzaf zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzany(zzacn zzacnVar, zzadp zzadpVar, zzaoa zzaoaVar, String str, int i10) throws zzbo {
        this.zza = zzacnVar;
        this.zzb = zzadpVar;
        this.zzc = zzaoaVar;
        int i11 = zzaoaVar.zzb * zzaoaVar.zze;
        int i12 = zzaoaVar.zzd;
        int i13 = i11 / 8;
        if (i12 != i13) {
            throw zzbo.zza("Expected block size: " + i13 + "; got: " + i12, null);
        }
        int i14 = zzaoaVar.zzc * i13;
        int i15 = i14 * 8;
        int iMax = Math.max(i13, i14 / 10);
        this.zze = iMax;
        zzad zzadVar = new zzad();
        zzadVar.zzX(str);
        zzadVar.zzx(i15);
        zzadVar.zzS(i15);
        zzadVar.zzP(iMax);
        zzadVar.zzy(zzaoaVar.zzb);
        zzadVar.zzY(zzaoaVar.zzc);
        zzadVar.zzR(i10);
        this.zzd = zzadVar.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(int i10, long j10) {
        this.zza.zzO(new zzaod(this.zzc, 1, i10, j10));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(long j10) {
        this.zzf = j10;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final boolean zzc(zzacl zzaclVar, long j10) throws IOException {
        int i10;
        int i11;
        long j11 = j10;
        while (j11 > 0 && (i10 = this.zzg) < (i11 = this.zze)) {
            int iZzf = this.zzb.zzf(zzaclVar, (int) Math.min(i11 - i10, j11), true);
            if (iZzf == -1) {
                j11 = 0;
            } else {
                this.zzg += iZzf;
                j11 -= (long) iZzf;
            }
        }
        zzaoa zzaoaVar = this.zzc;
        int i12 = this.zzg;
        int i13 = zzaoaVar.zzd;
        int i14 = i12 / i13;
        if (i14 > 0) {
            long jZzt = this.zzf + zzet.zzt(this.zzh, 1000000L, zzaoaVar.zzc, RoundingMode.FLOOR);
            int i15 = i14 * i13;
            int i16 = this.zzg - i15;
            this.zzb.zzs(jZzt, 1, i15, i16, null);
            this.zzh += (long) i14;
            this.zzg = i16;
        }
        return j11 <= 0;
    }
}
