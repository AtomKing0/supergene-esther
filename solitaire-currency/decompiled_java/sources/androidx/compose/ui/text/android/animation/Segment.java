package androidx.compose.ui.text.android.animation;

import androidx.compose.ui.text.android.InternalPlatformTextApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SegmentBreaker.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class Segment {
    private final int bottom;
    private final int endOffset;
    private final int left;
    private final int right;
    private final int startOffset;
    private final int top;

    public Segment(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.startOffset = i10;
        this.endOffset = i11;
        this.left = i12;
        this.top = i13;
        this.right = i14;
        this.bottom = i15;
    }

    public static /* synthetic */ Segment copy$default(Segment segment, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i10 = segment.startOffset;
        }
        if ((i16 & 2) != 0) {
            i11 = segment.endOffset;
        }
        int i17 = i11;
        if ((i16 & 4) != 0) {
            i12 = segment.left;
        }
        int i18 = i12;
        if ((i16 & 8) != 0) {
            i13 = segment.top;
        }
        int i19 = i13;
        if ((i16 & 16) != 0) {
            i14 = segment.right;
        }
        int i20 = i14;
        if ((i16 & 32) != 0) {
            i15 = segment.bottom;
        }
        return segment.copy(i10, i17, i18, i19, i20, i15);
    }

    public final int component1() {
        return this.startOffset;
    }

    public final int component2() {
        return this.endOffset;
    }

    public final int component3() {
        return this.left;
    }

    public final int component4() {
        return this.top;
    }

    public final int component5() {
        return this.right;
    }

    public final int component6() {
        return this.bottom;
    }

    @NotNull
    public final Segment copy(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new Segment(i10, i11, i12, i13, i14, i15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment segment = (Segment) obj;
        return this.startOffset == segment.startOffset && this.endOffset == segment.endOffset && this.left == segment.left && this.top == segment.top && this.right == segment.right && this.bottom == segment.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((((((this.startOffset * 31) + this.endOffset) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NotNull
    public String toString() {
        return "Segment(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }
}
