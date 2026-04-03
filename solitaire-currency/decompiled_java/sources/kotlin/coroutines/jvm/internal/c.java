package kotlin.coroutines.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements z8.d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f29804a = new c();

    private c() {
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }
}
