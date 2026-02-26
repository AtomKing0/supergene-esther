package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class OutlinedTextFieldKt$outlineCutout$1 extends v implements l<ContentDrawScope, k0> {
    final /* synthetic */ long $labelSize;
    final /* synthetic */ PaddingValues $paddingValues;

    /* JADX INFO: compiled from: OutlinedTextField.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$outlineCutout$1(long j10, PaddingValues paddingValues) {
        super(1);
        this.$labelSize = j10;
        this.$paddingValues = paddingValues;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
        invoke2(contentDrawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ContentDrawScope drawWithContent) {
        t.i(drawWithContent, "$this$drawWithContent");
        float fM1436getWidthimpl = Size.m1436getWidthimpl(this.$labelSize);
        if (fM1436getWidthimpl <= 0.0f) {
            drawWithContent.drawContent();
            return;
        }
        float fMo296toPx0680j_4 = drawWithContent.mo296toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
        float fMo296toPx0680j_42 = drawWithContent.mo296toPx0680j_4(this.$paddingValues.mo380calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - fMo296toPx0680j_4;
        float f10 = 2;
        float fM1436getWidthimpl2 = fM1436getWidthimpl + fMo296toPx0680j_42 + (fMo296toPx0680j_4 * f10);
        LayoutDirection layoutDirection = drawWithContent.getLayoutDirection();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        float fM1436getWidthimpl3 = iArr[layoutDirection.ordinal()] == 1 ? Size.m1436getWidthimpl(drawWithContent.mo1996getSizeNHjbRc()) - fM1436getWidthimpl2 : o.d(fMo296toPx0680j_42, 0.0f);
        if (iArr[drawWithContent.getLayoutDirection().ordinal()] == 1) {
            fM1436getWidthimpl2 = Size.m1436getWidthimpl(drawWithContent.mo1996getSizeNHjbRc()) - o.d(fMo296toPx0680j_42, 0.0f);
        }
        float f11 = fM1436getWidthimpl2;
        float fM1433getHeightimpl = Size.m1433getHeightimpl(this.$labelSize);
        float f12 = (-fM1433getHeightimpl) / f10;
        float f13 = fM1433getHeightimpl / f10;
        int iM1586getDifferencertfAjoo = ClipOp.Companion.m1586getDifferencertfAjoo();
        DrawContext drawContext = drawWithContent.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2005clipRectN_I0leg(fM1436getWidthimpl3, f12, f11, f13, iM1586getDifferencertfAjoo);
        drawWithContent.drawContent();
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }
}
