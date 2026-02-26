package ua;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class w0 extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final transient byte[][] f34838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final transient int[] f34839g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(f.f34756e.g());
        kotlin.jvm.internal.t.i(segments, "segments");
        kotlin.jvm.internal.t.i(directory, "directory");
        this.f34838f = segments;
        this.f34839g = directory;
    }

    private final f L() {
        return new f(K());
    }

    @Override // ua.f
    @NotNull
    public f D(int i10, int i11) {
        int iD = f1.d(this, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
        if (!(iD <= B())) {
            throw new IllegalArgumentException(("endIndex=" + iD + " > length(" + B() + ')').toString());
        }
        int i12 = iD - i10;
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + iD + " < beginIndex=" + i10).toString());
        }
        if (i10 == 0 && iD == B()) {
            return this;
        }
        if (i10 == iD) {
            return f.f34756e;
        }
        int iB = va.j.b(this, i10);
        int iB2 = va.j.b(this, iD - 1);
        byte[][] bArr = (byte[][]) kotlin.collections.o.p(J(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i13 = 0;
            int i14 = iB;
            while (true) {
                iArr[i13] = Math.min(I()[i14] - i10, i12);
                int i15 = i13 + 1;
                iArr[i13 + bArr.length] = I()[J().length + i14];
                if (i14 == iB2) {
                    break;
                }
                i14++;
                i13 = i15;
            }
        }
        int i16 = iB != 0 ? I()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i10 - i16);
        return new w0(bArr, iArr);
    }

    @Override // ua.f
    @NotNull
    public f F() {
        return L().F();
    }

    @Override // ua.f
    public void H(@NotNull c buffer, int i10, int i11) {
        kotlin.jvm.internal.t.i(buffer, "buffer");
        int i12 = i10 + i11;
        int iB = va.j.b(this, i10);
        while (i10 < i12) {
            int i13 = iB == 0 ? 0 : I()[iB - 1];
            int i14 = I()[iB] - i13;
            int i15 = I()[J().length + iB];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            u0 u0Var = new u0(J()[iB], i16, i16 + iMin, true, false);
            u0 u0Var2 = buffer.f34738a;
            if (u0Var2 == null) {
                u0Var.f34832g = u0Var;
                u0Var.f34831f = u0Var;
                buffer.f34738a = u0Var;
            } else {
                kotlin.jvm.internal.t.f(u0Var2);
                u0 u0Var3 = u0Var2.f34832g;
                kotlin.jvm.internal.t.f(u0Var3);
                u0Var3.c(u0Var);
            }
            i10 += iMin;
            iB++;
        }
        buffer.L0(buffer.size() + ((long) i11));
    }

    @NotNull
    public final int[] I() {
        return this.f34839g;
    }

    @NotNull
    public final byte[][] J() {
        return this.f34838f;
    }

    @NotNull
    public byte[] K() {
        byte[] bArr = new byte[B()];
        int length = J().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = I()[length + i10];
            int i14 = I()[i10];
            int i15 = i14 - i11;
            kotlin.collections.o.d(J()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // ua.f
    @NotNull
    public String a() {
        return L().a();
    }

    @Override // ua.f
    @NotNull
    public f d(@NotNull String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.t.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = J().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = I()[length + i10];
            int i13 = I()[i10];
            messageDigest.update(J()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.t.h(digestBytes, "digestBytes");
        return new f(digestBytes);
    }

    @Override // ua.f
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.B() == B() && v(0, fVar, 0, B())) {
                return true;
            }
        }
        return false;
    }

    @Override // ua.f
    public int hashCode() {
        int iH = h();
        if (iH != 0) {
            return iH;
        }
        int length = J().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = I()[length + i10];
            int i14 = I()[i10];
            byte[] bArr = J()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        x(i11);
        return i11;
    }

    @Override // ua.f
    public int i() {
        return I()[J().length - 1];
    }

    @Override // ua.f
    @NotNull
    public String k() {
        return L().k();
    }

    @Override // ua.f
    public int m(@NotNull byte[] other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        return L().m(other, i10);
    }

    @Override // ua.f
    @NotNull
    public byte[] o() {
        return K();
    }

    @Override // ua.f
    public byte p(int i10) {
        f1.b(I()[J().length - 1], i10, 1L);
        int iB = va.j.b(this, i10);
        return J()[iB][(i10 - (iB == 0 ? 0 : I()[iB - 1])) + I()[J().length + iB]];
    }

    @Override // ua.f
    public int r(@NotNull byte[] other, int i10) {
        kotlin.jvm.internal.t.i(other, "other");
        return L().r(other, i10);
    }

    @Override // ua.f
    @NotNull
    public String toString() {
        return L().toString();
    }

    @Override // ua.f
    public boolean v(int i10, @NotNull f other, int i11, int i12) {
        kotlin.jvm.internal.t.i(other, "other");
        if (i10 < 0 || i10 > B() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = va.j.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : I()[iB - 1];
            int i15 = I()[iB] - i14;
            int i16 = I()[J().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!other.w(i11, J()[iB], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }

    @Override // ua.f
    public boolean w(int i10, @NotNull byte[] other, int i11, int i12) {
        kotlin.jvm.internal.t.i(other, "other");
        if (i10 < 0 || i10 > B() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = va.j.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : I()[iB - 1];
            int i15 = I()[iB] - i14;
            int i16 = I()[J().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!f1.a(J()[iB], i16 + (i10 - i14), other, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }
}
