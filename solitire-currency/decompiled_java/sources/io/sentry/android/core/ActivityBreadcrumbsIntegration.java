package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.ironsource.v8;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityBreadcrumbsIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Application f26992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f26993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f26995d = new io.sentry.util.a();

    public ActivityBreadcrumbsIntegration(@NotNull Application application) {
        this.f26992a = (Application) io.sentry.util.w.c(application, "Application is required");
    }

    private void a(@NotNull Activity activity, @NotNull String str) {
        if (this.f26993b == null) {
            return;
        }
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
        breadcrumb.setData("state", str);
        breadcrumb.setData("screen", i(activity));
        breadcrumb.setCategory("ui.lifecycle");
        breadcrumb.setLevel(SentryLevel.INFO);
        io.sentry.l0 l0Var = new io.sentry.l0();
        l0Var.j("android:activity", activity);
        this.f26993b.addBreadcrumb(breadcrumb, l0Var);
    }

    @NotNull
    private String i(@NotNull Activity activity) {
        return activity.getClass().getSimpleName();
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f26993b = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        this.f26994c = sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs();
        io.sentry.w0 logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f26994c));
        if (this.f26994c) {
            this.f26992a.registerActivityLifecycleCallbacks(this);
            sentryOptions.getLogger().c(sentryLevel, "ActivityBreadcrumbIntegration installed.", new Object[0]);
            io.sentry.util.p.a("ActivityBreadcrumbs");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26994c) {
            this.f26992a.unregisterActivityLifecycleCallbacks(this);
            io.sentry.f1 f1Var = this.f26993b;
            if (f1Var != null) {
                f1Var.getOptions().getLogger().c(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, "created");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, "destroyed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, v8.h.f15788e0);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, "resumed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, "saveInstanceState");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, v8.h.f15786d0);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f26995d.a();
        try {
            a(activity, v8.h.f15794h0);
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
}
