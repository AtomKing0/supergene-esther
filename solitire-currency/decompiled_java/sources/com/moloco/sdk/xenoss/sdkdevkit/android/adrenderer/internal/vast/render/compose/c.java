package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.p;
import h9.t;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.DECKt$DEC$1", f = "DEC.kt", l = {25}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20910j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20911k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.c$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.DECKt$DEC$1$1", f = "DEC.kt", l = {}, m = "invokeSuspend")
        public static final class C0445a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20912j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20913k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0445a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar, z8.d<? super C0445a> dVar) {
                super(2, dVar);
                this.f20913k = eVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C0445a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0445a(this.f20913k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f20912j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.f20913k.b();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20911k = eVar;
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
            return new a(this.f20911k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20910j;
            if (i10 == 0) {
                u.b(obj);
                z8.g main = com.moloco.sdk.internal.scheduling.c.a().getMain();
                C0445a c0445a = new C0445a(this.f20911k, null);
                this.f20910j = 1;
                if (kotlinx.coroutines.i.g(main, c0445a, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.DECKt$DEC$2$1", f = "DEC.kt", l = {35}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20914j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20915k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20916l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20917m;

        public static final class a extends v implements p<Offset, Offset, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20918g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20919h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h9.a<k0> aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar) {
                super(2);
                this.f20918g = aVar;
                this.f20919h = eVar;
            }

            public final void a(long j10, long j11) {
                k0 k0Var;
                h9.a<k0> aVar = this.f20918g;
                if (aVar != null) {
                    aVar.invoke();
                    k0Var = k0.f35197a;
                } else {
                    k0Var = null;
                }
                if (k0Var == null) {
                    this.f20919h.L(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f20066a.c(j10));
                }
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Offset offset, Offset offset2) {
                a(offset.m1377unboximpl(), offset2.m1377unboximpl());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h9.a<k0> aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f20916l = aVar;
            this.f20917m = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f20916l, this.f20917m, dVar);
            bVar.f20915k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20914j;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.f20915k;
                a aVar = new a(this.f20916l, this.f20917m);
                this.f20914j = 1;
                if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.b(pointerInputScope, aVar, this) == objE) {
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

    public /* synthetic */ class d extends q implements h9.a<k0> {
        public d(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e.class, "onVastPrivacyIconDisplayed", "onVastPrivacyIconDisplayed()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e) this.receiver).h();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public /* synthetic */ class e extends q implements h9.a<k0> {
        public e(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e.class, "onVastPrivacyIconClick", "onVastPrivacyIconClick()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e) this.receiver).v();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public static final class f extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> f20923i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Modifier f20924j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f20925k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f20926l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVar, h9.a<k0> aVar, t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> tVar, Modifier modifier, int i10, int i11) {
            super(2);
            this.f20921g = eVar;
            this.f20922h = aVar;
            this.f20923i = tVar;
            this.f20924j = modifier;
            this.f20925k = i10;
            this.f20926l = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            c.b(this.f20921g, this.f20922h, this.f20923i, this.f20924j, composer, this.f20925k | 1, this.f20926l);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j a(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> state) {
        return state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e r21, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r22, @org.jetbrains.annotations.Nullable h9.t<? super androidx.compose.foundation.layout.BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.c.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e, h9.a, h9.t, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.c$c, reason: collision with other inner class name */
    public static final class C0446c extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0446c f20920g = new C0446c();

        public C0446c() {
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
