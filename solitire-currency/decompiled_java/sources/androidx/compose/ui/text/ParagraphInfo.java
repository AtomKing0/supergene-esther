package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MultiParagraph.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphInfo {
    private float bottom;
    private final int endIndex;
    private int endLineIndex;

    @NotNull
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public ParagraphInfo(@NotNull Paragraph paragraph, int i10, int i11, int i12, int i13, float f10, float f11) {
        t.i(paragraph, "paragraph");
        this.paragraph = paragraph;
        this.startIndex = i10;
        this.endIndex = i11;
        this.startLineIndex = i12;
        this.endLineIndex = i13;
        this.top = f10;
        this.bottom = f11;
    }

    public static /* synthetic */ ParagraphInfo copy$default(ParagraphInfo paragraphInfo, Paragraph paragraph, int i10, int i11, int i12, int i13, float f10, float f11, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            paragraph = paragraphInfo.paragraph;
        }
        if ((i14 & 2) != 0) {
            i10 = paragraphInfo.startIndex;
        }
        int i15 = i10;
        if ((i14 & 4) != 0) {
            i11 = paragraphInfo.endIndex;
        }
        int i16 = i11;
        if ((i14 & 8) != 0) {
            i12 = paragraphInfo.startLineIndex;
        }
        int i17 = i12;
        if ((i14 & 16) != 0) {
            i13 = paragraphInfo.endLineIndex;
        }
        int i18 = i13;
        if ((i14 & 32) != 0) {
            f10 = paragraphInfo.top;
        }
        float f12 = f10;
        if ((i14 & 64) != 0) {
            f11 = paragraphInfo.bottom;
        }
        return paragraphInfo.copy(paragraph, i15, i16, i17, i18, f12, f11);
    }

    @NotNull
    public final Paragraph component1() {
        return this.paragraph;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final int component4() {
        return this.startLineIndex;
    }

    public final int component5() {
        return this.endLineIndex;
    }

    public final float component6() {
        return this.top;
    }

    public final float component7() {
        return this.bottom;
    }

    @NotNull
    public final ParagraphInfo copy(@NotNull Paragraph paragraph, int i10, int i11, int i12, int i13, float f10, float f11) {
        t.i(paragraph, "paragraph");
        return new ParagraphInfo(paragraph, i10, i11, i12, i13, f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        return t.d(this.paragraph, paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && t.d(Float.valueOf(this.top), Float.valueOf(paragraphInfo.top)) && t.d(Float.valueOf(this.bottom), Float.valueOf(paragraphInfo.bottom));
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    @NotNull
    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((((((((this.paragraph.hashCode() * 31) + this.startIndex) * 31) + this.endIndex) * 31) + this.startLineIndex) * 31) + this.endLineIndex) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public final void setBottom(float f10) {
        this.bottom = f10;
    }

    public final void setEndLineIndex(int i10) {
        this.endLineIndex = i10;
    }

    public final void setStartLineIndex(int i10) {
        this.startLineIndex = i10;
    }

    public final void setTop(float f10) {
        this.top = f10;
    }

    @NotNull
    public final Rect toGlobal(@NotNull Rect rect) {
        t.i(rect, "<this>");
        return rect.m1404translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
    }

    /* JADX INFO: renamed from: toGlobal-GEjPoXI, reason: not valid java name */
    public final long m3258toGlobalGEjPoXI(long j10) {
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m3335getStartimpl(j10)), toGlobalIndex(TextRange.m3330getEndimpl(j10)));
    }

    public final int toGlobalIndex(int i10) {
        return i10 + this.startIndex;
    }

    public final int toGlobalLineIndex(int i10) {
        return i10 + this.startLineIndex;
    }

    public final float toGlobalYPosition(float f10) {
        return f10 + this.top;
    }

    /* JADX INFO: renamed from: toLocal-MK-Hz9U, reason: not valid java name */
    public final long m3259toLocalMKHz9U(long j10) {
        return OffsetKt.Offset(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10) - this.top);
    }

    public final int toLocalIndex(int i10) {
        return o.n(i10, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toLocalLineIndex(int i10) {
        return i10 - this.startLineIndex;
    }

    public final float toLocalYPosition(float f10) {
        return f10 - this.top;
    }

    @NotNull
    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    @NotNull
    public final Path toGlobal(@NotNull Path path) {
        t.i(path, "<this>");
        path.mo1503translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
        return path;
    }

    public /* synthetic */ ParagraphInfo(Paragraph paragraph, int i10, int i11, int i12, int i13, float f10, float f11, int i14, k kVar) {
        this(paragraph, i10, i11, (i14 & 8) != 0 ? -1 : i12, (i14 & 16) != 0 ? -1 : i13, (i14 & 32) != 0 ? -1.0f : f10, (i14 & 64) != 0 ? -1.0f : f11);
    }
}
