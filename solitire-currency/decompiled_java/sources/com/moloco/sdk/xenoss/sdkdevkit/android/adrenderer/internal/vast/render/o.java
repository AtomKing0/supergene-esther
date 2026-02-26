package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;
import s9.m0;
import s9.y;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a0 f21431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f21432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f21433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final z f21434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final h9.a<k0> f21435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final h9.a<k0> f21436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final y<k> f21437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final m0<j> f21438h;

    public static final class b implements s9.h<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f21446a;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f21447a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o$b$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.VastPrivacyIconImpl$special$$inlined$map$1$2", f = "VastPrivacyIcon.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
            public static final class C0468a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f21448j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f21449k;

                public C0468a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f21448j = obj;
                    this.f21449k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar) {
                this.f21447a = iVar;
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
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o.b.a.C0468a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o$b$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o.b.a.C0468a) r0
                    int r1 = r0.f21449k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f21449k = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o$b$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f21448j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f21449k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    s9.i r6 = r4.f21447a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.k r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.k) r5
                    if (r5 == 0) goto L3f
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j r5 = r5.j()
                    goto L40
                L3f:
                    r5 = 0
                L40:
                    r0.f21449k = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o.b.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public b(s9.h hVar) {
            this.f21446a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super j> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f21446a.collect(new a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    public o(@Nullable a0 a0Var, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @NotNull o0 scope, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull z externalLinkHandler, @Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2) {
        t.i(scope, "scope");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(externalLinkHandler, "externalLinkHandler");
        this.f21431a = a0Var;
        this.f21432b = str;
        this.f21433c = customUserEventBuilderService;
        this.f21434d = externalLinkHandler;
        this.f21435e = aVar;
        this.f21436f = aVar2;
        y<k> yVarA = s9.o0.a(null);
        this.f21437g = yVarA;
        kotlinx.coroutines.k.d(scope, null, null, new a(context, num, num2, null), 3, null);
        this.f21438h = s9.j.L(new b(yVarA), scope, i0.a.b(i0.f33702a, 0L, 0L, 3, null), null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    @NotNull
    public m0<j> G() {
        return this.f21438h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        y<k> yVar = this.f21437g;
        k value = yVar.getValue();
        if (value != null) {
            value.destroy();
        }
        yVar.setValue(null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void h() {
        h9.a<k0> aVar = this.f21436f;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void v() {
        String str = this.f21432b;
        if (str != null) {
            h9.a<k0> aVar = this.f21435e;
            if (aVar != null) {
                aVar.invoke();
            }
            this.f21434d.a(str);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.VastPrivacyIconImpl$1", f = "VastPrivacyIcon.kt", l = {67}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21439j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Context f21441l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Integer f21442m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Integer f21443n;

        public static final class b extends v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f21445g = new b();

            public b() {
                super(1);
            }

            public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c it) {
                t.i(it, "it");
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
                a(cVar);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Integer num, Integer num2, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f21441l = context;
            this.f21442m = num;
            this.f21443n = num2;
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
            return o.this.new a(this.f21441l, this.f21442m, this.f21443n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objB;
            Object objE = a9.d.e();
            int i10 = this.f21439j;
            k kVar = null;
            try {
            } catch (Exception unused) {
                if (kVar != null) {
                    kVar.destroy();
                }
                o.this.destroy();
            }
            if (i10 == 0) {
                u.b(obj);
                a0 a0Var = o.this.f21431a;
                if (a0Var != null) {
                    Context context = this.f21441l;
                    com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = o.this.f21433c;
                    z zVar = o.this.f21434d;
                    Integer num = this.f21442m;
                    int iIntValue = num != null ? num.intValue() : 0;
                    Integer num2 = this.f21443n;
                    int iIntValue2 = num2 != null ? num2.intValue() : 0;
                    C0467a c0467a = C0467a.f21444g;
                    b bVar = b.f21445g;
                    this.f21439j = 1;
                    objB = l.b(a0Var, context, aVar, zVar, iIntValue, iIntValue2, c0467a, bVar, (128 & 128) != 0 ? false : false, this);
                    if (objB == objE) {
                        return objE;
                    }
                }
                o.this.f21437g.setValue(kVar);
                return k0.f35197a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            objB = obj;
            kVar = (k) objB;
            o.this.f21437g.setValue(kVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.o$a$a, reason: collision with other inner class name */
        public static final class C0467a extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0467a f21444g = new C0467a();

            public C0467a() {
                super(0);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }

            public final void b() {
            }
        }
    }
}
