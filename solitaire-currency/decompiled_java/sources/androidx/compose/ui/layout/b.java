package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Rect a(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z10);
    }
}
