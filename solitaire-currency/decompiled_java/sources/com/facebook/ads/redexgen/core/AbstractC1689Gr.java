package com.facebook.ads.redexgen.core;

import androidx.media3.common.C;
import io.sentry.protocol.ViewHierarchyNode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1689Gr {
    public static String[] A00 = {"LICRowSKufdYuvwk0u6bsAkyuycb3o", "3c3IkJ7dOAlpkofMi9kyF", "8", "QmWMZEVudINzrA2kZLMiJGq1bO", "Rty4yJjWzs33", "sO", ViewHierarchyNode.JsonKeys.X, "tim3YlDUE2i6MxDxj85j1aO5zMSMD9gT"};

    public static int A00(ByteBuffer byteBuffer) {
        long packetDurationUs = A03(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0);
        return (int) ((48000 * packetDurationUs) / 1000000);
    }

    public static int A01(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int A02(byte[] bArr) {
        return ((bArr[11] & 255) << 8) | (bArr[10] & 255);
    }

    public static long A03(byte b10, byte b11) {
        int i10;
        int length;
        int frames = b10 & 255;
        int toc = frames & 3;
        switch (toc) {
            case 0:
                i10 = 1;
                break;
            case 1:
            case 2:
                i10 = 2;
                break;
            default:
                i10 = b11 & 63;
                break;
        }
        int frames2 = frames >> 3;
        int frameDurationUs = frames2 & 3;
        if (frames2 >= 16) {
            if (A00[7].charAt(3) != 79) {
                A00[2] = "r0CXzG1";
                length = 2500 << frameDurationUs;
            } else {
                throw new RuntimeException();
            }
        } else if (frames2 >= 12) {
            int toc2 = frameDurationUs & 1;
            length = 10000 << toc2;
        } else if (frameDurationUs == 3) {
            length = 60000;
        } else {
            length = 10000 << frameDurationUs;
        }
        return ((long) i10) * ((long) length);
    }

    public static long A04(long j10) {
        return (C.NANOS_PER_SECOND * j10) / 48000;
    }

    public static long A05(byte[] bArr) {
        return A03(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static List<byte[]> A06(byte[] bArr) {
        int preSkipSamples = A02(bArr);
        long jA04 = A04(preSkipSamples);
        long jA042 = A04(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(A07(jA04));
        arrayList.add(A07(jA042));
        return arrayList;
    }

    public static byte[] A07(long j10) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j10).array();
    }
}
