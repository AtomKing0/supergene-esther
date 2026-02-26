package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import com.ironsource.c3;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanw implements zzanx {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, c3.a.b.f11499h, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzacn zzc;
    private final zzadp zzd;
    private final zzaoa zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzek zzh;
    private final int zzi;
    private final zzaf zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanw(zzacn zzacnVar, zzadp zzadpVar, zzaoa zzaoaVar) throws zzbo {
        this.zzc = zzacnVar;
        this.zzd = zzadpVar;
        this.zze = zzaoaVar;
        int iMax = Math.max(1, zzaoaVar.zzc / 10);
        this.zzi = iMax;
        zzek zzekVar = new zzek(zzaoaVar.zzf);
        zzekVar.zzk();
        int iZzk = zzekVar.zzk();
        this.zzf = iZzk;
        int i10 = zzaoaVar.zzb;
        int i11 = zzaoaVar.zzd;
        int i12 = (((i11 - (i10 * 4)) * 8) / (zzaoaVar.zze * i10)) + 1;
        if (iZzk != i12) {
            throw zzbo.zza("Expected frames per block: " + i12 + "; got: " + iZzk, null);
        }
        int i13 = zzet.zza;
        int i14 = ((iMax + iZzk) - 1) / iZzk;
        this.zzg = new byte[i11 * i14];
        this.zzh = new zzek(i14 * (iZzk + iZzk) * i10);
        int i15 = ((zzaoaVar.zzc * zzaoaVar.zzd) * 8) / iZzk;
        zzad zzadVar = new zzad();
        zzadVar.zzX(MimeTypes.AUDIO_RAW);
        zzadVar.zzx(i15);
        zzadVar.zzS(i15);
        zzadVar.zzP((iMax + iMax) * i10);
        zzadVar.zzy(zzaoaVar.zzb);
        zzadVar.zzY(zzaoaVar.zzc);
        zzadVar.zzR(2);
        this.zzj = zzadVar.zzad();
    }

    private final int zzd(int i10) {
        int i11 = this.zze.zzb;
        return i10 / (i11 + i11);
    }

    private final int zze(int i10) {
        return (i10 + i10) * this.zze.zzb;
    }

    private final void zzf(int i10) {
        long jZzt = this.zzl + zzet.zzt(this.zzn, 1000000L, this.zze.zzc, RoundingMode.FLOOR);
        int iZze = zze(i10);
        this.zzd.zzs(jZzt, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i10;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(int i10, long j10) {
        this.zzc.zzO(new zzaod(this.zze, this.zzf, i10, j10));
        this.zzd.zzl(this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(long j10) {
        this.zzk = 0;
        this.zzl = j10;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003b -> B:4:0x0020). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzanx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r21, long r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanw.zzc(com.google.android.gms.internal.ads.zzacl, long):boolean");
    }
}
