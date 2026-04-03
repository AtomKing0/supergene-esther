package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.AlignmentLineProvider;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class CrossAxisAlignment {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final CrossAxisAlignment Center = CenterCrossAxisAlignment.INSTANCE;

    @NotNull
    private static final CrossAxisAlignment Start = StartCrossAxisAlignment.INSTANCE;

    @NotNull
    private static final CrossAxisAlignment End = EndCrossAxisAlignment.INSTANCE;

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class AlignmentLineCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        private final AlignmentLineProvider alignmentLineProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlignmentLineCrossAxisAlignment(@NotNull AlignmentLineProvider alignmentLineProvider) {
            super(null);
            t.i(alignmentLineProvider, "alignmentLineProvider");
            this.alignmentLineProvider = alignmentLineProvider;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            int iCalculateAlignmentLinePosition = this.alignmentLineProvider.calculateAlignmentLinePosition(placeable);
            if (iCalculateAlignmentLinePosition == Integer.MIN_VALUE) {
                return 0;
            }
            int i12 = i11 - iCalculateAlignmentLinePosition;
            return layoutDirection == LayoutDirection.Rtl ? i10 - i12 : i12;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        @NotNull
        public Integer calculateAlignmentLinePosition$foundation_layout_release(@NotNull Placeable placeable) {
            t.i(placeable, "placeable");
            return Integer.valueOf(this.alignmentLineProvider.calculateAlignmentLinePosition(placeable));
        }

        @NotNull
        public final AlignmentLineProvider getAlignmentLineProvider() {
            return this.alignmentLineProvider;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public boolean isRelative$foundation_layout_release() {
            return true;
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class CenterCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        public static final CenterCrossAxisAlignment INSTANCE = new CenterCrossAxisAlignment();

        private CenterCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            return i10 / 2;
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class EndCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        public static final EndCrossAxisAlignment INSTANCE = new EndCrossAxisAlignment();

        private EndCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            if (layoutDirection == LayoutDirection.Ltr) {
                return i10;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class HorizontalCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        private final Alignment.Horizontal horizontal;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HorizontalCrossAxisAlignment(@NotNull Alignment.Horizontal horizontal) {
            super(null);
            t.i(horizontal, "horizontal");
            this.horizontal = horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            return this.horizontal.align(0, i10, layoutDirection);
        }

        @NotNull
        public final Alignment.Horizontal getHorizontal() {
            return this.horizontal;
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class StartCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        public static final StartCrossAxisAlignment INSTANCE = new StartCrossAxisAlignment();

        private StartCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return i10;
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    private static final class VerticalCrossAxisAlignment extends CrossAxisAlignment {

        @NotNull
        private final Alignment.Vertical vertical;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerticalCrossAxisAlignment(@NotNull Alignment.Vertical vertical) {
            super(null);
            t.i(vertical, "vertical");
            this.vertical = vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11) {
            t.i(layoutDirection, "layoutDirection");
            t.i(placeable, "placeable");
            return this.vertical.align(0, i10);
        }

        @NotNull
        public final Alignment.Vertical getVertical() {
            return this.vertical;
        }
    }

    public /* synthetic */ CrossAxisAlignment(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract int align$foundation_layout_release(int i10, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i11);

    @Nullable
    public Integer calculateAlignmentLinePosition$foundation_layout_release(@NotNull Placeable placeable) {
        t.i(placeable, "placeable");
        return null;
    }

    public boolean isRelative$foundation_layout_release() {
        return false;
    }

    private CrossAxisAlignment() {
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final CrossAxisAlignment AlignmentLine(@NotNull AlignmentLine alignmentLine) {
            t.i(alignmentLine, "alignmentLine");
            return new AlignmentLineCrossAxisAlignment(new AlignmentLineProvider.Value(alignmentLine));
        }

        @NotNull
        public final CrossAxisAlignment Relative$foundation_layout_release(@NotNull AlignmentLineProvider alignmentLineProvider) {
            t.i(alignmentLineProvider, "alignmentLineProvider");
            return new AlignmentLineCrossAxisAlignment(alignmentLineProvider);
        }

        @NotNull
        public final CrossAxisAlignment getCenter() {
            return CrossAxisAlignment.Center;
        }

        @NotNull
        public final CrossAxisAlignment getEnd() {
            return CrossAxisAlignment.End;
        }

        @NotNull
        public final CrossAxisAlignment getStart() {
            return CrossAxisAlignment.Start;
        }

        @NotNull
        public final CrossAxisAlignment horizontal$foundation_layout_release(@NotNull Alignment.Horizontal horizontal) {
            t.i(horizontal, "horizontal");
            return new HorizontalCrossAxisAlignment(horizontal);
        }

        @NotNull
        public final CrossAxisAlignment vertical$foundation_layout_release(@NotNull Alignment.Vertical vertical) {
            t.i(vertical, "vertical");
            return new VerticalCrossAxisAlignment(vertical);
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getStart$annotations() {
        }
    }
}
