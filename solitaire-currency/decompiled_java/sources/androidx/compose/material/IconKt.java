package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IconKt {

    @NotNull
    private static final Modifier DefaultIconSizeModifier = SizeKt.m440size3ABfNKs(Modifier.Companion, Dp.m3673constructorimpl(24));

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1049Iconww6aTOc(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, long j10, @Nullable Composer composer, int i10, int i11) {
        t.i(imageVector, "imageVector");
        composer.startReplaceableGroup(-800853103);
        m1048Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composer, i10 & 14), str, (i11 & 4) != 0 ? Modifier.Companion : modifier, (i11 & 8) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10, composer, VectorPainter.$stable | (i10 & 112) | (i10 & 896) | (i10 & 7168), 0);
        composer.endReplaceableGroup();
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        return modifier.then((Size.m1432equalsimpl0(painter.mo2089getIntrinsicSizeNHjbRc(), Size.Companion.m1444getUnspecifiedNHjbRc()) || m1050isInfiniteuvyYCjk(painter.mo2089getIntrinsicSizeNHjbRc())) ? DefaultIconSizeModifier : Modifier.Companion);
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m1050isInfiniteuvyYCjk(long j10) {
        return Float.isInfinite(Size.m1436getWidthimpl(j10)) && Float.isInfinite(Size.m1433getHeightimpl(j10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1047Iconww6aTOc(@NotNull ImageBitmap bitmap, @Nullable String str, @Nullable Modifier modifier, long j10, @Nullable Composer composer, int i10, int i11) {
        t.i(bitmap, "bitmap");
        composer.startReplaceableGroup(-554892675);
        Modifier modifier2 = (i11 & 4) != 0 ? Modifier.Companion : modifier;
        long jM1597copywmQWz5c$default = (i11 & 8) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(bitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(bitmap, 0L, 0L, 6, null);
            composer.updateRememberedValue(bitmapPainter);
            objRememberedValue = bitmapPainter;
        }
        composer.endReplaceableGroup();
        m1048Iconww6aTOc((BitmapPainter) objRememberedValue, str, modifier2, jM1597copywmQWz5c$default, composer, (i10 & 112) | 8 | (i10 & 896) | (i10 & 7168), 0);
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1048Iconww6aTOc(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, long j10, @Nullable Composer composer, int i10, int i11) {
        Modifier modifierSemantics$default;
        t.i(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1142959010);
        Modifier modifier2 = (i11 & 4) != 0 ? Modifier.Companion : modifier;
        long jM1597copywmQWz5c$default = (i11 & 8) != 0 ? Color.m1597copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        ColorFilter colorFilterM1639tintxETnrds$default = Color.m1599equalsimpl0(jM1597copywmQWz5c$default, Color.Companion.m1634getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m1639tintxETnrds$default(ColorFilter.Companion, jM1597copywmQWz5c$default, 0, 2, null);
        composerStartRestartGroup.startReplaceableGroup(1547385429);
        if (str != null) {
            Modifier.Companion companion = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new IconKt$Icon$semantics$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (l) objRememberedValue, 1, null);
        } else {
            modifierSemantics$default = Modifier.Companion;
        }
        composerStartRestartGroup.endReplaceableGroup();
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier2), painter), painter, false, null, ContentScale.Companion.getFit(), 0.0f, colorFilterM1639tintxETnrds$default, 22, null).then(modifierSemantics$default), composerStartRestartGroup, 0);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new IconKt$Icon$1(painter, str, modifier2, jM1597copywmQWz5c$default, i10, i11));
    }
}
