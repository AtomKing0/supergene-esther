package androidx.compose.runtime.snapshots;

import kotlin.collections.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotDoubleIndexHeap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;

    @NotNull
    private int[] handles;
    private int size;

    @NotNull
    private int[] values = new int[16];

    @NotNull
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i10 = 0;
        while (i10 < 16) {
            int i11 = i10 + 1;
            iArr[i10] = i11;
            i10 = i11;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i10 = length * 2;
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                iArr[i11] = i12;
                i11 = i12;
            }
            o.l(this.handles, iArr, 0, 0, 0, 14, null);
            this.handles = iArr;
        }
        int i13 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i13];
        return i13;
    }

    private final void ensure(int i10) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (i10 <= length) {
            return;
        }
        int i11 = length * 2;
        int[] iArr2 = new int[i11];
        int[] iArr3 = new int[i11];
        o.l(iArr, iArr2, 0, 0, 0, 14, null);
        o.l(this.index, iArr3, 0, 0, 0, 14, null);
        this.values = iArr2;
        this.index = iArr3;
    }

    private final void freeHandle(int i10) {
        this.handles[i10] = this.firstFreeHandle;
        this.firstFreeHandle = i10;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i10);
    }

    private final void shiftDown(int i10) {
        int i11;
        int[] iArr = this.values;
        int i12 = this.size >> 1;
        while (i10 < i12) {
            int i13 = (i10 + 1) << 1;
            int i14 = i13 - 1;
            if (i13 >= this.size || (i11 = iArr[i13]) >= iArr[i14]) {
                if (iArr[i14] >= iArr[i10]) {
                    return;
                }
                swap(i14, i10);
                i10 = i14;
            } else {
                if (i11 >= iArr[i10]) {
                    return;
                }
                swap(i13, i10);
                i10 = i13;
            }
        }
    }

    private final void shiftUp(int i10) {
        int[] iArr = this.values;
        int i11 = iArr[i10];
        while (i10 > 0) {
            int i12 = ((i10 + 1) >> 1) - 1;
            if (iArr[i12] <= i11) {
                return;
            }
            swap(i12, i10);
            i10 = i12;
        }
    }

    private final void swap(int i10, int i11) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i12 = iArr[i10];
        iArr[i10] = iArr[i11];
        iArr[i11] = i12;
        int i13 = iArr2[i10];
        iArr2[i10] = iArr2[i11];
        iArr2[i11] = i13;
        iArr3[iArr2[i10]] = i10;
        iArr3[iArr2[i11]] = i11;
    }

    public final int add(int i10) {
        ensure(this.size + 1);
        int i11 = this.size;
        this.size = i11 + 1;
        int iAllocateHandle = allocateHandle();
        this.values[i11] = i10;
        this.index[i11] = iAllocateHandle;
        this.handles[iAllocateHandle] = i11;
        shiftUp(i11);
        return iAllocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int i10) {
        return this.size > 0 ? this.values[0] : i10;
    }

    public final void remove(int i10) {
        int i11 = this.handles[i10];
        swap(i11, this.size - 1);
        this.size--;
        shiftUp(i11);
        shiftDown(i11);
        freeHandle(i10);
    }

    public final void validate() {
        int i10 = this.size;
        int i11 = 1;
        while (i11 < i10) {
            int i12 = i11 + 1;
            int[] iArr = this.values;
            if (iArr[(i12 >> 1) - 1] > iArr[i11]) {
                throw new IllegalStateException(("Index " + i11 + " is out of place").toString());
            }
            i11 = i12;
        }
    }

    public final void validateHandle(int i10, int i11) {
        int i12 = this.handles[i10];
        if (this.index[i12] != i10) {
            throw new IllegalStateException(("Index for handle " + i10 + " is corrupted").toString());
        }
        if (this.values[i12] == i11) {
            return;
        }
        throw new IllegalStateException(("Value for handle " + i10 + " was " + this.values[i12] + " but was supposed to be " + i11).toString());
    }
}
