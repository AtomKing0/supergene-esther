package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BringIntoViewResponder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidBringIntoViewParent implements BringIntoViewParent {

    @NotNull
    private final View view;

    public AndroidBringIntoViewParent(@NotNull View view) {
        t.i(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    @Nullable
    public Object bringChildIntoView(@NotNull Rect rect, @NotNull LayoutCoordinates layoutCoordinates, @NotNull d<? super k0> dVar) {
        this.view.requestRectangleOnScreen(BringIntoViewResponder_androidKt.toRect(rect.m1404translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))), false);
        return k0.f35197a;
    }
}
