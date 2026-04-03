package m2;

import androidx.media3.common.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OpusUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 {
    public static List<byte[]> a(byte[] bArr) {
        long jE = e(d(bArr));
        long jE2 = e(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(jE));
        arrayList.add(b(jE2));
        return arrayList;
    }

    private static byte[] b(long j10) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j10).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static int d(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    private static long e(long j10) {
        return (j10 * C.NANOS_PER_SECOND) / 48000;
    }
}
