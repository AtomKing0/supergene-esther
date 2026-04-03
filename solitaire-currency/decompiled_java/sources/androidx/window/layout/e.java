package androidx.window.layout;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.window.layout.WindowInfoTracker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInfoTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    @NotNull
    public static WindowInfoTracker a(@NotNull Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void b(@NotNull WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void c() {
        WindowInfoTracker.Companion.reset();
    }
}
