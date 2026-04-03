package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import h9.q;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class IntrinsicMeasureBlocks {

    @NotNull
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMinWidth = IntrinsicMeasureBlocks$HorizontalMinWidth$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinWidth = IntrinsicMeasureBlocks$VerticalMinWidth$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMinHeight = IntrinsicMeasureBlocks$HorizontalMinHeight$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinHeight = IntrinsicMeasureBlocks$VerticalMinHeight$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxWidth = IntrinsicMeasureBlocks$HorizontalMaxWidth$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxWidth = IntrinsicMeasureBlocks$VerticalMaxWidth$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxHeight = IntrinsicMeasureBlocks$HorizontalMaxHeight$1.INSTANCE;

    @NotNull
    private static final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxHeight = IntrinsicMeasureBlocks$VerticalMaxHeight$1.INSTANCE;

    private IntrinsicMeasureBlocks() {
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMaxHeight() {
        return HorizontalMaxHeight;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMaxWidth() {
        return HorizontalMaxWidth;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMinHeight() {
        return HorizontalMinHeight;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMinWidth() {
        return HorizontalMinWidth;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMaxHeight() {
        return VerticalMaxHeight;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMaxWidth() {
        return VerticalMaxWidth;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMinHeight() {
        return VerticalMinHeight;
    }

    @NotNull
    public final q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMinWidth() {
        return VerticalMinWidth;
    }
}
