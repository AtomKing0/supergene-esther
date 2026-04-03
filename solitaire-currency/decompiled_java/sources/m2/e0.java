package m2;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.ts.PsExtractor;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import k2.o1;

/* JADX INFO: compiled from: DtsUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f31263a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f31264b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.SAMPLE_RATE, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f31265c = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, RendererCapabilities.DECODER_SUPPORT_MASK, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, IronSourceConstants.IS_AD_UNIT_CAPPED, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4a
            r2 = -1
            if (r1 == r2) goto L32
            r2 = 31
            if (r1 == r2) goto L21
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L58
        L21:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L42
        L32:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L42:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5d
        L4a:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L58:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L5d:
            if (r0 == 0) goto L63
            int r7 = r7 * 16
            int r7 = r7 / 14
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.e0.a(byte[]):int");
    }

    private static a4.b0 b(byte[] bArr) {
        if (bArr[0] == 127) {
            return new a4.b0(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(bArrCopyOf)) {
            for (int i10 = 0; i10 < bArrCopyOf.length - 1; i10 += 2) {
                byte b10 = bArrCopyOf[i10];
                int i11 = i10 + 1;
                bArrCopyOf[i10] = bArrCopyOf[i11];
                bArrCopyOf[i11] = b10;
            }
        }
        a4.b0 b0Var = new a4.b0(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            a4.b0 b0Var2 = new a4.b0(bArrCopyOf);
            while (b0Var2.b() >= 16) {
                b0Var2.r(2);
                b0Var.f(b0Var2.h(14), 14);
            }
        }
        b0Var.n(bArrCopyOf);
        return b0Var;
    }

    private static boolean c(byte[] bArr) {
        byte b10 = bArr[0];
        return b10 == -2 || b10 == -1;
    }

    public static boolean d(int i10) {
        return i10 == 2147385345 || i10 == -25230976 || i10 == 536864768 || i10 == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        int iPosition = byteBuffer.position();
        byte b12 = byteBuffer.get(iPosition);
        if (b12 != -2) {
            if (b12 == -1) {
                i10 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b11 = byteBuffer.get(iPosition + 7);
            } else if (b12 != 31) {
                i10 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b10 = byteBuffer.get(iPosition + 5);
            } else {
                i10 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b11 = byteBuffer.get(iPosition + 6);
            }
            i11 = b11 & 60;
            return (((i11 >> 2) | i10) + 1) * 32;
        }
        i10 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b10 = byteBuffer.get(iPosition + 4);
        i11 = b10 & 252;
        return (((i11 >> 2) | i10) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        byte b12 = bArr[0];
        if (b12 != -2) {
            if (b12 == -1) {
                i10 = (bArr[4] & 7) << 4;
                b11 = bArr[7];
            } else if (b12 != 31) {
                i10 = (bArr[4] & 1) << 6;
                b10 = bArr[5];
            } else {
                i10 = (bArr[5] & 7) << 4;
                b11 = bArr[6];
            }
            i11 = b11 & 60;
            return (((i11 >> 2) | i10) + 1) * 32;
        }
        i10 = (bArr[5] & 1) << 6;
        b10 = bArr[4];
        i11 = b10 & 252;
        return (((i11 >> 2) | i10) + 1) * 32;
    }

    public static o1 g(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable o2.m mVar) {
        a4.b0 b0VarB = b(bArr);
        b0VarB.r(60);
        int i10 = f31263a[b0VarB.h(6)];
        int i11 = f31264b[b0VarB.h(4)];
        int iH = b0VarB.h(5);
        int[] iArr = f31265c;
        int i12 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        b0VarB.r(10);
        return new o1.b().S(str).e0(MimeTypes.AUDIO_DTS).G(i12).H(i10 + (b0VarB.h(2) > 0 ? 1 : 0)).f0(i11).M(mVar).V(str2).E();
    }
}
