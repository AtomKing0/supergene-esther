package ua;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.f;

/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final byte[] f34753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final byte[] f34754b;

    static {
        f.a aVar = f.f34755d;
        f34753a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").g();
        f34754b = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").g();
    }

    @Nullable
    public static final byte[] a(@NotNull String str) {
        int i10;
        char cCharAt;
        kotlin.jvm.internal.t.i(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i11 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i12 >= length) {
                int i16 = i13 % 4;
                if (i16 == 1) {
                    return null;
                }
                if (i16 == 2) {
                    bArr[i15] = (byte) ((i14 << 12) >> 16);
                    i15++;
                } else if (i16 == 3) {
                    int i17 = i14 << 6;
                    int i18 = i15 + 1;
                    bArr[i15] = (byte) (i17 >> 16);
                    i15 = i18 + 1;
                    bArr[i18] = (byte) (i17 >> 8);
                }
                if (i15 == i11) {
                    return bArr;
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i15);
                kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, newSize)");
                return bArrCopyOf;
            }
            char cCharAt2 = str.charAt(i12);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i10 = cCharAt2 - 'A';
            } else {
                if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i10 = cCharAt2 - 'G';
                } else {
                    if ('0' <= cCharAt2 && cCharAt2 < ':') {
                        i10 = cCharAt2 + 4;
                    } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                        i10 = 62;
                    } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                        i10 = 63;
                    } else {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            return null;
                        }
                        i12++;
                    }
                }
            }
            i14 = (i14 << 6) | i10;
            i13++;
            if (i13 % 4 == 0) {
                int i19 = i15 + 1;
                bArr[i15] = (byte) (i14 >> 16);
                int i20 = i19 + 1;
                bArr[i19] = (byte) (i14 >> 8);
                bArr[i20] = (byte) i14;
                i15 = i20 + 1;
            }
            i12++;
        }
    }

    @NotNull
    public static final String b(@NotNull byte[] bArr, @NotNull byte[] map) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        kotlin.jvm.internal.t.i(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            int i13 = i12 + 1;
            byte b11 = bArr[i12];
            int i14 = i13 + 1;
            byte b12 = bArr[i13];
            int i15 = i11 + 1;
            bArr2[i11] = map[(b10 & 255) >> 2];
            int i16 = i15 + 1;
            bArr2[i15] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i17 = i16 + 1;
            bArr2[i16] = map[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 = i17 + 1;
            bArr2[i17] = map[b12 & 63];
            i10 = i14;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            int i18 = i11 + 1;
            bArr2[i11] = map[(b13 & 255) >> 2];
            int i19 = i18 + 1;
            bArr2[i18] = map[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr2[i19] = b14;
            bArr2[i19 + 1] = b14;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            byte b15 = bArr[i10];
            byte b16 = bArr[i20];
            int i21 = i11 + 1;
            bArr2[i11] = map[(b15 & 255) >> 2];
            int i22 = i21 + 1;
            bArr2[i21] = map[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr2[i22] = map[(b16 & 15) << 2];
            bArr2[i22 + 1] = (byte) 61;
        }
        return e1.b(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = f34753a;
        }
        return b(bArr, bArr2);
    }
}
