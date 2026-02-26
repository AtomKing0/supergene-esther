package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahk {
    private final zzek zza = new zzek(8);
    private int zzb;

    private final long zzb(zzacl zzaclVar) throws IOException {
        int i10;
        zzaby zzabyVar = (zzaby) zzaclVar;
        int i11 = 0;
        zzabyVar.zzm(this.zza.zzM(), 0, 1, false);
        int i12 = this.zza.zzM()[0] & 255;
        if (i12 == 0) {
            return Long.MIN_VALUE;
        }
        int i13 = 128;
        int i14 = 0;
        while (true) {
            i10 = i14 + 1;
            if ((i12 & i13) != 0) {
                break;
            }
            i13 >>= 1;
            i14 = i10;
        }
        int i15 = i12 & (~i13);
        zzabyVar.zzm(this.zza.zzM(), 1, i14, false);
        while (i11 < i14) {
            i11++;
            i15 = (this.zza.zzM()[i11] & 255) + (i15 << 8);
        }
        this.zzb += i10;
        return i15;
    }

    public final boolean zza(zzacl zzaclVar) throws IOException {
        long jZzd = zzaclVar.zzd();
        long j10 = 1024;
        if (jZzd != -1 && jZzd <= 1024) {
            j10 = jZzd;
        }
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(this.zza.zzM(), 0, 4, false);
        long jZzu = this.zza.zzu();
        this.zzb = 4;
        while (jZzu != 440786851) {
            int i10 = (int) j10;
            int i11 = this.zzb + 1;
            this.zzb = i11;
            if (i11 == i10) {
                return false;
            }
            zzabyVar.zzm(this.zza.zzM(), 0, 1, false);
            jZzu = ((jZzu << 8) & (-256)) | ((long) (this.zza.zzM()[0] & 255));
        }
        long jZzb = zzb(zzaclVar);
        long j11 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j12 = j11 + jZzb;
            if (jZzd == -1 || j12 < jZzd) {
                while (true) {
                    long j13 = this.zzb;
                    if (j13 < j12) {
                        if (zzb(zzaclVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzaclVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i12 = (int) jZzb2;
                            zzabyVar.zzl(i12, false);
                            this.zzb += i12;
                        }
                    } else if (j13 == j12) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
