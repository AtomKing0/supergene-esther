package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import j9.c;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewHolder_androidKt {
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View view, LayoutNode layoutNode) {
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int iC = c.c(Offset.m1367getXimpl(jPositionInRoot));
        int iC2 = c.c(Offset.m1368getYimpl(jPositionInRoot));
        view.layout(iC, iC2, view.getMeasuredWidth() + iC, view.getMeasuredHeight() + iC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int i10) {
        return i10 * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float f10) {
        return f10 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int i10) {
        return i10 == 0 ? NestedScrollSource.Companion.m2787getDragWNlRxjI() : NestedScrollSource.Companion.m2788getFlingWNlRxjI();
    }
}
