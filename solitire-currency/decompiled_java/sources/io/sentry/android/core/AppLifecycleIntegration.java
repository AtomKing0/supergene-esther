package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.SentryLevel;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class AppLifecycleIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @TestOnly
    @Nullable
    volatile t1 f27043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final u1 f27045c;

    public AppLifecycleIntegration() {
        this(new u1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull io.sentry.f1 f1Var) {
        SentryAndroidOptions sentryAndroidOptions = this.f27044b;
        if (sentryAndroidOptions == null) {
            return;
        }
        this.f27043a = new t1(f1Var, sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.f27044b.isEnableAutoSessionTracking(), this.f27044b.isEnableAppLifecycleBreadcrumbs());
        try {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f27043a);
            this.f27044b.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
            io.sentry.util.p.a("AppLifecycle");
        } catch (Throwable th) {
            this.f27043a = null;
            this.f27044b.getLogger().b(SentryLevel.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void q() {
        t1 t1Var = this.f27043a;
        if (t1Var != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(t1Var);
            SentryAndroidOptions sentryAndroidOptions = this.f27044b;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.f27043a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.sentry.w0] */
    /* JADX WARN: Type inference failed for: r7v3, types: [io.sentry.w0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v1, types: [io.sentry.SentryLevel] */
    /* JADX WARN: Type inference failed for: r8v2, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v3, types: [io.sentry.w0] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v6, types: [io.sentry.SentryLevel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0078 -> B:19:0x0091). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0084
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // io.sentry.v1
    public void c(@org.jetbrains.annotations.NotNull final io.sentry.f1 r7, @org.jetbrains.annotations.NotNull io.sentry.SentryOptions r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Scopes are required"
            io.sentry.util.w.c(r7, r0)
            boolean r0 = r8 instanceof io.sentry.android.core.SentryAndroidOptions
            if (r0 == 0) goto Ld
            r0 = r8
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            java.lang.String r1 = "SentryAndroidOptions is required"
            java.lang.Object r0 = io.sentry.util.w.c(r0, r1)
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            r6.f27044b = r0
            io.sentry.w0 r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            io.sentry.android.core.SentryAndroidOptions r4 = r6.f27044b
            boolean r4 = r4.isEnableAutoSessionTracking()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "enableSessionTracking enabled: %s"
            r0.c(r1, r4, r3)
            io.sentry.android.core.SentryAndroidOptions r0 = r6.f27044b
            io.sentry.w0 r0 = r0.getLogger()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            io.sentry.android.core.SentryAndroidOptions r3 = r6.f27044b
            boolean r3 = r3.isEnableAppLifecycleBreadcrumbs()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2[r5] = r3
            java.lang.String r3 = "enableAppLifecycleBreadcrumbs enabled: %s"
            r0.c(r1, r3, r2)
            io.sentry.android.core.SentryAndroidOptions r0 = r6.f27044b
            boolean r0 = r0.isEnableAutoSessionTracking()
            if (r0 != 0) goto L5c
            io.sentry.android.core.SentryAndroidOptions r0 = r6.f27044b
            boolean r0 = r0.isEnableAppLifecycleBreadcrumbs()
            if (r0 == 0) goto L91
        L5c:
            androidx.lifecycle.ProcessLifecycleOwner$Companion r0 = androidx.lifecycle.ProcessLifecycleOwner.Companion     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            io.sentry.android.core.internal.util.d r0 = io.sentry.android.core.internal.util.d.e()     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            boolean r0 = r0.a()     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            if (r0 == 0) goto L6c
            r6.x(r7)     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            goto L91
        L6c:
            io.sentry.android.core.u1 r0 = r6.f27045c     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            io.sentry.android.core.u0 r1 = new io.sentry.android.core.u0     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            r1.<init>()     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            r0.b(r1)     // Catch: java.lang.IllegalStateException -> L77 java.lang.ClassNotFoundException -> L84
            goto L91
        L77:
            r7 = move-exception
            io.sentry.w0 r8 = r8.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR
            java.lang.String r1 = "AppLifecycleIntegration could not be installed"
            r8.b(r0, r1, r7)
            goto L91
        L84:
            io.sentry.w0 r7 = r8.getLogger()
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.WARNING
            java.lang.String r0 = "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed"
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r7.c(r8, r0, r1)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AppLifecycleIntegration.c(io.sentry.f1, io.sentry.SentryOptions):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f27043a == null) {
            return;
        }
        if (io.sentry.android.core.internal.util.d.e().a()) {
            q();
        } else {
            this.f27045c.b(new Runnable() { // from class: io.sentry.android.core.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27499a.q();
                }
            });
        }
    }

    AppLifecycleIntegration(@NotNull u1 u1Var) {
        this.f27045c = u1Var;
    }
}
