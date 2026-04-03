package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextKt$Text$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ FontFamily $fontFamily;
    final /* synthetic */ long $fontSize;
    final /* synthetic */ FontStyle $fontStyle;
    final /* synthetic */ FontWeight $fontWeight;
    final /* synthetic */ long $letterSpacing;
    final /* synthetic */ long $lineHeight;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ String $text;
    final /* synthetic */ TextAlign $textAlign;
    final /* synthetic */ TextDecoration $textDecoration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextKt$Text$2(String str, Modifier modifier, long j10, long j11, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j12, TextDecoration textDecoration, TextAlign textAlign, long j13, int i10, boolean z10, int i11, l<? super TextLayoutResult, k0> lVar, TextStyle textStyle, int i12, int i13, int i14) {
        super(2);
        this.$text = str;
        this.$modifier = modifier;
        this.$color = j10;
        this.$fontSize = j11;
        this.$fontStyle = fontStyle;
        this.$fontWeight = fontWeight;
        this.$fontFamily = fontFamily;
        this.$letterSpacing = j12;
        this.$textDecoration = textDecoration;
        this.$textAlign = textAlign;
        this.$lineHeight = j13;
        this.$overflow = i10;
        this.$softWrap = z10;
        this.$maxLines = i11;
        this.$onTextLayout = lVar;
        this.$style = textStyle;
        this.$$changed = i12;
        this.$$changed1 = i13;
        this.$$default = i14;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        TextKt.m1218TextfLXpl1I(this.$text, this.$modifier, this.$color, this.$fontSize, this.$fontStyle, this.$fontWeight, this.$fontFamily, this.$letterSpacing, this.$textDecoration, this.$textAlign, this.$lineHeight, this.$overflow, this.$softWrap, this.$maxLines, this.$onTextLayout, this.$style, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
