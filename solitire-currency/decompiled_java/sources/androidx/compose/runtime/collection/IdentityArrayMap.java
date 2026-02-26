package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import h9.l;
import h9.p;
import kotlin.collections.o;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: IdentityArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdentityArrayMap<Key, Value> {

    @NotNull
    private Object[] keys;
    private int size;

    @NotNull
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, null);
    }

    private final int find(Object obj) {
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i10 = this.size - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            Object obj2 = this.keys[i12];
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i11 = i12 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return obj == obj2 ? i12 : findExactIndex(i12, obj, iIdentityHashCode);
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityArrayMap.findExactIndex(int, java.lang.Object, int):int");
    }

    public final boolean contains(@NotNull Key key) {
        t.i(key, "key");
        return find(key) >= 0;
    }

    public final void forEach(@NotNull p<? super Key, ? super Value, k0> block) {
        t.i(block, "block");
        int size$runtime_release = getSize$runtime_release();
        for (int i10 = 0; i10 < size$runtime_release; i10++) {
            Object obj = getKeys$runtime_release()[i10];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            }
            block.mo4invoke(obj, getValues$runtime_release()[i10]);
        }
    }

    @Nullable
    public final Value get(@NotNull Key key) {
        t.i(key, "key");
        int iFind = find(key);
        if (iFind >= 0) {
            return (Value) this.values[iFind];
        }
        return null;
    }

    @NotNull
    public final Object[] getKeys$runtime_release() {
        return this.keys;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    @NotNull
    public final Object[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean remove(@NotNull Key key) {
        t.i(key, "key");
        int iFind = find(key);
        if (iFind < 0) {
            return false;
        }
        int i10 = this.size;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i11 = iFind + 1;
        o.i(objArr, objArr, iFind, i11, i10);
        o.i(objArr2, objArr2, iFind, i11, i10);
        int i12 = i10 - 1;
        objArr[i12] = null;
        objArr2[i12] = null;
        this.size = i12;
        return true;
    }

    public final void removeValueIf(@NotNull l<? super Value, Boolean> block) {
        t.i(block, "block");
        int size$runtime_release = getSize$runtime_release();
        int i10 = 0;
        for (int i11 = 0; i11 < size$runtime_release; i11++) {
            Object obj = getValues$runtime_release()[i11];
            if (!block.invoke(obj).booleanValue()) {
                if (i10 != i11) {
                    getKeys$runtime_release()[i10] = getKeys$runtime_release()[i11];
                    getValues$runtime_release()[i10] = obj;
                }
                i10++;
            }
        }
        if (getSize$runtime_release() > i10) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int i12 = i10; i12 < size$runtime_release2; i12++) {
                getKeys$runtime_release()[i12] = null;
                getValues$runtime_release()[i12] = null;
            }
            setSize$runtime_release(i10);
        }
    }

    public final void set(@NotNull Key key, Value value) {
        t.i(key, "key");
        int iFind = find(key);
        if (iFind >= 0) {
            this.values[iFind] = value;
            return;
        }
        int i10 = -(iFind + 1);
        int i11 = this.size;
        Object[] objArr = this.keys;
        boolean z10 = i11 == objArr.length;
        Object[] objArr2 = z10 ? new Object[i11 * 2] : objArr;
        int i12 = i10 + 1;
        o.i(objArr, objArr2, i12, i10, i11);
        if (z10) {
            o.m(this.keys, objArr2, 0, 0, i10, 6, null);
        }
        objArr2[i10] = key;
        this.keys = objArr2;
        Object[] objArr3 = z10 ? new Object[this.size * 2] : this.values;
        o.i(this.values, objArr3, i12, i10, this.size);
        if (z10) {
            o.m(this.values, objArr3, 0, 0, i10, 6, null);
        }
        objArr3[i10] = value;
        this.values = objArr3;
        this.size++;
    }

    public final void setKeys$runtime_release(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize$runtime_release(int i10) {
        this.size = i10;
    }

    public final void setValues$runtime_release(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.values = objArr;
    }

    public IdentityArrayMap(int i10) {
        this.keys = new Object[i10];
        this.values = new Object[i10];
    }

    public /* synthetic */ IdentityArrayMap(int i10, int i11, k kVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }
}
