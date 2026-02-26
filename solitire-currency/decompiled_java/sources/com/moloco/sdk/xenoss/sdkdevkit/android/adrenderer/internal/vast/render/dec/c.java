package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import kotlin.collections.v;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.h;
import s9.m0;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final s f21261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final z f21262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f21263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d f21264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final d f21265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final x<b> f21266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final h<b> f21267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f21269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f21270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f21271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final n f21272l;

    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.DECControllerImpl$onEvent$1", f = "DECControllerImpl.kt", l = {53}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21273j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ b f21275l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f21275l = bVar;
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
            return c.this.new a(this.f21275l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21273j;
            if (i10 == 0) {
                u.b(obj);
                x xVar = c.this.f21266f;
                b bVar = this.f21275l;
                this.f21273j = 1;
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

    public /* synthetic */ c(s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVar, int i10, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, z zVar, k kVar) {
        this(sVar, eVar, i10, context, aVar, zVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean C() {
        return this.f21268h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    @NotNull
    public m0<j> G() {
        return this.f21272l.G();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void L(@NotNull a.AbstractC0481a.f position) {
        t.i(position, "position");
        String strG = this.f21261a.g();
        if (strG != null) {
            this.f21265e.d(position);
            this.f21262b.a(strG);
            l(b.ClickThrough);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a
    @NotNull
    public h<b> a() {
        return this.f21267g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    public void b() {
        this.f21265e.a();
        l(b.DisplayStarted);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f21263c, null, 1, null);
        this.f21272l.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    @Nullable
    public String f() {
        return this.f21270j;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f21265e.c(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void h() {
        this.f21272l.h();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f21265e.b(buttonType);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    @Nullable
    public String k() {
        return this.f21269i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f21264d.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.f21264d.reset();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a
    public void u() {
        this.f21265e.e();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void v() {
        this.f21272l.v();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    @Nullable
    public String z() {
        return this.f21271k;
    }

    public c(s dec, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVar, int i10, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, z externalLinkHandler) {
        t.i(dec, "dec");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(externalLinkHandler, "externalLinkHandler");
        this.f21261a = dec;
        this.f21262b = externalLinkHandler;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f21263c = o0VarA;
        this.f21264d = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f.a(i10, o0VarA);
        this.f21265e = new d(customUserEventBuilderService, v.o(dec.f()), v.o(dec.h()), v.o(dec.i()), null, null, 48, null);
        x<b> xVarB = e0.b(0, 0, null, 7, null);
        this.f21266f = xVarB;
        this.f21267g = xVarB;
        this.f21268h = dec.g() != null;
        this.f21269i = dec.c();
        this.f21270j = dec.d();
        this.f21271k = dec.e();
        this.f21272l = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.p.a(eVar != null ? eVar.f() : null, eVar != null ? Integer.valueOf(eVar.h()) : null, eVar != null ? Integer.valueOf(eVar.d()) : null, eVar != null ? eVar.a() : null, o0VarA, context, customUserEventBuilderService, externalLinkHandler, null, null);
    }

    public final b2 l(b bVar) {
        return kotlinx.coroutines.k.d(this.f21263c, null, null, new a(bVar, null), 3, null);
    }
}
