package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.platform.ComposeView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;
import s9.m0;
import s9.y;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u<T extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c> extends FrameLayout implements h, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f21650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f21651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public View f21652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final v8.l f21653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f21654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final v8.l f21655f;

    public static final class a extends v implements h9.a<m0<? extends Boolean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ u<T> f21656g;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.XenossBannerView$isAdDisplaying$2$1", f = "XenossBannerView.kt", l = {}, m = "invokeSuspend")
        public static final class C0480a extends kotlin.coroutines.jvm.internal.l implements h9.q<Boolean, Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21657j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f21658k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public /* synthetic */ boolean f21659l;

            public C0480a(z8.d<? super C0480a> dVar) {
                super(3, dVar);
            }

            @Nullable
            public final Object f(boolean z10, boolean z11, @Nullable z8.d<? super Boolean> dVar) {
                C0480a c0480a = new C0480a(dVar);
                c0480a.f21658k = z10;
                c0480a.f21659l = z11;
                return c0480a.invokeSuspend(k0.f35197a);
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), bool2.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21657j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f21658k && this.f21659l);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u<T> uVar) {
            super(0);
            this.f21656g = uVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0<Boolean> invoke() {
            return s9.j.L(s9.j.A(this.f21656g.isLoaded(), this.f21656g.f21654e, new C0480a(null)), this.f21656g.f21650a, i0.f33702a.c(), Boolean.FALSE);
        }
    }

    public static final class b extends v implements h9.a<m0<? extends Boolean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ u<T> f21660g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u<T> uVar) {
            super(0);
            this.f21660g = uVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0<Boolean> invoke() {
            return this.f21660g.getAdLoader().isLoaded();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.XenossBannerView$load$1", f = "XenossBannerView.kt", l = {59}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21661j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ u<T> f21662k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f21663l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b.a f21664m;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.XenossBannerView$load$1$1", f = "XenossBannerView.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21665j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f21666k;

            public a(z8.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                a aVar = new a(dVar);
                aVar.f21666k = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Nullable
            public final Object f(boolean z10, @Nullable z8.d<? super Boolean> dVar) {
                return ((a) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21665j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f21666k);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u<T> uVar, long j10, b.a aVar, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f21662k = uVar;
            this.f21663l = j10;
            this.f21664m = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new c(this.f21662k, this.f21663l, this.f21664m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21661j;
            if (i10 == 0) {
                v8.u.b(obj);
                this.f21662k.getAdLoader().g(this.f21663l, this.f21664m);
                m0<Boolean> m0VarIsLoaded = this.f21662k.isLoaded();
                a aVar = new a(null);
                this.f21661j = 1;
                if (s9.j.v(m0VarIsLoaded, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            this.f21662k.m();
            return k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull Context context, @NotNull o0 scope) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(scope, "scope");
        this.f21650a = scope;
        this.f21653d = v8.n.a(new b(this));
        this.f21654e = s9.o0.a(Boolean.FALSE);
        this.f21655f = v8.n.a(new a(this));
    }

    public void destroy() {
        p0.e(this.f21650a, null, 1, null);
        setAdView(null);
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        kotlinx.coroutines.k.d(this.f21650a, null, null, new c(this, j10, aVar, null), 3, null);
    }

    @NotNull
    public abstract com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b getAdLoader();

    @Nullable
    public T getAdShowListener() {
        return this.f21651b;
    }

    @Nullable
    public final View getAdView() {
        return this.f21652c;
    }

    @Nullable
    public abstract /* synthetic */ g getCreativeType();

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return (m0) this.f21653d.getValue();
    }

    public abstract void m();

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        kotlin.jvm.internal.t.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, i10);
        this.f21654e.setValue(Boolean.valueOf(i10 == 0));
    }

    public void setAdShowListener(@Nullable T t10) {
        this.f21651b = t10;
    }

    public final void setAdView(@Nullable View view) {
        View view2 = this.f21652c;
        this.f21652c = view;
        removeAllViews();
        ComposeView composeView = view2 instanceof ComposeView ? (ComposeView) view2 : null;
        if (composeView != null) {
            composeView.disposeComposition();
        }
        if (view != null) {
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @NotNull
    public m0<Boolean> l() {
        return (m0) this.f21655f.getValue();
    }

    @VisibleForTesting(otherwise = 4)
    public static /* synthetic */ void getAdView$annotations() {
    }
}
