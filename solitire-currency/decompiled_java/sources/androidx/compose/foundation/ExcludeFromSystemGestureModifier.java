package androidx.compose.foundation;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemGestureExclusion.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
final class ExcludeFromSystemGestureModifier implements OnGloballyPositionedModifier {

    @Nullable
    private final h9.l<LayoutCoordinates, Rect> exclusion;

    @Nullable
    private android.graphics.Rect rect;

    @NotNull
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public ExcludeFromSystemGestureModifier(@NotNull View view, @Nullable h9.l<? super LayoutCoordinates, Rect> lVar) {
        t.i(view, "view");
        this.view = view;
        this.exclusion = lVar;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect) {
        LayoutCoordinates layoutCoordinatesFindRoot = findRoot(layoutCoordinates);
        long jMo2990localPositionOfR5De75A = layoutCoordinatesFindRoot.mo2990localPositionOfR5De75A(layoutCoordinates, rect.m1402getTopLeftF1C5BW0());
        long jMo2990localPositionOfR5De75A2 = layoutCoordinatesFindRoot.mo2990localPositionOfR5De75A(layoutCoordinates, rect.m1403getTopRightF1C5BW0());
        long jMo2990localPositionOfR5De75A3 = layoutCoordinatesFindRoot.mo2990localPositionOfR5De75A(layoutCoordinates, rect.m1395getBottomLeftF1C5BW0());
        long jMo2990localPositionOfR5De75A4 = layoutCoordinatesFindRoot.mo2990localPositionOfR5De75A(layoutCoordinates, rect.m1396getBottomRightF1C5BW0());
        return new android.graphics.Rect(j9.c.c(x8.c.d(Offset.m1367getXimpl(jMo2990localPositionOfR5De75A), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A2), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A3), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A4))), j9.c.c(x8.c.d(Offset.m1368getYimpl(jMo2990localPositionOfR5De75A), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A2), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A3), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A4))), j9.c.c(x8.c.c(Offset.m1367getXimpl(jMo2990localPositionOfR5De75A), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A2), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A3), Offset.m1367getXimpl(jMo2990localPositionOfR5De75A4))), j9.c.c(x8.c.c(Offset.m1368getYimpl(jMo2990localPositionOfR5De75A), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A2), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A3), Offset.m1368getYimpl(jMo2990localPositionOfR5De75A4))));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates2 = parentLayoutCoordinates;
            LayoutCoordinates layoutCoordinates3 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates2;
            if (layoutCoordinates == null) {
                return layoutCoordinates3;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Nullable
    public final h9.l<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    @Nullable
    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        h9.l<LayoutCoordinates, Rect> lVar = this.exclusion;
        replaceRect(lVar == null ? RectHelper_androidKt.toAndroidRect(LayoutCoordinatesKt.boundsInRoot(coordinates)) : calcBounds(coordinates, lVar.invoke(coordinates)));
    }

    public final void removeRect() {
        replaceRect(null);
    }

    public final void replaceRect(@Nullable android.graphics.Rect rect) {
        boolean z10 = false;
        MutableVector mutableVector = new MutableVector(new android.graphics.Rect[16], 0);
        List systemGestureExclusionRects = this.view.getSystemGestureExclusionRects();
        t.h(systemGestureExclusionRects, "view.systemGestureExclusionRects");
        mutableVector.addAll(mutableVector.getSize(), systemGestureExclusionRects);
        android.graphics.Rect rect2 = this.rect;
        if (rect2 != null) {
            mutableVector.remove(rect2);
        }
        if (rect != null && !rect.isEmpty()) {
            z10 = true;
        }
        if (z10) {
            mutableVector.add(rect);
        }
        this.view.setSystemGestureExclusionRects(mutableVector.asMutableList());
        this.rect = rect;
    }

    public final void setRect(@Nullable android.graphics.Rect rect) {
        this.rect = rect;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
