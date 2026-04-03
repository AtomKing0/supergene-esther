package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Selection.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Selection {

    @NotNull
    private final AnchorInfo end;
    private final boolean handlesCrossed;

    @NotNull
    private final AnchorInfo start;

    /* JADX INFO: compiled from: Selection.kt */
    @Immutable
    public static final class AnchorInfo {

        @NotNull
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;

        public AnchorInfo(@NotNull ResolvedTextDirection direction, int i10, long j10) {
            t.i(direction, "direction");
            this.direction = direction;
            this.offset = i10;
            this.selectableId = j10;
        }

        public static /* synthetic */ AnchorInfo copy$default(AnchorInfo anchorInfo, ResolvedTextDirection resolvedTextDirection, int i10, long j10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                resolvedTextDirection = anchorInfo.direction;
            }
            if ((i11 & 2) != 0) {
                i10 = anchorInfo.offset;
            }
            if ((i11 & 4) != 0) {
                j10 = anchorInfo.selectableId;
            }
            return anchorInfo.copy(resolvedTextDirection, i10, j10);
        }

        @NotNull
        public final ResolvedTextDirection component1() {
            return this.direction;
        }

        public final int component2() {
            return this.offset;
        }

        public final long component3() {
            return this.selectableId;
        }

        @NotNull
        public final AnchorInfo copy(@NotNull ResolvedTextDirection direction, int i10, long j10) {
            t.i(direction, "direction");
            return new AnchorInfo(direction, i10, j10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            return this.direction == anchorInfo.direction && this.offset == anchorInfo.offset && this.selectableId == anchorInfo.selectableId;
        }

        @NotNull
        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }

        public int hashCode() {
            return (((this.direction.hashCode() * 31) + this.offset) * 31) + androidx.compose.animation.a.a(this.selectableId);
        }

        @NotNull
        public String toString() {
            return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }
    }

    public Selection(@NotNull AnchorInfo start, @NotNull AnchorInfo end, boolean z10) {
        t.i(start, "start");
        t.i(end, "end");
        this.start = start;
        this.end = end;
        this.handlesCrossed = z10;
    }

    public static /* synthetic */ Selection copy$default(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            anchorInfo = selection.start;
        }
        if ((i10 & 2) != 0) {
            anchorInfo2 = selection.end;
        }
        if ((i10 & 4) != 0) {
            z10 = selection.handlesCrossed;
        }
        return selection.copy(anchorInfo, anchorInfo2, z10);
    }

    @NotNull
    public final AnchorInfo component1() {
        return this.start;
    }

    @NotNull
    public final AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    @NotNull
    public final Selection copy(@NotNull AnchorInfo start, @NotNull AnchorInfo end, boolean z10) {
        t.i(start, "start");
        t.i(end, "end");
        return new Selection(start, end, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return t.d(this.start, selection.start) && t.d(this.end, selection.end) && this.handlesCrossed == selection.handlesCrossed;
    }

    @NotNull
    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    @NotNull
    public final AnchorInfo getStart() {
        return this.start;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.start.hashCode() * 31) + this.end.hashCode()) * 31;
        boolean z10 = this.handlesCrossed;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    @NotNull
    public final Selection merge(@Nullable Selection selection) {
        return selection == null ? this : this.handlesCrossed ? copy$default(this, selection.start, null, false, 6, null) : copy$default(this, null, selection.end, false, 5, null);
    }

    @NotNull
    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    /* JADX INFO: renamed from: toTextRange-d9O1mEE, reason: not valid java name */
    public final long m767toTextRanged9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }

    public /* synthetic */ Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z10, int i10, k kVar) {
        this(anchorInfo, anchorInfo2, (i10 & 4) != 0 ? false : z10);
    }
}
