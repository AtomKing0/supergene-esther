package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
final class BorderKt$drawRectBorder$1 extends v implements h9.l<ContentDrawScope, k0> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $rectTopLeft;
    final /* synthetic */ long $size;
    final /* synthetic */ DrawStyle $style;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$drawRectBorder$1(Brush brush, long j10, long j11, DrawStyle drawStyle) {
        super(1);
        this.$brush = brush;
        this.$rectTopLeft = j10;
        this.$size = j11;
        this.$style = drawStyle;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
        invoke2(contentDrawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ContentDrawScope onDrawWithContent) {
        t.i(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.drawContent();
        androidx.compose.ui.graphics.drawscope.b.J(onDrawWithContent, this.$brush, this.$rectTopLeft, this.$size, 0.0f, this.$style, null, 0, 104, null);
    }
}
