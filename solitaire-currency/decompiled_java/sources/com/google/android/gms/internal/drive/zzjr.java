package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjr extends zzjb {
    private static final Logger logger = Logger.getLogger(zzjr.class.getName());
    private static final boolean zzog = zznd.zzfd();
    zzjt zzoh;

    static class zza extends zzjr {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i12 = i11 + 0;
            if ((i11 | 0 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
            }
            this.buffer = bArr;
            this.offset = 0;
            this.position = 0;
            this.limit = i12;
        }

        private final void write(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.buffer, this.position, i11);
                this.position += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i10, long j10) throws IOException {
            zzb(i10, 0);
            zzl(j10);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzaa(int i10) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                int i12 = i11 + 1;
                bArr[i11] = (byte) i10;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i10 >> 8);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i10 >> 16);
                this.position = i14 + 1;
                bArr[i14] = (byte) (i10 >>> 24);
            } catch (IndexOutOfBoundsException e10) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i10, int i11) throws IOException {
            zzy((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int i10, int i11) throws IOException {
            zzb(i10, 0);
            zzx(i11);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final int zzca() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzd(int i10, int i11) throws IOException {
            zzb(i10, 0);
            zzy(i11);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzf(int i10, int i11) throws IOException {
            zzb(i10, 5);
            zzaa(i11);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzl(long j10) throws IOException {
            if (zzjr.zzog && zzca() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zznd.zza(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zznd.zza(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                }
            }
            byte[] bArr4 = this.buffer;
            int i13 = this.position;
            this.position = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzn(long j10) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i10 = this.position;
                int i11 = i10 + 1;
                bArr[i10] = (byte) j10;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (j10 >> 8);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (j10 >> 16);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (j10 >> 24);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (j10 >> 32);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (j10 >> 40);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (j10 >> 48);
                this.position = i17 + 1;
                bArr[i17] = (byte) (j10 >> 56);
            } catch (IndexOutOfBoundsException e10) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzx(int i10) throws IOException {
            if (i10 >= 0) {
                zzy(i10);
            } else {
                zzl(i10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzy(int i10) throws IOException {
            if (!zzjr.zzog || zzix.zzbr() || zzca() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i11 = this.position;
                        this.position = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                zznd.zza(bArr3, i13, (byte) i10);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            zznd.zza(bArr4, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zznd.zza(bArr5, i16, (byte) i15);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i17 = this.position;
            this.position = i17 + 1;
            zznd.zza(bArr6, i17, (byte) (i15 | 128));
            int i18 = i15 >>> 7;
            if ((i18 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i19 = this.position;
                this.position = i19 + 1;
                zznd.zza(bArr7, i19, (byte) i18);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i20 = this.position;
            this.position = i20 + 1;
            zznd.zza(bArr8, i20, (byte) (i18 | 128));
            int i21 = i18 >>> 7;
            if ((i21 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i22 = this.position;
                this.position = i22 + 1;
                zznd.zza(bArr9, i22, (byte) i21);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i23 = this.position;
            this.position = i23 + 1;
            zznd.zza(bArr10, i23, (byte) (i21 | 128));
            byte[] bArr11 = this.buffer;
            int i24 = this.position;
            this.position = i24 + 1;
            zznd.zza(bArr11, i24, (byte) (i21 >>> 7));
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i10, boolean z10) throws IOException {
            zzb(i10, 0);
            zzc(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i10, String str) throws IOException {
            zzb(i10, 2);
            zzl(str);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int i10, long j10) throws IOException {
            zzb(i10, 1);
            zzn(j10);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzd(byte[] bArr, int i10, int i11) throws IOException {
            zzy(i11);
            write(bArr, 0, i11);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i10, zzjc zzjcVar) throws IOException {
            zzb(1, 3);
            zzd(2, i10);
            zza(3, zzjcVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i10, zzjc zzjcVar) throws IOException {
            zzb(i10, 2);
            zza(zzjcVar);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(byte b10) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(zzjc zzjcVar) throws IOException {
            zzy(zzjcVar.size());
            zzjcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(zzlq zzlqVar) throws IOException {
            zzy(zzlqVar.zzcx());
            zzlqVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzl(String str) throws IOException {
            int i10 = this.position;
            try {
                int iZzad = zzjr.zzad(str.length() * 3);
                int iZzad2 = zzjr.zzad(str.length());
                if (iZzad2 == iZzad) {
                    int i11 = i10 + iZzad2;
                    this.position = i11;
                    int iZza = zznf.zza(str, this.buffer, i11, zzca());
                    this.position = i10;
                    zzy((iZza - i10) - iZzad2);
                    this.position = iZza;
                    return;
                }
                zzy(zznf.zza(str));
                this.position = zznf.zza(str, this.buffer, this.position, zzca());
            } catch (zznj e10) {
                this.position = i10;
                zza(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzb(e11);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        final void zza(int i10, zzlq zzlqVar, zzmf zzmfVar) throws IOException {
            zzb(i10, 2);
            zzit zzitVar = (zzit) zzlqVar;
            int iZzbm = zzitVar.zzbm();
            if (iZzbm == -1) {
                iZzbm = zzmfVar.zzn(zzitVar);
                zzitVar.zzo(iZzbm);
            }
            zzy(iZzbm);
            zzmfVar.zza(zzlqVar, this.zzoh);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i10, zzlq zzlqVar) throws IOException {
            zzb(1, 3);
            zzd(2, i10);
            zzb(3, 2);
            zzb(zzlqVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.drive.zzjb
        public final void zza(byte[] bArr, int i10, int i11) throws IOException {
            write(bArr, i10, i11);
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzjr() {
    }

    public static int zzab(int i10) {
        return zzad(i10 << 3);
    }

    public static int zzac(int i10) {
        if (i10 >= 0) {
            return zzad(i10);
        }
        return 10;
    }

    public static int zzad(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzae(int i10) {
        return zzad(zzai(i10));
    }

    public static int zzaf(int i10) {
        return 4;
    }

    public static int zzag(int i10) {
        return 4;
    }

    public static int zzah(int i10) {
        return zzac(i10);
    }

    private static int zzai(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    @Deprecated
    public static int zzaj(int i10) {
        return zzad(i10);
    }

    public static int zzb(double d10) {
        return 8;
    }

    public static int zzd(boolean z10) {
        return 1;
    }

    public static int zzf(int i10, long j10) {
        return zzab(i10) + zzp(zzt(j10));
    }

    public static int zzg(int i10, int i11) {
        return zzab(i10) + zzac(i11);
    }

    public static int zzh(int i10, int i11) {
        return zzab(i10) + zzad(i11);
    }

    public static int zzi(int i10, int i11) {
        return zzab(i10) + zzad(zzai(i11));
    }

    public static int zzj(int i10, int i11) {
        return zzab(i10) + 4;
    }

    public static int zzk(int i10, int i11) {
        return zzab(i10) + 4;
    }

    public static int zzl(int i10, int i11) {
        return zzab(i10) + zzac(i11);
    }

    public static int zzo(long j10) {
        return zzp(j10);
    }

    public static int zzp(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int zzq(long j10) {
        return zzp(zzt(j10));
    }

    public static int zzr(long j10) {
        return 8;
    }

    public static int zzs(long j10) {
        return 8;
    }

    private static long zzt(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public final void zza(int i10, float f10) throws IOException {
        zzf(i10, Float.floatToRawIntBits(f10));
    }

    public abstract void zza(int i10, long j10) throws IOException;

    public abstract void zza(int i10, zzjc zzjcVar) throws IOException;

    public abstract void zza(int i10, zzlq zzlqVar) throws IOException;

    abstract void zza(int i10, zzlq zzlqVar, zzmf zzmfVar) throws IOException;

    public abstract void zza(int i10, String str) throws IOException;

    public abstract void zza(zzjc zzjcVar) throws IOException;

    public abstract void zzaa(int i10) throws IOException;

    public abstract void zzb(int i10, int i11) throws IOException;

    public abstract void zzb(int i10, zzjc zzjcVar) throws IOException;

    public abstract void zzb(int i10, boolean z10) throws IOException;

    public abstract void zzb(zzlq zzlqVar) throws IOException;

    public abstract void zzc(byte b10) throws IOException;

    public abstract void zzc(int i10, int i11) throws IOException;

    public abstract void zzc(int i10, long j10) throws IOException;

    public final void zzc(boolean z10) throws IOException {
        zzc(z10 ? (byte) 1 : (byte) 0);
    }

    public abstract int zzca();

    public final void zzcb() {
        if (zzca() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzd(int i10, int i11) throws IOException;

    abstract void zzd(byte[] bArr, int i10, int i11) throws IOException;

    public final void zze(int i10, int i11) throws IOException {
        zzd(i10, zzai(i11));
    }

    public abstract void zzf(int i10, int i11) throws IOException;

    public abstract void zzl(long j10) throws IOException;

    public abstract void zzl(String str) throws IOException;

    public final void zzm(long j10) throws IOException {
        zzl(zzt(j10));
    }

    public abstract void zzn(long j10) throws IOException;

    public abstract void zzx(int i10) throws IOException;

    public abstract void zzy(int i10) throws IOException;

    public final void zzz(int i10) throws IOException {
        zzy(zzai(i10));
    }

    public static int zzb(float f10) {
        return 4;
    }

    public static int zzc(int i10, boolean z10) {
        return zzab(i10) + 1;
    }

    public static int zzd(int i10, long j10) {
        return zzab(i10) + zzp(j10);
    }

    public static int zze(int i10, long j10) {
        return zzab(i10) + zzp(j10);
    }

    public static int zzg(int i10, long j10) {
        return zzab(i10) + 8;
    }

    public static int zzh(int i10, long j10) {
        return zzab(i10) + 8;
    }

    public static int zzm(String str) {
        int length;
        try {
            length = zznf.zza(str);
        } catch (zznj unused) {
            length = str.getBytes(zzkm.UTF_8).length;
        }
        return zzad(length) + length;
    }

    public final void zza(int i10, double d10) throws IOException {
        zzc(i10, Double.doubleToRawLongBits(d10));
    }

    public static zzjr zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzc(int i10, zzjc zzjcVar) {
        int iZzab = zzab(i10);
        int size = zzjcVar.size();
        return iZzab + zzad(size) + size;
    }

    public final void zza(float f10) throws IOException {
        zzaa(Float.floatToRawIntBits(f10));
    }

    public static int zzd(int i10, zzjc zzjcVar) {
        return (zzab(1) << 1) + zzh(2, i10) + zzc(3, zzjcVar);
    }

    public final void zza(double d10) throws IOException {
        zzn(Double.doubleToRawLongBits(d10));
    }

    public static int zza(int i10, zzkx zzkxVar) {
        int iZzab = zzab(i10);
        int iZzcx = zzkxVar.zzcx();
        return iZzab + zzad(iZzcx) + iZzcx;
    }

    public final void zzb(int i10, long j10) throws IOException {
        zza(i10, zzt(j10));
    }

    public static int zzb(int i10, float f10) {
        return zzab(i10) + 4;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzad(length) + length;
    }

    public static int zzb(int i10, double d10) {
        return zzab(i10) + 8;
    }

    @Deprecated
    public static int zzd(zzlq zzlqVar) {
        return zzlqVar.zzcx();
    }

    public static int zza(zzkx zzkxVar) {
        int iZzcx = zzkxVar.zzcx();
        return zzad(iZzcx) + iZzcx;
    }

    public static int zzb(int i10, String str) {
        return zzab(i10) + zzm(str);
    }

    public static int zzc(zzlq zzlqVar) {
        int iZzcx = zzlqVar.zzcx();
        return zzad(iZzcx) + iZzcx;
    }

    static int zzb(int i10, zzlq zzlqVar, zzmf zzmfVar) {
        return zzab(i10) + zza(zzlqVar, zzmfVar);
    }

    static int zza(zzlq zzlqVar, zzmf zzmfVar) {
        zzit zzitVar = (zzit) zzlqVar;
        int iZzbm = zzitVar.zzbm();
        if (iZzbm == -1) {
            iZzbm = zzmfVar.zzn(zzitVar);
            zzitVar.zzo(iZzbm);
        }
        return zzad(iZzbm) + iZzbm;
    }

    public static int zzb(int i10, zzlq zzlqVar) {
        return (zzab(1) << 1) + zzh(2, i10) + zzab(3) + zzc(zzlqVar);
    }

    @Deprecated
    static int zzc(int i10, zzlq zzlqVar, zzmf zzmfVar) {
        int iZzab = zzab(i10) << 1;
        zzit zzitVar = (zzit) zzlqVar;
        int iZzbm = zzitVar.zzbm();
        if (iZzbm == -1) {
            iZzbm = zzmfVar.zzn(zzitVar);
            zzitVar.zzo(iZzbm);
        }
        return iZzab + iZzbm;
    }

    public static int zzb(int i10, zzkx zzkxVar) {
        return (zzab(1) << 1) + zzh(2, i10) + zza(3, zzkxVar);
    }

    final void zza(String str, zznj zznjVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznjVar);
        byte[] bytes = str.getBytes(zzkm.UTF_8);
        try {
            zzy(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzb(e11);
        }
    }

    public static int zzb(zzjc zzjcVar) {
        int size = zzjcVar.size();
        return zzad(size) + size;
    }
}
