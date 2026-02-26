package ua;

import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f implements Serializable, Comparable<f> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f34755d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final f f34756e = new f(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final byte[] f34757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f34758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private transient String f34759c;

    /* JADX INFO: compiled from: ByteString.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ f g(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = f1.c();
            }
            return aVar.f(bArr, i10, i11);
        }

        @Nullable
        public final f a(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            byte[] bArrA = d1.a(str);
            if (bArrA != null) {
                return new f(bArrA);
            }
            return null;
        }

        @NotNull
        public final f b(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((va.g.e(str.charAt(i11)) << 4) + va.g.e(str.charAt(i11 + 1)));
            }
            return new f(bArr);
        }

        @NotNull
        public final f c(@NotNull String str, @NotNull Charset charset) {
            kotlin.jvm.internal.t.i(str, "<this>");
            kotlin.jvm.internal.t.i(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
            return new f(bytes);
        }

        @NotNull
        public final f d(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            f fVar = new f(e1.a(str));
            fVar.y(str);
            return fVar;
        }

        @NotNull
        public final f e(@NotNull byte... data) {
            kotlin.jvm.internal.t.i(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, size)");
            return new f(bArrCopyOf);
        }

        @NotNull
        public final f f(@NotNull byte[] bArr, int i10, int i11) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            int iE = f1.e(bArr, i11);
            f1.b(bArr.length, i10, iE);
            return new f(kotlin.collections.o.n(bArr, i10, iE + i10));
        }
    }

    public f(@NotNull byte[] data) {
        kotlin.jvm.internal.t.i(data, "data");
        this.f34757a = data;
    }

    public static /* synthetic */ f E(f fVar, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = f1.c();
        }
        return fVar.D(i10, i11);
    }

    public static /* synthetic */ int n(f fVar, f fVar2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return fVar.l(fVar2, i10);
    }

    public static /* synthetic */ int s(f fVar, f fVar2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = f1.c();
        }
        return fVar.q(fVar2, i10);
    }

    @NotNull
    public static final f u(@NotNull byte... bArr) {
        return f34755d.e(bArr);
    }

    @NotNull
    public final f A() {
        return d("SHA-256");
    }

    public final int B() {
        return i();
    }

    public final boolean C(@NotNull f prefix) {
        kotlin.jvm.internal.t.i(prefix, "prefix");
        return v(0, prefix, 0, prefix.B());
    }

    @NotNull
    public f D(int i10, int i11) {
        int iD = f1.d(this, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (iD <= g().length) {
            if (iD - i10 >= 0) {
                return (i10 == 0 && iD == g().length) ? this : new f(kotlin.collections.o.n(g(), i10, iD));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + g().length + ')').toString());
    }

    @NotNull
    public f F() {
        byte b10;
        for (int i10 = 0; i10 < g().length; i10++) {
            byte b11 = g()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] bArrG = g();
                byte[] bArrCopyOf = Arrays.copyOf(bArrG, bArrG.length);
                kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new f(bArrCopyOf);
            }
        }
        return this;
    }

    @NotNull
    public String G() {
        String strJ = j();
        if (strJ != null) {
            return strJ;
        }
        String strB = e1.b(o());
        y(strB);
        return strB;
    }

    public void H(@NotNull c buffer, int i10, int i11) {
        kotlin.jvm.internal.t.i(buffer, "buffer");
        va.g.d(this, buffer, i10, i11);
    }

    @NotNull
    public String a() {
        return d1.c(g(), null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r0 < r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L13;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(@org.jetbrains.annotations.NotNull ua.f r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.t.i(r10, r0)
            int r0 = r9.B()
            int r1 = r10.B()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.f(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.f(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = r5
            goto L33
        L32:
            r3 = r6
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.f.compareTo(ua.f):int");
    }

    @NotNull
    public f d(@NotNull String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.t.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f34757a, 0, B());
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.t.h(digestBytes, "digestBytes");
        return new f(digestBytes);
    }

    public final boolean e(@NotNull f suffix) {
        kotlin.jvm.internal.t.i(suffix, "suffix");
        return v(B() - suffix.B(), suffix, 0, suffix.B());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.B() == g().length && fVar.w(0, g(), 0, g().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte f(int i10) {
        return p(i10);
    }

    @NotNull
    public final byte[] g() {
        return this.f34757a;
    }

    public final int h() {
        return this.f34758b;
    }

    public int hashCode() {
        int iH = h();
        if (iH != 0) {
            return iH;
        }
        int iHashCode = Arrays.hashCode(g());
        x(iHashCode);
        return iHashCode;
    }

    public int i() {
        return g().length;
    }

    @Nullable
    public final String j() {
        return this.f34759c;
    }

    @NotNull
    public String k() {
        char[] cArr = new char[g().length * 2];
        int i10 = 0;
        for (byte b10 : g()) {
            int i11 = i10 + 1;
            cArr[i10] = va.g.f()[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = va.g.f()[b10 & 15];
        }
        return p9.q.p(cArr);
    }

    public final int l(@NotNull f other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        return m(other.o(), i10);
    }

    public int m(@NotNull byte[] other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        int length = g().length - other.length;
        int iMax = Math.max(i10, 0);
        if (iMax <= length) {
            while (!f1.a(g(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @NotNull
    public byte[] o() {
        return g();
    }

    public byte p(int i10) {
        return g()[i10];
    }

    public final int q(@NotNull f other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        return r(other.o(), i10);
    }

    public int r(@NotNull byte[] other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        for (int iMin = Math.min(f1.d(this, i10), g().length - other.length); -1 < iMin; iMin--) {
            if (f1.a(g(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    @NotNull
    public final f t() {
        return d("MD5");
    }

    @NotNull
    public String toString() {
        String str;
        if (g().length == 0) {
            str = "[size=0]";
        } else {
            int iC = va.g.c(g(), 64);
            if (iC != -1) {
                String strG = G();
                String strSubstring = strG.substring(0, iC);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strG2 = p9.q.G(p9.q.G(p9.q.G(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iC >= strG.length()) {
                    return "[text=" + strG2 + ']';
                }
                return "[size=" + g().length + " text=" + strG2 + "…]";
            }
            if (g().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(g().length);
                sb.append(" hex=");
                int iD = f1.d(this, 64);
                if (iD <= g().length) {
                    if (!(iD + 0 >= 0)) {
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                    sb.append((iD == g().length ? this : new f(kotlin.collections.o.n(g(), 0, iD))).k());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + g().length + ')').toString());
            }
            str = "[hex=" + k() + ']';
        }
        return str;
    }

    public boolean v(int i10, @NotNull f other, int i11, int i12) {
        kotlin.jvm.internal.t.i(other, "other");
        return other.w(i11, g(), i10, i12);
    }

    public boolean w(int i10, @NotNull byte[] other, int i11, int i12) {
        kotlin.jvm.internal.t.i(other, "other");
        return i10 >= 0 && i10 <= g().length - i12 && i11 >= 0 && i11 <= other.length - i12 && f1.a(g(), i10, other, i11, i12);
    }

    public final void x(int i10) {
        this.f34758b = i10;
    }

    public final void y(@Nullable String str) {
        this.f34759c = str;
    }

    @NotNull
    public final f z() {
        return d(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
    }
}
