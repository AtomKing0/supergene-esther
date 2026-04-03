package t9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class x<T> implements z8.d<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z8.d<T> f34184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final z8.g f34185b;

    /* JADX WARN: Multi-variable type inference failed */
    public x(@NotNull z8.d<? super T> dVar, @NotNull z8.g gVar) {
        this.f34184a = dVar;
        this.f34185b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        z8.d<T> dVar = this.f34184a;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return this.f34185b;
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        this.f34184a.resumeWith(obj);
    }
}
