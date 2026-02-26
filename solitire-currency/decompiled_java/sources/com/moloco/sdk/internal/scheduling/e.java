package com.moloco.sdk.internal.scheduling;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o0 f18394a = p0.a(c.a().a());

    @f(c = "com.moloco.sdk.internal.scheduling.RunOnMainDispatcherKt$runOnMainDispatcher$1", f = "RunOnMainDispatcher.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18395j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f18396k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h9.a<k0> aVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f18396k = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f18396k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18395j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.f18396k.invoke();
            return k0.f35197a;
        }
    }

    @NotNull
    public static final b2 a(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        return k.d(f18394a, null, null, new a(block, null), 3, null);
    }
}
