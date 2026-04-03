package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextLayoutHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutHelperKt {
    /* JADX INFO: renamed from: canReuse-7_7YC6M, reason: not valid java name */
    public static final boolean m741canReuse7_7YC6M(@NotNull TextLayoutResult canReuse, @NotNull AnnotatedString text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10, int i11, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull FontFamily.Resolver fontFamilyResolver, long j10) {
        t.i(canReuse, "$this$canReuse");
        t.i(text, "text");
        t.i(style, "style");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = canReuse.getLayoutInput();
        if (canReuse.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || !t.d(layoutInput.getText(), text) || !layoutInput.getStyle().hasSameLayoutAffectingAttributes(style) || !t.d(layoutInput.getPlaceholders(), placeholders) || layoutInput.getMaxLines() != i10 || layoutInput.getSoftWrap() != z10 || !TextOverflow.m3619equalsimpl0(layoutInput.m3317getOverflowgIe3tQ8(), i11) || !t.d(layoutInput.getDensity(), density) || layoutInput.getLayoutDirection() != layoutDirection || !t.d(layoutInput.getFontFamilyResolver(), fontFamilyResolver) || Constraints.m3643getMinWidthimpl(j10) != Constraints.m3643getMinWidthimpl(layoutInput.m3316getConstraintsmsEJaDk())) {
            return false;
        }
        if (z10 || TextOverflow.m3619equalsimpl0(i11, TextOverflow.Companion.m3627getEllipsisgIe3tQ8())) {
            return Constraints.m3641getMaxWidthimpl(j10) == Constraints.m3641getMaxWidthimpl(layoutInput.m3316getConstraintsmsEJaDk()) && Constraints.m3640getMaxHeightimpl(j10) == Constraints.m3640getMaxHeightimpl(layoutInput.m3316getConstraintsmsEJaDk());
        }
        return true;
    }
}
