package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f19320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f19321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f19322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f19323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19325f;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticAdLoad$load$1", f = "StaticAdLoad.kt", l = {23}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19326j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f19328l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b.a f19329m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, b.a aVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19328l = j10;
            this.f19329m = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return k0.this.new a(this.f19328l, this.f19329m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            b.a aVar;
            Object objE = a9.d.e();
            int i10 = this.f19326j;
            if (i10 == 0) {
                v8.u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar2 = k0.this.f19322c;
                String str = k0.this.f19320a;
                long j10 = this.f19328l;
                this.f19326j = 1;
                obj = aVar2.b(str, j10, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            com.moloco.sdk.internal.t tVar = (com.moloco.sdk.internal.t) obj;
            if (tVar instanceof t.b) {
                k0.this.f19324e.setValue(kotlin.coroutines.jvm.internal.b.a(true));
                b.a aVar3 = this.f19329m;
                if (aVar3 != null) {
                    aVar3.a();
                }
            } else if ((tVar instanceof t.a) && (aVar = this.f19329m) != null) {
                aVar.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((t.a) tVar).a());
            }
            return v8.k0.f35197a;
        }
    }

    public k0(@NotNull String adm, @NotNull o0 scope, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a staticWebView) {
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(staticWebView, "staticWebView");
        this.f19320a = adm;
        this.f19321b = scope;
        this.f19322c = staticWebView;
        this.f19323d = "StaticAdLoad";
        s9.y<Boolean> yVarA = s9.o0.a(Boolean.FALSE);
        this.f19324e = yVarA;
        this.f19325f = yVarA;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        kotlinx.coroutines.k.d(this.f19321b, null, null, new a(j10, aVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19325f;
    }
}
