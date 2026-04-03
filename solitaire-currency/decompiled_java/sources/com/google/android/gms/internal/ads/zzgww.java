package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgww {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgwx zzc;

    /* synthetic */ zzgww(zzgwv zzgwvVar) {
    }

    public static int zzD(int i10) {
        return (i10 >>> 1) ^ (-(i10 & 1));
    }

    public static int zzE(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int i13 = inputStream.read();
            if (i13 == -1) {
                throw zzgyn.zzi();
            }
            i11 |= (i13 & 127) << i12;
            if ((i13 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        while (i12 < 64) {
            int i14 = inputStream.read();
            if (i14 == -1) {
                throw zzgyn.zzi();
            }
            if ((i14 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        throw zzgyn.zze();
    }

    public static long zzF(long j10) {
        return (j10 >>> 1) ^ (-(1 & j10));
    }

    public static zzgww zzG(InputStream inputStream, int i10) {
        if (inputStream != null) {
            return new zzgws(inputStream, 4096, null);
        }
        byte[] bArr = zzgyl.zzb;
        int length = bArr.length;
        return zzH(bArr, 0, 0, false);
    }

    static zzgww zzH(byte[] bArr, int i10, int i11, boolean z10) {
        zzgwo zzgwoVar = new zzgwo(bArr, i10, i11, z10, null);
        try {
            zzgwoVar.zzd(i11);
            return zzgwoVar;
        } catch (zzgyn e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract boolean zzA() throws IOException;

    public abstract boolean zzB() throws IOException;

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzc();

    public abstract int zzd(int i10) throws zzgyn;

    public abstract int zze() throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzs() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract zzgwm zzv() throws IOException;

    public abstract String zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract void zzy(int i10) throws zzgyn;

    public abstract void zzz(int i10);
}
