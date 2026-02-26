package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: MeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: MeasureScope.kt */
    public final /* synthetic */ class CC {
        @NotNull
        public static MeasureResult a(MeasureScope measureScope, int i10, int i11, @NotNull Map alignmentLines, @NotNull h9.l placementBlock) {
            t.i(alignmentLines, "alignmentLines");
            t.i(placementBlock, "placementBlock");
            return new MeasureResult(i10, i11, alignmentLines, measureScope, placementBlock) { // from class: androidx.compose.ui.layout.MeasureScope.layout.1
                final /* synthetic */ h9.l<Placeable.PlacementScope, k0> $placementBlock;
                final /* synthetic */ int $width;

                @NotNull
                private final Map<AlignmentLine, Integer> alignmentLines;
                private final int height;
                final /* synthetic */ MeasureScope this$0;
                private final int width;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$width = i10;
                    this.this$0 = measureScope;
                    this.$placementBlock = placementBlock;
                    this.width = i10;
                    this.height = i11;
                    this.alignmentLines = alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                @NotNull
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                    int i12 = this.$width;
                    LayoutDirection layoutDirection = this.this$0.getLayoutDirection();
                    h9.l<Placeable.PlacementScope, k0> lVar = this.$placementBlock;
                    int parentWidth = companion.getParentWidth();
                    LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                    Placeable.PlacementScope.parentWidth = i12;
                    Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
                    lVar.invoke(companion);
                    Placeable.PlacementScope.parentWidth = parentWidth;
                    Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MeasureResult p(MeasureScope measureScope, int i10, int i11, Map map, h9.l lVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
            }
            if ((i12 & 4) != 0) {
                map = r0.g();
            }
            return measureScope.layout(i10, i11, map, lVar);
        }
    }

    /* JADX INFO: compiled from: MeasureScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i10, int i11, @NotNull Map<AlignmentLine, Integer> alignmentLines, @NotNull h9.l<? super Placeable.PlacementScope, k0> placementBlock) {
            t.i(alignmentLines, "alignmentLines");
            t.i(placementBlock, "placementBlock");
            return CC.a(measureScope, i10, i11, alignmentLines, placementBlock);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2997roundToPxR2X_6o(@NotNull MeasureScope measureScope, long j10) {
            return androidx.compose.ui.unit.a.a(measureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2998roundToPx0680j_4(@NotNull MeasureScope measureScope, float f10) {
            return androidx.compose.ui.unit.a.b(measureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2999toDpGaN1DYA(@NotNull MeasureScope measureScope, long j10) {
            return androidx.compose.ui.unit.a.c(measureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3000toDpu2uoSUM(@NotNull MeasureScope measureScope, float f10) {
            return androidx.compose.ui.unit.a.d(measureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3002toDpSizekrfVVM(@NotNull MeasureScope measureScope, long j10) {
            return androidx.compose.ui.unit.a.f(measureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3003toPxR2X_6o(@NotNull MeasureScope measureScope, long j10) {
            return androidx.compose.ui.unit.a.g(measureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3004toPx0680j_4(@NotNull MeasureScope measureScope, float f10) {
            return androidx.compose.ui.unit.a.h(measureScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull MeasureScope measureScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(measureScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3005toSizeXkaWNTQ(@NotNull MeasureScope measureScope, long j10) {
            return androidx.compose.ui.unit.a.j(measureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3006toSp0xMU5do(@NotNull MeasureScope measureScope, float f10) {
            return androidx.compose.ui.unit.a.k(measureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3007toSpkPz2Gy4(@NotNull MeasureScope measureScope, float f10) {
            return androidx.compose.ui.unit.a.l(measureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3001toDpu2uoSUM(@NotNull MeasureScope measureScope, int i10) {
            return androidx.compose.ui.unit.a.e(measureScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3008toSpkPz2Gy4(@NotNull MeasureScope measureScope, int i10) {
            return androidx.compose.ui.unit.a.m(measureScope, i10);
        }
    }

    @NotNull
    MeasureResult layout(int i10, int i11, @NotNull Map<AlignmentLine, Integer> map, @NotNull h9.l<? super Placeable.PlacementScope, k0> lVar);
}
