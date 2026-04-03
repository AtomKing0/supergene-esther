package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class VastActivity extends ComponentActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20076c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> f20077d = e0.b(0, 0, null, 7, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static WeakReference<VastActivity> f20078e = new WeakReference<>(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a f20079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> f20080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public static h9.a<k0> f20081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public static b2 f20082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public static r f20083j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f20084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f20085b = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());

    public static final class a {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2", f = "VastActivity.kt", l = {166}, m = "invokeSuspend")
        public static final class C0419a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super b2>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20086j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a f20087k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ q f20088l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> f20089m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Context f20090n;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1", f = "VastActivity.kt", l = {}, m = "invokeSuspend")
            public static final class C0420a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super b2>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f20091j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f20092k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> f20093l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ Context f20094m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public final /* synthetic */ q f20095n;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1", f = "VastActivity.kt", l = {173}, m = "invokeSuspend")
                public static final class C0421a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public int f20096j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> f20097k;

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a$a, reason: collision with other inner class name */
                    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1$1", f = "VastActivity.kt", l = {}, m = "invokeSuspend")
                    public static final class C0422a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, z8.d<? super k0>, Object> {

                        /* JADX INFO: renamed from: j, reason: collision with root package name */
                        public int f20098j;

                        /* JADX INFO: renamed from: k, reason: collision with root package name */
                        public /* synthetic */ Object f20099k;

                        /* JADX INFO: renamed from: l, reason: collision with root package name */
                        public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> f20100l;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public C0422a(h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> lVar, z8.d<? super C0422a> dVar) {
                            super(2, dVar);
                            this.f20100l = lVar;
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @NotNull
                        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                            C0422a c0422a = new C0422a(this.f20100l, dVar);
                            c0422a.f20099k = obj;
                            return c0422a;
                        }

                        @Override // h9.p
                        @Nullable
                        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, @Nullable z8.d<? super k0> dVar) {
                            return ((C0422a) create(bVar, dVar)).invokeSuspend(k0.f35197a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            a9.d.e();
                            if (this.f20098j != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                            this.f20100l.invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f20099k);
                            return k0.f35197a;
                        }
                    }

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a$b */
                    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1$2", f = "VastActivity.kt", l = {}, m = "invokeSuspend")
                    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, z8.d<? super Boolean>, Object> {

                        /* JADX INFO: renamed from: j, reason: collision with root package name */
                        public int f20101j;

                        /* JADX INFO: renamed from: k, reason: collision with root package name */
                        public /* synthetic */ Object f20102k;

                        public b(z8.d<? super b> dVar) {
                            super(2, dVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @NotNull
                        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                            b bVar = new b(dVar);
                            bVar.f20102k = obj;
                            return bVar;
                        }

                        @Override // h9.p
                        @Nullable
                        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, @Nullable z8.d<? super Boolean> dVar) {
                            return ((b) create(bVar, dVar)).invokeSuspend(k0.f35197a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            a9.d.e();
                            if (this.f20101j != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                            return kotlin.coroutines.jvm.internal.b.a(VastActivity.f20076c.g((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f20102k));
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0421a(h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> lVar, z8.d<? super C0421a> dVar) {
                        super(2, dVar);
                        this.f20097k = lVar;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                        return ((C0421a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C0421a(this.f20097k, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.f20096j;
                        if (i10 == 0) {
                            u.b(obj);
                            s9.h hVarG = s9.j.G(VastActivity.f20077d, new C0422a(this.f20097k, null));
                            b bVar = new b(null);
                            this.f20096j = 1;
                            if (s9.j.x(hVarG, bVar, this) == objE) {
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

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$b */
                @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$2", f = "VastActivity.kt", l = {}, m = "invokeSuspend")
                public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public int f20103j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ Context f20104k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    public final /* synthetic */ q f20105l;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(Context context, q qVar, z8.d<? super b> dVar) {
                        super(2, dVar);
                        this.f20104k = context;
                        this.f20105l = qVar;
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
                        return new b(this.f20104k, this.f20105l, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        a9.d.e();
                        if (this.f20103j != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                        Context context = this.f20104k;
                        Intent intent = new Intent(this.f20104k, (Class<?>) VastActivity.class);
                        q qVar = this.f20105l;
                        d0.j(intent, qVar.g());
                        d0.a(intent, qVar.c());
                        d0.e(intent, qVar.d());
                        d0.b(intent, qVar.e());
                        d0.i(intent, qVar.f());
                        d0.f(intent, qVar.b());
                        d0.c(intent, qVar.a());
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0420a(h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> lVar, Context context, q qVar, z8.d<? super C0420a> dVar) {
                    super(2, dVar);
                    this.f20093l = lVar;
                    this.f20094m = context;
                    this.f20095n = qVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b2> dVar) {
                    return ((C0420a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C0420a c0420a = new C0420a(this.f20093l, this.f20094m, this.f20095n, dVar);
                    c0420a.f20092k = obj;
                    return c0420a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f20091j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    o0 o0Var = (o0) this.f20092k;
                    a aVar = VastActivity.f20076c;
                    VastActivity.f20082i = kotlinx.coroutines.k.d(o0Var, null, null, new C0421a(this.f20093l, null), 3, null);
                    return kotlinx.coroutines.k.d(o0Var, null, null, new b(this.f20094m, this.f20095n, null), 3, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0419a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, q qVar, h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> lVar, Context context, z8.d<? super C0419a> dVar) {
                super(2, dVar);
                this.f20087k = aVar;
                this.f20088l = qVar;
                this.f20089m = lVar;
                this.f20090n = context;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b2> dVar) {
                return ((C0419a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0419a(this.f20087k, this.f20088l, this.f20089m, this.f20090n, dVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f20086j;
                try {
                    if (i10 == 0) {
                        u.b(obj);
                        a aVar = VastActivity.f20076c;
                        VastActivity.f20079f = this.f20087k;
                        VastActivity.f20080g = this.f20088l.h();
                        C0420a c0420a = new C0420a(this.f20089m, this.f20090n, this.f20088l, null);
                        this.f20086j = 1;
                        obj = p0.f(c0420a, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    return (b2) obj;
                } finally {
                    a aVar2 = VastActivity.f20076c;
                    VastActivity vastActivityH = aVar2.h();
                    if (vastActivityH != null) {
                        vastActivityH.finish();
                    }
                    VastActivity.f20081h = null;
                    VastActivity.f20079f = null;
                    VastActivity.f20080g = null;
                    aVar2.b();
                }
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final Object a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, @NotNull Context context, @NotNull q qVar, @NotNull h9.a<k0> aVar2, @NotNull r rVar, @NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, k0> lVar, @NotNull z8.d<? super k0> dVar) {
            VastActivity.f20083j = rVar;
            VastActivity.f20081h = aVar2;
            Object objG = kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getMain(), new C0419a(aVar, qVar, lVar, context, null), dVar);
            return objG == a9.d.e() ? objG : k0.f35197a;
        }

        public final void b() {
            b2 b2Var = VastActivity.f20082i;
            if (b2Var == null || !b2Var.isActive()) {
                return;
            }
            b2 b2Var2 = VastActivity.f20082i;
            if (b2Var2 != null) {
                b2.a.a(b2Var2, null, 1, null);
            }
            VastActivity.f20082i = null;
        }

        public final void e(VastActivity vastActivity) {
            VastActivity.f20078e = new WeakReference(vastActivity);
            if (vastActivity == null) {
                b();
            }
        }

        public final boolean g(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return (bVar instanceof b.f) || t.d(bVar, b.e.f20759a);
        }

        public final VastActivity h() {
            return (VastActivity) VastActivity.f20078e.get();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$onCreate$1", f = "VastActivity.kt", l = {97}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20106j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20107k;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = VastActivity.this.new b(dVar);
            bVar.f20107k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar;
            Object objE = a9.d.e();
            int i10 = this.f20106j;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f20107k;
                x xVar = VastActivity.f20077d;
                this.f20107k = bVar2;
                this.f20106j = 1;
                if (xVar.emit(bVar2, this) == objE) {
                    return objE;
                }
                bVar = bVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f20107k;
                u.b(obj);
            }
            if (VastActivity.f20076c.g(bVar)) {
                VastActivity.this.finish();
            }
            return k0.f35197a;
        }
    }

    public static final class c extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f20110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> f20111i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVar) {
            super(2);
            this.f20110h = aVar;
            this.f20111i = pVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1009520481, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity.onCreate.<anonymous> (VastActivity.kt:103)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.c.a(VastActivity.this, this.f20110h, this.f20111i, VastActivity.f20083j, composer, 8, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.moloco.sdk.internal.android_context.b.a(getApplicationContext());
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = f20079f;
        if (aVar == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastActivity", "ad is missing", null, false, 12, null);
            finish();
            return;
        }
        h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVar = f20080g;
        if (pVar == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastActivity", "VastRenderer is missing", null, false, 12, null);
            finish();
            return;
        }
        z zVarD = a.h.f18920a.d();
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVarA = a.k.f18946a.a();
        Intent intent = getIntent();
        t.h(intent, "intent");
        boolean zN = d0.n(intent);
        Intent intent2 = getIntent();
        t.h(intent2, "intent");
        Boolean boolL = d0.l(intent2);
        Intent intent3 = getIntent();
        t.h(intent3, "intent");
        int iM = d0.m(intent3);
        Intent intent4 = getIntent();
        t.h(intent4, "intent");
        int iH = d0.h(intent4);
        Intent intent5 = getIntent();
        t.h(intent5, "intent");
        int iK = d0.k(intent5);
        Intent intent6 = getIntent();
        t.h(intent6, "intent");
        boolean zG = d0.g(intent6);
        Intent intent7 = getIntent();
        t.h(intent7, "intent");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b(aVar, zVarD, this, aVarA, zN, boolL, iM, iH, iK, zG, d0.d(intent7));
        this.f20084a = aVarB;
        f20076c.e(this);
        s9.j.D(s9.j.G(aVarB.a(), new b(null)), this.f20085b);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1009520481, true, new c(aVarB, pVar)), 1, null);
        aVarB.d();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h9.a<k0> aVar = f20081h;
        if (aVar != null) {
            aVar.invoke();
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar2 = this.f20084a;
        if (aVar2 != null) {
            aVar2.destroy();
        }
        this.f20084a = null;
        p0.e(this.f20085b, null, 1, null);
        f20076c.e(null);
    }
}
