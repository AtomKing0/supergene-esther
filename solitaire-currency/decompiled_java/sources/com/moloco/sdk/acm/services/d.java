package com.moloco.sdk.acm.services;

import androidx.lifecycle.Lifecycle;
import h9.p;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17467d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Lifecycle f17468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.services.a f17469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public AtomicBoolean f17470c;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.services.ApplicationLifecycleTrackerImpl$startObserving$2", f = "ApplicationLifecycleTracker.kt", l = {}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17471j;

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
            return d.this.new b(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17471j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (d.this.f17470c.compareAndSet(false, true)) {
                e.f(e.f17473a, "ApplicationLifecycleTrackerServiceImpl", "Start observing application lifecycle events", false, 4, null);
                d.this.f17468a.addObserver(d.this.f17469b);
            }
            return k0.f35197a;
        }
    }

    public d(@NotNull Lifecycle lifecycle, @NotNull com.moloco.sdk.acm.services.a bgListener) {
        t.i(lifecycle, "lifecycle");
        t.i(bgListener, "bgListener");
        this.f17468a = lifecycle;
        this.f17469b = bgListener;
        this.f17470c = new AtomicBoolean(false);
    }

    @Override // com.moloco.sdk.acm.services.c
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        Object objG = i.g(e1.c().getImmediate(), new b(null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }
}
