package com.ironsource;

import android.os.Handler;
import com.ironsource.environment.thread.IronSourceThreadManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Handler f12480a;

    public static final class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f12481a;

        a(Runnable runnable) {
            this.f12481a = runnable;
        }

        @Override // com.ironsource.yp
        public void a() {
            this.f12481a.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public hh() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void c(Runnable runnable) {
        yp aVar = runnable instanceof yp ? (yp) runnable : new a(runnable);
        if (Thread.currentThread().getId() == this.f12480a.getLooper().getThread().getId()) {
            aVar.run();
        } else {
            a(this, aVar, 0L, 2, null);
        }
    }

    @NotNull
    public final Handler a() {
        return this.f12480a;
    }

    public final void b(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        c(runnable);
    }

    public hh(@NotNull Handler handler) {
        kotlin.jvm.internal.t.i(handler, "handler");
        this.f12480a = handler;
    }

    public static /* synthetic */ void a(hh hhVar, yp ypVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        hhVar.a(ypVar, j10);
    }

    public /* synthetic */ hh(Handler handler, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new Handler(IronSourceThreadManager.INSTANCE.getSharedManagersThread().getLooper()) : handler);
    }

    public final void a(@NotNull yp task) {
        kotlin.jvm.internal.t.i(task, "task");
        this.f12480a.removeCallbacks(task);
    }

    public final void a(@NotNull yp task, long j10) {
        kotlin.jvm.internal.t.i(task, "task");
        this.f12480a.postDelayed(task, j10);
    }

    public final void a(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        c(callback);
    }
}
