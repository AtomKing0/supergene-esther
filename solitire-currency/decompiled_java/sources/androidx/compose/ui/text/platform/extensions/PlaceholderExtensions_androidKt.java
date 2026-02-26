package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlaceholderExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceholderExtensions_androidKt {
    /* JADX INFO: renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m3528getSpanUnitR2X_6o(long j10) {
        long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA()) ? 1 : 2;
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m3530getSpanVerticalAligndo9XGg(int i10) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3283getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3289getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3284getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3285getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3288getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3286getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m3279equalsimpl0(i10, companion.m3287getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i10, int i11, Density density) {
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m3854getValueimpl(placeholder.m3275getWidthXSAIIZE()), m3528getSpanUnitR2X_6o(placeholder.m3275getWidthXSAIIZE()), TextUnit.m3854getValueimpl(placeholder.m3273getHeightXSAIIZE()), m3528getSpanUnitR2X_6o(placeholder.m3273getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m3530getSpanVerticalAligndo9XGg(placeholder.m3274getPlaceholderVerticalAlignJ6kI3mc())), i10, i11);
    }

    public static final void setPlaceholders(@NotNull Spannable spannable, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density) {
        t.i(spannable, "<this>");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        int size = placeholders.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<Placeholder> range = placeholders.get(i10);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }

    /* JADX INFO: renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m3529getSpanUnitR2X_6o$annotations(long j10) {
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m3531getSpanVerticalAligndo9XGg$annotations(int i10) {
    }
}
