package l3;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: ShuffleOrder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface w0 {

    /* JADX INFO: compiled from: ShuffleOrder.java */
    public static class a implements w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Random f30760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f30761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f30762c;

        public a(int i10) {
            this(i10, new Random());
        }

        private static int[] a(int i10, Random random) {
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                int iNextInt = random.nextInt(i12);
                iArr[i11] = iArr[iNextInt];
                iArr[iNextInt] = i11;
                i11 = i12;
            }
            return iArr;
        }

        @Override // l3.w0
        public w0 cloneAndClear() {
            return new a(0, new Random(this.f30760a.nextLong()));
        }

        @Override // l3.w0
        public w0 cloneAndInsert(int i10, int i11) {
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int i12 = 0;
            int i13 = 0;
            while (i13 < i11) {
                iArr[i13] = this.f30760a.nextInt(this.f30761b.length + 1);
                int i14 = i13 + 1;
                int iNextInt = this.f30760a.nextInt(i14);
                iArr2[i13] = iArr2[iNextInt];
                iArr2[iNextInt] = i13 + i10;
                i13 = i14;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f30761b.length + i11];
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f30761b;
                if (i12 >= iArr4.length + i11) {
                    return new a(iArr3, new Random(this.f30760a.nextLong()));
                }
                if (i15 >= i11 || i16 != iArr[i15]) {
                    int i17 = i16 + 1;
                    int i18 = iArr4[i16];
                    iArr3[i12] = i18;
                    if (i18 >= i10) {
                        iArr3[i12] = i18 + i11;
                    }
                    i16 = i17;
                } else {
                    iArr3[i12] = iArr2[i15];
                    i15++;
                }
                i12++;
            }
        }

        @Override // l3.w0
        public w0 cloneAndRemove(int i10, int i11) {
            int i12 = i11 - i10;
            int[] iArr = new int[this.f30761b.length - i12];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int[] iArr2 = this.f30761b;
                if (i13 >= iArr2.length) {
                    return new a(iArr, new Random(this.f30760a.nextLong()));
                }
                int i15 = iArr2[i13];
                if (i15 < i10 || i15 >= i11) {
                    int i16 = i13 - i14;
                    if (i15 >= i10) {
                        i15 -= i12;
                    }
                    iArr[i16] = i15;
                } else {
                    i14++;
                }
                i13++;
            }
        }

        @Override // l3.w0
        public int getFirstIndex() {
            int[] iArr = this.f30761b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // l3.w0
        public int getLastIndex() {
            int[] iArr = this.f30761b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // l3.w0
        public int getLength() {
            return this.f30761b.length;
        }

        @Override // l3.w0
        public int getNextIndex(int i10) {
            int i11 = this.f30762c[i10] + 1;
            int[] iArr = this.f30761b;
            if (i11 < iArr.length) {
                return iArr[i11];
            }
            return -1;
        }

        @Override // l3.w0
        public int getPreviousIndex(int i10) {
            int i11 = this.f30762c[i10] - 1;
            if (i11 >= 0) {
                return this.f30761b[i11];
            }
            return -1;
        }

        private a(int i10, Random random) {
            this(a(i10, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f30761b = iArr;
            this.f30760a = random;
            this.f30762c = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                this.f30762c[iArr[i10]] = i10;
            }
        }
    }

    w0 cloneAndClear();

    w0 cloneAndInsert(int i10, int i11);

    w0 cloneAndRemove(int i10, int i11);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i10);

    int getPreviousIndex(int i10);
}
