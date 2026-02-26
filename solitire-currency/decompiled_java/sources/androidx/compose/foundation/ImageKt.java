package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.ImageKt$Image$3, reason: invalid class name */
    /* JADX INFO: compiled from: Image.kt */
    static final class AnonymousClass3 extends v implements h9.p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Alignment $alignment;
        final /* synthetic */ float $alpha;
        final /* synthetic */ ColorFilter $colorFilter;
        final /* synthetic */ String $contentDescription;
        final /* synthetic */ ContentScale $contentScale;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Painter $painter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10, int i11) {
            super(2);
            this.$painter = painter;
            this.$contentDescription = str;
            this.$modifier = modifier;
            this.$alignment = alignment;
            this.$contentScale = contentScale;
            this.$alpha = f10;
            this.$colorFilter = colorFilter;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ImageKt.Image(this.$painter, this.$contentDescription, this.$modifier, this.$alignment, this.$contentScale, this.$alpha, this.$colorFilter, composer, this.$$changed | 1, this.$$default);
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final /* synthetic */ void Image(ImageBitmap bitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, Composer composer, int i10, int i11) {
        t.i(bitmap, "bitmap");
        composer.startReplaceableGroup(-2123228673);
        m212Image5hnEew(bitmap, str, (i11 & 4) != 0 ? Modifier.Companion : modifier, (i11 & 8) != 0 ? Alignment.Companion.getCenter() : alignment, (i11 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale, (i11 & 32) != 0 ? 1.0f : f10, (i11 & 64) != 0 ? null : colorFilter, FilterQuality.Companion.m1684getLowfv9h1I(), composer, (i10 & 112) | 8 | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (i10 & 3670016), 0);
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m212Image5hnEew(@NotNull ImageBitmap bitmap, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, int i10, @Nullable Composer composer, int i11, int i12) {
        t.i(bitmap, "bitmap");
        composer.startReplaceableGroup(-1396260732);
        Modifier modifier2 = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i12 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i12 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f11 = (i12 & 32) != 0 ? 1.0f : f10;
        ColorFilter colorFilter2 = (i12 & 64) != 0 ? null : colorFilter;
        int iM2027getDefaultFilterQualityfv9h1I = (i12 & 128) != 0 ? DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I() : i10;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(bitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = BitmapPainterKt.m2092BitmapPainterQZhYCtY$default(bitmap, 0L, 0L, iM2027getDefaultFilterQualityfv9h1I, 6, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Image((BitmapPainter) objRememberedValue, str, modifier2, center, fit, f11, colorFilter2, composer, (i11 & 112) | 8 | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11), 0);
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Image(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i10, int i11) {
        t.i(imageVector, "imageVector");
        composer.startReplaceableGroup(1595907091);
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer, i10 & 14), str, (i11 & 4) != 0 ? Modifier.Companion : modifier, (i11 & 8) != 0 ? Alignment.Companion.getCenter() : alignment, (i11 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale, (i11 & 32) != 0 ? 1.0f : f10, (i11 & 64) != 0 ? null : colorFilter, composer, VectorPainter.$stable | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (i10 & 3670016), 0);
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Image(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i10, int i11) {
        Modifier modifierSemantics$default;
        t.i(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(1142754848);
        Modifier modifier2 = (i11 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i11 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i11 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f11 = (i11 & 32) != 0 ? 1.0f : f10;
        ColorFilter colorFilter2 = (i11 & 64) != 0 ? null : colorFilter;
        composerStartRestartGroup.startReplaceableGroup(-816794123);
        if (str != null) {
            Modifier.Companion companion = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ImageKt$Image$semantics$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (h9.l) objRememberedValue, 1, null);
        } else {
            modifierSemantics$default = Modifier.Companion;
        }
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierPaint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifierSemantics$default)), painter, false, center, fit, f11, colorFilter2, 2, null);
        AnonymousClass2 anonymousClass2 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt.Image.2
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                return androidx.compose.ui.layout.d.a(this, intrinsicMeasureScope, list, i12);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                return androidx.compose.ui.layout.d.b(this, intrinsicMeasureScope, list, i12);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> list, long j10) {
                t.i(Layout, "$this$Layout");
                t.i(list, "<anonymous parameter 0>");
                return MeasureScope.CC.p(Layout, Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10), null, ImageKt$Image$2$measure$1.INSTANCE, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                return androidx.compose.ui.layout.d.c(this, intrinsicMeasureScope, list, i12);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                return androidx.compose.ui.layout.d.d(this, intrinsicMeasureScope, list, i12);
            }
        };
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion2.getConstructor();
        h9.q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierPaint$default);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, anonymousClass2, companion2.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2077995625);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(painter, str, modifier2, center, fit, f11, colorFilter2, i10, i11));
    }
}
