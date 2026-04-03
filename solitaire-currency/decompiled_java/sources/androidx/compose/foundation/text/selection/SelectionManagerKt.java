package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionManagerKt {

    /* JADX INFO: compiled from: SelectionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.SelectionStart.ordinal()] = 1;
            iArr[Handle.SelectionEnd.ordinal()] = 2;
            iArr[Handle.Cursor.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m816calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull SelectionManager manager, long j10) {
        t.i(manager, "manager");
        Selection selection = manager.getSelection();
        if (selection == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        int i10 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i10 == -1) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        if (i10 == 1) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, j10, selection.getStart(), true);
        }
        if (i10 == 2) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, j10, selection.getEnd(), false);
        }
        if (i10 != 3) {
            throw new q();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager selectionManager, long j10, Selection.AnchorInfo anchorInfo, boolean z10) {
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates();
        if (containerLayoutCoordinates == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        int offset = anchorInfo.getOffset();
        if (!z10) {
            offset--;
        }
        Offset offsetM805getCurrentDragPosition_m7T9E = selectionManager.m805getCurrentDragPosition_m7T9E();
        t.f(offsetM805getCurrentDragPosition_m7T9E);
        float fM1367getXimpl = Offset.m1367getXimpl(layoutCoordinates.mo2990localPositionOfR5De75A(containerLayoutCoordinates, offsetM805getCurrentDragPosition_m7T9E.m1377unboximpl()));
        long jMo760getRangeOfLineContainingjx7JFs = anchorSelectable$foundation_release.mo760getRangeOfLineContainingjx7JFs(offset);
        Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.m3333getMinimpl(jMo760getRangeOfLineContainingjx7JFs));
        Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(o.e(TextRange.m3332getMaximpl(jMo760getRangeOfLineContainingjx7JFs) - 1, TextRange.m3333getMinimpl(jMo760getRangeOfLineContainingjx7JFs)));
        float fM = o.m(fM1367getXimpl, Math.min(boundingBox.getLeft(), boundingBox2.getLeft()), Math.max(boundingBox.getRight(), boundingBox2.getRight()));
        return Math.abs(fM1367getXimpl - fM) > ((float) (IntSize.m3833getWidthimpl(j10) / 2)) ? Offset.Companion.m1382getUnspecifiedF1C5BW0() : containerLayoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(fM, Offset.m1368getYimpl(anchorSelectable$foundation_release.getBoundingBox(offset).m1397getCenterF1C5BW0())));
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m817containsInclusiveUv8p0NA(@NotNull Rect containsInclusive, long j10) {
        t.i(containsInclusive, "$this$containsInclusive");
        float left = containsInclusive.getLeft();
        float right = containsInclusive.getRight();
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        if (left <= fM1367getXimpl && fM1367getXimpl <= right) {
            float top = containsInclusive.getTop();
            float bottom = containsInclusive.getBottom();
            float fM1368getYimpl = Offset.m1368getYimpl(j10);
            if (top <= fM1368getYimpl && fM1368getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final AnnotatedString getCurrentSelectedText(@NotNull Selectable selectable, @NotNull Selection selection) {
        t.i(selectable, "selectable");
        t.i(selection, "selection");
        AnnotatedString text = selectable.getText();
        return (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId()) ? (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) ? selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset()) : selectable.getSelectableId() == selection.getStart().getSelectableId() ? selection.getHandlesCrossed() ? text.subSequence(0, selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), text.length()) : selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), text.length()) : text.subSequence(0, selection.getEnd().getOffset()) : text;
    }

    @Nullable
    public static final Selection merge(@Nullable Selection selection, @Nullable Selection selection2) {
        Selection selectionMerge;
        return (selection == null || (selectionMerge = selection.merge(selection2)) == null) ? selection2 : selectionMerge;
    }

    @NotNull
    public static final Rect visibleBounds(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        Rect rectBoundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m1405Rect0a9Yr6o(layoutCoordinates.mo2993windowToLocalMKHz9U(rectBoundsInWindow.m1402getTopLeftF1C5BW0()), layoutCoordinates.mo2993windowToLocalMKHz9U(rectBoundsInWindow.m1396getBottomRightF1C5BW0()));
    }
}
