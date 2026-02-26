package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    public static final class a extends v implements h9.l<a.AbstractC0481a.c, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f20038g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MutableState<a.AbstractC0481a.c> f20039h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(h9.l<? super a.AbstractC0481a.c, k0> lVar, MutableState<a.AbstractC0481a.c> mutableState) {
            super(1);
            this.f20038g = lVar;
            this.f20039h = mutableState;
        }

        public final void a(@NotNull a.AbstractC0481a.c it) {
            kotlin.jvm.internal.t.i(it, "it");
            t.b(this.f20039h, it);
            this.f20038g.invoke(it);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
            a(cVar);
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f20040g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a.AbstractC0481a.c.EnumC0483a f20041h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f20042i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.q<Modifier, Composer, Integer, k0> f20043j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f20044k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f20045l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Modifier modifier, a.AbstractC0481a.c.EnumC0483a enumC0483a, h9.l<? super a.AbstractC0481a.c, k0> lVar, h9.q<? super Modifier, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.f20040g = modifier;
            this.f20041h = enumC0483a;
            this.f20042i = lVar;
            this.f20043j = qVar;
            this.f20044k = i10;
            this.f20045l = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            t.c(this.f20040g, this.f20041h, this.f20042i, this.f20043j, composer, this.f20044k | 1, this.f20045l);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final a.AbstractC0481a.c a(MutableState<a.AbstractC0481a.c> mutableState) {
        return mutableState.getValue();
    }

    public static final void b(MutableState<a.AbstractC0481a.c> mutableState, a.AbstractC0481a.c cVar) {
        mutableState.setValue(cVar);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void c(@Nullable Modifier modifier, @NotNull a.AbstractC0481a.c.EnumC0483a buttonType, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.q<? super Modifier, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        int i12;
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
        kotlin.jvm.internal.t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-361890132);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(buttonType) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(onButtonRendered) ? 256 : 128;
        }
        if ((i11 & 8) != 0) {
            i12 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i12 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-361890132, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.TrackableButton (TrackableButton.kt:17)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(buttonType), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            a.AbstractC0481a.c cVarA = a(mutableState);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(onButtonRendered);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a(onButtonRendered, mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            content.invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a.a(modifier, cVarA, (h9.l) objRememberedValue2), composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(modifier2, buttonType, onButtonRendered, content, i10, i11));
    }
}
