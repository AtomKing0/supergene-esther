package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $it;
    final /* synthetic */ long $labelContentColor;
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ long $labelTextStyleColor;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(float f10, long j10, p<? super Composer, ? super Integer, k0> pVar, int i10, boolean z10, long j11) {
        super(2);
        this.$labelProgress = f10;
        this.$labelContentColor = j10;
        this.$it = pVar;
        this.$$dirty = i10;
        this.$shouldOverrideTextStyleColor = z10;
        this.$labelTextStyleColor = j11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme.getTypography(composer, 6).getSubtitle1(), materialTheme.getTypography(composer, 6).getCaption(), this.$labelProgress);
        TextFieldImplKt.m1204DecorationeuL9pac(this.$labelContentColor, this.$shouldOverrideTextStyleColor ? textStyleLerp.m3346copyHL5avdY((262111 & 1) != 0 ? textStyleLerp.spanStyle.m3308getColor0d7_KjU() : this.$labelTextStyleColor, (262111 & 2) != 0 ? textStyleLerp.spanStyle.m3309getFontSizeXSAIIZE() : 0L, (262111 & 4) != 0 ? textStyleLerp.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? textStyleLerp.spanStyle.m3310getFontStyle4Lr2A7w() : null, (262111 & 16) != 0 ? textStyleLerp.spanStyle.m3311getFontSynthesisZQGJjVo() : null, (262111 & 32) != 0 ? textStyleLerp.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? textStyleLerp.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? textStyleLerp.spanStyle.m3312getLetterSpacingXSAIIZE() : 0L, (262111 & 256) != 0 ? textStyleLerp.spanStyle.m3307getBaselineShift5SSeXJ0() : null, (262111 & 512) != 0 ? textStyleLerp.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? textStyleLerp.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? textStyleLerp.spanStyle.m3306getBackground0d7_KjU() : 0L, (262111 & 4096) != 0 ? textStyleLerp.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? textStyleLerp.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? textStyleLerp.paragraphStyle.m3269getTextAlignbuA522U() : null, (262111 & 32768) != 0 ? textStyleLerp.paragraphStyle.m3270getTextDirectionmmuk1to() : null, (262111 & 65536) != 0 ? textStyleLerp.paragraphStyle.m3268getLineHeightXSAIIZE() : 0L, (262111 & 131072) != 0 ? textStyleLerp.paragraphStyle.getTextIndent() : null) : textStyleLerp, null, this.$it, composer, ((this.$$dirty >> 6) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
    }
}
