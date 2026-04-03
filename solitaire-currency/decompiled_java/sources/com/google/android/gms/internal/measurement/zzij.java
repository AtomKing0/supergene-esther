package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzij implements Serializable, Iterable<Byte> {
    public static final zzij zza = new zzit(zzjw.zzb);
    private static final zzim zzb = new zzis();
    private static final Comparator<zzij> zzc = new zzil();
    private int zzd = 0;

    zzij() {
    }

    static /* synthetic */ int zza(byte b10) {
        return b10 & 255;
    }

    static zzio zzc(int i10) {
        return new zzio(i10);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzb = this.zzd;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzd = iZzb;
        }
        return iZzb;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzii(this);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            strZza = zzmp.zza(this);
        } else {
            strZza = zzmp.zza(zza(0, 47)) + "...";
        }
        objArr[2] = strZza;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i10);

    public abstract zzij zza(int i10, int i11);

    protected abstract String zza(Charset charset);

    abstract void zza(zzig zzigVar) throws IOException;

    abstract byte zzb(int i10);

    public abstract int zzb();

    protected abstract int zzb(int i10, int i11, int i12);

    public abstract boolean zzd();

    static int zza(int i10, int i11, int i12) {
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

    public final String zzc() {
        return zzb() == 0 ? "" : zza(zzjw.zza);
    }

    protected final int zza() {
        return this.zzd;
    }

    public static zzij zza(byte[] bArr, int i10, int i11) {
        zza(i10, i10 + i11, bArr.length);
        return new zzit(zzb.zza(bArr, i10, i11));
    }

    public static zzij zza(String str) {
        return new zzit(str.getBytes(zzjw.zza));
    }

    static zzij zza(byte[] bArr) {
        return new zzit(bArr);
    }
}
