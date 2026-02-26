package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoo {
    public static long zza(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 16);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 12);
    }

    static Pair zzc(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair pairZzf = zzf(randomAccessFile, 0);
        return pairZzf != null ? pairZzf : zzf(randomAccessFile, 65535);
    }

    public static void zzd(ByteBuffer byteBuffer, long j10) {
        zzg(byteBuffer);
        int iPosition = byteBuffer.position() + 16;
        if (j10 >= 0 && j10 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + iPosition, (int) j10);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j10);
    }

    private static long zze(ByteBuffer byteBuffer, int i10) {
        return ((long) byteBuffer.getInt(i10)) & 4294967295L;
    }

    private static Pair zzf(RandomAccessFile randomAccessFile, int i10) throws IOException {
        int i11;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i10, (-22) + length)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        zzg(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity < 22) {
            i11 = -1;
        } else {
            int i12 = iCapacity - 22;
            int iMin = Math.min(i12, 65535);
            for (int i13 = 0; i13 < iMin; i13++) {
                i11 = i12 - i13;
                if (byteBufferAllocate.getInt(i11) == 101010256 && ((char) byteBufferAllocate.getShort(i11 + 20)) == i13) {
                    break;
                }
            }
            i11 = -1;
        }
        if (i11 == -1) {
            return null;
        }
        byteBufferAllocate.position(i11);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i11)));
    }

    private static void zzg(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
