package com.vungle.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    @NotNull
    public static final v INSTANCE = new v();

    @NotNull
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());

    @Nullable
    private static Executor uiExecutor;

    private v() {
    }

    @Nullable
    public final Executor getUiExecutor$vungle_ads_release() {
        return uiExecutor;
    }

    public final boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        return mainLooper.isCurrentThread();
    }

    public final void runOnUiThread(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        if (isMainThread()) {
            runnable.run();
            return;
        }
        Executor executor = uiExecutor;
        if (executor == null) {
            UI_HANDLER.post(runnable);
        } else if (executor != null) {
            executor.execute(runnable);
        }
    }

    public final void setUiExecutor$vungle_ads_release(@Nullable Executor executor) {
        uiExecutor = executor;
    }

    @VisibleForTesting
    public static /* synthetic */ void getUiExecutor$vungle_ads_release$annotations() {
    }
}
