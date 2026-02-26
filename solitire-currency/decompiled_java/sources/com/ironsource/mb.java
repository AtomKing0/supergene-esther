package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class mb extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Handler f13240a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb(@NotNull String name) {
        super(name);
        kotlin.jvm.internal.t.i(name, "name");
    }

    public final void a() {
        this.f13240a = new Handler(getLooper());
    }

    public final void a(@NotNull Runnable task) {
        kotlin.jvm.internal.t.i(task, "task");
        Handler handler = this.f13240a;
        if (handler != null) {
            handler.post(task);
        }
    }
}
