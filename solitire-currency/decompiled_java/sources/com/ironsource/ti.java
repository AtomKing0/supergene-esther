package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ti extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Handler f15399a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ti(@NotNull String name) {
        super(name);
        kotlin.jvm.internal.t.i(name, "name");
    }

    public final void a() {
        this.f15399a = new Handler(getLooper());
    }

    public final void b(@NotNull Runnable task) {
        kotlin.jvm.internal.t.i(task, "task");
        Handler handler = this.f15399a;
        if (handler != null) {
            handler.removeCallbacks(task);
        }
    }

    public static /* synthetic */ void a(ti tiVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        tiVar.a(runnable, j10);
    }

    public final void a(@NotNull Runnable task) {
        kotlin.jvm.internal.t.i(task, "task");
        a(this, task, 0L, 2, null);
    }

    public final void a(@NotNull Runnable task, long j10) {
        kotlin.jvm.internal.t.i(task, "task");
        Handler handler = this.f15399a;
        if (handler != null) {
            handler.postDelayed(task, j10);
        }
    }
}
