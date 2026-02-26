package x3;

import a4.o0;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import k2.b3;
import k2.c3;
import k2.d3;
import k2.n3;
import l3.a0;
import l3.c1;
import l3.e1;

/* JADX INFO: compiled from: MappingTrackSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private a f36017c;

    /* JADX INFO: compiled from: MappingTrackSelector.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f36019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f36020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e1[] f36021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f36022e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[][][] f36023f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final e1 f36024g;

        @VisibleForTesting
        a(String[] strArr, int[] iArr, e1[] e1VarArr, int[] iArr2, int[][][] iArr3, e1 e1Var) {
            this.f36019b = strArr;
            this.f36020c = iArr;
            this.f36021d = e1VarArr;
            this.f36023f = iArr3;
            this.f36022e = iArr2;
            this.f36024g = e1Var;
            this.f36018a = iArr.length;
        }

        public int a(int i10, int i11, boolean z10) {
            int i12 = this.f36021d[i10].b(i11).f30482a;
            int[] iArr = new int[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                int iG = g(i10, i11, i14);
                if (iG == 4 || (z10 && iG == 3)) {
                    iArr[i13] = i14;
                    i13++;
                }
            }
            return b(i10, i11, Arrays.copyOf(iArr, i13));
        }

        public int b(int i10, int i11, int[] iArr) {
            int i12 = 0;
            int iMin = 16;
            String str = null;
            boolean z10 = false;
            int i13 = 0;
            while (i12 < iArr.length) {
                String str2 = this.f36021d[i10].b(i11).c(iArr[i12]).f29347l;
                int i14 = i13 + 1;
                if (i13 == 0) {
                    str = str2;
                } else {
                    z10 |= !o0.c(str, str2);
                }
                iMin = Math.min(iMin, b3.d(this.f36023f[i10][i11][i12]));
                i12++;
                i13 = i14;
            }
            return z10 ? Math.min(iMin, this.f36022e[i10]) : iMin;
        }

        public int c(int i10, int i11, int i12) {
            return this.f36023f[i10][i11][i12];
        }

        public int d() {
            return this.f36018a;
        }

        public int e(int i10) {
            return this.f36020c[i10];
        }

        public e1 f(int i10) {
            return this.f36021d[i10];
        }

        public int g(int i10, int i11, int i12) {
            return b3.f(c(i10, i11, i12));
        }

        public e1 h() {
            return this.f36024g;
        }
    }

    private static int k(c3[] c3VarArr, c1 c1Var, int[] iArr, boolean z10) throws k2.q {
        int length = c3VarArr.length;
        int i10 = 0;
        boolean z11 = true;
        for (int i11 = 0; i11 < c3VarArr.length; i11++) {
            c3 c3Var = c3VarArr[i11];
            int iMax = 0;
            for (int i12 = 0; i12 < c1Var.f30482a; i12++) {
                iMax = Math.max(iMax, b3.f(c3Var.a(c1Var.c(i12))));
            }
            boolean z12 = iArr[i11] == 0;
            if (iMax > i10 || (iMax == i10 && z10 && !z11 && z12)) {
                length = i11;
                z11 = z12;
                i10 = iMax;
            }
        }
        return length;
    }

    private static int[] l(c3 c3Var, c1 c1Var) throws k2.q {
        int[] iArr = new int[c1Var.f30482a];
        for (int i10 = 0; i10 < c1Var.f30482a; i10++) {
            iArr[i10] = c3Var.a(c1Var.c(i10));
        }
        return iArr;
    }

    private static int[] m(c3[] c3VarArr) throws k2.q {
        int length = c3VarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = c3VarArr[i10].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // x3.b0
    public final void f(@Nullable Object obj) {
        this.f36017c = (a) obj;
    }

    @Override // x3.b0
    public final c0 h(c3[] c3VarArr, e1 e1Var, a0.b bVar, n3 n3Var) throws k2.q {
        int[] iArr = new int[c3VarArr.length + 1];
        int length = c3VarArr.length + 1;
        c1[][] c1VarArr = new c1[length][];
        int[][][] iArr2 = new int[c3VarArr.length + 1][][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = e1Var.f30517a;
            c1VarArr[i10] = new c1[i11];
            iArr2[i10] = new int[i11][];
        }
        int[] iArrM = m(c3VarArr);
        for (int i12 = 0; i12 < e1Var.f30517a; i12++) {
            c1 c1VarB = e1Var.b(i12);
            int iK = k(c3VarArr, c1VarB, iArr, c1VarB.f30484c == 5);
            int[] iArrL = iK == c3VarArr.length ? new int[c1VarB.f30482a] : l(c3VarArr[iK], c1VarB);
            int i13 = iArr[iK];
            c1VarArr[iK][i13] = c1VarB;
            iArr2[iK][i13] = iArrL;
            iArr[iK] = i13 + 1;
        }
        e1[] e1VarArr = new e1[c3VarArr.length];
        String[] strArr = new String[c3VarArr.length];
        int[] iArr3 = new int[c3VarArr.length];
        for (int i14 = 0; i14 < c3VarArr.length; i14++) {
            int i15 = iArr[i14];
            e1VarArr[i14] = new e1((c1[]) o0.A0(c1VarArr[i14], i15));
            iArr2[i14] = (int[][]) o0.A0(iArr2[i14], i15);
            strArr[i14] = c3VarArr[i14].getName();
            iArr3[i14] = c3VarArr[i14].getTrackType();
        }
        a aVar = new a(strArr, iArr3, e1VarArr, iArrM, iArr2, new e1((c1[]) o0.A0(c1VarArr[c3VarArr.length], iArr[c3VarArr.length])));
        Pair<d3[], s[]> pairN = n(aVar, iArr2, iArrM, bVar, n3Var);
        return new c0((d3[]) pairN.first, (s[]) pairN.second, a0.b(aVar, (v[]) pairN.second), aVar);
    }

    protected abstract Pair<d3[], s[]> n(a aVar, int[][][] iArr, int[] iArr2, a0.b bVar, n3 n3Var) throws k2.q;
}
