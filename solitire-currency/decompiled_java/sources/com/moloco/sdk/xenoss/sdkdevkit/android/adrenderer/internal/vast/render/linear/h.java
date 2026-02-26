package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import h9.p;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import s9.y;
import v8.c0;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final t f21399a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public j0 f21402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public b2 f21403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21404f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f21400b = "LinearGoNextActionImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f21401c = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final y<d.a> f21405g = s9.o0.a(d.a.c.f21257a);

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearGoNextActionImpl$startTimer$1", f = "LinearGoNextAction.kt", l = {126}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21406j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.h$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearGoNextActionImpl$startTimer$1$1", f = "LinearGoNextAction.kt", l = {}, m = "invokeSuspend")
        public static final class C0466a extends kotlin.coroutines.jvm.internal.l implements p<c0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21408j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ int f21409k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ h f21410l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0466a(h hVar, z8.d<? super C0466a> dVar) {
                super(2, dVar);
                this.f21410l = hVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0466a c0466a = new C0466a(this.f21410l, dVar);
                c0466a.f21409k = ((c0) obj).g();
                return c0466a;
            }

            @Nullable
            public final Object f(int i10, @Nullable z8.d<? super k0> dVar) {
                return ((C0466a) create(c0.a(i10), dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(c0 c0Var, z8.d<? super k0> dVar) {
                return f(c0Var.g(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21408j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                int i10 = this.f21409k;
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, this.f21410l.f21400b, "Updating countdown to " + ((Object) c0.f(i10)), null, false, 12, null);
                this.f21410l.f21404f = i10;
                MolocoLogger.info$default(molocoLogger, this.f21410l.f21400b, "Propagating state: " + i.h(i10), null, false, 12, null);
                this.f21410l.l().setValue(i.h(i10));
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
            return h.this.new a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            m0<c0> m0VarB;
            Object objE = a9.d.e();
            int i10 = this.f21406j;
            if (i10 == 0) {
                u.b(obj);
                if (h.this.f21402d == null) {
                    h.this.f21402d = new j0(h.this.f21404f, h.this.f21401c, null);
                } else {
                    j0 j0Var = h.this.f21402d;
                    if (j0Var != null) {
                        j0Var.c(h.this.f21404f);
                    }
                }
                j0 j0Var2 = h.this.f21402d;
                if (j0Var2 != null && (m0VarB = j0Var2.b()) != null) {
                    C0466a c0466a = new C0466a(h.this, null);
                    this.f21406j = 1;
                    if (s9.j.l(m0VarB, c0466a, this) == objE) {
                        return objE;
                    }
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

    public h(@Nullable t tVar) {
        this.f21399a = tVar;
    }

    public final void b(long j10) {
        if (i.i(this.f21403e)) {
            this.f21404f = c0.c((int) j10);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21400b, "Start timer for duration: " + j10 + " seconds", null, false, 12, null);
            this.f21403e = kotlinx.coroutines.k.d(this.f21401c, null, null, new a(null), 3, null);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public y<d.a> l() {
        return this.f21405g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void m() {
        l().setValue(d.a.c.f21257a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void pause() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21400b, "Canceling timer", null, false, 12, null);
        b2 b2Var = this.f21403e;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void t() {
        if (Integer.compare(this.f21404f ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0) {
            b(((long) this.f21404f) & 4294967295L);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void a(int i10, int i11) {
        double d10 = (((double) i10) / ((double) i11)) * ((double) 100);
        if (i10 >= i11) {
            l().setValue(d.a.C0463a.f21255a);
            return;
        }
        if (this.f21399a == null) {
            l().setValue(d.a.c.f21257a);
            return;
        }
        if (this.f21403e == null) {
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, this.f21400b, "Starting timer", null, false, 12, null);
            t tVar = this.f21399a;
            if (tVar instanceof t.a) {
                MolocoLogger.info$default(molocoLogger, this.f21400b, "Offset Percents detected", null, false, 12, null);
                b(((long) i.f(new n9.i((int) d10, ((t.a) this.f21399a).a()), i11)) & 4294967295L);
            } else if (tVar instanceof t.b) {
                MolocoLogger.info$default(molocoLogger, this.f21400b, "Offset Millis detected", null, false, 12, null);
                b(i.g(((t.b) this.f21399a).a()));
            }
        }
    }
}
