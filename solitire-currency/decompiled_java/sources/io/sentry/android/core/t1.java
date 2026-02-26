package io.sentry.android.core;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.offline.DownloadService;
import io.sentry.Breadcrumb;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.e8;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LifecycleWatcher.java */
/* JADX INFO: loaded from: classes5.dex */
final class t1 implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f27500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private TimerTask f27502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Timer f27503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final io.sentry.f1 f27505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f27506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f27507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final io.sentry.transport.p f27508i;

    /* JADX INFO: compiled from: LifecycleWatcher.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (t1.this.f27506g) {
                t1.this.f27505f.endSession();
            }
            t1.this.f27505f.getOptions().getReplayController().stop();
            t1.this.f27505f.getOptions().getContinuousProfiler().b(false);
        }
    }

    t1(@NotNull io.sentry.f1 f1Var, long j10, boolean z10, boolean z11) {
        this(f1Var, j10, z10, z11, io.sentry.transport.n.b());
    }

    private void d(@NotNull String str) {
        if (this.f27507h) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setCategory("app.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.f27505f.c(breadcrumb);
        }
    }

    private void e() {
        io.sentry.k1 k1VarA = this.f27504e.a();
        try {
            TimerTask timerTask = this.f27502c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f27502c = null;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(io.sentry.c1 c1Var) {
        e8 session;
        if (this.f27500a.get() != 0 || (session = c1Var.getSession()) == null || session.k() == null) {
            return;
        }
        this.f27500a.set(session.k().getTime());
    }

    private void g() {
        io.sentry.k1 k1VarA = this.f27504e.a();
        try {
            e();
            if (this.f27503d != null) {
                a aVar = new a();
                this.f27502c = aVar;
                this.f27503d.schedule(aVar, this.f27501b);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void h() {
        e();
        long jA = this.f27508i.a();
        this.f27505f.n(new ScopeCallback() { // from class: io.sentry.android.core.s1
            @Override // io.sentry.ScopeCallback
            public final void run(io.sentry.c1 c1Var) {
                this.f27497a.f(c1Var);
            }
        });
        long j10 = this.f27500a.get();
        if (j10 == 0 || j10 + this.f27501b <= jA) {
            if (this.f27506g) {
                this.f27505f.startSession();
            }
            this.f27505f.getOptions().getReplayController().start();
        }
        this.f27505f.getOptions().getReplayController().resume();
        this.f27500a.set(jA);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        h();
        d(DownloadService.KEY_FOREGROUND);
        v0.a().c(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        this.f27500a.set(this.f27508i.a());
        this.f27505f.getOptions().getReplayController().pause();
        g();
        v0.a().c(true);
        d("background");
    }

    t1(@NotNull io.sentry.f1 f1Var, long j10, boolean z10, boolean z11, @NotNull io.sentry.transport.p pVar) {
        this.f27500a = new AtomicLong(0L);
        this.f27503d = new Timer(true);
        this.f27504e = new io.sentry.util.a();
        this.f27501b = j10;
        this.f27506g = z10;
        this.f27507h = z11;
        this.f27505f = f1Var;
        this.f27508i = pVar;
    }
}
