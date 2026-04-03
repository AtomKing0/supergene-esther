package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
final class BorderKt$drawRoundRectBorder$1 extends v implements h9.l<ContentDrawScope, k0> {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$drawRoundRectBorder$1(boolean z10, Brush brush, long j10, float f10, float f11, long j11, long j12, Stroke stroke) {
        super(1);
        this.$fillArea = z10;
        this.$brush = brush;
        this.$cornerRadius = j10;
        this.$halfStroke = f10;
        this.$strokeWidth = f11;
        this.$topLeft = j11;
        this.$borderSize = j12;
        this.$borderStroke = stroke;
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
        if (this.$fillArea) {
            androidx.compose.ui.graphics.drawscope.b.L(onDrawWithContent, this.$brush, 0L, 0L, this.$cornerRadius, 0.0f, null, null, 0, 246, null);
            return;
        }
        float fM1342getXimpl = CornerRadius.m1342getXimpl(this.$cornerRadius);
        float f10 = this.$halfStroke;
        if (fM1342getXimpl >= f10) {
            androidx.compose.ui.graphics.drawscope.b.L(onDrawWithContent, this.$brush, this.$topLeft, this.$borderSize, BorderKt.m176shrinkKibmq7A(this.$cornerRadius, f10), 0.0f, this.$borderStroke, null, 0, 208, null);
            return;
        }
        float f11 = this.$strokeWidth;
        float fM1436getWidthimpl = Size.m1436getWidthimpl(onDrawWithContent.mo1996getSizeNHjbRc()) - this.$strokeWidth;
        float fM1433getHeightimpl = Size.m1433getHeightimpl(onDrawWithContent.mo1996getSizeNHjbRc()) - this.$strokeWidth;
        int iM1586getDifferencertfAjoo = ClipOp.Companion.m1586getDifferencertfAjoo();
        Brush brush = this.$brush;
        long j10 = this.$cornerRadius;
        DrawContext drawContext = onDrawWithContent.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2005clipRectN_I0leg(f11, f11, fM1436getWidthimpl, fM1433getHeightimpl, iM1586getDifferencertfAjoo);
        androidx.compose.ui.graphics.drawscope.b.L(onDrawWithContent, brush, 0L, 0L, j10, 0.0f, null, null, 0, 246, null);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }
}
