package o9;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicReference<g<T>> f32045a;

    public a(@NotNull g<? extends T> sequence) {
        t.i(sequence, "sequence");
        this.f32045a = new AtomicReference<>(sequence);
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        g<T> andSet = this.f32045a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
