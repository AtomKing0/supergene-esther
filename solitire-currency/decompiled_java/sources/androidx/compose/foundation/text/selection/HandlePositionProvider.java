package androidx.compose.foundation.text.selection;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {

    @NotNull
    private final HandleReferencePoint handleReferencePoint;
    private final long offset;

    /* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            iArr[HandleReferencePoint.TopRight.ordinal()] = 2;
            iArr[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j10, k kVar) {
        this(handleReferencePoint, j10);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo758calculatePositionllwVHH4(@NotNull IntRect anchorBounds, long j10, @NotNull LayoutDirection layoutDirection, long j11) {
        t.i(anchorBounds, "anchorBounds");
        t.i(layoutDirection, "layoutDirection");
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i10 == 1) {
            return IntOffsetKt.IntOffset(anchorBounds.getLeft() + IntOffset.m3791getXimpl(this.offset), anchorBounds.getTop() + IntOffset.m3792getYimpl(this.offset));
        }
        if (i10 == 2) {
            return IntOffsetKt.IntOffset((anchorBounds.getLeft() + IntOffset.m3791getXimpl(this.offset)) - IntSize.m3833getWidthimpl(j11), anchorBounds.getTop() + IntOffset.m3792getYimpl(this.offset));
        }
        if (i10 == 3) {
            return IntOffsetKt.IntOffset((anchorBounds.getLeft() + IntOffset.m3791getXimpl(this.offset)) - (IntSize.m3833getWidthimpl(j11) / 2), anchorBounds.getTop() + IntOffset.m3792getYimpl(this.offset));
        }
        throw new q();
    }

    private HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j10) {
        this.handleReferencePoint = handleReferencePoint;
        this.offset = j10;
    }
}
