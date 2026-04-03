package l8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StackWalkingFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f30961a = new l();

    private l() {
    }

    public final void a() {
        throw new IllegalStateException("Failed to capture stack frame. This is usually happens when a coroutine is running so the frame stack is changing quickly and the coroutine debug agent is unable to capture it concurrently. You may retry running your test to see this particular trace.".toString());
    }
}
