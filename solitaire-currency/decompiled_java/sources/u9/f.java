package u9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements kotlinx.coroutines.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z8.g f34655a;

    public f(@NotNull z8.g gVar) {
        this.f34655a = gVar;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f34655a;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
