package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    public static final class a extends v implements h9.l<Context, View> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> f20118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f20119h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar) {
            super(1);
            this.f20118g = pVar;
            this.f20119h = aVar;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(@NotNull Context ctx) {
            t.i(ctx, "ctx");
            return this.f20118g.mo4invoke(ctx, this.f20119h);
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ k0 f20120g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k0 k0Var) {
            super(2);
            this.f20120g = k0Var;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040652088, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastView.<anonymous>.<anonymous> (VastActivity.kt:231)");
            }
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

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.c$c, reason: collision with other inner class name */
    public /* synthetic */ class C0423c extends q implements h9.a<k0> {
        public C0423c(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a.class, "goNextAdPartOrDismissAd", "goNextAdPartOrDismissAd()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a) this.receiver).y();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f20121g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f20122h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> f20123i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ r f20124j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f20125k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f20126l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVar, r rVar, int i10, int i11) {
            super(2);
            this.f20121g = activity;
            this.f20122h = aVar;
            this.f20123i = pVar;
            this.f20124j = rVar;
            this.f20125k = i10;
            this.f20126l = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            c.a(this.f20121g, this.f20122h, this.f20123i, this.f20124j, composer, this.f20125k | 1, this.f20126l);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void a(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVar, r rVar, Composer composer, int i10, int i11) {
        h9.p<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> pVarB;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1851234025);
        if ((i11 & 2) != 0) {
            pVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.b((1023 & 1) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (1023 & 2) != 0 ? k.i.f21111g : null, (1023 & 4) != 0 ? k.j.f21112g : null, (1023 & 8) != 0 ? k.C0456k.f21113g : null, (1023 & 16) != 0 ? k.l.f21114g : null, (1023 & 32) != 0 ? null : null, (1023 & 64) != 0 ? k.m.f21115g : null, (1023 & 128) != 0 ? k.n.f21116g : null, (1023 & 256) != 0 ? k.o.f21117g : null, (1023 & 512) != 0 ? a.h.f18920a.h() : null);
            i12 = i10 & (-897);
        } else {
            pVarB = pVar;
            i12 = i10;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1851234025, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastView (VastActivity.kt:223)");
        }
        composerStartRestartGroup.startReplaceableGroup(49866581);
        AndroidView_androidKt.AndroidView(new a(pVarB, aVar), null, null, composerStartRestartGroup, 0, 6);
        k0 k0Var = k0.f35197a;
        if (rVar != null) {
            rVar.a(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1040652088, true, new b(k0Var)), composerStartRestartGroup, ((i12 >> 6) & 112) | 6);
        }
        composerStartRestartGroup.endReplaceableGroup();
        BackHandlerKt.BackHandler(false, new C0423c(aVar), composerStartRestartGroup, 0, 1);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(activity, composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(activity, aVar, pVarB, rVar, i10, i11));
    }
}
