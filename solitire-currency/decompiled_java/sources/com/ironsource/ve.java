package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ve implements jt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f15891c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ti f15893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ti f15894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final ti f15895g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ve f15889a = new ve();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Handler f15890b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final v8.l f15892d = v8.n.a(a.f15896a);

    static final class a extends kotlin.jvm.internal.v implements h9.a<zp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15896a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final zp invoke() {
            return new zp(0, null, null, 7, null);
        }
    }

    static {
        ti tiVar = new ti("isadplayer-background");
        tiVar.start();
        tiVar.a();
        f15893e = tiVar;
        ti tiVar2 = new ti("isadplayer-publisher-callbacks");
        tiVar2.start();
        tiVar2.a();
        f15894f = tiVar2;
        ti tiVar3 = new ti("isadplayer-release");
        tiVar3.start();
        tiVar3.a();
        f15895g = tiVar3;
    }

    private ve() {
    }

    private final zp b() {
        return (zp) f15892d.getValue();
    }

    private final boolean f(Runnable runnable) {
        return f15891c && b().getQueue().contains(runnable);
    }

    @Nullable
    public final Looper a() {
        return f15893e.getLooper();
    }

    @NotNull
    public final ThreadPoolExecutor c() {
        return b();
    }

    public final void d(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final void e(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        if (f(action)) {
            b().remove(action);
        } else {
            f15895g.b(action);
        }
    }

    public static /* synthetic */ void a(ve veVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        veVar.b(runnable, j10);
    }

    public static /* synthetic */ void b(ve veVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        veVar.c(runnable, j10);
    }

    public static /* synthetic */ void c(ve veVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        veVar.d(runnable, j10);
    }

    public final void d(@NotNull Runnable action, long j10) {
        kotlin.jvm.internal.t.i(action, "action");
        f15890b.postDelayed(action, j10);
    }

    @Override // com.ironsource.jt
    public void a(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final void b(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        a(this, action, 0L, 2, null);
    }

    public final void c(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        b(this, action, 0L, 2, null);
    }

    public final boolean d() {
        return f15891c;
    }

    @Override // com.ironsource.jt
    public void a(@NotNull Runnable action, long j10) {
        kotlin.jvm.internal.t.i(action, "action");
        if (f15891c) {
            b().schedule(action, j10, TimeUnit.MILLISECONDS);
        } else {
            f15895g.a(action, j10);
        }
    }

    public final void b(@NotNull Runnable action, long j10) {
        kotlin.jvm.internal.t.i(action, "action");
        f15893e.a(action, j10);
    }

    public final void c(@NotNull Runnable action, long j10) {
        kotlin.jvm.internal.t.i(action, "action");
        f15894f.a(action, j10);
    }

    public final void a(boolean z10) {
        f15891c = z10;
    }
}
