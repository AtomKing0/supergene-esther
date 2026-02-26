package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class UserInteractionIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Application f27109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f27110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f27113e;

    public UserInteractionIntegration(@NotNull Application application, @NotNull io.sentry.util.s sVar) {
        this.f27109a = (Application) io.sentry.util.w.c(application, "Application is required");
        this.f27112d = sVar.b("androidx.core.view.GestureDetectorCompat", this.f27111c);
        this.f27113e = sVar.b("androidx.lifecycle.Lifecycle", this.f27111c);
    }

    private void a(@NotNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f27111c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Window was null in startTracking", new Object[0]);
                return;
            }
            return;
        }
        if (this.f27110b == null || this.f27111c == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback == null) {
            callback = new io.sentry.android.core.internal.gestures.b();
        }
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            return;
        }
        window.setCallback(new io.sentry.android.core.internal.gestures.h(callback, activity, new io.sentry.android.core.internal.gestures.g(activity, this.f27110b, this.f27111c), this.f27111c));
    }

    private void i(@NotNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f27111c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Window was null in stopTracking", new Object[0]);
                return;
            }
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            io.sentry.android.core.internal.gestures.h hVar = (io.sentry.android.core.internal.gestures.h) callback;
            hVar.c();
            if (hVar.a() instanceof io.sentry.android.core.internal.gestures.b) {
                window.setCallback(null);
            } else {
                window.setCallback(hVar.a());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f27111c = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f27110b = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        boolean z10 = this.f27111c.isEnableUserInteractionBreadcrumbs() || this.f27111c.isEnableUserInteractionTracing();
        io.sentry.w0 logger = this.f27111c.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "UserInteractionIntegration enabled: %s", Boolean.valueOf(z10));
        if (z10) {
            if (!this.f27112d) {
                sentryOptions.getLogger().c(SentryLevel.INFO, "androidx.core is not available, UserInteractionIntegration won't be installed", new Object[0]);
                return;
            }
            this.f27109a.registerActivityLifecycleCallbacks(this);
            this.f27111c.getLogger().c(sentryLevel, "UserInteractionIntegration installed.", new Object[0]);
            io.sentry.util.p.a("UserInteraction");
            if (this.f27113e) {
                Activity activityB = f1.c().b();
                if ((activityB instanceof LifecycleOwner) && ((LifecycleOwner) activityB).getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                    a(activityB);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27109a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f27111c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        i(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
    }
}
