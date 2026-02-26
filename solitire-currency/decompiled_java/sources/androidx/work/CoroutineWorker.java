package androidx.work;

import a9.c;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.m;
import h9.p;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    @NotNull
    private final k0 coroutineContext;

    @NotNull
    private final SettableFuture<ListenableWorker.Result> future;

    @NotNull
    private final a0 job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @f(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super v8.k0>, Object> {
        final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$jobFuture = jobListenableFuture;
            this.this$0 = coroutineWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            JobListenableFuture jobListenableFuture;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = jobListenableFuture2;
                this.label = 1;
                Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
                if (foregroundInfo == objE) {
                    return objE;
                }
                jobListenableFuture = jobListenableFuture2;
                obj = foregroundInfo;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jobListenableFuture = (JobListenableFuture) this.L$0;
                u.b(obj);
            }
            jobListenableFuture.complete(obj);
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @f(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    static final class C10631 extends l implements p<o0, d<? super v8.k0>, Object> {
        int label;

        C10631(d<? super C10631> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return CoroutineWorker.this.new C10631(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.label = 1;
                    obj = coroutineWorker.doWork(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_release().setException(th);
            }
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((C10631) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context appContext, @NotNull WorkerParameters params) {
        super(appContext, params);
        t.i(appContext, "appContext");
        t.i(params, "params");
        this.job = h2.b(null, 1, null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        t.h(settableFutureCreate, "create()");
        this.future = settableFutureCreate;
        settableFutureCreate.addListener(new Runnable() { // from class: androidx.work.a
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineWorker._init_$lambda$0(this.f1755a);
            }
        }, getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = e1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CoroutineWorker this$0) {
        t.i(this$0, "this$0");
        if (this$0.future.isCancelled()) {
            b2.a.a(this$0.job, null, 1, null);
        }
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, d<? super ForegroundInfo> dVar) {
        throw new IllegalStateException("Not implemented");
    }

    @Nullable
    public abstract Object doWork(@NotNull d<? super ListenableWorker.Result> dVar);

    @NotNull
    public k0 getCoroutineContext() {
        return this.coroutineContext;
    }

    @Nullable
    public Object getForegroundInfo(@NotNull d<? super ForegroundInfo> dVar) {
        return getForegroundInfo$suspendImpl(this, dVar);
    }

    @Override // androidx.work.ListenableWorker
    @NotNull
    public final m<ForegroundInfo> getForegroundInfoAsync() {
        a0 a0VarB = h2.b(null, 1, null);
        o0 o0VarA = p0.a(getCoroutineContext().plus(a0VarB));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(a0VarB, null, 2, null);
        k.d(o0VarA, null, null, new AnonymousClass1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    @NotNull
    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_release() {
        return this.future;
    }

    @NotNull
    public final a0 getJob$work_runtime_release() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    @Nullable
    public final Object setForeground(@NotNull ForegroundInfo foregroundInfo, @NotNull d<? super v8.k0> dVar) throws Throwable {
        m<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        t.h(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                foregroundAsync.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        } else {
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
            pVar.C();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(pVar, foregroundAsync), DirectExecutor.INSTANCE);
            pVar.m(new ListenableFutureKt$await$2$2(foregroundAsync));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            if (objZ == a9.d.e()) {
                return objZ;
            }
        }
        return v8.k0.f35197a;
    }

    @Nullable
    public final Object setProgress(@NotNull Data data, @NotNull d<? super v8.k0> dVar) throws Throwable {
        m<Void> progressAsync = setProgressAsync(data);
        t.h(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        } else {
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
            pVar.C();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(pVar, progressAsync), DirectExecutor.INSTANCE);
            pVar.m(new ListenableFutureKt$await$2$2(progressAsync));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            if (objZ == a9.d.e()) {
                return objZ;
            }
        }
        return v8.k0.f35197a;
    }

    @Override // androidx.work.ListenableWorker
    @NotNull
    public final m<ListenableWorker.Result> startWork() {
        k.d(p0.a(getCoroutineContext().plus(this.job)), null, null, new C10631(null), 3, null);
        return this.future;
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
