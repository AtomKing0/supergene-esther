package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.m;
import h9.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JobListenableFuture<R> implements m<R> {

    @NotNull
    private final b2 job;

    @NotNull
    private final SettableFuture<R> underlying;

    /* JADX INFO: renamed from: androidx.work.JobListenableFuture$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListenableFuture.kt */
    static final class AnonymousClass1 extends v implements l<Throwable, k0> {
        final /* synthetic */ JobListenableFuture<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JobListenableFuture<R> jobListenableFuture) {
            super(1);
            this.this$0 = jobListenableFuture;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            if (th == null) {
                if (!((JobListenableFuture) this.this$0).underlying.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                if (th instanceof CancellationException) {
                    ((JobListenableFuture) this.this$0).underlying.cancel(true);
                    return;
                }
                SettableFuture settableFuture = ((JobListenableFuture) this.this$0).underlying;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                settableFuture.setException(th);
            }
        }
    }

    public JobListenableFuture(@NotNull b2 job, @NotNull SettableFuture<R> underlying) {
        t.i(job, "job");
        t.i(underlying, "underlying");
        this.job = job;
        this.underlying = underlying;
        job.J(new AnonymousClass1(this));
    }

    @Override // com.google.common.util.concurrent.m
    public void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.underlying.cancel(z10);
    }

    public final void complete(R r10) {
        this.underlying.set(r10);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.underlying.isDone();
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, TimeUnit timeUnit) {
        return this.underlying.get(j10, timeUnit);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JobListenableFuture(b2 b2Var, SettableFuture settableFuture, int i10, k kVar) {
        if ((i10 & 2) != 0) {
            settableFuture = SettableFuture.create();
            t.h(settableFuture, "create()");
        }
        this(b2Var, settableFuture);
    }
}
