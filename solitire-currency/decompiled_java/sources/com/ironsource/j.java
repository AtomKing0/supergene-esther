package com.ironsource;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f12678a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static AtomicReference<Boolean> f12679b = new AtomicReference<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static AtomicReference<WeakReference<Activity>> f12680c = new AtomicReference<>(null);

    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            kotlin.jvm.internal.t.i(activity, "activity");
            androidx.compose.animation.core.d.a(j.f12680c, null, new WeakReference(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            kotlin.jvm.internal.t.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            kotlin.jvm.internal.t.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            kotlin.jvm.internal.t.i(activity, "activity");
            j.f12680c.set(new WeakReference(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            kotlin.jvm.internal.t.i(activity, "activity");
            kotlin.jvm.internal.t.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            kotlin.jvm.internal.t.i(activity, "activity");
            androidx.compose.animation.core.d.a(j.f12680c, null, new WeakReference(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            kotlin.jvm.internal.t.i(activity, "activity");
        }
    }

    private j() {
    }

    @Nullable
    public final Activity b() {
        WeakReference<Activity> weakReference = f12680c.get();
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    public final void a(@NotNull Context context) {
        Application application;
        kotlin.jvm.internal.t.i(context, "context");
        if (androidx.compose.animation.core.d.a(f12679b, Boolean.FALSE, Boolean.TRUE)) {
            if (context instanceof Activity) {
                Application application2 = ((Activity) context).getApplication();
                kotlin.jvm.internal.t.h(application2, "context.application");
                a(application2);
                f12680c.set(new WeakReference<>(context));
                return;
            }
            if (context instanceof Service) {
                application = ((Service) context).getApplication();
                kotlin.jvm.internal.t.h(application, "context.application");
            } else if (!(context instanceof Application)) {
                return;
            } else {
                application = (Application) context;
            }
            a(application);
        }
    }
}
