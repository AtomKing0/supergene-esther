package g5;

import e5.o;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Ints.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    /* JADX INFO: compiled from: Ints.java */
    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f25880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f25881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f25882c;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            o.h(i10, size());
            return Integer.valueOf(this.f25880a[this.f25881b + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer set(int i10, Integer num) {
            o.h(i10, size());
            int[] iArr = this.f25880a;
            int i11 = this.f25881b;
            int i12 = iArr[i11 + i10];
            iArr[i11 + i10] = ((Integer) o.j(num)).intValue();
            return Integer.valueOf(i12);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && e.h(this.f25880a, ((Integer) obj).intValue(), this.f25881b, this.f25882c) != -1;
        }

        int[] d() {
            return Arrays.copyOfRange(this.f25880a, this.f25881b, this.f25882c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f25880a[this.f25881b + i10] != aVar.f25880a[aVar.f25881b + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iG = 1;
            for (int i10 = this.f25881b; i10 < this.f25882c; i10++) {
                iG = (iG * 31) + e.g(this.f25880a[i10]);
            }
            return iG;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iH;
            if (!(obj instanceof Integer) || (iH = e.h(this.f25880a, ((Integer) obj).intValue(), this.f25881b, this.f25882c)) < 0) {
                return -1;
            }
            return iH - this.f25881b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int i10;
            if (!(obj instanceof Integer) || (i10 = e.i(this.f25880a, ((Integer) obj).intValue(), this.f25881b, this.f25882c)) < 0) {
                return -1;
            }
            return i10 - this.f25881b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f25882c - this.f25881b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i10, int i11) {
            o.n(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            int[] iArr = this.f25880a;
            int i12 = this.f25881b;
            return new a(iArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f25880a[this.f25881b]);
            int i10 = this.f25881b;
            while (true) {
                i10++;
                if (i10 >= this.f25882c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f25880a[i10]);
            }
        }

        a(int[] iArr, int i10, int i11) {
            this.f25880a = iArr;
            this.f25881b = i10;
            this.f25882c = i11;
        }
    }

    public static List<Integer> c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j10) {
        int i10 = (int) j10;
        o.g(((long) i10) == j10, "Out of range: %s", j10);
        return i10;
    }

    public static int e(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int f(int i10, int i11, int i12) {
        o.f(i11 <= i12, "min (%s) must be less than or equal to max (%s)", i11, i12);
        return Math.min(Math.max(i10, i11), i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int[] iArr, int i10, int i11, int i12) {
        while (i11 < i12) {
            if (iArr[i11] == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int[] iArr, int i10, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (iArr[i13] == i10) {
                return i13;
            }
        }
        return -1;
    }

    public static int j(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static int[] k(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = ((Number) o.j(array[i10])).intValue();
        }
        return iArr;
    }

    public static int g(int i10) {
        return i10;
    }
}
