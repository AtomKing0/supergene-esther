package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.x;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    public static final class a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ j.a f21150g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f21151h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21152i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21153j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j.a aVar, Modifier modifier, int i10, int i11) {
            super(2);
            this.f21150g = aVar;
            this.f21151h = modifier;
            this.f21152i = i10;
            this.f21153j = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            l.a(this.f21150g, this.f21151h, composer, this.f21152i | 1, this.f21153j);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ j.a f21154g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f21155h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21156i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21157j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j.a aVar, Modifier modifier, int i10, int i11) {
            super(2);
            this.f21154g = aVar;
            this.f21155h = modifier;
            this.f21156i = i10;
            this.f21157j = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            l.a(this.f21154g, this.f21155h, composer, this.f21156i | 1, this.f21157j);
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
    public static final void a(@NotNull j.a htmlResource, @Nullable Modifier modifier, @Nullable Composer composer, int i10, int i11) {
        int i12;
        t.i(htmlResource, "htmlResource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1230364815);
        if ((i11 & 1) != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(htmlResource) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i13 = i11 & 2;
        if (i13 != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1230364815, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastResourceHtml (VastResourceHtml.kt:11)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                x xVar = x.f21624a;
                Object obj = x.f21625b.get(Integer.valueOf(htmlResource.a()));
                if (!(obj instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i)) {
                    obj = null;
                }
                objRememberedValue = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i) obj;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i) objRememberedValue;
            if (iVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new b(htmlResource, modifier, i10, i11));
                return;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(iVar, modifier, null, composerStartRestartGroup, (i12 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup2.updateScope(new a(htmlResource, modifier, i10, i11));
    }
}
