package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import s9.e0;
import s9.i0;
import s9.m0;
import s9.x;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public h9.a<k0> f19561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f19562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final WebView f19563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d f19564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final x<l> f19565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final c0<l> f19566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final m0<n.f> f19567h;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$onEvent$1", f = "MraidFullscreenContentControllerImpl.kt", l = {41}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19568j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ l f19570l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19570l = lVar;
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
            return k.this.new a(this.f19570l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19568j;
            if (i10 == 0) {
                v8.u.b(obj);
                x xVar = k.this.f19565f;
                l lVar = this.f19570l;
                this.f19568j = 1;
                if (xVar.emit(lVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public static final class b implements s9.h<n.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f19571a;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f19572a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$special$$inlined$mapNotNull$1$2", f = "MraidFullscreenContentControllerImpl.kt", l = {225}, m = "emit")
            public static final class C0386a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f19573j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f19574k;

                public C0386a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f19573j = obj;
                    this.f19574k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar) {
                this.f19572a = iVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull z8.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.C0386a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.C0386a) r0
                    int r1 = r0.f19574k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f19574k = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f19573j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f19574k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    s9.i r6 = r4.f19572a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n) r5
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n.f
                    if (r2 == 0) goto L3f
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n$f r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n.f) r5
                    goto L40
                L3f:
                    r5 = 0
                L40:
                    if (r5 == 0) goto L4b
                    r0.f19574k = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public b(s9.h hVar) {
            this.f19571a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super n.f> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f19571a.collect(new a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    public /* synthetic */ k(boolean z10, h9.a aVar, o0 o0Var, int i10, WebView webView, c0 c0Var, kotlin.jvm.internal.k kVar) {
        this(z10, aVar, o0Var, i10, webView, c0Var);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean C() {
        return this.f19560a;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void L(@NotNull a.AbstractC0481a.f position) {
        kotlin.jvm.internal.t.i(position, "position");
        q(l.ClickThrough);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public void M() {
        q(l.SkipOrClose);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    @NotNull
    public WebView c() {
        return this.f19563d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        this.f19561b.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f19564e.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    @NotNull
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public c0<l> a() {
        return this.f19566g;
    }

    public final b2 q(l lVar) {
        return kotlinx.coroutines.k.d(this.f19562c, null, null, new a(lVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    @NotNull
    public m0<n.f> s() {
        return this.f19567h;
    }

    public k(boolean z10, h9.a<k0> closeFullscreenAdRepresentation, o0 scope, int i10, WebView webView, c0<? extends n> mraidJsCommands) {
        kotlin.jvm.internal.t.i(closeFullscreenAdRepresentation, "closeFullscreenAdRepresentation");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(webView, "webView");
        kotlin.jvm.internal.t.i(mraidJsCommands, "mraidJsCommands");
        this.f19560a = z10;
        this.f19561b = closeFullscreenAdRepresentation;
        this.f19562c = scope;
        this.f19563d = webView;
        this.f19564e = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f.a(i10, scope);
        x<l> xVarB = e0.b(0, 0, null, 7, null);
        this.f19565f = xVarB;
        this.f19566g = xVarB;
        this.f19567h = s9.j.L(new b(mraidJsCommands), scope, i0.f33702a.c(), null);
    }
}
