package androidx.work.impl.background.greedy;

import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TimeLimiter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeLimiter {

    @NotNull
    private final WorkLauncher launcher;

    @NotNull
    private final Object lock;

    @NotNull
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;

    @NotNull
    private final Map<StartStopToken, Runnable> tracked;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeLimiter(@NotNull RunnableScheduler runnableScheduler, @NotNull WorkLauncher launcher) {
        this(runnableScheduler, launcher, 0L, 4, null);
        t.i(runnableScheduler, "runnableScheduler");
        t.i(launcher, "launcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter this$0, StartStopToken token) {
        t.i(this$0, "this$0");
        t.i(token, "$token");
        this$0.launcher.stopWork(token, 3);
    }

    public final void cancel(@NotNull StartStopToken token) {
        Runnable runnableRemove;
        t.i(token, "token");
        synchronized (this.lock) {
            runnableRemove = this.tracked.remove(token);
        }
        if (runnableRemove != null) {
            this.runnableScheduler.cancel(runnableRemove);
        }
    }

    public final void track(@NotNull final StartStopToken token) {
        t.i(token, "token");
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.a
            @Override // java.lang.Runnable
            public final void run() {
                TimeLimiter.track$lambda$0(this.f1762a, token);
            }
        };
        synchronized (this.lock) {
            this.tracked.put(token, runnable);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, runnable);
    }

    public TimeLimiter(@NotNull RunnableScheduler runnableScheduler, @NotNull WorkLauncher launcher, long j10) {
        t.i(runnableScheduler, "runnableScheduler");
        t.i(launcher, "launcher");
        this.runnableScheduler = runnableScheduler;
        this.launcher = launcher;
        this.timeoutMs = j10;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j10, int i10, k kVar) {
        this(runnableScheduler, workLauncher, (i10 & 4) != 0 ? TimeUnit.MINUTES.toMillis(90L) : j10);
    }
}
