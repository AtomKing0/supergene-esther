package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$Decoration$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Float $contentAlpha;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ TextStyle $typography;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldImplKt$Decoration$1(long j10, TextStyle textStyle, Float f10, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
        super(2);
        this.$contentColor = j10;
        this.$typography = textStyle;
        this.$contentAlpha = f10;
        this.$content = pVar;
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
        TextFieldImplKt.m1204DecorationeuL9pac(this.$contentColor, this.$typography, this.$contentAlpha, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
