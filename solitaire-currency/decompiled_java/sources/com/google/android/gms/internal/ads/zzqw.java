package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqw {
    private static final byte[] zza = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};
    private static final byte[] zzb = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};
    private ByteBuffer zzc = zzct.zza;
    private int zze = 0;
    private int zzd = 2;

    private static final void zzc(ByteBuffer byteBuffer, long j10, int i10, int i11, boolean z10) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(true != z10 ? (byte) 0 : (byte) 2);
        byteBuffer.putLong(j10);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i10);
        byteBuffer.putInt(0);
        byteBuffer.put(zzgas.zza(i11));
    }

    public final void zza(zzhd zzhdVar, List list) {
        int length;
        ByteBuffer byteBuffer = zzhdVar.zzc;
        byteBuffer.getClass();
        if (byteBuffer.limit() - zzhdVar.zzc.position() == 0) {
            return;
        }
        byte[] bArr = null;
        if (this.zzd == 2 && (list.size() == 1 || list.size() == 3)) {
            bArr = (byte[]) list.get(0);
        }
        ByteBuffer byteBuffer2 = zzhdVar.zzc;
        int iPosition = byteBuffer2.position();
        int iLimit = byteBuffer2.limit();
        int i10 = iLimit - iPosition;
        int i11 = (i10 + 255) / 255;
        int i12 = i11 + 27 + i10;
        if (this.zzd == 2) {
            length = bArr != null ? bArr.length + 28 : 47;
            i12 += length + 44;
        } else {
            length = 0;
        }
        if (this.zzc.capacity() < i12) {
            this.zzc = ByteBuffer.allocate(i12).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.zzc.clear();
        }
        ByteBuffer byteBuffer3 = this.zzc;
        if (this.zzd == 2) {
            if (bArr != null) {
                zzc(byteBuffer3, 0L, 0, 1, true);
                int length2 = bArr.length;
                byteBuffer3.put(zzgas.zza(length2));
                byteBuffer3.put(bArr);
                int i13 = length2 + 28;
                byteBuffer3.putInt(22, zzet.zze(byteBuffer3.array(), byteBuffer3.arrayOffset(), i13, 0));
                byteBuffer3.position(i13);
            } else {
                byteBuffer3.put(zza);
            }
            byteBuffer3.put(zzb);
        }
        int iZzc = this.zze + zzade.zzc(byteBuffer2);
        this.zze = iZzc;
        zzc(byteBuffer3, iZzc, this.zzd, i11, false);
        for (int i14 = 0; i14 < i11; i14++) {
            if (i10 >= 255) {
                byteBuffer3.put((byte) -1);
                i10 -= 255;
            } else {
                byteBuffer3.put((byte) i10);
                i10 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBuffer3.put(byteBuffer2.get(iPosition));
            iPosition++;
        }
        byteBuffer2.position(byteBuffer2.limit());
        byteBuffer3.flip();
        if (this.zzd == 2) {
            byteBuffer3.putInt(length + 66, zzet.zze(byteBuffer3.array(), byteBuffer3.arrayOffset() + length + 44, byteBuffer3.limit() - byteBuffer3.position(), 0));
        } else {
            byteBuffer3.putInt(22, zzet.zze(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0));
        }
        this.zzd++;
        this.zzc = byteBuffer3;
        zzhdVar.zzb();
        zzhdVar.zzi(this.zzc.remaining());
        zzhdVar.zzc.put(this.zzc);
        zzhdVar.zzj();
    }

    public final void zzb() {
        this.zzc = zzct.zza;
        this.zze = 0;
        this.zzd = 2;
    }
}
