package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.SentryLevel;
import io.sentry.android.core.e1;
import io.sentry.i5;
import io.sentry.protocol.App;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.r6;
import io.sentry.s2;
import io.sentry.util.r;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: DefaultAndroidEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
final class i1 implements io.sentry.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @TestOnly
    final Context f27226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Future<j1> f27229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.r<String> f27230e = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.android.core.g1
        @Override // io.sentry.util.r.a
        public final Object a() {
            return i1.f();
        }
    });

    public i1(@NotNull Context context, @NotNull w0 w0Var, @NotNull final SentryAndroidOptions sentryAndroidOptions) {
        this.f27226a = (Context) io.sentry.util.w.c(e1.h(context), "The application context is required.");
        this.f27227b = (w0) io.sentry.util.w.c(w0Var, "The BuildInfoProvider is required.");
        this.f27228c = (SentryAndroidOptions) io.sentry.util.w.c(sentryAndroidOptions, "The options object is required.");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f27229d = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: io.sentry.android.core.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f27204a.g(sentryAndroidOptions);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(@org.jetbrains.annotations.NotNull io.sentry.r6 r4) {
        /*
            java.util.List r4 = r4.j()
            if (r4 == 0) goto L4d
            int r0 = r4.size()
            r1 = 1
            if (r0 <= r1) goto L4d
            int r0 = r4.size()
            int r0 = r0 - r1
            java.lang.Object r0 = r4.get(r0)
            io.sentry.protocol.SentryException r0 = (io.sentry.protocol.SentryException) r0
            java.lang.String r2 = r0.getModule()
            java.lang.String r3 = "java.lang"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4d
            io.sentry.protocol.SentryStackTrace r0 = r0.getStacktrace()
            if (r0 == 0) goto L4d
            java.util.List r0 = r0.getFrames()
            if (r0 == 0) goto L4d
            java.util.Iterator r0 = r0.iterator()
        L34:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r0.next()
            io.sentry.protocol.SentryStackFrame r2 = (io.sentry.protocol.SentryStackFrame) r2
            java.lang.String r3 = "com.android.internal.os.RuntimeInit$MethodAndArgsCaller"
            java.lang.String r2 = r2.getModule()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L34
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r1 == 0) goto L53
            java.util.Collections.reverse(r4)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.i1.e(io.sentry.r6):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f() {
        return e1.m(s2.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j1 g(SentryAndroidOptions sentryAndroidOptions) throws Exception {
        return j1.i(this.f27226a, sentryAndroidOptions);
    }

    private void h(@NotNull i5 i5Var) {
        String str;
        OperatingSystem operatingSystem = i5Var.getContexts().getOperatingSystem();
        try {
            i5Var.getContexts().setOperatingSystem(this.f27229d.get().j());
        } catch (Throwable th) {
            this.f27228c.getLogger().b(SentryLevel.ERROR, "Failed to retrieve os system", th);
        }
        if (operatingSystem != null) {
            String name = operatingSystem.getName();
            if (name == null || name.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + name.trim().toLowerCase(Locale.ROOT);
            }
            i5Var.getContexts().put(str, operatingSystem);
        }
    }

    private void i(@NotNull i5 i5Var) {
        User user = i5Var.getUser();
        if (user == null) {
            user = new User();
            i5Var.setUser(user);
        }
        if (user.getId() == null) {
            user.setId(o1.a(this.f27226a));
        }
        if (user.getIpAddress() == null && this.f27228c.isSendDefaultPii()) {
            user.setIpAddress("{{auto}}");
        }
    }

    private void j(@NotNull i5 i5Var, @NotNull io.sentry.l0 l0Var) {
        App app = i5Var.getContexts().getApp();
        if (app == null) {
            app = new App();
        }
        k(app, l0Var);
        o(i5Var, app);
        i5Var.getContexts().setApp(app);
    }

    private void k(@NotNull App app, @NotNull io.sentry.l0 l0Var) {
        Boolean boolB;
        app.setAppName(e1.j(this.f27226a));
        io.sentry.android.core.performance.i iVarM = io.sentry.android.core.performance.h.q().m(this.f27228c);
        if (iVarM.n()) {
            app.setAppStartTime(io.sentry.n.o(iVarM.h()));
        }
        if (io.sentry.util.m.i(l0Var) || app.getInForeground() != null || (boolB = v0.a().b()) == null) {
            return;
        }
        app.setInForeground(Boolean.valueOf(!boolB.booleanValue()));
    }

    private void l(@NotNull i5 i5Var, boolean z10, boolean z11) {
        i(i5Var);
        m(i5Var, z10, z11);
        p(i5Var);
    }

    private void m(@NotNull i5 i5Var, boolean z10, boolean z11) {
        if (i5Var.getContexts().getDevice() == null) {
            try {
                i5Var.getContexts().setDevice(this.f27229d.get().a(z10, z11));
            } catch (Throwable th) {
                this.f27228c.getLogger().b(SentryLevel.ERROR, "Failed to retrieve device info", th);
            }
            h(i5Var);
        }
    }

    private void n(@NotNull i5 i5Var, @NotNull String str) {
        if (i5Var.getDist() == null) {
            i5Var.setDist(str);
        }
    }

    private void o(@NotNull i5 i5Var, @NotNull App app) {
        j1 j1Var;
        PackageInfo packageInfoP = e1.p(this.f27226a, 4096, this.f27228c.getLogger(), this.f27227b);
        if (packageInfoP != null) {
            n(i5Var, e1.r(packageInfoP, this.f27227b));
            try {
                j1Var = this.f27229d.get();
            } catch (Throwable th) {
                this.f27228c.getLogger().b(SentryLevel.ERROR, "Failed to retrieve device info", th);
                j1Var = null;
            }
            e1.E(packageInfoP, this.f27227b, j1Var, app);
        }
    }

    private void p(@NotNull i5 i5Var) {
        try {
            e1.a aVarL = this.f27229d.get().l();
            if (aVarL != null) {
                for (Map.Entry<String, String> entry : aVarL.a().entrySet()) {
                    i5Var.setTag(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f27228c.getLogger().b(SentryLevel.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void q(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        if (r6Var.o() != null) {
            boolean zI = io.sentry.util.m.i(l0Var);
            for (SentryThread sentryThread : r6Var.o()) {
                boolean zG = io.sentry.android.core.internal.util.d.e().g(sentryThread);
                if (sentryThread.isCurrent() == null) {
                    sentryThread.setCurrent(Boolean.valueOf(zG));
                }
                if (!zI && sentryThread.isMain() == null) {
                    sentryThread.setMain(Boolean.valueOf(zG));
                }
            }
        }
    }

    private boolean r(@NotNull i5 i5Var, @NotNull io.sentry.l0 l0Var) {
        if (io.sentry.util.m.u(l0Var)) {
            return true;
        }
        this.f27228c.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", i5Var.getEventId());
        return false;
    }

    @Override // io.sentry.g0
    @NotNull
    public r6 a(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        boolean zR = r(r6Var, l0Var);
        if (zR) {
            j(r6Var, l0Var);
            q(r6Var, l0Var);
        }
        l(r6Var, true, zR);
        e(r6Var);
        return r6Var;
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull io.sentry.l0 l0Var) {
        boolean zR = r(sentryTransaction, l0Var);
        if (zR) {
            j(sentryTransaction, l0Var);
        }
        l(sentryTransaction, false, zR);
        return sentryTransaction;
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 8000L;
    }
}
