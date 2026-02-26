package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MaxLinesHeightModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MaxLinesHeightModifierKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.MaxLinesHeightModifierKt$maxLinesHeight$2, reason: invalid class name */
    /* JADX INFO: compiled from: MaxLinesHeightModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ int $maxLines;
        final /* synthetic */ TextStyle $textStyle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i10, TextStyle textStyle) {
            super(3);
            this.$maxLines = i10;
            this.$textStyle = textStyle;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1027014173);
            int i11 = this.$maxLines;
            if (!(i11 > 0)) {
                throw new IllegalArgumentException("maxLines must be greater than 0".toString());
            }
            if (i11 == Integer.MAX_VALUE) {
                Modifier.Companion companion = Modifier.Companion;
                composer.endReplaceableGroup();
                return companion;
            }
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            TextStyle textStyle = this.$textStyle;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            TextStyle textStyle2 = (TextStyle) objRememberedValue;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(resolver) | composer.changed(textStyle2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                FontFamily fontFamily = textStyle2.getFontFamily();
                FontWeight fontWeight = textStyle2.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle fontStyleM3353getFontStyle4Lr2A7w = textStyle2.m3353getFontStyle4Lr2A7w();
                int iM3416unboximpl = fontStyleM3353getFontStyle4Lr2A7w != null ? fontStyleM3353getFontStyle4Lr2A7w.m3416unboximpl() : FontStyle.Companion.m3418getNormal_LCdwA();
                FontSynthesis fontSynthesisM3354getFontSynthesisZQGJjVo = textStyle2.m3354getFontSynthesisZQGJjVo();
                objRememberedValue2 = resolver.mo3392resolveDPcqOEQ(fontFamily, fontWeight, iM3416unboximpl, fontSynthesisM3354getFontSynthesisZQGJjVo != null ? fontSynthesisM3354getFontSynthesisZQGJjVo.m3427unboximpl() : FontSynthesis.Companion.m3428getAllGVVA2EU());
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            State state = (State) objRememberedValue2;
            Object[] objArr = {density, resolver, this.$textStyle, layoutDirection, state.getValue()};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged3 = false;
            for (int i12 = 0; i12 < 5; i12++) {
                zChanged3 |= composer.changed(objArr[i12]);
            }
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = Integer.valueOf(IntSize.m3832getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            int iIntValue = ((Number) objRememberedValue3).intValue();
            Object[] objArr2 = {density, resolver, this.$textStyle, layoutDirection, state.getValue()};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged4 = false;
            for (int i13 = 0; i13 < 5; i13++) {
                zChanged4 |= composer.changed(objArr2[i13]);
            }
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = Integer.valueOf(IntSize.m3832getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            Modifier modifierM428heightInVpY3zN4$default = SizeKt.m428heightInVpY3zN4$default(Modifier.Companion, 0.0f, density.mo293toDpu2uoSUM(iIntValue + ((((Number) objRememberedValue4).intValue() - iIntValue) * (this.$maxLines - 1))), 1, null);
            composer.endReplaceableGroup();
            return modifierM428heightInVpY3zN4$default;
        }
    }

    @NotNull
    public static final Modifier maxLinesHeight(@NotNull Modifier modifier, int i10, @NotNull TextStyle textStyle) {
        t.i(modifier, "<this>");
        t.i(textStyle, "textStyle");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new MaxLinesHeightModifierKt$maxLinesHeight$$inlined$debugInspectorInfo$1(i10, textStyle) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(i10, textStyle));
    }
}
