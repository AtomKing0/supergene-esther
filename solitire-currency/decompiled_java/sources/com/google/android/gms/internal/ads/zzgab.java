package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgab {
    static {
        new zzfzz();
    }

    public static InputStream zza(InputStream inputStream, long j10) {
        return new zzgaa(inputStream, j10);
    }

    public static byte[] zzb(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iHighestOneBit = Integer.highestOneBit(0);
        int iMin = Math.min(8192, Math.max(128, iHighestOneBit + iHighestOneBit));
        int i10 = 0;
        while (i10 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i10);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i11 = 0;
            while (i11 < iMin2) {
                int i12 = inputStream.read(bArr, i11, iMin2 - i11);
                if (i12 == -1) {
                    return zzc(arrayDeque, i10);
                }
                i11 += i12;
                i10 += i12;
            }
            iMin = zzgap.zze(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return zzc(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzc(Queue queue, int i10) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i10) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
        int i11 = i10 - length;
        while (i11 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(i11, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i10 - i11, iMin);
            i11 -= iMin;
        }
        return bArrCopyOf;
    }
}
