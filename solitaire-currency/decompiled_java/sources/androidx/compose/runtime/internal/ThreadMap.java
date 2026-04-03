package androidx.compose.runtime.internal;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadMap {

    @NotNull
    private final long[] keys;
    private final int size;

    @NotNull
    private final Object[] values;

    public ThreadMap(int i10, @NotNull long[] keys, @NotNull Object[] values) {
        t.i(keys, "keys");
        t.i(values, "values");
        this.size = i10;
        this.keys = keys;
        this.values = values;
    }

    private final int find(long j10) {
        int i10 = this.size - 1;
        if (i10 == -1) {
            return -1;
        }
        int i11 = 0;
        if (i10 == 0) {
            long j11 = this.keys[0];
            if (j11 == j10) {
                return 0;
            }
            return j11 > j10 ? -2 : -1;
        }
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j12 = this.keys[i12] - j10;
            if (j12 < 0) {
                i11 = i12 + 1;
            } else {
                if (j12 <= 0) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    @Nullable
    public final Object get(long j10) {
        int iFind = find(j10);
        if (iFind >= 0) {
            return this.values[iFind];
        }
        return null;
    }

    @NotNull
    public final ThreadMap newWith(long j10, @Nullable Object obj) {
        int i10 = this.size;
        Object[] objArr = this.values;
        int length = objArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= length) {
                break;
            }
            if (objArr[i12] != null) {
                i13++;
            }
            i12++;
        }
        int i14 = i13 + 1;
        long[] jArr = new long[i14];
        Object[] objArr2 = new Object[i14];
        if (i14 > 1) {
            int i15 = 0;
            while (true) {
                if (i11 >= i14 || i15 >= i10) {
                    break;
                }
                long j11 = this.keys[i15];
                Object obj2 = this.values[i15];
                if (j11 > j10) {
                    jArr[i11] = j10;
                    objArr2[i11] = obj;
                    i11++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i11] = j11;
                    objArr2[i11] = obj2;
                    i11++;
                }
                i15++;
            }
            if (i15 == i10) {
                int i16 = i14 - 1;
                jArr[i16] = j10;
                objArr2[i16] = obj;
            } else {
                while (i11 < i14) {
                    long j12 = this.keys[i15];
                    Object obj3 = this.values[i15];
                    if (obj3 != null) {
                        jArr[i11] = j12;
                        objArr2[i11] = obj3;
                        i11++;
                    }
                    i15++;
                }
            }
        } else {
            jArr[0] = j10;
            objArr2[0] = obj;
        }
        return new ThreadMap(i14, jArr, objArr2);
    }

    public final boolean trySet(long j10, @Nullable Object obj) {
        int iFind = find(j10);
        if (iFind < 0) {
            return false;
        }
        this.values[iFind] = obj;
        return true;
    }
}
