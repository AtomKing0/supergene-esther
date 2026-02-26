package androidx.compose.runtime;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Stack.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Stack<T> {

    @NotNull
    private final ArrayList<T> backing = new ArrayList<>();

    public final void clear() {
        this.backing.clear();
    }

    public final int getSize() {
        return this.backing.size();
    }

    public final boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final T peek() {
        return this.backing.get(getSize() - 1);
    }

    public final T pop() {
        return this.backing.remove(getSize() - 1);
    }

    public final boolean push(T t10) {
        return this.backing.add(t10);
    }

    @NotNull
    public final T[] toArray() {
        int size = this.backing.size();
        T[] tArr = (T[]) new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            tArr[i10] = this.backing.get(i10);
        }
        return tArr;
    }

    public final T peek(int i10) {
        return this.backing.get(i10);
    }
}
