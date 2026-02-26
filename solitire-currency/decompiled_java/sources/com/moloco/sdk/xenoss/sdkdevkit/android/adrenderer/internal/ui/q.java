package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.app.Activity;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.HideSystemUIKt$HideSystemUI$1", f = "HideSystemUI.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19924j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f19925k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Activity f19926l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, Activity activity, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19925k = z10;
            this.f19926l = activity;
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
            return new a(this.f19925k, this.f19926l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19924j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (this.f19925k) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c.a(this.f19926l);
            }
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f19927g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f19928h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, int i10) {
            super(2);
            this.f19927g = activity;
            this.f19928h = i10;
        }

        public final void a(@Nullable Composer composer, int i10) {
            q.a(this.f19927g, composer, this.f19928h | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @Composable
    public static final void a(@NotNull Activity activity, @Nullable Composer composer, int i10) {
        kotlin.jvm.internal.t.i(activity, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-726701488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726701488, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.HideSystemUI (HideSystemUI.kt:9)");
        }
        boolean zIsWindowFocused = ((WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused();
        EffectsKt.LaunchedEffect(Boolean.valueOf(zIsWindowFocused), new a(zIsWindowFocused, activity, null), composerStartRestartGroup, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(activity, i10));
    }
}
