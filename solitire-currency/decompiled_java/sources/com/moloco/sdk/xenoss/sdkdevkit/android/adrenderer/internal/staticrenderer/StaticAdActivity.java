package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import com.ironsource.f5;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.l;
import h9.p;
import h9.w;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.o0;
import s9.y;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class StaticAdActivity extends ComponentActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> f19705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f19706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static StaticAdActivity f19707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static h9.a<k0> f19708e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static r f19710g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f19704a = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final y<Boolean> f19709f = o0.a(Boolean.FALSE);

    public static final class a {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$a, reason: collision with other inner class name */
        @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$Companion", f = "StaticAdActivity.kt", l = {99}, m = f5.f12054u)
        public static final class C0390a extends d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public Object f19711j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f19712k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f19714m;

            public C0390a(z8.d<? super C0390a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f19712k = obj;
                this.f19714m |= Integer.MIN_VALUE;
                return a.this.a(null, null, null, null, null, this);
            }
        }

        @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$Companion$show$3", f = "StaticAdActivity.kt", l = {}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements p<Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19715j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f19716k;

            public b(z8.d<? super b> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                b bVar = new b(dVar);
                bVar.f19716k = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Nullable
            public final Object f(boolean z10, @Nullable z8.d<? super Boolean> dVar) {
                return ((b) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
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
                if (this.f19715j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f19716k);
            }
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(@org.jetbrains.annotations.NotNull android.content.Context r7, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a r8, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r9, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d r10, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r r11, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r12) {
            /*
                r6 = this;
                boolean r0 = r12 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.a.C0390a
                if (r0 == 0) goto L13
                r0 = r12
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.a.C0390a) r0
                int r1 = r0.f19714m
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19714m = r1
                goto L18
            L13:
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$a
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.f19712k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f19714m
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L37
                if (r2 != r4) goto L2f
                java.lang.Object r7 = r0.f19711j
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a r7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.a) r7
                v8.u.b(r12)     // Catch: java.lang.Throwable -> L94
                goto L74
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                v8.u.b(r12)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.p(r11)     // Catch: java.lang.Throwable -> L94
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.o(r8)     // Catch: java.lang.Throwable -> L94
                h9.w r8 = r10.a()     // Catch: java.lang.Throwable -> L94
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.r(r8)     // Catch: java.lang.Throwable -> L94
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.q(r9)     // Catch: java.lang.Throwable -> L94
                android.content.Intent r8 = new android.content.Intent     // Catch: java.lang.Throwable -> L94
                java.lang.Class<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity> r9 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.class
                r8.<init>(r7, r9)     // Catch: java.lang.Throwable -> L94
                int r9 = r10.b()     // Catch: java.lang.Throwable -> L94
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0.a(r8, r9)     // Catch: java.lang.Throwable -> L94
                r9 = 268435456(0x10000000, float:2.524355E-29)
                r8.setFlags(r9)     // Catch: java.lang.Throwable -> L94
                r7.startActivity(r8)     // Catch: java.lang.Throwable -> L94
                s9.y r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.s()     // Catch: java.lang.Throwable -> L94
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$b r8 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$a$b     // Catch: java.lang.Throwable -> L94
                r8.<init>(r5)     // Catch: java.lang.Throwable -> L94
                r0.f19711j = r6     // Catch: java.lang.Throwable -> L94
                r0.f19714m = r4     // Catch: java.lang.Throwable -> L94
                java.lang.Object r7 = s9.j.v(r7, r8, r0)     // Catch: java.lang.Throwable -> L94
                if (r7 != r1) goto L74
                return r1
            L74:
                s9.y r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.s()
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.b.a(r3)
                r7.setValue(r8)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.q(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.o(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.r(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.m()
                if (r7 == 0) goto L91
                r7.finish()
            L91:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L94:
                r7 = move-exception
                s9.y r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.s()
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.b.a(r3)
                r8.setValue(r9)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.q(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.o(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.r(r5)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.m()
                if (r8 == 0) goto Lb2
                r8.finish()
            Lb2:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.a.a(android.content.Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a, h9.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, z8.d):java.lang.Object");
        }

        public final void b() {
            StaticAdActivity.f19709f.setValue(Boolean.TRUE);
        }

        public final void e(a.AbstractC0481a.c cVar) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = StaticAdActivity.f19706c;
            if (aVar != null) {
                aVar.g(cVar);
            }
        }

        public a() {
        }
    }

    public static final class b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f19718h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f19719i;

        public /* synthetic */ class a extends q implements l<a.AbstractC0481a.c, k0> {
            public a(Object obj) {
                super(1, obj, a.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
            }

            public final void a(@NotNull a.AbstractC0481a.c p02) {
                t.i(p02, "p0");
                ((a) this.receiver).e(p02);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
                a(cVar);
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity$b$b, reason: collision with other inner class name */
        public /* synthetic */ class C0391b extends q implements h9.a<k0> {
            public C0391b(Object obj) {
                super(0, obj, a.class, "dismiss", "dismiss()V", 0);
            }

            public final void c() {
                ((a) this.receiver).b();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                c();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar) {
            super(2);
            this.f19718h = aVar;
            this.f19719i = wVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193619358, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity.onCreate.<anonymous> (StaticAdActivity.kt:37)");
            }
            StaticAdActivity staticAdActivity = StaticAdActivity.this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = this.f19718h;
            Intent intent = staticAdActivity.getIntent();
            t.h(intent, "intent");
            int iH = d0.h(intent);
            a aVar2 = StaticAdActivity.f19704a;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.e(staticAdActivity, aVar, iH, new a(aVar2), new C0391b(aVar2), this.f19719i, StaticAdActivity.f19710g, composer, 64);
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
        f19707d = this;
        w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar = f19705b;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = f19706c;
        if (aVar == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "StaticAdActivity", "can't display ad: WebView is missing", null, false, 12, null);
            f19704a.b();
        } else if (wVar != null) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1193619358, true, new b(aVar, wVar)), 1, null);
        } else {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "StaticAdActivity", "can't display ad: StaticRenderer is missing", null, false, 12, null);
            f19704a.b();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h9.a<k0> aVar = f19708e;
        if (aVar != null) {
            aVar.invoke();
        }
        f19707d = null;
    }
}
