package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f19310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final s9.y<m0<v8.c0>> f19311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final m0<v8.c0> f19312c;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ResettableCountdownSecondsStateFlow$countdownSecondsStateFlow$1", f = "CountdownFlow.kt", l = {82}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<r9.r<? super v8.c0>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19313j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19314k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ResettableCountdownSecondsStateFlow$countdownSecondsStateFlow$1$1", f = "CountdownFlow.kt", l = {83}, m = "invokeSuspend")
        public static final class C0371a extends kotlin.coroutines.jvm.internal.l implements h9.p<m0<? extends v8.c0>, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19316j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f19317k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ r9.r<v8.c0> f19318l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0$a$a$a, reason: collision with other inner class name */
            public static final class C0372a implements s9.i<v8.c0> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ r9.r<v8.c0> f19319a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0372a(r9.r<? super v8.c0> rVar) {
                    this.f19319a = rVar;
                }

                @Nullable
                public final Object b(int i10, @NotNull z8.d<? super v8.k0> dVar) {
                    Object objP = this.f19319a.p(v8.c0.a(i10), dVar);
                    return objP == a9.d.e() ? objP : v8.k0.f35197a;
                }

                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(v8.c0 c0Var, z8.d dVar) {
                    return b(c0Var.g(), dVar);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0371a(r9.r<? super v8.c0> rVar, z8.d<? super C0371a> dVar) {
                super(2, dVar);
                this.f19318l = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0371a c0371a = new C0371a(this.f19318l, dVar);
                c0371a.f19317k = obj;
                return c0371a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull m0<v8.c0> m0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((C0371a) create(m0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19316j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    m0 m0Var = (m0) this.f19317k;
                    C0372a c0372a = new C0372a(this.f19318l);
                    this.f19316j = 1;
                    if (m0Var.collect(c0372a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                throw new v8.h();
            }
        }

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = j0.this.new a(dVar);
            aVar.f19314k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r9.r<? super v8.c0> rVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(rVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19313j;
            if (i10 == 0) {
                v8.u.b(obj);
                r9.r rVar = (r9.r) this.f19314k;
                s9.y yVar = j0.this.f19311b;
                C0371a c0371a = new C0371a(rVar, null);
                this.f19313j = 1;
                if (s9.j.l(yVar, c0371a, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ j0(int i10, o0 o0Var, kotlin.jvm.internal.k kVar) {
        this(i10, o0Var);
    }

    @NotNull
    public final m0<v8.c0> b() {
        return this.f19312c;
    }

    public final void c(int i10) {
        this.f19311b.setValue(n.b(i10, this.f19310a));
    }

    public j0(int i10, o0 scope) {
        kotlin.jvm.internal.t.i(scope, "scope");
        this.f19310a = scope;
        s9.y<m0<v8.c0>> yVarA = s9.o0.a(n.b(i10, scope));
        this.f19311b = yVarA;
        this.f19312c = s9.j.L(s9.j.j(new a(null)), scope, i0.a.b(s9.i0.f33702a, 0L, 0L, 3, null), yVarA.getValue().getValue());
    }
}
