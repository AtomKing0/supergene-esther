package io.sentry.android.core;

import android.app.Activity;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CurrentActivityHolder.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class f1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final f1 f27189b = new f1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private WeakReference<Activity> f27190a;

    private f1() {
    }

    @NotNull
    public static f1 c() {
        return f27189b;
    }

    public void a(@NotNull Activity activity) {
        WeakReference<Activity> weakReference = this.f27190a;
        if (weakReference == null || weakReference.get() == activity) {
            this.f27190a = null;
        }
    }

    @Nullable
    public Activity b() {
        WeakReference<Activity> weakReference = this.f27190a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void d(@NotNull Activity activity) {
        WeakReference<Activity> weakReference = this.f27190a;
        if (weakReference == null || weakReference.get() != activity) {
            this.f27190a = new WeakReference<>(activity);
        }
    }
}
