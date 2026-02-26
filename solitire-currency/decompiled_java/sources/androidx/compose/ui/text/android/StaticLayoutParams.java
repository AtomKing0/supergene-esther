package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
final class StaticLayoutParams {

    @NotNull
    private final Layout.Alignment alignment;
    private final int breakStrategy;

    @Nullable
    private final TextUtils.TruncateAt ellipsize;
    private final int ellipsizedWidth;
    private final int end;
    private final int hyphenationFrequency;
    private final boolean includePadding;
    private final int justificationMode;

    @Nullable
    private final int[] leftIndents;
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int maxLines;

    @NotNull
    private final TextPaint paint;

    @Nullable
    private final int[] rightIndents;
    private final int start;

    @NotNull
    private final CharSequence text;

    @NotNull
    private final TextDirectionHeuristic textDir;
    private final boolean useFallbackLineSpacing;
    private final int width;

    public StaticLayoutParams(@NotNull CharSequence text, int i10, int i11, @NotNull TextPaint paint, int i12, @NotNull TextDirectionHeuristic textDir, @NotNull Layout.Alignment alignment, int i13, @Nullable TextUtils.TruncateAt truncateAt, int i14, float f10, float f11, int i15, boolean z10, boolean z11, int i16, int i17, @Nullable int[] iArr, @Nullable int[] iArr2) {
        t.i(text, "text");
        t.i(paint, "paint");
        t.i(textDir, "textDir");
        t.i(alignment, "alignment");
        this.text = text;
        this.start = i10;
        this.end = i11;
        this.paint = paint;
        this.width = i12;
        this.textDir = textDir;
        this.alignment = alignment;
        this.maxLines = i13;
        this.ellipsize = truncateAt;
        this.ellipsizedWidth = i14;
        this.lineSpacingMultiplier = f10;
        this.lineSpacingExtra = f11;
        this.justificationMode = i15;
        this.includePadding = z10;
        this.useFallbackLineSpacing = z11;
        this.breakStrategy = i16;
        this.hyphenationFrequency = i17;
        this.leftIndents = iArr;
        this.rightIndents = iArr2;
        if (!(i10 >= 0 && i10 <= i11)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i11 >= 0 && i11 <= text.length())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i13 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i14 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(f10 >= 0.0f)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @NotNull
    public final Layout.Alignment getAlignment() {
        return this.alignment;
    }

    public final int getBreakStrategy() {
        return this.breakStrategy;
    }

    @Nullable
    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final int getEllipsizedWidth() {
        return this.ellipsizedWidth;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    @Nullable
    public final int[] getLeftIndents() {
        return this.leftIndents;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    @NotNull
    public final TextPaint getPaint() {
        return this.paint;
    }

    @Nullable
    public final int[] getRightIndents() {
        return this.rightIndents;
    }

    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final CharSequence getText() {
        return this.text;
    }

    @NotNull
    public final TextDirectionHeuristic getTextDir() {
        return this.textDir;
    }

    public final boolean getUseFallbackLineSpacing() {
        return this.useFallbackLineSpacing;
    }

    public final int getWidth() {
        return this.width;
    }

    public /* synthetic */ StaticLayoutParams(CharSequence charSequence, int i10, int i11, TextPaint textPaint, int i12, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i13, TextUtils.TruncateAt truncateAt, int i14, float f10, float f11, int i15, boolean z10, boolean z11, int i16, int i17, int[] iArr, int[] iArr2, int i18, k kVar) {
        this(charSequence, (i18 & 2) != 0 ? 0 : i10, i11, textPaint, i12, textDirectionHeuristic, alignment, i13, truncateAt, i14, f10, f11, i15, z10, z11, i16, i17, iArr, iArr2);
    }
}
