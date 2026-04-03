package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.h;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrioritySet {

    @NotNull
    private final List<Integer> list;

    /* JADX WARN: Multi-variable type inference failed */
    public PrioritySet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void add(int i10) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() == i10) {
                return;
            }
            if (this.list.get(r0.size() - 1).intValue() == i10) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i10));
        while (size > 0) {
            int i11 = ((size + 1) >>> 1) - 1;
            int iIntValue = this.list.get(i11).intValue();
            if (i10 <= iIntValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(iIntValue));
            size = i11;
        }
        this.list.set(size, Integer.valueOf(i10));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) d0.i0(this.list)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int takeMax() {
        int iIntValue;
        if (!(this.list.size() > 0)) {
            ComposerKt.composeRuntimeError("Set is empty".toString());
            throw new h();
        }
        int iIntValue2 = this.list.get(0).intValue();
        while ((!this.list.isEmpty()) && this.list.get(0).intValue() == iIntValue2) {
            List<Integer> list = this.list;
            list.set(0, d0.t0(list));
            List<Integer> list2 = this.list;
            list2.remove(list2.size() - 1);
            int size = this.list.size();
            int size2 = this.list.size() >>> 1;
            int i10 = 0;
            while (i10 < size2) {
                int iIntValue3 = this.list.get(i10).intValue();
                int i11 = (i10 + 1) * 2;
                int i12 = i11 - 1;
                int iIntValue4 = this.list.get(i12).intValue();
                if (i11 >= size || (iIntValue = this.list.get(i11).intValue()) <= iIntValue4) {
                    if (iIntValue4 > iIntValue3) {
                        this.list.set(i10, Integer.valueOf(iIntValue4));
                        this.list.set(i12, Integer.valueOf(iIntValue3));
                        i10 = i12;
                    }
                } else if (iIntValue > iIntValue3) {
                    this.list.set(i10, Integer.valueOf(iIntValue));
                    this.list.set(i11, Integer.valueOf(iIntValue3));
                    i10 = i11;
                }
            }
        }
        return iIntValue2;
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i10 = size / 2;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i11 + 1;
            int i13 = i12 * 2;
            boolean z10 = true;
            if (!(this.list.get(i11).intValue() >= this.list.get(i13 + (-1)).intValue())) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (i13 < size && this.list.get(i11).intValue() < this.list.get(i13).intValue()) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalStateException("Check failed.".toString());
            }
            i11 = i12;
        }
    }

    public PrioritySet(@NotNull List<Integer> list) {
        t.i(list, "list");
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i10, k kVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }
}
