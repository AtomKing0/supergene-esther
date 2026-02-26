package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.executor.i;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.m1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends ThreadPoolExecutor {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "VungleThreadPool";

    /* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.vungle.ads.internal.executor.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
        public static final class C0508a extends com.vungle.ads.internal.task.h {
            final /* synthetic */ Runnable $command;
            final /* synthetic */ Runnable $fail;

            C0508a(Runnable runnable, Runnable runnable2) {
                this.$command = runnable;
                this.$fail = runnable2;
            }

            @Override // com.vungle.ads.internal.task.h, java.lang.Comparable
            public int compareTo(@NotNull Object other) {
                t.i(other, "other");
                if (!(other instanceof com.vungle.ads.internal.task.h)) {
                    return 0;
                }
                return t.k(((com.vungle.ads.internal.task.h) other).getPriority(), getPriority());
            }

            @Override // com.vungle.ads.internal.task.h
            public int getPriority() {
                return ((com.vungle.ads.internal.task.h) this.$command).getPriority();
            }

            @Override // java.lang.Runnable
            public void run() {
                i.Companion.wrapRunnableWithFail(this.$command, this.$fail);
            }
        }

        /* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
        public static final class b implements b {
            final /* synthetic */ Runnable $command;
            final /* synthetic */ Runnable $fail;

            b(Runnable runnable, Runnable runnable2) {
                this.$command = runnable;
                this.$fail = runnable2;
            }

            @Override // java.lang.Comparable
            public int compareTo(@NotNull Object other) {
                t.i(other, "other");
                Runnable runnable = this.$command;
                if (runnable instanceof com.vungle.ads.internal.task.h) {
                    return ((com.vungle.ads.internal.task.h) runnable).compareTo(other);
                }
                return 0;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.Companion.wrapRunnableWithFail(this.$command, this.$fail);
            }
        }

        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Callable<T> getWrappedCallableWithFallback(final Callable<T> callable, final h9.a<k0> aVar) {
            return new Callable() { // from class: com.vungle.ads.internal.executor.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return i.a.m4041getWrappedCallableWithFallback$lambda0(callable, aVar);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: getWrappedCallableWithFallback$lambda-0, reason: not valid java name */
        public static final Object m4041getWrappedCallableWithFallback$lambda0(Callable command, h9.a failFallback) {
            t.i(command, "$command");
            t.i(failFallback, "$failFallback");
            try {
                return command.call();
            } catch (OutOfMemoryError unused) {
                failFallback.invoke();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b getWrappedRunnableWithFail(Runnable runnable, Runnable runnable2) {
            return runnable instanceof com.vungle.ads.internal.task.h ? new C0508a(runnable, runnable2) : new b(runnable, runnable2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void wrapRunnableWithFail(Runnable runnable, Runnable runnable2) {
            try {
                runnable.run();
            } catch (OutOfMemoryError unused) {
                runnable2.run();
            }
        }
    }

    /* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
    public interface b extends Comparable<Object>, Runnable {
    }

    /* JADX INFO: compiled from: VungleThreadPoolExecutor.kt */
    static final class c extends v implements h9.a<k0> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            new m1("submit callable error").logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public i(int i10, int i11, long j10, @Nullable TimeUnit timeUnit, @Nullable BlockingQueue<Runnable> blockingQueue, @Nullable ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: execute$lambda-0, reason: not valid java name */
    public static final void m4038execute$lambda0() {
        new m1("execute error").logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submit$lambda-1, reason: not valid java name */
    public static final void m4039submit$lambda1() {
        new m1("submit error").logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submit$lambda-2, reason: not valid java name */
    public static final void m4040submit$lambda2() {
        new m1("submit error with error").logErrorNoReturnValue$vungle_ads_release();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        t.i(command, "command");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(command, new Runnable() { // from class: com.vungle.ads.internal.executor.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.m4038execute$lambda0();
                }
            }));
        } catch (Exception e10) {
            p.Companion.e(TAG, "execute error: " + e10);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public Future<?> submit(@NotNull Runnable task) {
        t.i(task, "task");
        try {
            Future<?> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, new Runnable() { // from class: com.vungle.ads.internal.executor.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.m4039submit$lambda1();
                }
            }));
            t.h(futureSubmit, "{\n            super.subm…\n            })\n        }");
            return futureSubmit;
        } catch (Exception e10) {
            p.Companion.e(TAG, "submit error: " + e10);
            return new com.vungle.ads.internal.executor.b(null);
        }
    }

    public final void execute(@NotNull Runnable command, @NotNull Runnable fail) {
        t.i(command, "command");
        t.i(fail, "fail");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(command, fail));
        } catch (Exception e10) {
            p.Companion.e(TAG, "execute error with fail: " + e10);
            fail.run();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Runnable task, T t10) {
        t.i(task, "task");
        try {
            Future<T> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, new Runnable() { // from class: com.vungle.ads.internal.executor.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.m4040submit$lambda2();
                }
            }), t10);
            t.h(futureSubmit, "{\n            super.subm…     }, result)\n        }");
            return futureSubmit;
        } catch (Exception e10) {
            p.Companion.e(TAG, "submit error with result: " + e10);
            return new com.vungle.ads.internal.executor.b(null);
        }
    }

    @NotNull
    public final Future<?> submit(@NotNull Runnable task, @NotNull Runnable fail) {
        t.i(task, "task");
        t.i(fail, "fail");
        try {
            Future<?> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, fail));
            t.h(futureSubmit, "{\n            super.subm…il(task, fail))\n        }");
            return futureSubmit;
        } catch (Exception e10) {
            p.Companion.e(TAG, "submit error with fail: " + e10);
            fail.run();
            return new com.vungle.ads.internal.executor.b(null);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Callable<T> task) {
        t.i(task, "task");
        try {
            Future<T> futureSubmit = super.submit(Companion.getWrappedCallableWithFallback(task, c.INSTANCE));
            t.h(futureSubmit, "{\n            super.subm…\n            })\n        }");
            return futureSubmit;
        } catch (Exception e10) {
            p.Companion.e(TAG, "submit callable: " + e10);
            return new com.vungle.ads.internal.executor.b(null);
        }
    }
}
