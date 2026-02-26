package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgwm implements Iterable<Byte>, Serializable {
    public static final zzgwm zzb = new zzgwk(zzgyl.zzb);
    private int zza = 0;

    static {
        int i10 = zzgvz.zza;
    }

    zzgwm() {
    }

    private static zzgwm zzc(Iterator it, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i10)));
        }
        if (i10 == 1) {
            return (zzgwm) it.next();
        }
        int i11 = i10 >>> 1;
        zzgwm zzgwmVarZzc = zzc(it, i11);
        zzgwm zzgwmVarZzc2 = zzc(it, i10 - i11);
        if (Integer.MAX_VALUE - zzgwmVarZzc.zzd() >= zzgwmVarZzc2.zzd()) {
            return zzhad.zzC(zzgwmVarZzc, zzgwmVarZzc2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + zzgwmVarZzc.zzd() + "+" + zzgwmVarZzc2.zzd());
    }

    static int zzq(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        }
        throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
    }

    public static zzgwl zzt() {
        return new zzgwl(128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgwm zzu(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = iterable.size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzc(iterable.iterator(), size);
    }

    public static zzgwm zzv(byte[] bArr, int i10, int i11) {
        zzq(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new zzgwk(bArr2);
    }

    public static zzgwm zzw(String str) {
        return new zzgwk(str.getBytes(zzgyl.zza));
    }

    static void zzy(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzhaq.zza(this) : zzhaq.zza(zzk(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final byte[] zzA() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzgyl.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }

    public abstract byte zza(int i10);

    abstract byte zzb(int i10);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i10, int i11, int i12);

    protected abstract int zzf();

    protected abstract boolean zzh();

    protected abstract int zzi(int i10, int i11, int i12);

    protected abstract int zzj(int i10, int i11, int i12);

    public abstract zzgwm zzk(int i10, int i11);

    public abstract zzgww zzl();

    protected abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    abstract void zzo(zzgwd zzgwdVar) throws IOException;

    public abstract boolean zzp();

    protected final int zzr() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public zzgwh iterator() {
        return new zzgwe(this);
    }

    public final String zzx() {
        return zzd() == 0 ? "" : zzm(zzgyl.zza);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i10, int i11, int i12) {
        zzq(0, i12, zzd());
        zzq(i11, i11 + i12, bArr.length);
        if (i12 > 0) {
            zze(bArr, 0, i11, i12);
        }
    }
}
