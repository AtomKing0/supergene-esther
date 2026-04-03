package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends l1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Thread f29902g;

    public h(@NotNull Thread thread) {
        this.f29902g = thread;
    }

    @Override // kotlinx.coroutines.m1
    @NotNull
    protected Thread U0() {
        return this.f29902g;
    }
}
