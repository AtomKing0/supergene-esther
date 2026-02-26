package com.moloco.sdk.internal.services;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import com.moloco.sdk.internal.MolocoLogger;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18797e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Lifecycle f18798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.a f18799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f18800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18801d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$startObserving$1", f = "AnalyticsApplicationLifecycleTracker.kt", l = {}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18802j;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return n.this.new b(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18802j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            n.this.d();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$trackNextBackgroundForeground$1", f = "AnalyticsApplicationLifecycleTracker.kt", l = {}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18804j;

        public c(z8.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return n.this.new c(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18804j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AnalyticsApplicationLifecycleTrackerImpl", "Tracking next bg / fg of the application", false, 4, null);
            n.this.d();
            n.this.f18799b.a();
            return k0.f35197a;
        }
    }

    public n(@NotNull Lifecycle lifecycle, @NotNull com.moloco.sdk.internal.services.a fgBgListener) {
        kotlin.jvm.internal.t.i(lifecycle, "lifecycle");
        kotlin.jvm.internal.t.i(fgBgListener, "fgBgListener");
        this.f18798a = lifecycle;
        this.f18799b = fgBgListener;
        this.f18800c = p0.a(com.moloco.sdk.internal.scheduling.c.a().a());
    }

    @Override // com.moloco.sdk.internal.services.m
    public void b() {
        kotlinx.coroutines.k.d(this.f18800c, null, null, new c(null), 3, null);
    }

    @MainThread
    public final void d() {
        if (this.f18801d) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AnalyticsApplicationLifecycleTrackerImpl", "Observing application lifecycle events", false, 4, null);
        this.f18798a.addObserver(this.f18799b);
        this.f18801d = true;
    }

    @Override // com.moloco.sdk.internal.services.m
    public void a() {
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AnalyticsApplicationLifecycleTrackerImpl", "Start observing application lifecycle events", false, 4, null);
        kotlinx.coroutines.k.d(this.f18800c, null, null, new b(null), 3, null);
    }
}
