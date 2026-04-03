package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    @NotNull
    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect rectA;
        t.i(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectA = b.a(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m3833getWidthimpl(layoutCoordinates.mo2989getSizeYbymL2g()), IntSize.m3832getHeightimpl(layoutCoordinates.mo2989getSizeYbymL2g())) : rectA;
    }

    @NotNull
    public static final Rect boundsInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        return b.a(findRoot(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    @NotNull
    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        LayoutCoordinates layoutCoordinatesFindRoot = findRoot(layoutCoordinates);
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        long jMo2992localToWindowMKHz9U = layoutCoordinatesFindRoot.mo2992localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getLeft(), rectBoundsInRoot.getTop()));
        long jMo2992localToWindowMKHz9U2 = layoutCoordinatesFindRoot.mo2992localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getRight(), rectBoundsInRoot.getTop()));
        long jMo2992localToWindowMKHz9U3 = layoutCoordinatesFindRoot.mo2992localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getRight(), rectBoundsInRoot.getBottom()));
        long jMo2992localToWindowMKHz9U4 = layoutCoordinatesFindRoot.mo2992localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getLeft(), rectBoundsInRoot.getBottom()));
        return new Rect(x8.c.d(Offset.m1367getXimpl(jMo2992localToWindowMKHz9U), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U2), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U4), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U3)), x8.c.d(Offset.m1368getYimpl(jMo2992localToWindowMKHz9U), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U2), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U4), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U3)), x8.c.c(Offset.m1367getXimpl(jMo2992localToWindowMKHz9U), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U2), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U4), Offset.m1367getXimpl(jMo2992localToWindowMKHz9U3)), x8.c.c(Offset.m1368getYimpl(jMo2992localToWindowMKHz9U), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U2), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U4), Offset.m1368getYimpl(jMo2992localToWindowMKHz9U3)));
    }

    @NotNull
    public static final LayoutCoordinates findRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        t.i(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        LayoutNodeWrapper layoutNodeWrapper = layoutCoordinates2 instanceof LayoutNodeWrapper ? (LayoutNodeWrapper) layoutCoordinates2 : null;
        if (layoutNodeWrapper == null) {
            return layoutCoordinates2;
        }
        LayoutNodeWrapper wrappedBy$ui_release = layoutNodeWrapper.getWrappedBy$ui_release();
        while (true) {
            LayoutNodeWrapper layoutNodeWrapper2 = wrappedBy$ui_release;
            LayoutNodeWrapper layoutNodeWrapper3 = layoutNodeWrapper;
            layoutNodeWrapper = layoutNodeWrapper2;
            if (layoutNodeWrapper == null) {
                return layoutNodeWrapper3;
            }
            wrappedBy$ui_release = layoutNodeWrapper.getWrappedBy$ui_release();
        }
    }

    public static final long positionInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m1383getZeroF1C5BW0()) : Offset.Companion.m1383getZeroF1C5BW0();
    }

    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        return layoutCoordinates.mo2991localToRootMKHz9U(Offset.Companion.m1383getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        return layoutCoordinates.mo2992localToWindowMKHz9U(Offset.Companion.m1383getZeroF1C5BW0());
    }
}
