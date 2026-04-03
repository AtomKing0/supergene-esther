package m2;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;
import k2.o1;

/* JADX INFO: compiled from: Ac3Util.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f31149a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f31150b = {OpusUtil.SAMPLE_RATE, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f31151c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f31152d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f31153e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, RendererCapabilities.DECODER_SUPPORT_MASK, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f31154f = {69, 87, 104, 121, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: m2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Ac3Util.java */
    public static final class C0627b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f31155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f31159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f31160f;

        private C0627b(@Nullable String str, int i10, int i11, int i12, int i13, int i14) {
            this.f31155a = str;
            this.f31156b = i10;
            this.f31158d = i11;
            this.f31157c = i12;
            this.f31159e = i13;
            this.f31160f = i14;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i10 = iPosition; i10 <= iLimit; i10++) {
            if ((a4.o0.F(byteBuffer, i10 + 4) & (-2)) == -126718022) {
                return i10 - iPosition;
            }
        }
        return -1;
    }

    private static int b(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0) {
            return -1;
        }
        int[] iArr = f31150b;
        if (i10 >= iArr.length || i11 < 0) {
            return -1;
        }
        int[] iArr2 = f31154f;
        if (i12 >= iArr2.length) {
            return -1;
        }
        int i13 = iArr[i10];
        if (i13 == 44100) {
            return (iArr2[i12] + (i11 % 2)) * 2;
        }
        int i14 = f31153e[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static o1 c(a4.c0 c0Var, String str, String str2, @Nullable o2.m mVar) {
        int i10 = f31150b[(c0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int iD = c0Var.D();
        int i11 = f31152d[(iD & 56) >> 3];
        if ((iD & 4) != 0) {
            i11++;
        }
        return new o1.b().S(str).e0(MimeTypes.AUDIO_AC3).H(i11).f0(i10).M(mVar).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f31149a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0627b e(a4.b0 b0Var) {
        int iB;
        int i10;
        int i11;
        int i12;
        int i13;
        String str;
        int iH;
        int i14;
        int i15;
        int i16;
        int i17;
        int iE = b0Var.e();
        b0Var.r(40);
        boolean z10 = b0Var.h(5) > 10;
        b0Var.p(iE);
        int i18 = -1;
        if (z10) {
            b0Var.r(16);
            int iH2 = b0Var.h(2);
            if (iH2 == 0) {
                i18 = 0;
            } else if (iH2 == 1) {
                i18 = 1;
            } else if (iH2 == 2) {
                i18 = 2;
            }
            b0Var.r(3);
            iB = (b0Var.h(11) + 1) * 2;
            int iH3 = b0Var.h(2);
            if (iH3 == 3) {
                i10 = f31151c[b0Var.h(2)];
                i14 = 6;
                iH = 3;
            } else {
                iH = b0Var.h(2);
                i14 = f31149a[iH];
                i10 = f31150b[iH3];
            }
            i12 = i14 * 256;
            int iH4 = b0Var.h(3);
            boolean zG = b0Var.g();
            i11 = f31152d[iH4] + (zG ? 1 : 0);
            b0Var.r(10);
            if (b0Var.g()) {
                b0Var.r(8);
            }
            if (iH4 == 0) {
                b0Var.r(5);
                if (b0Var.g()) {
                    b0Var.r(8);
                }
            }
            if (i18 == 1 && b0Var.g()) {
                b0Var.r(16);
            }
            if (b0Var.g()) {
                if (iH4 > 2) {
                    b0Var.r(2);
                }
                if ((iH4 & 1) == 0 || iH4 <= 2) {
                    i16 = 6;
                } else {
                    i16 = 6;
                    b0Var.r(6);
                }
                if ((iH4 & 4) != 0) {
                    b0Var.r(i16);
                }
                if (zG && b0Var.g()) {
                    b0Var.r(5);
                }
                if (i18 == 0) {
                    if (b0Var.g()) {
                        i17 = 6;
                        b0Var.r(6);
                    } else {
                        i17 = 6;
                    }
                    if (iH4 == 0 && b0Var.g()) {
                        b0Var.r(i17);
                    }
                    if (b0Var.g()) {
                        b0Var.r(i17);
                    }
                    int iH5 = b0Var.h(2);
                    if (iH5 == 1) {
                        b0Var.r(5);
                    } else if (iH5 == 2) {
                        b0Var.r(12);
                    } else if (iH5 == 3) {
                        int iH6 = b0Var.h(5);
                        if (b0Var.g()) {
                            b0Var.r(5);
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                if (b0Var.g()) {
                                    b0Var.r(4);
                                }
                                if (b0Var.g()) {
                                    b0Var.r(4);
                                }
                            }
                        }
                        if (b0Var.g()) {
                            b0Var.r(5);
                            if (b0Var.g()) {
                                b0Var.r(7);
                                if (b0Var.g()) {
                                    b0Var.r(8);
                                }
                            }
                        }
                        b0Var.r((iH6 + 2) * 8);
                        b0Var.c();
                    }
                    if (iH4 < 2) {
                        if (b0Var.g()) {
                            b0Var.r(14);
                        }
                        if (iH4 == 0 && b0Var.g()) {
                            b0Var.r(14);
                        }
                    }
                    if (b0Var.g()) {
                        if (iH == 0) {
                            b0Var.r(5);
                        } else {
                            for (int i19 = 0; i19 < i14; i19++) {
                                if (b0Var.g()) {
                                    b0Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (b0Var.g()) {
                b0Var.r(5);
                if (iH4 == 2) {
                    b0Var.r(4);
                }
                if (iH4 >= 6) {
                    b0Var.r(2);
                }
                if (b0Var.g()) {
                    b0Var.r(8);
                }
                if (iH4 == 0 && b0Var.g()) {
                    b0Var.r(8);
                }
                if (iH3 < 3) {
                    b0Var.q();
                }
            }
            if (i18 == 0 && iH != 3) {
                b0Var.q();
            }
            if (i18 == 2 && (iH == 3 || b0Var.g())) {
                i15 = 6;
                b0Var.r(6);
            } else {
                i15 = 6;
            }
            str = (b0Var.g() && b0Var.h(i15) == 1 && b0Var.h(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i13 = i18;
        } else {
            b0Var.r(32);
            int iH7 = b0Var.h(2);
            String str2 = iH7 == 3 ? null : MimeTypes.AUDIO_AC3;
            iB = b(iH7, b0Var.h(6));
            b0Var.r(8);
            int iH8 = b0Var.h(3);
            if ((iH8 & 1) != 0 && iH8 != 1) {
                b0Var.r(2);
            }
            if ((iH8 & 4) != 0) {
                b0Var.r(2);
            }
            if (iH8 == 2) {
                b0Var.r(2);
            }
            int[] iArr = f31150b;
            i10 = iH7 < iArr.length ? iArr[iH7] : -1;
            i11 = f31152d[iH8] + (b0Var.g() ? 1 : 0);
            i12 = 1536;
            i13 = -1;
            str = str2;
        }
        return new C0627b(str, i13, i11, i10, iB, i12);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b10 = bArr[4];
        return b((b10 & 192) >> 6, b10 & 63);
    }

    public static o1 g(a4.c0 c0Var, String str, String str2, @Nullable o2.m mVar) {
        c0Var.Q(2);
        int i10 = f31150b[(c0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int iD = c0Var.D();
        int i11 = f31152d[(iD & 14) >> 1];
        if ((iD & 1) != 0) {
            i11++;
        }
        if (((c0Var.D() & 30) >> 1) > 0 && (2 & c0Var.D()) != 0) {
            i11 += 2;
        }
        return new o1.b().S(str).e0((c0Var.a() <= 0 || (c0Var.D() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC).H(i11).f0(i10).M(mVar).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i10) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i10) + ((byteBuffer.get((byteBuffer.position() + i10) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b10 = bArr[7];
            if ((b10 & 254) == 186) {
                return 40 << ((bArr[(b10 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
