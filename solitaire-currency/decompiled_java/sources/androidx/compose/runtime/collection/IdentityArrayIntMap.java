package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import h9.p;
import kotlin.collections.o;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: IdentityArrayIntMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdentityArrayIntMap {
    private int size;

    @NotNull
    private Object[] keys = new Object[4];

    @NotNull
    private int[] values = new int[4];

    private final int find(Object obj) {
        int i10 = this.size - 1;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            Object obj2 = this.keys[i12];
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i11 = i12 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return obj2 == obj ? i12 : findExactIndex(i12, obj, iIdentityHashCode);
                }
                i10 = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        return -(r3 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r3, java.lang.Object r4, int r5) {
        /*
            r2 = this;
            int r0 = r3 + (-1)
        L2:
            r1 = -1
            if (r1 >= r0) goto L16
            java.lang.Object[] r1 = r2.keys
            r1 = r1[r0]
            if (r1 != r4) goto Lc
            return r0
        Lc:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r5) goto L13
            goto L16
        L13:
            int r0 = r0 + (-1)
            goto L2
        L16:
            int r3 = r3 + 1
            int r0 = r2.size
        L1a:
            if (r3 >= r0) goto L30
            java.lang.Object[] r1 = r2.keys
            r1 = r1[r3]
            if (r1 != r4) goto L23
            return r3
        L23:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r5) goto L2d
        L29:
            int r3 = r3 + 1
            int r3 = -r3
            return r3
        L2d:
            int r3 = r3 + 1
            goto L1a
        L30:
            int r3 = r2.size
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityArrayIntMap.findExactIndex(int, java.lang.Object, int):int");
    }

    public final void add(@NotNull Object key, int i10) {
        int iFind;
        t.i(key, "key");
        if (this.size > 0) {
            iFind = find(key);
            if (iFind >= 0) {
                this.values[iFind] = i10;
                return;
            }
        } else {
            iFind = -1;
        }
        int i11 = -(iFind + 1);
        int i12 = this.size;
        Object[] objArr = this.keys;
        if (i12 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            int[] iArr = new int[objArr.length * 2];
            int i13 = i11 + 1;
            o.i(objArr, objArr2, i13, i11, i12);
            o.g(this.values, iArr, i13, i11, this.size);
            o.m(this.keys, objArr2, 0, 0, i11, 6, null);
            o.l(this.values, iArr, 0, 0, i11, 6, null);
            this.keys = objArr2;
            this.values = iArr;
        } else {
            int i14 = i11 + 1;
            o.i(objArr, objArr, i14, i11, i12);
            int[] iArr2 = this.values;
            o.g(iArr2, iArr2, i14, i11, this.size);
        }
        this.keys[i11] = key;
        this.values[i11] = i10;
        this.size++;
    }

    public final boolean any(@NotNull p<Object, ? super Integer, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = getKeys()[i10];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            if (predicate.mo4invoke(obj, Integer.valueOf(getValues()[i10])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(@NotNull p<Object, ? super Integer, k0> block) {
        t.i(block, "block");
        int size = getSize();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = getKeys()[i10];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            block.mo4invoke(obj, Integer.valueOf(getValues()[i10]));
        }
    }

    public final int get(@NotNull Object key) {
        t.i(key, "key");
        int iFind = find(key);
        if (iFind >= 0) {
            return this.values[iFind];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    @NotNull
    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(@NotNull Object key) {
        t.i(key, "key");
        int iFind = find(key);
        if (iFind < 0) {
            return false;
        }
        int i10 = this.size;
        if (iFind < i10 - 1) {
            Object[] objArr = this.keys;
            int i11 = iFind + 1;
            o.i(objArr, objArr, iFind, i11, i10);
            int[] iArr = this.values;
            o.g(iArr, iArr, iFind, i11, this.size);
        }
        int i12 = this.size - 1;
        this.size = i12;
        this.keys[i12] = null;
        return true;
    }

    public final void removeValueIf(@NotNull p<Object, ? super Integer, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = getKeys()[i11];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            int i12 = getValues()[i11];
            if (!predicate.mo4invoke(obj, Integer.valueOf(i12)).booleanValue()) {
                if (i10 != i11) {
                    getKeys()[i10] = obj;
                    getValues()[i10] = i12;
                }
                i10++;
            }
        }
        int size2 = getSize();
        for (int i13 = i10; i13 < size2; i13++) {
            getKeys()[i13] = null;
        }
        setSize(i10);
    }

    public final void setKeys(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize(int i10) {
        this.size = i10;
    }

    public final void setValues(@NotNull int[] iArr) {
        t.i(iArr, "<set-?>");
        this.values = iArr;
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
