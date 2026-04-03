package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvq {
    private final zzek zza = new zzek(32);
    private zzvp zzb;
    private zzvp zzc;
    private zzvp zzd;
    private long zze;
    private final zzyk zzf;

    public zzvq(zzyk zzykVar) {
        this.zzf = zzykVar;
        zzvp zzvpVar = new zzvp(0L, 65536);
        this.zzb = zzvpVar;
        this.zzc = zzvpVar;
        this.zzd = zzvpVar;
    }

    private final int zzi(int i10) {
        zzvp zzvpVar = this.zzd;
        if (zzvpVar.zzc == null) {
            zzyd zzydVarZzb = this.zzf.zzb();
            zzvp zzvpVar2 = new zzvp(this.zzd.zzb, 65536);
            zzvpVar.zzc = zzydVarZzb;
            zzvpVar.zzd = zzvpVar2;
        }
        return Math.min(i10, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvp zzj(zzvp zzvpVar, long j10) {
        while (j10 >= zzvpVar.zzb) {
            zzvpVar = zzvpVar.zzd;
        }
        return zzvpVar;
    }

    private static zzvp zzk(zzvp zzvpVar, long j10, ByteBuffer byteBuffer, int i10) {
        zzvp zzvpVarZzj = zzj(zzvpVar, j10);
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (zzvpVarZzj.zzb - j10));
            byteBuffer.put(zzvpVarZzj.zzc.zza, zzvpVarZzj.zza(j10), iMin);
            i10 -= iMin;
            j10 += (long) iMin;
            if (j10 == zzvpVarZzj.zzb) {
                zzvpVarZzj = zzvpVarZzj.zzd;
            }
        }
        return zzvpVarZzj;
    }

    private static zzvp zzl(zzvp zzvpVar, long j10, byte[] bArr, int i10) {
        zzvp zzvpVarZzj = zzj(zzvpVar, j10);
        int i11 = i10;
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (zzvpVarZzj.zzb - j10));
            System.arraycopy(zzvpVarZzj.zzc.zza, zzvpVarZzj.zza(j10), bArr, i10 - i11, iMin);
            i11 -= iMin;
            j10 += (long) iMin;
            if (j10 == zzvpVarZzj.zzb) {
                zzvpVarZzj = zzvpVarZzj.zzd;
            }
        }
        return zzvpVarZzj;
    }

    private static zzvp zzm(zzvp zzvpVar, zzhd zzhdVar, zzvs zzvsVar, zzek zzekVar) {
        zzvp zzvpVarZzl;
        if (zzhdVar.zzk()) {
            long j10 = zzvsVar.zzb;
            int iZzq = 1;
            zzekVar.zzH(1);
            zzvp zzvpVarZzl2 = zzl(zzvpVar, j10, zzekVar.zzM(), 1);
            long j11 = j10 + 1;
            byte b10 = zzekVar.zzM()[0];
            int i10 = b10 & 128;
            int i11 = b10 & 127;
            zzha zzhaVar = zzhdVar.zzb;
            byte[] bArr = zzhaVar.zza;
            if (bArr == null) {
                zzhaVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z10 = i10 != 0;
            zzvpVarZzl = zzl(zzvpVarZzl2, j11, zzhaVar.zza, i11);
            long j12 = j11 + ((long) i11);
            if (z10) {
                zzekVar.zzH(2);
                zzvpVarZzl = zzl(zzvpVarZzl, j12, zzekVar.zzM(), 2);
                j12 += 2;
                iZzq = zzekVar.zzq();
            }
            int i12 = iZzq;
            int[] iArr = zzhaVar.zzd;
            if (iArr == null || iArr.length < i12) {
                iArr = new int[i12];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhaVar.zze;
            if (iArr3 == null || iArr3.length < i12) {
                iArr3 = new int[i12];
            }
            int[] iArr4 = iArr3;
            if (z10) {
                int i13 = i12 * 6;
                zzekVar.zzH(i13);
                zzvpVarZzl = zzl(zzvpVarZzl, j12, zzekVar.zzM(), i13);
                j12 += (long) i13;
                zzekVar.zzK(0);
                for (int i14 = 0; i14 < i12; i14++) {
                    iArr2[i14] = zzekVar.zzq();
                    iArr4[i14] = zzekVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzvsVar.zza - ((int) (j12 - zzvsVar.zzb));
            }
            zzado zzadoVar = zzvsVar.zzc;
            int i15 = zzet.zza;
            zzhaVar.zzc(i12, iArr2, iArr4, zzadoVar.zzb, zzhaVar.zza, zzadoVar.zza, zzadoVar.zzc, zzadoVar.zzd);
            long j13 = zzvsVar.zzb;
            int i16 = (int) (j12 - j13);
            zzvsVar.zzb = j13 + ((long) i16);
            zzvsVar.zza -= i16;
        } else {
            zzvpVarZzl = zzvpVar;
        }
        if (!zzhdVar.zze()) {
            zzhdVar.zzi(zzvsVar.zza);
            return zzk(zzvpVarZzl, zzvsVar.zzb, zzhdVar.zzc, zzvsVar.zza);
        }
        zzekVar.zzH(4);
        zzvp zzvpVarZzl3 = zzl(zzvpVarZzl, zzvsVar.zzb, zzekVar.zzM(), 4);
        int iZzp = zzekVar.zzp();
        zzvsVar.zzb += 4;
        zzvsVar.zza -= 4;
        zzhdVar.zzi(iZzp);
        zzvp zzvpVarZzk = zzk(zzvpVarZzl3, zzvsVar.zzb, zzhdVar.zzc, iZzp);
        zzvsVar.zzb += (long) iZzp;
        int i17 = zzvsVar.zza - iZzp;
        zzvsVar.zza = i17;
        ByteBuffer byteBuffer = zzhdVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i17) {
            zzhdVar.zzf = ByteBuffer.allocate(i17);
        } else {
            zzhdVar.zzf.clear();
        }
        return zzk(zzvpVarZzk, zzvsVar.zzb, zzhdVar.zzf, zzvsVar.zza);
    }

    private final void zzn(int i10) {
        long j10 = this.zze + ((long) i10);
        this.zze = j10;
        zzvp zzvpVar = this.zzd;
        if (j10 == zzvpVar.zzb) {
            this.zzd = zzvpVar.zzd;
        }
    }

    public final int zza(zzp zzpVar, int i10, boolean z10) throws IOException {
        int iZzi = zzi(i10);
        zzvp zzvpVar = this.zzd;
        int iZza = zzpVar.zza(zzvpVar.zzc.zza, zzvpVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j10) {
        zzvp zzvpVar;
        if (j10 != -1) {
            while (true) {
                zzvpVar = this.zzb;
                if (j10 < zzvpVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvpVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvpVar.zza) {
                this.zzc = zzvpVar;
            }
        }
    }

    public final void zzd(zzhd zzhdVar, zzvs zzvsVar) {
        zzm(this.zzc, zzhdVar, zzvsVar, this.zza);
    }

    public final void zze(zzhd zzhdVar, zzvs zzvsVar) {
        this.zzc = zzm(this.zzc, zzhdVar, zzvsVar, this.zza);
    }

    public final void zzf() {
        zzvp zzvpVar = this.zzb;
        if (zzvpVar.zzc != null) {
            this.zzf.zzd(zzvpVar);
            zzvpVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzvp zzvpVar2 = this.zzb;
        this.zzc = zzvpVar2;
        this.zzd = zzvpVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzek zzekVar, int i10) {
        while (i10 > 0) {
            int iZzi = zzi(i10);
            zzvp zzvpVar = this.zzd;
            zzekVar.zzG(zzvpVar.zzc.zza, zzvpVar.zza(this.zze), iZzi);
            i10 -= iZzi;
            zzn(iZzi);
        }
    }
}
