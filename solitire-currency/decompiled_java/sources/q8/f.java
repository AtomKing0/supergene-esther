package q8;

import androidx.media3.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.h;
import v8.h0;

/* JADX INFO: compiled from: UTF8.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final int a(char c10, char c11) {
        return ((c10 - 55232) << 10) | (c11 - 56320);
    }

    public static final int b(@NotNull ByteBuffer encodeUTF8, @NotNull CharSequence text, int i10, int i11, int i12, int i13) {
        t.i(encodeUTF8, "$this$encodeUTF8");
        t.i(text, "text");
        int iMin = Math.min(i11, i10 + 65535);
        int iJ = o.j(i13, 65535);
        int i14 = i10;
        int i15 = i12;
        while (i15 < iJ && i14 < iMin) {
            int i16 = i14 + 1;
            int iCharAt = text.charAt(i14) & 65535;
            if ((65408 & iCharAt) != 0) {
                return c(encodeUTF8, text, i16 - 1, iMin, i10, i15, iJ, i12);
            }
            encodeUTF8.put(i15, (byte) iCharAt);
            i14 = i16;
            i15++;
        }
        return c.d(h0.c((short) (i14 - i10)), h0.c((short) (i15 - i12)));
    }

    private static final int c(ByteBuffer byteBuffer, CharSequence charSequence, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i14 - 3;
        int i17 = i10;
        int i18 = i13;
        while (i16 - i18 > 0 && i17 < i11) {
            int i19 = i17 + 1;
            char cCharAt = charSequence.charAt(i17);
            boolean zIsHighSurrogate = Character.isHighSurrogate(cCharAt);
            int i20 = cCharAt;
            if (zIsHighSurrogate) {
                if (i19 == i11 || !Character.isLowSurrogate(charSequence.charAt(i19))) {
                    i20 = 63;
                } else {
                    int iA = a(cCharAt, charSequence.charAt(i19));
                    i19++;
                    i20 = iA;
                }
            }
            boolean z10 = false;
            int i21 = 1;
            if (i20 >= 0 && i20 < 128) {
                byteBuffer.put(i18, (byte) i20);
            } else {
                if (128 <= i20 && i20 < 2048) {
                    byteBuffer.put(i18, (byte) (((i20 >> 6) & 31) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i18 + 1, (byte) ((i20 & 63) | 128));
                    i21 = 2;
                } else {
                    if (2048 <= i20 && i20 < 65536) {
                        byteBuffer.put(i18, (byte) (((i20 >> 12) & 15) | 224));
                        byteBuffer.put(i18 + 1, (byte) ((63 & (i20 >> 6)) | 128));
                        byteBuffer.put(i18 + 2, (byte) ((i20 & 63) | 128));
                        i21 = 3;
                    } else {
                        if (65536 <= i20 && i20 < 1114112) {
                            z10 = true;
                        }
                        if (!z10) {
                            j(i20);
                            throw new h();
                        }
                        byteBuffer.put(i18, (byte) (((i20 >> 18) & 7) | PsExtractor.VIDEO_STREAM_MASK));
                        byteBuffer.put(i18 + 1, (byte) (((i20 >> 12) & 63) | 128));
                        byteBuffer.put(i18 + 2, (byte) ((63 & (i20 >> 6)) | 128));
                        byteBuffer.put(i18 + 3, (byte) ((i20 & 63) | 128));
                        i21 = 4;
                    }
                }
            }
            i18 += i21;
            i17 = i19;
        }
        return i18 == i16 ? d(byteBuffer, charSequence, i17, i11, i12, i18, i14, i15) : c.d(h0.c((short) (i17 - i12)), h0.c((short) (i18 - i15)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0129, code lost:
    
        return q8.c.d(v8.h0.c((short) (r3 - r21)), v8.h0.c((short) (r4 - r24)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int d(java.nio.ByteBuffer r17, java.lang.CharSequence r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.f.d(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    public static final int e(int i10) {
        return (i10 >>> 10) + 55232;
    }

    public static final boolean f(int i10) {
        return (i10 >>> 16) == 0;
    }

    public static final boolean g(int i10) {
        return i10 <= 1114111;
    }

    public static final int h(int i10) {
        return (i10 & 1023) + 56320;
    }

    @NotNull
    public static final Void i(int i10) throws d {
        throw new d("Expected " + i10 + " more character bytes");
    }

    @NotNull
    public static final Void j(int i10) {
        throw new IllegalArgumentException("Malformed code-point " + i10 + " found");
    }
}
