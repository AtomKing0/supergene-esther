package com.ironsource.environment.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ironsource.i9;
import com.ironsource.ti;
import com.ironsource.zp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class IronSourceThreadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11969a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Handler f11971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ti f11972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ti f11973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ti f11974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final l f11975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final l f11976h;

    @NotNull
    public static final IronSourceThreadManager INSTANCE = new IronSourceThreadManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Handler f11970b = new Handler(Looper.getMainLooper());

    static final class a extends v implements h9.a<zp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11977a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final zp invoke() {
            return new zp(0, null, null, 7, null);
        }
    }

    static final class b extends v implements h9.a<ti> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11978a = new b();

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ti invoke() {
            ti tiVar = new ti("managersThread");
            tiVar.start();
            tiVar.a();
            return tiVar;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        handlerThread.start();
        f11971c = new Handler(handlerThread.getLooper());
        ti tiVar = new ti("mediationBackground");
        tiVar.start();
        tiVar.a();
        f11972d = tiVar;
        ti tiVar2 = new ti("adapterBackground");
        tiVar2.start();
        tiVar2.a();
        f11973e = tiVar2;
        ti tiVar3 = new ti("publisher-callbacks");
        tiVar3.start();
        tiVar3.a();
        f11974f = tiVar3;
        f11975g = n.a(a.f11977a);
        f11976h = n.a(b.f11978a);
    }

    private IronSourceThreadManager() {
    }

    private final zp a() {
        return (zp) f11975g.getValue();
    }

    public static /* synthetic */ void postAdapterBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        ironSourceThreadManager.postAdapterBackgroundTask(runnable, j10);
    }

    public static /* synthetic */ void postMediationBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        ironSourceThreadManager.postMediationBackgroundTask(runnable, j10);
    }

    public static /* synthetic */ void postOnUiThreadTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        ironSourceThreadManager.postOnUiThreadTask(runnable, j10);
    }

    public static /* synthetic */ void postPublisherCallback$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        ironSourceThreadManager.postPublisherCallback(runnable, j10);
    }

    public final void executeTasks(boolean z10, boolean z11, @NotNull List<? extends Runnable> tasks) {
        t.i(tasks, "tasks");
        if (!z10) {
            Iterator<T> it = tasks.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            return;
        }
        if (!z11) {
            Iterator<T> it2 = tasks.iterator();
            while (it2.hasNext()) {
                postMediationBackgroundTask$default(INSTANCE, (Runnable) it2.next(), 0L, 2, null);
            }
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
        for (final Runnable runnable : tasks) {
            postMediationBackgroundTask$default(INSTANCE, new Runnable() { // from class: com.ironsource.environment.thread.b
                @Override // java.lang.Runnable
                public final void run() {
                    IronSourceThreadManager.a(runnable, countDownLatch);
                }
            }, 0L, 2, null);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e10) {
            i9.d().a(e10);
        }
    }

    @NotNull
    public final Handler getInitHandler() {
        return f11971c;
    }

    @NotNull
    public final ti getSharedManagersThread() {
        return (ti) f11976h.getValue();
    }

    @NotNull
    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
    }

    public final boolean getUseSharedExecutorService() {
        return f11969a;
    }

    public final void postAdapterBackgroundTask(@NotNull Runnable action) {
        t.i(action, "action");
        postAdapterBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postMediationBackgroundTask(@NotNull Runnable action) {
        t.i(action, "action");
        postMediationBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postOnUiThreadTask(@NotNull Runnable action) {
        t.i(action, "action");
        postOnUiThreadTask$default(this, action, 0L, 2, null);
    }

    public final void postPublisherCallback(@NotNull Runnable action) {
        t.i(action, "action");
        postPublisherCallback$default(this, action, 0L, 2, null);
    }

    public final void removeAdapterBackgroundTask(@NotNull Runnable action) {
        t.i(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            f11973e.b(action);
        }
    }

    public final void removeMediationBackgroundTask(@NotNull Runnable action) {
        t.i(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            f11972d.b(action);
        }
    }

    public final void removeUiThreadTask(@NotNull Runnable action) {
        t.i(action, "action");
        f11970b.removeCallbacks(action);
    }

    public final void setUseSharedExecutorService(boolean z10) {
        f11969a = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Runnable it, final CountDownLatch latch) {
        t.i(it, "$it");
        t.i(latch, "$latch");
        it.run();
        new Runnable() { // from class: com.ironsource.environment.thread.a
            @Override // java.lang.Runnable
            public final void run() {
                IronSourceThreadManager.a(latch);
            }
        }.run();
    }

    public final void postAdapterBackgroundTask(@NotNull Runnable action, long j10) {
        t.i(action, "action");
        if (f11969a) {
            a().schedule(action, j10, TimeUnit.MILLISECONDS);
        } else {
            f11973e.a(action, j10);
        }
    }

    public final void postMediationBackgroundTask(@NotNull Runnable action, long j10) {
        t.i(action, "action");
        if (f11969a) {
            a().schedule(action, j10, TimeUnit.MILLISECONDS);
        } else {
            f11972d.a(action, j10);
        }
    }

    public final void postOnUiThreadTask(@NotNull Runnable action, long j10) {
        t.i(action, "action");
        f11970b.postDelayed(action, j10);
    }

    public final void postPublisherCallback(@NotNull Runnable action, long j10) {
        t.i(action, "action");
        f11974f.a(action, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CountDownLatch latch) {
        t.i(latch, "$latch");
        latch.countDown();
    }

    private final boolean a(Runnable runnable) {
        return f11969a && a().getQueue().contains(runnable);
    }
}
