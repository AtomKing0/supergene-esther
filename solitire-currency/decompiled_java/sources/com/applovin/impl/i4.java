package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f5379a = {-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f5380b;

    public enum a {
        NONE(-1),
        DEFAULT(0),
        V2(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5385a;

        a(int i10) {
            this.f5385a = i10;
        }

        public int b() {
            return this.f5385a;
        }

        public static a a(int i10) {
            return i10 == 0 ? DEFAULT : i10 == 1 ? V2 : DEFAULT;
        }
    }

    static {
        byte[] bArr = new byte[32];
        f5380b = bArr;
        System.arraycopy(new byte[]{18, 12, 28, 20, 17, 23, 26, 9, 21, 3, 14, 29, 4, 0, 2, 7, 10, 29, 6, 20, 1}, 0, bArr, 0, 21);
    }

    public static byte[] a(String str, long j10, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str2.length() >= 86) {
            return TextUtils.isEmpty(str) ? new byte[0] : a.NONE == aVar ? str.getBytes() : a.V2 == aVar ? a(str, j10, false, str2, jVar) : a(str, j10, str2, jVar);
        }
        throw new IllegalArgumentException("SDK key is too short");
    }

    public static String b(String str, long j10, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str2.length() < 86) {
            throw new IllegalArgumentException("SDK key is too short");
        }
        if (TextUtils.isEmpty(str) || a.NONE == aVar) {
            return str;
        }
        byte[] bArrA = a.V2 == aVar ? a(str, j10, true, str2, jVar) : a(str, j10, str2, jVar);
        if (bArrA != null) {
            return new String(bArrA);
        }
        return null;
    }

    private static int c(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        int iA;
        int i10;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || (iA = a(bArr, (byte) 58)) < 0) {
            return 0;
        }
        byte[] bytes = a(f5380b, jVar).getBytes();
        int i11 = iA + 1;
        int length = bytes.length + i11;
        if (bArr.length <= length || bArr[length] != 58 || bArr.length <= (i10 = length + 55) || bArr[i10] != 58 || !Arrays.equals(Arrays.copyOfRange(bArr, i11, bytes.length + i11), bytes)) {
            return 0;
        }
        int i12 = length + 56;
        if (length + 64 > bArr.length) {
            return 0;
        }
        return i12;
    }

    private static byte[] a(String str, long j10, String str2, com.applovin.impl.sdk.j jVar) {
        char c10 = ' ';
        try {
            String strSubstring = str2.substring(32);
            String strSubstring2 = str2.substring(0, 32);
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArrA = a(strSubstring2, f5379a, jVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(((byte) (j10 & 255)) ^ bArrA[0]);
            byteArrayOutputStream.write(((byte) ((j10 >> 8) & 255)) ^ bArrA[1]);
            byteArrayOutputStream.write(((byte) ((j10 >> 16) & 255)) ^ bArrA[2]);
            byteArrayOutputStream.write(((byte) ((j10 >> 24) & 255)) ^ bArrA[3]);
            byteArrayOutputStream.write(((byte) ((j10 >> 32) & 255)) ^ bArrA[4]);
            byteArrayOutputStream.write(((byte) ((j10 >> 40) & 255)) ^ bArrA[5]);
            byteArrayOutputStream.write(((byte) ((j10 >> 48) & 255)) ^ bArrA[6]);
            byteArrayOutputStream.write(((byte) ((j10 >> 56) & 255)) ^ bArrA[7]);
            int i10 = 0;
            while (i10 < bytes.length) {
                long j11 = j10 + ((long) i10);
                long j12 = (j11 ^ (j11 >> 33)) * (-4417276706812531889L);
                long j13 = (j12 ^ (j12 >> 29)) * (-8796714831421723037L);
                long j14 = j13 ^ (j13 >> c10);
                String str3 = strSubstring;
                byteArrayOutputStream.write((byte) (((long) ((i10 >= bytes.length ? (byte) 0 : bytes[i10]) ^ bArrA[i10 % bArrA.length])) ^ (j14 & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 1 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 8) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 2 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 16) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 3 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 24) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 4 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 32) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 5 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 40) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 6 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 48) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i10 + 7 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j14 >> 56) & 255)));
                i10 += 8;
                strSubstring = str3;
                c10 = ' ';
            }
            String str4 = strSubstring;
            String strC = c(byteArrayOutputStream.toByteArray());
            return ("1:" + a(f5379a, jVar) + ":" + str4 + ":" + strC).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            jVar.A().a("AppLovinSdk", "encode", e10);
            return null;
        }
    }

    public static String b(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        if (str != null) {
            if (str.length() < 86) {
                throw new IllegalArgumentException("SDK key is too short");
            }
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return "";
            }
            a aVarB = b(bArr);
            if (a.NONE == aVarB) {
                return new String(bArr);
            }
            if (aVarB == a.V2) {
                return a(bArr, str, jVar);
            }
            return a(new String(bArr), str, jVar);
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    private static String c(byte[] bArr) {
        return a(Base64.encode(bArr, 2));
    }

    public static a b(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char c10 = (char) bArr[0];
            if (c10 == '2') {
                return a.V2;
            }
            if (c10 == '{') {
                return a.NONE;
            }
            return a.DEFAULT;
        }
        return a.NONE;
    }

    private static byte[] b(String str) {
        return Base64.decode(a(str), 0);
    }

    private static byte[] a(String str, long j10, boolean z10, String str2, com.applovin.impl.sdk.j jVar) {
        ByteBuffer byteBufferAllocate;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            String strSubstring = str2.substring(32);
            String strSubstring2 = str2.substring(0, 32);
            byte[] bArr = f5380b;
            byte[] bArrA = a(strSubstring2, bArr, jVar);
            long jC = z6.c(bArrA) ^ j10;
            byte[] bytes2 = String.format("2:%s:%s:", a(bArr, jVar), strSubstring).getBytes();
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(16);
            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate2.putLong(length);
            byteBufferAllocate2.putLong(jC);
            byteBufferAllocate2.flip();
            byte[] bArrA2 = a(z6.a(bytes), j10, bArrA);
            if (z10) {
                byte[] bytes3 = c(byteBufferAllocate2.array()).getBytes();
                byte[] bytes4 = c(bArrA2).getBytes();
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + bytes3.length + bytes4.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(bytes3);
                byteBufferAllocate.put(bytes4);
            } else {
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + byteBufferAllocate2.remaining() + bArrA2.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(byteBufferAllocate2);
                byteBufferAllocate.put(bArrA2);
            }
            byteBufferAllocate.flip();
            return byteBufferAllocate.array();
        } catch (UnsupportedEncodingException e10) {
            jVar.A().a("AppLovinSdk", "encode2", e10);
            throw new RuntimeException("UTF-8 encoding not found", e10);
        } catch (IOException e11) {
            jVar.A().a("AppLovinSdk", "encode2", e11);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, long j10, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        long j11 = j10;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (i10 % 8 == 0) {
                long j12 = ((long) i10) + j10;
                long j13 = (j12 ^ (j12 >>> 33)) * (-4417276706812531889L);
                long j14 = (j13 ^ (j13 >>> 29)) * (-8796714831421723037L);
                j11 = j14 ^ (j14 >>> 32);
            }
            byte b10 = bArrCopyOf[i10];
            bArrCopyOf[i10] = (byte) (((long) b10) ^ (((j11 >> (r4 * 8)) & 255) ^ ((long) bArr2[i10 % bArr2.length])));
        }
        return bArrCopyOf;
    }

    private static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        String[] strArrSplit = str.split(":");
        char c10 = 0;
        try {
            if (!"1".equals(strArrSplit[0]) || strArrSplit.length != 4) {
                return null;
            }
            String str3 = strArrSplit[1];
            String str4 = strArrSplit[2];
            byte[] bArrB = b(strArrSplit[3]);
            if (!str2.endsWith(str4)) {
                return null;
            }
            byte[] bArr = f5379a;
            if (!a(bArr, jVar).equals(str3)) {
                return null;
            }
            char c11 = ' ';
            byte[] bArrA = a(str2.substring(0, 32), bArr, jVar);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrB);
            char c12 = '\b';
            long j10 = (((long) ((byteArrayInputStream.read() ^ bArrA[1]) & 255)) << 8) | ((long) ((byteArrayInputStream.read() ^ bArrA[0]) & 255)) | (((long) ((byteArrayInputStream.read() ^ bArrA[2]) & 255)) << 16) | (((long) ((byteArrayInputStream.read() ^ bArrA[3]) & 255)) << 24) | (((long) ((byteArrayInputStream.read() ^ bArrA[4]) & 255)) << 32) | (((long) ((byteArrayInputStream.read() ^ bArrA[5]) & 255)) << 40) | (((long) ((byteArrayInputStream.read() ^ bArrA[6]) & 255)) << 48) | (((long) ((byteArrayInputStream.read() ^ bArrA[7]) & 255)) << 56);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[8];
            int i10 = byteArrayInputStream.read(bArr2);
            int i11 = 0;
            while (i10 >= 0) {
                ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                long j11 = ((long) i11) + j10;
                long j12 = (j11 ^ (j11 >> 33)) * (-4417276706812531889L);
                long j13 = (j12 ^ (j12 >> 29)) * (-8796714831421723037L);
                long j14 = j13 ^ (j13 >> c11);
                byteArrayOutputStream.write((byte) (((long) (bArr2[c10] ^ bArrA[i11 % bArrA.length])) ^ (j14 & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[(i11 + 1) % bArrA.length] ^ bArr2[1])) ^ ((j14 >> c12) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[(i11 + 2) % bArrA.length] ^ bArr2[2])) ^ ((j14 >> 16) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArr2[3] ^ bArrA[(i11 + 3) % bArrA.length])) ^ ((j14 >> 24) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[(i11 + 4) % bArrA.length] ^ bArr2[4])) ^ ((j14 >> 32) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[(i11 + 5) % bArrA.length] ^ bArr2[5])) ^ ((j14 >> 40) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[(i11 + 6) % bArrA.length] ^ bArr2[6])) ^ ((j14 >> 48) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArr2[7] ^ bArrA[(i11 + 7) % bArrA.length])) ^ ((j14 >> 56) & 255)));
                i11 += 8;
                byteArrayInputStream = byteArrayInputStream2;
                i10 = byteArrayInputStream2.read(bArr2);
                j10 = j10;
                c12 = '\b';
                c10 = 0;
                c11 = ' ';
            }
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
        } catch (UnsupportedEncodingException e10) {
            jVar.A().a("AppLovinSdk", "decode", e10);
            throw new RuntimeException("UTF-8 encoding not found", e10);
        } catch (IOException e11) {
            com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to read bytes", e11);
            jVar.A().a("AppLovinSdk", "decode", e11);
            return null;
        }
    }

    private static String a(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        try {
            int iC = c(bArr, str, jVar);
            if (iC == 0) {
                return null;
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, iC, bArr.length);
            if (bArrCopyOfRange.length < 16) {
                return null;
            }
            long jA = z6.a(bArrCopyOfRange, 8);
            byte[] bArrA = a(str.substring(0, 32), f5380b, jVar);
            return new String(z6.d(a(Arrays.copyOfRange(bArrCopyOfRange, 16, bArrCopyOfRange.length), jA ^ z6.c(bArrA), bArrA)), "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            jVar.A().a("AppLovinSdk", "decode2", e10);
            throw new RuntimeException("UTF-8 encoding not found", e10);
        } catch (IOException e11) {
            com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to ungzip decode", e11);
            jVar.A().a("AppLovinSdk", "decode2", e11);
            return null;
        }
    }

    private static int a(byte[] bArr, byte b10) {
        if (bArr != null && bArr.length != 0) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (bArr[i10] == b10) {
                    return i10;
                }
            }
        }
        return -1;
    }

    private static byte[] a(String str, byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            jVar.A().a("AppLovinSdk", "SHA256", e10);
            throw new RuntimeException("SHA-256 algorithm not found", e10);
        }
    }

    private static String a(byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
            messageDigest.update(bArr);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            jVar.A().a("AppLovinSdk", "SHA1", e10);
            throw new RuntimeException("SHA-1 algorithm not found", e10);
        }
    }

    private static String a(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', com.ironsource.nb.T);
    }

    private static String a(byte[] bArr) {
        return new String(bArr, "UTF-8").replace('+', '-').replace('/', '_').replace(com.ironsource.nb.T, '*');
    }
}
