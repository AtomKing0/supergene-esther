package androidx.compose.ui.text.caches;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.nb;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.o;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SimpleArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleArrayMap<K, V> {
    private int _size;

    @NotNull
    private int[] hashes;

    @NotNull
    private Object[] keyValues;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public final void clear() {
        if (this._size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
            this._size = 0;
        }
        if (this._size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(K k10) {
        return indexOfKey(k10) >= 0;
    }

    public final boolean containsValue(V v10) {
        return indexOfValue$ui_text_release(v10) >= 0;
    }

    public final void ensureCapacity(int i10) {
        int i11 = this._size;
        int[] iArr = this.hashes;
        if (iArr.length < i10) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.keyValues, i10 << 1);
            t.h(objArrCopyOf, "copyOf(this, newSize)");
            this.keyValues = objArrCopyOf;
        }
        if (this._size != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i10 = this._size;
                if (i10 != simpleArrayMap._size) {
                    return false;
                }
                for (int i11 = 0; i11 < i10; i11++) {
                    K kKeyAt = keyAt(i11);
                    V vValueAt = valueAt(i11);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!t.d(vValueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this._size != ((Map) obj).size()) {
                return false;
            }
            int i12 = this._size;
            for (int i13 = 0; i13 < i12; i13++) {
                K kKeyAt2 = keyAt(i13);
                V vValueAt2 = valueAt(i13);
                Object obj3 = ((Map) obj).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!t.d(vValueAt2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Nullable
    public final V get(K k10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return (V) this.keyValues[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    public final V getOrDefault(K k10, V v10) {
        int iIndexOfKey = indexOfKey(k10);
        return iIndexOfKey >= 0 ? (V) this.keyValues[(iIndexOfKey << 1) + 1] : v10;
    }

    protected final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.keyValues;
        int i10 = this._size;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    protected final int indexOf(@NotNull Object key, int i10) {
        t.i(key, "key");
        int i11 = this._size;
        if (i11 == 0) {
            return -1;
        }
        int iBinarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i11, i10);
        if (iBinarySearchInternal < 0 || t.d(key, this.keyValues[iBinarySearchInternal << 1])) {
            return iBinarySearchInternal;
        }
        int i12 = iBinarySearchInternal + 1;
        while (i12 < i11 && this.hashes[i12] == i10) {
            if (t.d(key, this.keyValues[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iBinarySearchInternal - 1; i13 >= 0 && this.hashes[i13] == i10; i13--) {
            if (t.d(key, this.keyValues[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public final int indexOfKey(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    protected final int indexOfNull() {
        int i10 = this._size;
        if (i10 == 0) {
            return -1;
        }
        int iBinarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i10, 0);
        if (iBinarySearchInternal < 0 || this.keyValues[iBinarySearchInternal << 1] == null) {
            return iBinarySearchInternal;
        }
        int i11 = iBinarySearchInternal + 1;
        while (i11 < i10 && this.hashes[i11] == 0) {
            if (this.keyValues[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iBinarySearchInternal - 1; i12 >= 0 && this.hashes[i12] == 0; i12--) {
            if (this.keyValues[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public final int indexOfValue$ui_text_release(V v10) {
        int i10 = this._size << 1;
        Object[] objArr = this.keyValues;
        if (v10 == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (t.d(v10, objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size <= 0;
    }

    public final K keyAt(int i10) {
        return (K) this.keyValues[i10 << 1];
    }

    @Nullable
    public final V put(K k10, V v10) {
        int iHashCode;
        int iIndexOf;
        int i10 = this._size;
        if (k10 == null) {
            iIndexOf = indexOfNull();
            iHashCode = 0;
        } else {
            iHashCode = k10.hashCode();
            iIndexOf = indexOf(k10, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i11 = (iIndexOf << 1) + 1;
            Object[] objArr = this.keyValues;
            V v11 = (V) objArr[i11];
            objArr[i11] = v10;
            return v11;
        }
        int i12 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.keyValues, i13 << 1);
            t.h(objArrCopyOf, "copyOf(this, newSize)");
            this.keyValues = objArrCopyOf;
            if (i10 != this._size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.hashes;
            int i14 = i12 + 1;
            o.g(iArr2, iArr2, i14, i12, i10);
            Object[] objArr2 = this.keyValues;
            o.i(objArr2, objArr2, i14 << 1, i12 << 1, this._size << 1);
        }
        int i15 = this._size;
        if (i10 == i15) {
            int[] iArr3 = this.hashes;
            if (i12 < iArr3.length) {
                iArr3[i12] = iHashCode;
                Object[] objArr3 = this.keyValues;
                int i16 = i12 << 1;
                objArr3[i16] = k10;
                objArr3[i16 + 1] = v10;
                this._size = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final void putAll(@NotNull SimpleArrayMap<? extends K, ? extends V> array) {
        t.i(array, "array");
        int i10 = array._size;
        ensureCapacity(this._size + i10);
        if (this._size != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(array.keyAt(i11), array.valueAt(i11));
            }
        } else if (i10 > 0) {
            o.g(array.hashes, this.hashes, 0, 0, i10);
            o.i(array.keyValues, this.keyValues, 0, 0, i10 << 1);
            this._size = i10;
        }
    }

    @Nullable
    public final V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? put(k10, v10) : v11;
    }

    @Nullable
    public final V remove(K k10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    @Nullable
    public final V removeAt(int i10) {
        Object[] objArr = this.keyValues;
        int i11 = i10 << 1;
        V v10 = (V) objArr[i11 + 1];
        int i12 = this._size;
        if (i12 <= 1) {
            clear();
        } else {
            int i13 = i12 - 1;
            int[] iArr = this.hashes;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i13) {
                    int i14 = i10 + 1;
                    int i15 = i13 + 1;
                    o.g(iArr, iArr, i10, i14, i15);
                    Object[] objArr2 = this.keyValues;
                    o.i(objArr2, objArr2, i11, i14 << 1, i15 << 1);
                }
                Object[] objArr3 = this.keyValues;
                int i16 = i13 << 1;
                objArr3[i16] = null;
                objArr3[i16 + 1] = null;
            } else {
                int i17 = i12 > 8 ? i12 + (i12 >> 1) : 8;
                int[] iArr2 = new int[i17];
                this.hashes = iArr2;
                this.keyValues = new Object[i17 << 1];
                if (i10 > 0) {
                    o.g(iArr, iArr2, 0, 0, i10);
                    o.i(objArr, this.keyValues, 0, 0, i11);
                }
                if (i10 < i13) {
                    int i18 = i10 + 1;
                    int i19 = i13 + 1;
                    o.g(iArr, this.hashes, i10, i18, i19);
                    o.i(objArr, this.keyValues, i11, i18 << 1, i19 << 1);
                }
            }
            if (i12 != this._size) {
                throw new ConcurrentModificationException();
            }
            this._size = i13;
        }
        return v10;
    }

    @Nullable
    public final V replace(K k10, V v10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v10);
        }
        return null;
    }

    public final V setValueAt(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.keyValues;
        V v11 = (V) objArr[i11];
        objArr[i11] = v10;
        return v11;
    }

    protected final void set_size(int i10) {
        this._size = i10;
    }

    public final int size() {
        return this._size;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this._size * 28);
        sb.append('{');
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i11);
            if (kKeyAt != this) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(nb.T);
            V vValueAt = valueAt(i11);
            if (vValueAt != this) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        t.h(string, "buffer.toString()");
        return string;
    }

    public final V valueAt(int i10) {
        return (V) this.keyValues[(i10 << 1) + 1];
    }

    public SimpleArrayMap(int i10) {
        if (i10 == 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            this.hashes = new int[i10];
            this.keyValues = new Object[i10 << 1];
        }
        this._size = 0;
    }

    public final boolean remove(K k10, V v10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey < 0 || !t.d(v10, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public final boolean replace(K k10, V v10, V v11) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey < 0 || valueAt(iIndexOfKey) != v10) {
            return false;
        }
        setValueAt(iIndexOfKey, v11);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i10, int i11, k kVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(@Nullable SimpleArrayMap<K, V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    public static /* synthetic */ void size$annotations() {
    }
}
