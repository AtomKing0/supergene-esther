package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import j9.c;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: TextFieldDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;

    @NotNull
    private static final String EmptyTextReplacement = q.C("H", 10);

    public static final long computeSizeForDefaultText(@NotNull TextStyle style, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull String text, int i10) {
        t.i(style, "style");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(text, "text");
        Paragraph paragraphM3260ParagraphUdtVg6A = ParagraphKt.m3260ParagraphUdtVg6A(text, style, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), density, fontFamilyResolver, (64 & 32) != 0 ? v.l() : v.l(), (64 & 64) != 0 ? v.l() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : i10, (64 & 256) != 0 ? false : false);
        return IntSizeKt.IntSize(toIntPx(paragraphM3260ParagraphUdtVg6A.getMinIntrinsicWidth()), toIntPx(paragraphM3260ParagraphUdtVg6A.getHeight()));
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i11 & 16) != 0) {
            i10 = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i10);
    }

    @NotNull
    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }

    private static final int toIntPx(float f10) {
        return c.c((float) Math.ceil(f10));
    }
}
