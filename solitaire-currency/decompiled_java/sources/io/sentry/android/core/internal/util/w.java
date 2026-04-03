package io.sentry.android.core.internal.util;

import android.os.Handler;
import android.view.Window;
import androidx.annotation.RequiresApi;
import io.sentry.android.core.internal.util.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class w {
    @RequiresApi(api = 24)
    public static void a(v.c cVar, @NotNull Window window, @Nullable Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, @Nullable Handler handler) {
        window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
    }

    @RequiresApi(api = 24)
    public static void b(v.c cVar, @NotNull Window window, @Nullable Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
        window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
    }
}
