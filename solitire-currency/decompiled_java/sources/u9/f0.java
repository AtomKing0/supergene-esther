package u9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f0<S extends e0<S>> {
    @NotNull
    public static final S b(Object obj) {
        if (obj == d.f34649a) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    public static final boolean c(Object obj) {
        return obj == d.f34649a;
    }

    @NotNull
    public static <S extends e0<S>> Object a(@Nullable Object obj) {
        return obj;
    }
}
