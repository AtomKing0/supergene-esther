package com.ironsource;

import android.os.Handler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class js implements wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Handler f12774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final b f12779f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12781b;

        public a(long j10, long j11) {
            this.f12780a = j10;
            this.f12781b = j11;
        }

        public final long a() {
            return this.f12780a;
        }

        public final long b() {
            return this.f12781b;
        }

        public final long c() {
            return this.f12780a;
        }

        public final long d() {
            return this.f12781b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12780a == aVar.f12780a && this.f12781b == aVar.f12781b;
        }

        public int hashCode() {
            return (androidx.compose.animation.a.a(this.f12780a) * 31) + androidx.compose.animation.a.a(this.f12781b);
        }

        @NotNull
        public String toString() {
            return "Status(remainingTime=" + this.f12780a + ", timePassed=" + this.f12781b + ')';
        }

        @NotNull
        public final a a(long j10, long j11) {
            return new a(j10, j11);
        }

        public static /* synthetic */ a a(a aVar, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = aVar.f12780a;
            }
            if ((i10 & 2) != 0) {
                j11 = aVar.f12781b;
            }
            return aVar.a(j10, j11);
        }
    }

    public static final class b extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f12782a;

        b(Runnable runnable) {
            this.f12782a = runnable;
        }

        @Override // com.ironsource.yp
        public void a() {
            this.f12782a.run();
        }
    }

    public js(@NotNull Handler handler, @NotNull Runnable task, long j10) {
        kotlin.jvm.internal.t.i(handler, "handler");
        kotlin.jvm.internal.t.i(task, "task");
        this.f12774a = handler;
        this.f12775b = j10;
        this.f12779f = new b(task);
        this.f12778e = c();
        a();
    }

    private final long c() {
        return System.currentTimeMillis();
    }

    private final long d() {
        return this.f12775b - this.f12776c;
    }

    @Override // com.ironsource.wn
    @NotNull
    public a a() {
        if (e()) {
            this.f12777d = c();
            this.f12778e = 0L;
            this.f12774a.postDelayed(this.f12779f, d());
        }
        return new a(d(), this.f12776c);
    }

    @Override // com.ironsource.wn
    @NotNull
    public a b() {
        if (!e()) {
            long jC = c();
            this.f12778e = jC;
            this.f12776c += jC - this.f12777d;
            this.f12774a.removeCallbacks(this.f12779f);
        }
        return new a(d(), this.f12776c);
    }

    public final boolean e() {
        return this.f12778e > 0;
    }
}
