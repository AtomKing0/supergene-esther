package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import h9.l;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.o;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: IdentityScopeMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdentityScopeMap<T> {

    @NotNull
    private IdentityArraySet<T>[] scopeSets;
    private int size;

    @NotNull
    private int[] valueOrder;

    @NotNull
    private Object[] values;

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i10 = 0; i10 < 50; i10++) {
            iArr[i10] = i10;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int find(Object obj) {
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i10 = this.size - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            Object obj2 = this.values[this.valueOrder[i12]];
            t.f(obj2);
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r4, java.lang.Object r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = -1
            if (r1 >= r0) goto L1d
            java.lang.Object[] r1 = r3.values
            int[] r2 = r3.valueOrder
            r2 = r2[r0]
            r1 = r1[r2]
            kotlin.jvm.internal.t.f(r1)
            if (r1 != r5) goto L13
            return r0
        L13:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r6) goto L1a
            goto L1d
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.size
        L21:
            if (r4 >= r0) goto L3e
            java.lang.Object[] r1 = r3.values
            int[] r2 = r3.valueOrder
            r2 = r2[r4]
            r1 = r1[r2]
            kotlin.jvm.internal.t.f(r1)
            if (r1 != r5) goto L31
            return r4
        L31:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r6) goto L3b
        L37:
            int r4 = r4 + 1
            int r4 = -r4
            return r4
        L3b:
            int r4 = r4 + 1
            goto L21
        L3e:
            int r4 = r3.size
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.findExactIndex(int, java.lang.Object, int):int");
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object obj) {
        int iFind;
        if (this.size > 0) {
            iFind = find(obj);
            if (iFind >= 0) {
                return scopeSetAt(iFind);
            }
        } else {
            iFind = -1;
        }
        int i10 = -(iFind + 1);
        int i11 = this.size;
        int[] iArr = this.valueOrder;
        if (i11 < iArr.length) {
            int i12 = iArr[i11];
            this.values[i12] = obj;
            IdentityArraySet<T> identityArraySet = this.scopeSets[i12];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                this.scopeSets[i12] = identityArraySet;
            }
            int i13 = this.size;
            if (i10 < i13) {
                int[] iArr2 = this.valueOrder;
                o.g(iArr2, iArr2, i10 + 1, i10, i13);
            }
            this.valueOrder[i10] = i12;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.scopeSets, length);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        this.scopeSets = (IdentityArraySet[]) objArrCopyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        this.scopeSets[i11] = identityArraySet2;
        Object[] objArrCopyOf2 = Arrays.copyOf(this.values, length);
        t.h(objArrCopyOf2, "copyOf(this, newSize)");
        this.values = objArrCopyOf2;
        objArrCopyOf2[i11] = obj;
        int[] iArr3 = new int[length];
        int i14 = this.size;
        while (true) {
            i14++;
            if (i14 >= length) {
                break;
            }
            iArr3[i14] = i14;
        }
        int i15 = this.size;
        if (i10 < i15) {
            o.g(this.valueOrder, iArr3, i10 + 1, i10, i15);
        }
        iArr3[i10] = i11;
        if (i10 > 0) {
            o.l(this.valueOrder, iArr3, 0, 0, i10, 6, null);
        }
        this.valueOrder = iArr3;
        this.size++;
        return identityArraySet2;
    }

    private final void removingScopes(l<? super IdentityArraySet<T>, k0> lVar) {
        int size = getSize();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = getValueOrder()[i11];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i12];
            t.f(identityArraySet);
            lVar.invoke(identityArraySet);
            if (identityArraySet.size() > 0) {
                if (i10 != i11) {
                    int i13 = getValueOrder()[i10];
                    getValueOrder()[i10] = i12;
                    getValueOrder()[i11] = i13;
                }
                i10++;
            }
        }
        int size2 = getSize();
        for (int i14 = i10; i14 < size2; i14++) {
            getValues()[getValueOrder()[i14]] = null;
        }
        setSize(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int i10) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[i10]];
        t.f(identityArraySet);
        return identityArraySet;
    }

    private final Object valueAt(int i10) {
        Object obj = this.values[this.valueOrder[i10]];
        t.f(obj);
        return obj;
    }

    public final boolean add(@NotNull Object value, @NotNull T scope) {
        t.i(value, "value");
        t.i(scope, "scope");
        return getOrCreateIdentitySet(value).add(scope);
    }

    public final void clear() {
        int length = this.scopeSets.length;
        for (int i10 = 0; i10 < length; i10++) {
            IdentityArraySet<T> identityArraySet = this.scopeSets[i10];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            this.valueOrder[i10] = i10;
            this.values[i10] = null;
        }
        this.size = 0;
    }

    public final boolean contains(@NotNull Object element) {
        t.i(element, "element");
        return find(element) >= 0;
    }

    public final void forEachScopeOf(@NotNull Object value, @NotNull l<? super T, k0> block) {
        t.i(value, "value");
        t.i(block, "block");
        int iFind = find(value);
        if (iFind >= 0) {
            Iterator<T> it = scopeSetAt(iFind).iterator();
            while (it.hasNext()) {
                block.invoke(it.next());
            }
        }
    }

    @NotNull
    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    @NotNull
    public final Object[] getValues() {
        return this.values;
    }

    public final boolean remove(@NotNull Object value, @NotNull T scope) {
        int i10;
        IdentityArraySet<T> identityArraySet;
        t.i(value, "value");
        t.i(scope, "scope");
        int iFind = find(value);
        if (iFind < 0 || (identityArraySet = this.scopeSets[(i10 = this.valueOrder[iFind])]) == null) {
            return false;
        }
        boolean zRemove = identityArraySet.remove(scope);
        if (identityArraySet.size() == 0) {
            int i11 = iFind + 1;
            int i12 = this.size;
            if (i11 < i12) {
                int[] iArr = this.valueOrder;
                o.g(iArr, iArr, iFind, i11, i12);
            }
            int[] iArr2 = this.valueOrder;
            int i13 = this.size;
            iArr2[i13 - 1] = i10;
            this.values[i10] = null;
            this.size = i13 - 1;
        }
        return zRemove;
    }

    public final void removeScope(@NotNull T scope) {
        t.i(scope, "scope");
        int size = getSize();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = getValueOrder()[i11];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i12];
            t.f(identityArraySet);
            identityArraySet.remove(scope);
            if (identityArraySet.size() > 0) {
                if (i10 != i11) {
                    int i13 = getValueOrder()[i10];
                    getValueOrder()[i10] = i12;
                    getValueOrder()[i11] = i13;
                }
                i10++;
            }
        }
        int size2 = getSize();
        for (int i14 = i10; i14 < size2; i14++) {
            getValues()[getValueOrder()[i14]] = null;
        }
        setSize(i10);
    }

    public final void removeValueIf(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = getValueOrder()[i11];
            IdentityArraySet<T> identityArraySet = getScopeSets()[i12];
            t.f(identityArraySet);
            int size2 = identityArraySet.size();
            int i13 = 0;
            for (int i14 = 0; i14 < size2; i14++) {
                Object obj = identityArraySet.getValues()[i14];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                }
                if (!predicate.invoke(obj).booleanValue()) {
                    if (i13 != i14) {
                        identityArraySet.getValues()[i13] = obj;
                    }
                    i13++;
                }
            }
            int size3 = identityArraySet.size();
            for (int i15 = i13; i15 < size3; i15++) {
                identityArraySet.getValues()[i15] = null;
            }
            identityArraySet.setSize(i13);
            if (identityArraySet.size() > 0) {
                if (i10 != i11) {
                    int i16 = getValueOrder()[i10];
                    getValueOrder()[i10] = i12;
                    getValueOrder()[i11] = i16;
                }
                i10++;
            }
        }
        int size4 = getSize();
        for (int i17 = i10; i17 < size4; i17++) {
            getValues()[getValueOrder()[i17]] = null;
        }
        setSize(i10);
    }

    public final void setScopeSets(@NotNull IdentityArraySet<T>[] identityArraySetArr) {
        t.i(identityArraySetArr, "<set-?>");
        this.scopeSets = identityArraySetArr;
    }

    public final void setSize(int i10) {
        this.size = i10;
    }

    public final void setValueOrder(@NotNull int[] iArr) {
        t.i(iArr, "<set-?>");
        this.valueOrder = iArr;
    }

    public final void setValues(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.values = objArr;
    }

    public static /* synthetic */ void getScopeSets$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValueOrder$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
