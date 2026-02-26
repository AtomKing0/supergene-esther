package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;
import v8.s;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Comparator<a0> f20258a = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i.c((a0) obj, (a0) obj2);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f20259b = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n) obj, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n) obj2);
        }
    };

    public static final class a extends v implements h9.l<a0, Boolean> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f20260g = new a();

        public a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@NotNull a0 it) {
            t.i(it, "it");
            return Boolean.valueOf(it instanceof a0.c);
        }
    }

    public static final class b extends v implements h9.l<s<? extends Boolean, ? extends Boolean>, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l0 f20261g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l0 f20262h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l0 l0Var, l0 l0Var2) {
            super(1);
            this.f20261g = l0Var;
            this.f20262h = l0Var2;
        }

        public final void a(@NotNull s<Boolean, Boolean> sVar) {
            t.i(sVar, "<name for destructuring parameter 0>");
            boolean zBooleanValue = sVar.a().booleanValue();
            boolean zBooleanValue2 = sVar.b().booleanValue();
            if (zBooleanValue) {
                this.f20261g.f29831a++;
            }
            if (zBooleanValue2) {
                this.f20262h.f29831a++;
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(s<? extends Boolean, ? extends Boolean> sVar) {
            a(sVar);
            return k0.f35197a;
        }
    }

    public static final class c extends v implements h9.l<s<? extends Boolean, ? extends Boolean>, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l0 f20263g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l0 f20264h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l0 l0Var, l0 l0Var2) {
            super(1);
            this.f20263g = l0Var;
            this.f20264h = l0Var2;
        }

        public final void a(@NotNull s<Boolean, Boolean> sVar) {
            t.i(sVar, "<name for destructuring parameter 0>");
            boolean zBooleanValue = sVar.a().booleanValue();
            boolean zBooleanValue2 = sVar.b().booleanValue();
            if (zBooleanValue) {
                this.f20263g.f29831a++;
            }
            if (zBooleanValue2) {
                this.f20264h.f29831a++;
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(s<? extends Boolean, ? extends Boolean> sVar) {
            a(sVar);
            return k0.f35197a;
        }
    }

    public static final int a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n nVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n nVar2) {
        return f20258a.compare(nVar.f(), nVar2.f());
    }

    public static final int b(a0 a0Var) {
        if (a0Var instanceof a0.a) {
            return 4;
        }
        if (a0Var instanceof a0.c) {
            return ((a0.c) a0Var).a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.JS ? 3 : 2;
        }
        if (a0Var instanceof a0.b) {
            return 1;
        }
        throw new q();
    }

    public static final int c(a0 vr1, a0 vr2) {
        t.h(vr2, "vr2");
        int iB = b(vr2);
        t.h(vr1, "vr1");
        return t.k(iB, b(vr1));
    }

    public static final Double d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, double d10, Long l10) {
        Double dE = e(sVar, l10);
        if (dE != null) {
            return Double.valueOf(dE.doubleValue() - d10);
        }
        return null;
    }

    public static final Double e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, Long l10) {
        if (l10 == null) {
            return null;
        }
        Double dValueOf = sVar.b() != null ? Double.valueOf(sVar.b().intValue()) : (sVar.d() == null || sVar.f() == null) ? null : Double.valueOf(((double) (sVar.d().intValue() - sVar.f().intValue())) / 2.0d);
        if (dValueOf != null) {
            return Double.valueOf((dValueOf.doubleValue() / ((double) 8192)) * (l10.longValue() / 1000.0d));
        }
        return null;
    }

    public static final Double f(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((((double) num.intValue()) * ((double) num2.intValue())) - (((double) num3.intValue()) * ((double) num4.intValue())));
    }

    @NotNull
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> g() {
        return f20259b;
    }

    @NotNull
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s> h(double d10, @Nullable Long l10, @Nullable Integer num, @Nullable Integer num2) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.b(d10, l10, num, num2);
    }

    @NotNull
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> i(@Nullable Integer num, @Nullable Integer num2) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.a(num, num2);
    }

    public static final s<Boolean, Boolean> j(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar2) {
        Object obj;
        Object next;
        a aVar = a.f20260g;
        Iterator<T> it = gVar.e().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (aVar.invoke(next).booleanValue()) {
                break;
            }
        }
        boolean z10 = next != null;
        Iterator<T> it2 = gVar2.e().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (aVar.invoke(next2).booleanValue()) {
                obj = next2;
                break;
            }
        }
        return y.a(Boolean.valueOf(z10), Boolean.valueOf(obj != null));
    }

    public static final s<Boolean, Boolean> l(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar2, double d10, Long l10) {
        return o(d(sVar, d10, l10), d(sVar2, d10, l10));
    }

    public static final s<Boolean, Boolean> n(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar2, Integer num, Integer num2) {
        return o(f(sVar.h(), sVar.c(), num, num2), f(sVar2.h(), sVar2.c(), num, num2));
    }

    public static final s<Boolean, Boolean> o(Double d10, Double d11) {
        if (d10 == null || d11 == null) {
            return y.a(Boolean.valueOf(d10 != null), Boolean.valueOf(d11 != null));
        }
        if (t.b(d10, d11)) {
            Boolean bool = Boolean.TRUE;
            return y.a(bool, bool);
        }
        if (Math.abs(d10.doubleValue()) == Math.abs(d11.doubleValue())) {
            return y.a(Boolean.valueOf(d10.doubleValue() < 0.0d), Boolean.valueOf(d11.doubleValue() < 0.0d));
        }
        return Double.compare(Math.abs(d10.doubleValue()), Math.abs(d11.doubleValue())) < 0 ? y.a(Boolean.TRUE, Boolean.FALSE) : y.a(Boolean.FALSE, Boolean.TRUE);
    }

    public static final Double p(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((((double) num.intValue()) / ((double) num2.intValue())) - (((double) num3.intValue()) / ((double) num4.intValue())));
    }

    @NotNull
    public static final Comparator<a0> q() {
        return f20258a;
    }

    public static final s<Boolean, Boolean> r(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar2, Integer num, Integer num2) {
        return o(f(gVar.f(), gVar.d(), num, num2), f(gVar2.f(), gVar2.d(), num, num2));
    }

    public static final s<Integer, Integer> s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar2, double d10, Long l10, Integer num, Integer num2) {
        l0 l0Var = new l0();
        l0 l0Var2 = new l0();
        c cVar = new c(l0Var, l0Var2);
        cVar.invoke(n(sVar, sVar2, num, num2));
        cVar.invoke(t(sVar, sVar2, num, num2));
        cVar.invoke(l(sVar, sVar2, d10, l10));
        return y.a(Integer.valueOf(l0Var.f29831a), Integer.valueOf(l0Var2.f29831a));
    }

    public static final s<Boolean, Boolean> t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar2, Integer num, Integer num2) {
        return o(p(sVar.h(), sVar.c(), num, num2), p(sVar2.h(), sVar2.c(), num, num2));
    }

    public static final s<Boolean, Boolean> u(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar2, Integer num, Integer num2) {
        return o(p(gVar.f(), gVar.d(), num, num2), p(gVar2.f(), gVar2.d(), num, num2));
    }

    public static final s<Integer, Integer> v(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar2, Integer num, Integer num2) {
        l0 l0Var = new l0();
        l0 l0Var2 = new l0();
        b bVar = new b(l0Var, l0Var2);
        bVar.invoke(r(gVar, gVar2, num, num2));
        bVar.invoke(u(gVar, gVar2, num, num2));
        bVar.invoke(j(gVar, gVar2));
        return y.a(Integer.valueOf(l0Var.f29831a), Integer.valueOf(l0Var2.f29831a));
    }
}
