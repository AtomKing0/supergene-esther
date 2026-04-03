package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    private static final zzji zznr;
    private static final Comparator<zzjc> zznt;
    private int zzns = 0;

    static {
        zzjd zzjdVar = null;
        zznr = zzix.zzbr() ? new zzjn(zzjdVar) : new zzjg(zzjdVar);
        zznt = new zzje();
    }

    zzjc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zza(byte b10) {
        return b10 & 255;
    }

    public static zzjc zzb(byte[] bArr, int i10, int i11) {
        zzb(i10, i10 + i11, bArr.length);
        return new zzjm(zznr.zzc(bArr, i10, i11));
    }

    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    static zzjk zzu(int i10) {
        return new zzjk(i10, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZza = this.zzns;
        if (iZza == 0) {
            int size = size();
            iZza = zza(size, 0, size);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzns = iZza;
        }
        return iZza;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzjd(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract int zza(int i10, int i11, int i12);

    public abstract zzjc zza(int i10, int i11);

    protected abstract String zza(Charset charset);

    abstract void zza(zzjb zzjbVar) throws IOException;

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    public abstract boolean zzbu();

    protected final int zzbv() {
        return this.zzns;
    }

    public abstract byte zzs(int i10);

    abstract byte zzt(int i10);

    static int zzb(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i10);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i11 < i10) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i11);
        sb3.append(" >= ");
        sb3.append(i12);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
