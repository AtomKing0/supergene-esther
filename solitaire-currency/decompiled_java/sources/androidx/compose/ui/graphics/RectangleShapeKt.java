package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RectangleShape.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RectangleShapeKt {

    @NotNull
    private static final Shape RectangleShape = new Shape() { // from class: androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1
        @NotNull
        public String toString() {
            return "RectangleShape";
        }

        @Override // androidx.compose.ui.graphics.Shape
        @NotNull
        /* JADX INFO: renamed from: createOutline-Pq9zytI */
        public Outline.Rectangle mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            kotlin.jvm.internal.t.i(layoutDirection, "layoutDirection");
            kotlin.jvm.internal.t.i(density, "density");
            return new Outline.Rectangle(SizeKt.m1457toRectuvyYCjk(j10));
        }
    };

    @NotNull
    public static final Shape getRectangleShape() {
        return RectangleShape;
    }

    @Stable
    public static /* synthetic */ void getRectangleShape$annotations() {
    }
}
