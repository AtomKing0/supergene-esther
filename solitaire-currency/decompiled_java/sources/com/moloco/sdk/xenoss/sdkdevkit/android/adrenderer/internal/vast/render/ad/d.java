package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;
import s9.m0;
import s9.y;
import v8.k0;
import v8.q;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final m0<k> f20764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final y<d.a> f20765b;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdGoNextActionImpl$1", f = "AdGoNextAction.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<k, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20767k;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(dVar);
            aVar.f20767k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@Nullable k kVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(kVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20766j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            k kVar = (k) this.f20767k;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d dVarA = kVar instanceof k.a ? ((k.a) kVar).a() : kVar instanceof k.b ? ((k.b) kVar).a() : null;
            if (dVarA == null) {
                return k0.f35197a;
            }
            dVarA.reset();
            return k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull m0<? extends k> currentPlaylistItem, @NotNull o0 scope) {
        t.i(currentPlaylistItem, "currentPlaylistItem");
        t.i(scope, "scope");
        this.f20764a = currentPlaylistItem;
        s9.j.L(s9.j.G(currentPlaylistItem, new a(null)), scope, i0.f33702a.c(), null);
        this.f20765b = s9.o0.a(d.a.c.f21257a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        k value = this.f20764a.getValue();
        if (value instanceof k.a) {
            return ((k.a) value).a().l();
        }
        if (value instanceof k.b) {
            return ((k.b) value).a().l();
        }
        if (value instanceof k.c) {
            return ((k.c) value).a().l();
        }
        if (value instanceof k.d) {
            return ((k.d) value).a().l();
        }
        if (value == null) {
            return this.f20765b;
        }
        throw new q();
    }
}
