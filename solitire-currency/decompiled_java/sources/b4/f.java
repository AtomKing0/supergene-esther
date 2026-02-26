package b4;

import a4.c0;
import a4.y;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import k2.j2;

/* JADX INFO: compiled from: HevcConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f2107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f2112f;

    private f(List<byte[]> list, int i10, int i11, int i12, float f10, @Nullable String str) {
        this.f2107a = list;
        this.f2108b = i10;
        this.f2109c = i11;
        this.f2110d = i12;
        this.f2111e = f10;
        this.f2112f = str;
    }

    public static f a(c0 c0Var) throws j2 {
        int i10;
        int i11;
        try {
            c0Var.Q(21);
            int iD = c0Var.D() & 3;
            int iD2 = c0Var.D();
            int iE = c0Var.e();
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < iD2; i14++) {
                c0Var.Q(1);
                int iJ = c0Var.J();
                for (int i15 = 0; i15 < iJ; i15++) {
                    int iJ2 = c0Var.J();
                    i13 += iJ2 + 4;
                    c0Var.Q(iJ2);
                }
            }
            c0Var.P(iE);
            byte[] bArr = new byte[i13];
            int i16 = -1;
            int i17 = -1;
            float f10 = 1.0f;
            String strC = null;
            int i18 = 0;
            int i19 = 0;
            while (i18 < iD2) {
                int iD3 = c0Var.D() & 63;
                int iJ3 = c0Var.J();
                int i20 = i12;
                while (i20 < iJ3) {
                    int iJ4 = c0Var.J();
                    byte[] bArr2 = a4.y.f258a;
                    int i21 = iD2;
                    System.arraycopy(bArr2, i12, bArr, i19, bArr2.length);
                    int length = i19 + bArr2.length;
                    System.arraycopy(c0Var.d(), c0Var.e(), bArr, length, iJ4);
                    if (iD3 == 33 && i20 == 0) {
                        y.a aVarH = a4.y.h(bArr, length, length + iJ4);
                        int i22 = aVarH.f269h;
                        i17 = aVarH.f270i;
                        f10 = aVarH.f271j;
                        i10 = iD3;
                        i11 = iJ3;
                        i16 = i22;
                        strC = a4.e.c(aVarH.f262a, aVarH.f263b, aVarH.f264c, aVarH.f265d, aVarH.f266e, aVarH.f267f);
                    } else {
                        i10 = iD3;
                        i11 = iJ3;
                    }
                    i19 = length + iJ4;
                    c0Var.Q(iJ4);
                    i20++;
                    iD2 = i21;
                    iD3 = i10;
                    iJ3 = i11;
                    i12 = 0;
                }
                i18++;
                i12 = 0;
            }
            return new f(i13 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iD + 1, i16, i17, f10, strC);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw j2.a("Error parsing HEVC config", e10);
        }
    }
}
