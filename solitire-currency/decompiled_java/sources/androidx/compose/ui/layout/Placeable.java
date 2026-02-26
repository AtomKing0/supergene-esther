package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Placeable.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    /* JADX INFO: compiled from: Placeable.kt */
    @StabilityInferred(parameters = 0)
    public static abstract class PlacementScope {
        public static final int $stable = 0;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;
        private static int parentWidth;

        /* JADX INFO: compiled from: Placeable.kt */
        public static final class Companion extends PlacementScope {
            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final void executeWithRtlMirroringValues(int i10, @NotNull LayoutDirection parentLayoutDirection, @NotNull h9.l<? super PlacementScope, k0> block) {
                t.i(parentLayoutDirection, "parentLayoutDirection");
                t.i(block, "block");
                Companion companion = PlacementScope.Companion;
                int parentWidth = companion.getParentWidth();
                LayoutDirection parentLayoutDirection2 = companion.getParentLayoutDirection();
                PlacementScope.parentWidth = i10;
                PlacementScope.parentLayoutDirection = parentLayoutDirection;
                block.invoke(this);
                PlacementScope.parentWidth = parentWidth;
                PlacementScope.parentLayoutDirection = parentLayoutDirection2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            @NotNull
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i10, int i11, float f10, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i12 & 4) != 0) {
                f10 = 0.0f;
            }
            placementScope.place(placeable, i10, i11, f10);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m3017place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j10, float f10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i10 & 2) != 0) {
                f10 = 0.0f;
            }
            placementScope.m3021place70tqf50(placeable, j10, f10);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i10, int i11, float f10, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i12 & 4) != 0) {
                f10 = 0.0f;
            }
            placementScope.placeRelative(placeable, i10, i11, f10);
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m3018placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j10, float f10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i10 & 2) != 0) {
                f10 = 0.0f;
            }
            placementScope.m3024placeRelative70tqf50(placeable, j10, f10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i10, int i11, float f10, h9.l lVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i12 & 4) != 0) {
                f10 = 0.0f;
            }
            float f11 = f10;
            if ((i12 & 8) != 0) {
                lVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i10, i11, f11, lVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m3019placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j10, float f10, h9.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i10 & 2) != 0) {
                f10 = 0.0f;
            }
            float f11 = f10;
            if ((i10 & 4) != 0) {
                lVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m3025placeRelativeWithLayeraW9wM(placeable, j10, f11, lVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i10, int i11, float f10, h9.l lVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i12 & 4) != 0) {
                f10 = 0.0f;
            }
            float f11 = f10;
            if ((i12 & 8) != 0) {
                lVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i10, i11, f11, lVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m3020placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j10, float f10, h9.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i10 & 2) != 0) {
                f10 = 0.0f;
            }
            float f11 = f10;
            if ((i10 & 4) != 0) {
                lVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m3026placeWithLayeraW9wM(placeable, j10, f11, lVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public abstract LayoutDirection getParentLayoutDirection();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getParentWidth();

        public final void place(@NotNull Placeable placeable, int i10, int i11, float f10) {
            t.i(placeable, "<this>");
            long jIntOffset = IntOffsetKt.IntOffset(i10, i11);
            long jM3012getApparentToRealOffsetnOccac = placeable.m3012getApparentToRealOffsetnOccac();
            placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, null);
        }

        /* JADX INFO: renamed from: place-70tqf50, reason: not valid java name */
        public final void m3021place70tqf50(@NotNull Placeable place, long j10, float f10) {
            t.i(place, "$this$place");
            long jM3012getApparentToRealOffsetnOccac = place.m3012getApparentToRealOffsetnOccac();
            place.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, null);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m3022placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeApparentToRealOffset, long j10, float f10, @Nullable h9.l<? super GraphicsLayerScope, k0> lVar) {
            t.i(placeApparentToRealOffset, "$this$placeApparentToRealOffset");
            long jM3012getApparentToRealOffsetnOccac = placeApparentToRealOffset.m3012getApparentToRealOffsetnOccac();
            placeApparentToRealOffset.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, lVar);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m3023placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeAutoMirrored, long j10, float f10, @Nullable h9.l<? super GraphicsLayerScope, k0> lVar) {
            t.i(placeAutoMirrored, "$this$placeAutoMirrored");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long jM3012getApparentToRealOffsetnOccac = placeAutoMirrored.m3012getApparentToRealOffsetnOccac();
                placeAutoMirrored.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, lVar);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m3833getWidthimpl(placeAutoMirrored.measuredSize)) - IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10));
                long jM3012getApparentToRealOffsetnOccac2 = placeAutoMirrored.m3012getApparentToRealOffsetnOccac();
                placeAutoMirrored.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac2), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac2)), f10, lVar);
            }
        }

        public final void placeRelative(@NotNull Placeable placeable, int i10, int i11, float f10) {
            t.i(placeable, "<this>");
            long jIntOffset = IntOffsetKt.IntOffset(i10, i11);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long jM3012getApparentToRealOffsetnOccac = placeable.m3012getApparentToRealOffsetnOccac();
                placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, null);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m3833getWidthimpl(placeable.measuredSize)) - IntOffset.m3791getXimpl(jIntOffset), IntOffset.m3792getYimpl(jIntOffset));
                long jM3012getApparentToRealOffsetnOccac2 = placeable.m3012getApparentToRealOffsetnOccac();
                placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset2) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac2), IntOffset.m3792getYimpl(jIntOffset2) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac2)), f10, null);
            }
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m3024placeRelative70tqf50(@NotNull Placeable placeRelative, long j10, float f10) {
            t.i(placeRelative, "$this$placeRelative");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long jM3012getApparentToRealOffsetnOccac = placeRelative.m3012getApparentToRealOffsetnOccac();
                placeRelative.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, null);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m3833getWidthimpl(placeRelative.measuredSize)) - IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10));
                long jM3012getApparentToRealOffsetnOccac2 = placeRelative.m3012getApparentToRealOffsetnOccac();
                placeRelative.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac2), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac2)), f10, null);
            }
        }

        public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i10, int i11, float f10, @NotNull h9.l<? super GraphicsLayerScope, k0> layerBlock) {
            t.i(placeable, "<this>");
            t.i(layerBlock, "layerBlock");
            long jIntOffset = IntOffsetKt.IntOffset(i10, i11);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long jM3012getApparentToRealOffsetnOccac = placeable.m3012getApparentToRealOffsetnOccac();
                placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, layerBlock);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m3833getWidthimpl(placeable.measuredSize)) - IntOffset.m3791getXimpl(jIntOffset), IntOffset.m3792getYimpl(jIntOffset));
                long jM3012getApparentToRealOffsetnOccac2 = placeable.m3012getApparentToRealOffsetnOccac();
                placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset2) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac2), IntOffset.m3792getYimpl(jIntOffset2) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac2)), f10, layerBlock);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m3025placeRelativeWithLayeraW9wM(@NotNull Placeable placeRelativeWithLayer, long j10, float f10, @NotNull h9.l<? super GraphicsLayerScope, k0> layerBlock) {
            t.i(placeRelativeWithLayer, "$this$placeRelativeWithLayer");
            t.i(layerBlock, "layerBlock");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long jM3012getApparentToRealOffsetnOccac = placeRelativeWithLayer.m3012getApparentToRealOffsetnOccac();
                placeRelativeWithLayer.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, layerBlock);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m3833getWidthimpl(placeRelativeWithLayer.measuredSize)) - IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10));
                long jM3012getApparentToRealOffsetnOccac2 = placeRelativeWithLayer.m3012getApparentToRealOffsetnOccac();
                placeRelativeWithLayer.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac2), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac2)), f10, layerBlock);
            }
        }

        public final void placeWithLayer(@NotNull Placeable placeable, int i10, int i11, float f10, @NotNull h9.l<? super GraphicsLayerScope, k0> layerBlock) {
            t.i(placeable, "<this>");
            t.i(layerBlock, "layerBlock");
            long jIntOffset = IntOffsetKt.IntOffset(i10, i11);
            long jM3012getApparentToRealOffsetnOccac = placeable.m3012getApparentToRealOffsetnOccac();
            placeable.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, layerBlock);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m3026placeWithLayeraW9wM(@NotNull Placeable placeWithLayer, long j10, float f10, @NotNull h9.l<? super GraphicsLayerScope, k0> layerBlock) {
            t.i(placeWithLayer, "$this$placeWithLayer");
            t.i(layerBlock, "layerBlock");
            long jM3012getApparentToRealOffsetnOccac = placeWithLayer.m3012getApparentToRealOffsetnOccac();
            placeWithLayer.mo2988placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(j10) + IntOffset.m3791getXimpl(jM3012getApparentToRealOffsetnOccac), IntOffset.m3792getYimpl(j10) + IntOffset.m3792getYimpl(jM3012getApparentToRealOffsetnOccac)), f10, layerBlock);
        }
    }

    private final void recalculateWidthAndHeight() {
        this.width = o.n(IntSize.m3833getWidthimpl(this.measuredSize), Constraints.m3643getMinWidthimpl(this.measurementConstraints), Constraints.m3641getMaxWidthimpl(this.measurementConstraints));
        this.height = o.n(IntSize.m3832getHeightimpl(this.measuredSize), Constraints.m3642getMinHeightimpl(this.measurementConstraints), Constraints.m3640getMaxHeightimpl(this.measurementConstraints));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public final long m3012getApparentToRealOffsetnOccac() {
        return IntOffsetKt.IntOffset((this.width - IntSize.m3833getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m3832getHeightimpl(this.measuredSize)) / 2);
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return IntSize.m3832getHeightimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g, reason: not valid java name */
    protected final long m3013getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return IntSize.m3833getWidthimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name */
    protected final long m3014getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    @Override // androidx.compose.ui.layout.Measured
    public /* synthetic */ Object getParentData() {
        return e.a(this);
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo2988placeAtf8xVGno(long j10, float f10, @Nullable h9.l<? super GraphicsLayerScope, k0> lVar);

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    protected final void m3015setMeasuredSizeozmzZPI(long j10) {
        if (IntSize.m3831equalsimpl0(this.measuredSize, j10)) {
            return;
        }
        this.measuredSize = j10;
        recalculateWidthAndHeight();
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    protected final void m3016setMeasurementConstraintsBRTryo0(long j10) {
        if (Constraints.m3634equalsimpl0(this.measurementConstraints, j10)) {
            return;
        }
        this.measurementConstraints = j10;
        recalculateWidthAndHeight();
    }
}
