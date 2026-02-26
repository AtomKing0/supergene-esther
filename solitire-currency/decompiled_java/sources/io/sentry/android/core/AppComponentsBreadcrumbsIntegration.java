package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.v8;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Device;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class AppComponentsBreadcrumbsIntegration implements io.sentry.v1, Closeable, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final io.sentry.l0 f27038e = new io.sentry.l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f27040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.h f27042d = new io.sentry.android.core.internal.util.h(io.sentry.android.core.internal.util.b.b(), 60000, 0);

    public AppComponentsBreadcrumbsIntegration(@NotNull Context context) {
        this.f27039a = (Context) io.sentry.util.w.c(e1.h(context), "Context is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void z(long j10, @NotNull Configuration configuration) {
        if (this.f27040b != null) {
            Device.DeviceOrientation deviceOrientationA = io.sentry.android.core.internal.util.i.a(this.f27039a.getResources().getConfiguration().orientation);
            String lowerCase = deviceOrientationA != null ? deviceOrientationA.name().toLowerCase(Locale.ROOT) : "undefined";
            Breadcrumb breadcrumb = new Breadcrumb(j10);
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setCategory("device.orientation");
            breadcrumb.setData(v8.h.L, lowerCase);
            breadcrumb.setLevel(SentryLevel.INFO);
            io.sentry.l0 l0Var = new io.sentry.l0();
            l0Var.j("android:configuration", configuration);
            this.f27040b.addBreadcrumb(breadcrumb, l0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void B(long j10, int i10) {
        if (this.f27040b != null) {
            Breadcrumb breadcrumb = new Breadcrumb(j10);
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            breadcrumb.setMessage("Low memory");
            breadcrumb.setData("action", "LOW_MEMORY");
            breadcrumb.setData(AppLovinEventTypes.USER_COMPLETED_LEVEL, Integer.valueOf(i10));
            breadcrumb.setLevel(SentryLevel.WARNING);
            this.f27040b.addBreadcrumb(breadcrumb, f27038e);
        }
    }

    private void x(@NotNull Runnable runnable) {
        SentryAndroidOptions sentryAndroidOptions = this.f27041c;
        if (sentryAndroidOptions != null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(runnable);
            } catch (Throwable th) {
                this.f27041c.getLogger().a(SentryLevel.ERROR, th, "Failed to submit app components breadcrumb task", new Object[0]);
            }
        }
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f27040b = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f27041c = sentryAndroidOptions;
        io.sentry.w0 logger = sentryAndroidOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f27041c.isEnableAppComponentBreadcrumbs()));
        if (this.f27041c.isEnableAppComponentBreadcrumbs()) {
            try {
                this.f27039a.registerComponentCallbacks(this);
                sentryOptions.getLogger().c(sentryLevel, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                io.sentry.util.p.a("AppComponentsBreadcrumbs");
            } catch (Throwable th) {
                this.f27041c.setEnableAppComponentBreadcrumbs(false);
                sentryOptions.getLogger().a(SentryLevel.INFO, th, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f27039a.unregisterComponentCallbacks(this);
        } catch (Throwable th) {
            SentryAndroidOptions sentryAndroidOptions = this.f27041c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().a(SentryLevel.DEBUG, th, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.f27041c;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().c(SentryLevel.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull final Configuration configuration) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        x(new Runnable() { // from class: io.sentry.android.core.s0
            @Override // java.lang.Runnable
            public final void run() {
                this.f27494a.z(jCurrentTimeMillis, configuration);
            }
        });
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(final int i10) {
        if (i10 >= 40 && !this.f27042d.a()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            x(new Runnable() { // from class: io.sentry.android.core.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27487a.B(jCurrentTimeMillis, i10);
                }
            });
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
