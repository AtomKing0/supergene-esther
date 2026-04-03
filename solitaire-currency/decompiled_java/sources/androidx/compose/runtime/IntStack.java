package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Stack.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntStack {

    @NotNull
    private int[] slots = new int[10];
    private int tos;

    public final void clear() {
        this.tos = 0;
    }

    public final int getSize() {
        return this.tos;
    }

    public final int indexOf(int i10) {
        int i11 = this.tos;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.slots[i12] == i10) {
                return i12;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.tos == 0;
    }

    public final boolean isNotEmpty() {
        return this.tos != 0;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peekOr(int i10) {
        return this.tos > 0 ? peek() : i10;
    }

    public final int pop() {
        int[] iArr = this.slots;
        int i10 = this.tos - 1;
        this.tos = i10;
        return iArr[i10];
    }

    public final void push(int i10) {
        int i11 = this.tos;
        int[] iArr = this.slots;
        if (i11 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.slots = iArrCopyOf;
        }
        int[] iArr2 = this.slots;
        int i12 = this.tos;
        this.tos = i12 + 1;
        iArr2[i12] = i10;
    }

    public final int peek(int i10) {
        return this.slots[i10];
    }
}
