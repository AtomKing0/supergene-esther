package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import android.content.Context;
import androidx.compose.ui.geometry.Offset;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.m0;
import s9.x;
import s9.y;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c f20845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f20846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f20847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final z f20848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final o0 f20850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final d f20851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public a.AbstractC0481a.f f20852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final g f20853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> f20854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> f20855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f20856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public k f20857m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final y<j> f20858n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final m0<j> f20859o;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionControllerImpl$1", f = "CompanionControllerImpl.kt", l = {100}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20860j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20861k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c$a$a, reason: collision with other inner class name */
        public static final class C0436a extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ c f20863g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0436a(c cVar) {
                super(0);
                this.f20863g = cVar;
            }

            public final void b() {
                this.f20863g.f20853i.d(this.f20863g.f20852h);
                this.f20863g.n(b.a.f20842a);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }
        }

        public static final class b extends v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ c f20864g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(c cVar) {
                super(1);
                this.f20864g = cVar;
            }

            public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
                t.i(error, "error");
                this.f20864g.p(error);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
                a(cVar);
                return k0.f35197a;
            }
        }

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
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
            return c.this.new a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            c cVar;
            Object objE = a9.d.e();
            int i10 = this.f20861k;
            if (i10 == 0) {
                u.b(obj);
                c cVar2 = c.this;
                a0 a0VarE = cVar2.f20845a.e();
                Context context = c.this.f20846b;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = c.this.f20847c;
                z zVar = c.this.f20848d;
                int iF = c.this.f20845a.f();
                int iD = c.this.f20845a.d();
                C0436a c0436a = new C0436a(c.this);
                b bVar = new b(c.this);
                boolean z10 = c.this.f20849e;
                this.f20860j = cVar2;
                this.f20861k = 1;
                Object objB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.l.b(a0VarE, context, aVar, zVar, iF, iD, c0436a, bVar, z10, this);
                if (objB == objE) {
                    return objE;
                }
                cVar = cVar2;
                obj = objB;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cVar = (c) this.f20860j;
                u.b(obj);
            }
            cVar.r((k) obj);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionControllerImpl$onEvent$1", f = "CompanionControllerImpl.kt", l = {55}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20865j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b f20867l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f20867l = bVar;
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
            return c.this.new b(this.f20867l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20865j;
            if (i10 == 0) {
                u.b(obj);
                x xVar = c.this.f20854j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar = this.f20867l;
                this.f20865j = 1;
                if (xVar.emit(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public /* synthetic */ c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVar, int i10, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, z zVar, boolean z10, kotlin.jvm.internal.k kVar) {
        this(cVar, i10, context, aVar, zVar, z10);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean C() {
        return this.f20856l;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    @NotNull
    public m0<j> D() {
        return this.f20859o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void K(@NotNull a.AbstractC0481a.f position) {
        t.i(position, "position");
        this.f20852h = position;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void L(@NotNull a.AbstractC0481a.f position) {
        t.i(position, "position");
        String strA = this.f20845a.a();
        if (strA != null) {
            this.f20853i.d(position);
            this.f20848d.a(strA);
            n(b.a.f20842a);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a
    @NotNull
    public s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> a() {
        return this.f20855k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void b() {
        this.f20853i.a();
        n(b.C0435b.f20843a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f20850f, null, 1, null);
        k kVar = this.f20857m;
        if (kVar != null) {
            kVar.destroy();
        }
        r(null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f20853i.c(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f20853i.b(buttonType);
    }

    public final b2 n(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar) {
        return kotlinx.coroutines.k.d(this.f20850f, null, null, new b(bVar, null), 3, null);
    }

    public void p(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
        t.i(error, "error");
        n(new b.c(error));
    }

    public final void r(k kVar) {
        this.f20857m = kVar;
        this.f20858n.setValue(kVar != null ? kVar.j() : null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.f20851g.reset();
    }

    public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c companion, int i10, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, z externalLinkHandler, boolean z10) {
        t.i(companion, "companion");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(externalLinkHandler, "externalLinkHandler");
        this.f20845a = companion;
        this.f20846b = context;
        this.f20847c = customUserEventBuilderService;
        this.f20848d = externalLinkHandler;
        this.f20849e = z10;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f20850f = o0VarA;
        this.f20851g = f.a(i10, o0VarA);
        this.f20852h = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f20066a.c(Offset.Companion.m1383getZeroF1C5BW0());
        this.f20853i = new g(customUserEventBuilderService, companion.b(), companion.c(), null, null, 24, null);
        x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> xVarB = e0.b(0, 0, null, 7, null);
        this.f20854j = xVarB;
        this.f20855k = xVarB;
        this.f20856l = companion.a() != null;
        k kVar = this.f20857m;
        y<j> yVarA = s9.o0.a(kVar != null ? kVar.j() : null);
        this.f20858n = yVarA;
        this.f20859o = yVarA;
        kotlinx.coroutines.k.d(o0VarA, null, null, new a(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f20851g.l();
    }
}
