package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ClipScrollableContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClipScrollableContainerKt {

    @NotNull
    private static final Modifier HorizontalScrollableClipModifier;
    private static final float MaxSupportedElevation = Dp.m3673constructorimpl(30);

    @NotNull
    private static final Modifier VerticalScrollableClipModifier;

    static {
        Modifier.Companion companion = Modifier.Companion;
        HorizontalScrollableClipModifier = ClipKt.clip(companion, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$HorizontalScrollableClipModifier$1
            @Override // androidx.compose.ui.graphics.Shape
            @NotNull
            /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
            public Outline mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
                t.i(layoutDirection, "layoutDirection");
                t.i(density, "density");
                float fMo290roundToPx0680j_4 = density.mo290roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
                return new Outline.Rectangle(new Rect(0.0f, -fMo290roundToPx0680j_4, Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10) + fMo290roundToPx0680j_4));
            }
        });
        VerticalScrollableClipModifier = ClipKt.clip(companion, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$VerticalScrollableClipModifier$1
            @Override // androidx.compose.ui.graphics.Shape
            @NotNull
            /* JADX INFO: renamed from: createOutline-Pq9zytI */
            public Outline mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
                t.i(layoutDirection, "layoutDirection");
                t.i(density, "density");
                float fMo290roundToPx0680j_4 = density.mo290roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
                return new Outline.Rectangle(new Rect(-fMo290roundToPx0680j_4, 0.0f, Size.m1436getWidthimpl(j10) + fMo290roundToPx0680j_4, Size.m1433getHeightimpl(j10)));
            }
        });
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier clipScrollableContainer(@NotNull Modifier modifier, @NotNull Orientation orientation) {
        t.i(modifier, "<this>");
        t.i(orientation, "orientation");
        return modifier.then(orientation == Orientation.Vertical ? VerticalScrollableClipModifier : HorizontalScrollableClipModifier);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }
}
