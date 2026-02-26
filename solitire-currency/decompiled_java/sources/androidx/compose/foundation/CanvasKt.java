package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.CanvasKt$Canvas$1, reason: invalid class name */
    /* JADX INFO: compiled from: Canvas.kt */
    static final class AnonymousClass1 extends v implements h9.p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ h9.l<DrawScope, k0> $onDraw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Modifier modifier, h9.l<? super DrawScope, k0> lVar, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$onDraw = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CanvasKt.Canvas(this.$modifier, this.$onDraw, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CanvasKt$Canvas$3, reason: invalid class name */
    /* JADX INFO: compiled from: Canvas.kt */
    static final class AnonymousClass3 extends v implements h9.p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ String $contentDescription;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ h9.l<DrawScope, k0> $onDraw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Modifier modifier, String str, h9.l<? super DrawScope, k0> lVar, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$contentDescription = str;
            this.$onDraw = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CanvasKt.Canvas(this.$modifier, this.$contentDescription, this.$onDraw, composer, this.$$changed | 1);
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Canvas(@NotNull Modifier modifier, @NotNull h9.l<? super DrawScope, k0> onDraw, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        t.i(onDraw, "onDraw");
        Composer composerStartRestartGroup = composer.startRestartGroup(-932836462);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(onDraw) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier, onDraw), composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, onDraw, i10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalFoundationApi
    public static final void Canvas(@NotNull Modifier modifier, @NotNull String contentDescription, @NotNull h9.l<? super DrawScope, k0> onDraw, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        t.i(contentDescription, "contentDescription");
        t.i(onDraw, "onDraw");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162737955);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(contentDescription) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(onDraw) ? 256 : 128;
        }
        if ((i11 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifier, onDraw);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(contentDescription);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new CanvasKt$Canvas$2$1(contentDescription);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(SemanticsModifierKt.semantics$default(modifierDrawBehind, false, (h9.l) objRememberedValue, 1, null), composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(modifier, contentDescription, onDraw, i10));
    }
}
