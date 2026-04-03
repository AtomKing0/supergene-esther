package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgyo extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzgyo(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzc++;
        }
        this.zzd = -1;
        if (zzb()) {
            return;
        }
        this.zzb = zzgyl.zzc;
        this.zzd = 0;
        this.zze = 0;
        this.zzi = 0L;
    }

    private final void zza(int i10) {
        int i11 = this.zze + i10;
        this.zze = i11;
        if (i11 == this.zzb.limit()) {
            zzb();
        }
    }

    private final boolean zzb() {
        this.zzd++;
        if (!this.zza.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.zza.next();
        this.zzb = byteBuffer;
        this.zze = byteBuffer.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzhaz.zze(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            int i10 = this.zzg[this.zze + this.zzh] & 255;
            zza(1);
            return i10;
        }
        int iZza = zzhaz.zza(((long) this.zze) + this.zzi) & 255;
        zza(1);
        return iZza;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int iLimit = this.zzb.limit();
        int i12 = this.zze;
        int i13 = iLimit - i12;
        if (i11 > i13) {
            i11 = i13;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i12 + this.zzh, bArr, i10, i11);
            zza(i11);
        } else {
            int iPosition = this.zzb.position();
            this.zzb.position(this.zze);
            this.zzb.get(bArr, i10, i11);
            this.zzb.position(iPosition);
            zza(i11);
        }
        return i11;
    }
}
