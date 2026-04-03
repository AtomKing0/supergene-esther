package com.king.store.billingutil;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] WEBSAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte[] DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, EQUALS_SIGN_ENC, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NEW_LINE, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    private static final byte[] WEBSAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, EQUALS_SIGN_ENC, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NEW_LINE, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    private Base64() {
    }

    public static byte[] decode(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    private static int decode4to3(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3) {
        byte b10 = bArr[i10 + 2];
        if (b10 == 61) {
            bArr2[i11] = (byte) ((((bArr3[bArr[i10 + 1]] << 24) >>> 12) | ((bArr3[bArr[i10]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        byte b11 = bArr[i10 + 3];
        if (b11 == 61) {
            int i12 = ((bArr3[bArr[i10 + 1]] << 24) >>> 12) | ((bArr3[bArr[i10]] << 24) >>> 6) | ((bArr3[b10] << 24) >>> 18);
            bArr2[i11] = (byte) (i12 >>> 16);
            bArr2[i11 + 1] = (byte) (i12 >>> 8);
            return 2;
        }
        int i13 = ((bArr3[bArr[i10 + 1]] << 24) >>> 12) | ((bArr3[bArr[i10]] << 24) >>> 6) | ((bArr3[b10] << 24) >>> 18) | ((bArr3[b11] << 24) >>> 24);
        bArr2[i11] = (byte) (i13 >> 16);
        bArr2[i11 + 1] = (byte) (i13 >> 8);
        bArr2[i11 + 2] = (byte) i13;
        return 3;
    }

    public static byte[] decodeWebSafe(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decodeWebSafe(bytes, 0, bytes.length);
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, ALPHABET, true);
    }

    private static byte[] encode3to4(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, byte[] bArr3) {
        int i13 = (i11 > 0 ? (bArr[i10] << 24) >>> 8 : 0) | (i11 > 1 ? (bArr[i10 + 1] << 24) >>> 16 : 0) | (i11 > 2 ? (bArr[i10 + 2] << 24) >>> 24 : 0);
        if (i11 == 1) {
            bArr2[i12] = bArr3[i13 >>> 18];
            bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
            bArr2[i12 + 2] = EQUALS_SIGN;
            bArr2[i12 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i11 == 2) {
            bArr2[i12] = bArr3[i13 >>> 18];
            bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
            bArr2[i12 + 2] = bArr3[(i13 >>> 6) & 63];
            bArr2[i12 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i11 != 3) {
            return bArr2;
        }
        bArr2[i12] = bArr3[i13 >>> 18];
        bArr2[i12 + 1] = bArr3[(i13 >>> 12) & 63];
        bArr2[i12 + 2] = bArr3[(i13 >>> 6) & 63];
        bArr2[i12 + 3] = bArr3[i13 & 63];
        return bArr2;
    }

    public static String encodeWebSafe(byte[] bArr, boolean z10) {
        return encode(bArr, 0, bArr.length, WEBSAFE_ALPHABET, z10);
    }

    public static String encode(byte[] bArr, int i10, int i11, byte[] bArr2, boolean z10) {
        byte[] bArrEncode = encode(bArr, i10, i11, bArr2, Integer.MAX_VALUE);
        int length = bArrEncode.length;
        while (!z10 && length > 0 && bArrEncode[length - 1] == 61) {
            length--;
        }
        return new String(bArrEncode, 0, length);
    }

    public static byte[] decode(byte[] bArr) throws Base64DecoderException {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr) throws Base64DecoderException {
        return decodeWebSafe(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i10, int i11) throws Base64DecoderException {
        return decode(bArr, i10, i11, DECODABET);
    }

    public static byte[] decodeWebSafe(byte[] bArr, int i10, int i11) throws Base64DecoderException {
        return decode(bArr, i10, i11, WEBSAFE_DECODABET);
    }

    public static byte[] decode(byte[] bArr, int i10, int i11, byte[] bArr2) throws Base64DecoderException {
        byte[] bArr3 = new byte[((i11 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i12 = 0;
        int i13 = 0;
        int iDecode4to3 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + i10;
            byte b10 = (byte) (bArr[i14] & 127);
            byte b11 = bArr2[b10];
            if (b11 < -5) {
                throw new Base64DecoderException("Bad Base64 input character at " + i12 + ": " + ((int) bArr[i14]) + "(decimal)");
            }
            if (b11 >= -1) {
                if (b10 == 61) {
                    int i15 = i11 - i12;
                    byte b12 = (byte) (bArr[(i11 - 1) + i10] & 127);
                    if (i13 == 0 || i13 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i12);
                    }
                    if ((i13 == 3 && i15 > 2) || (i13 == 4 && i15 > 1)) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i12);
                    }
                    if (b12 != 61 && b12 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    }
                } else {
                    int i16 = i13 + 1;
                    bArr4[i13] = b10;
                    if (i16 == 4) {
                        iDecode4to3 += decode4to3(bArr4, 0, bArr3, iDecode4to3, bArr2);
                        i13 = 0;
                    } else {
                        i13 = i16;
                    }
                }
            }
            i12++;
        }
        if (i13 != 0) {
            if (i13 != 1) {
                bArr4[i13] = EQUALS_SIGN;
                iDecode4to3 += decode4to3(bArr4, 0, bArr3, iDecode4to3, bArr2);
            } else {
                throw new Base64DecoderException("single trailing character at offset " + (i11 - 1));
            }
        }
        byte[] bArr5 = new byte[iDecode4to3];
        System.arraycopy(bArr3, 0, bArr5, 0, iDecode4to3);
        return bArr5;
    }

    public static byte[] encode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int i13 = ((i11 + 2) / 3) * 4;
        byte[] bArr3 = new byte[i13 + (i13 / i12)];
        int i14 = i11 - 2;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < i14) {
            int i18 = ((bArr[i15 + i10] << 24) >>> 8) | ((bArr[(i15 + 1) + i10] << 24) >>> 16) | ((bArr[(i15 + 2) + i10] << 24) >>> 24);
            bArr3[i16] = bArr2[i18 >>> 18];
            int i19 = i16 + 1;
            bArr3[i19] = bArr2[(i18 >>> 12) & 63];
            bArr3[i16 + 2] = bArr2[(i18 >>> 6) & 63];
            bArr3[i16 + 3] = bArr2[i18 & 63];
            i17 += 4;
            if (i17 == i12) {
                bArr3[i16 + 4] = NEW_LINE;
                i17 = 0;
                i16 = i19;
            }
            i15 += 3;
            i16 += 4;
        }
        if (i15 < i11) {
            encode3to4(bArr, i15 + i10, i11 - i15, bArr3, i16, bArr2);
            if (i17 + 4 == i12) {
                bArr3[i16 + 4] = NEW_LINE;
            }
        }
        return bArr3;
    }
}
