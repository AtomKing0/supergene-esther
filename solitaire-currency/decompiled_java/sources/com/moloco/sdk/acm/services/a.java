package com.moloco.sdk.acm.services;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.eventprocessing.b f17462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f17463b;

    /* JADX INFO: renamed from: com.moloco.sdk.acm.services.a$a, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.services.ApplicationLifecycleObserver$onStop$1", f = "ApplicationLifecycleTracker.kt", l = {}, m = "invokeSuspend")
    public static final class C0293a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17464j;

        public C0293a(z8.d<? super C0293a> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C0293a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return a.this.new C0293a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17464j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            a.this.f17462a.a();
            return k0.f35197a;
        }
    }

    public a(@NotNull com.moloco.sdk.acm.eventprocessing.b dbWorkRequest, @NotNull o0 scope) {
        t.i(dbWorkRequest, "dbWorkRequest");
        t.i(scope, "scope");
        this.f17462a = dbWorkRequest;
        this.f17463b = scope;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        t.i(owner, "owner");
        androidx.lifecycle.c.f(this, owner);
        e.f(e.f17473a, "ApplicationLifecycleObserver", "Application onStop", false, 4, null);
        k.d(this.f17463b, null, null, new C0293a(null), 3, null);
    }
}
