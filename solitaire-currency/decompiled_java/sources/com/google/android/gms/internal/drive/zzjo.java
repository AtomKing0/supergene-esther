package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjo {
    private int zznz;
    private int zzoa;
    private boolean zzob;

    private zzjo() {
        this.zznz = 100;
        this.zzoa = Integer.MAX_VALUE;
        this.zzob = false;
    }

    static zzjo zza(byte[] bArr, int i10, int i11, boolean z10) {
        zzjq zzjqVar = new zzjq(bArr, 0, i11, false);
        try {
            zzjqVar.zzv(i11);
            return zzjqVar;
        } catch (zzkq e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static long zzk(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static int zzw(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract int zzbz();

    public abstract int zzv(int i10) throws zzkq;
}
