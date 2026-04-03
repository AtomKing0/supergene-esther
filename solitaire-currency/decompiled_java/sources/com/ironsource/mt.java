package com.ironsource;

import com.ironsource.ot;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface mt {

    public interface a {
        void a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f14038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f14039b;

        public final long a() {
            return this.f14039b;
        }

        public final long b() {
            return this.f14038a;
        }

        public final void a(long j10) {
            this.f14039b = j10;
        }

        public final void b(long j10) {
            this.f14038a = j10;
        }
    }

    public interface c {
        @NotNull
        mt a(@NotNull b bVar);
    }

    public static final class d implements c {
        @Override // com.ironsource.mt.c
        @NotNull
        public mt a(@NotNull b timerConfig) {
            kotlin.jvm.internal.t.i(timerConfig, "timerConfig");
            return new e(new ot(timerConfig.b()));
        }
    }

    private static final class e implements mt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ot f14040a;

        public static final class a implements ot.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f14041a;

            a(a aVar) {
                this.f14041a = aVar;
            }

            @Override // com.ironsource.ot.a
            public void a() {
                this.f14041a.a();
            }
        }

        public e(@NotNull ot timer) {
            kotlin.jvm.internal.t.i(timer, "timer");
            this.f14040a = timer;
        }

        @Override // com.ironsource.mt
        public void a(@NotNull a callback) {
            kotlin.jvm.internal.t.i(callback, "callback");
            this.f14040a.a((ot.a) new a(callback));
        }

        @Override // com.ironsource.mt
        public void cancel() {
            this.f14040a.e();
        }
    }

    void a(@NotNull a aVar);

    void cancel();
}
