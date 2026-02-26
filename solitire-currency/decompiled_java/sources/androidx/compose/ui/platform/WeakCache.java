package androidx.compose.ui.platform;

import androidx.compose.runtime.collection.MutableVector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WeakCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WeakCache<T> {

    @NotNull
    private final MutableVector<Reference<T>> values = new MutableVector<>(new Reference[16], 0);

    @NotNull
    private final ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();

    private final void clearWeakReferences() {
        Reference<? extends T> referencePoll;
        do {
            referencePoll = this.referenceQueue.poll();
            if (referencePoll != null) {
                this.values.remove(referencePoll);
            }
        } while (referencePoll != null);
    }

    public final int getSize() {
        clearWeakReferences();
        return this.values.getSize();
    }

    @Nullable
    public final T pop() {
        clearWeakReferences();
        while (this.values.isNotEmpty()) {
            T t10 = this.values.removeAt(r0.getSize() - 1).get();
            if (t10 != null) {
                return t10;
            }
        }
        return null;
    }

    public final void push(T t10) {
        clearWeakReferences();
        this.values.add(new WeakReference(t10, this.referenceQueue));
    }
}
