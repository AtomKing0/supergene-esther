package com.ironsource;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ls f13064a = new ls();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final v8.l f13065b = v8.n.a(a.f13066a);

    static final class a extends kotlin.jvm.internal.v implements h9.a<zp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13066a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final zp invoke() {
            return new zp(16, null, null, 6, null);
        }
    }

    private ls() {
    }

    private final zp a() {
        return (zp) f13065b.getValue();
    }

    public static /* synthetic */ void a(ls lsVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        lsVar.a(runnable, j10);
    }

    public final void a(@NotNull Runnable action) {
        kotlin.jvm.internal.t.i(action, "action");
        a(this, action, 0L, 2, null);
    }

    public final void a(@NotNull Runnable action, long j10) {
        kotlin.jvm.internal.t.i(action, "action");
        a().schedule(action, j10, TimeUnit.MILLISECONDS);
    }
}
