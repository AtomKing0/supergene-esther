package io.sentry.android.core.performance;

import android.view.Window;
import io.sentry.android.core.internal.gestures.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowContentChangedCallback.java */
/* JADX INFO: loaded from: classes5.dex */
public class j extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Runnable f27477b;

    public j(@NotNull Window.Callback callback, @NotNull Runnable runnable) {
        super(callback);
        this.f27477b = runnable;
    }

    @Override // io.sentry.android.core.internal.gestures.k, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.f27477b.run();
    }
}
