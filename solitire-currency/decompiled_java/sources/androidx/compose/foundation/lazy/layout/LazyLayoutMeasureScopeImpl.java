package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyLayoutMeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {

    @NotNull
    private final LazyLayoutItemContentFactory itemContentFactory;

    @NotNull
    private final HashMap<Integer, Placeable[]> placeablesCache;

    @NotNull
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(@NotNull LazyLayoutItemContentFactory itemContentFactory, @NotNull SubcomposeMeasureScope subcomposeMeasureScope) {
        t.i(itemContentFactory, "itemContentFactory");
        t.i(subcomposeMeasureScope, "subcomposeMeasureScope");
        this.itemContentFactory = itemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.placeablesCache = new HashMap<>();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(int i10, int i11, @NotNull Map<AlignmentLine, Integer> alignmentLines, @NotNull l<? super Placeable.PlacementScope, k0> placementBlock) {
        t.i(alignmentLines, "alignmentLines");
        t.i(placementBlock, "placementBlock");
        return this.subcomposeMeasureScope.layout(i10, i11, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    @NotNull
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public Placeable[] mo608measure0kLqBqw(int i10, long j10) {
        Placeable[] placeableArr = this.placeablesCache.get(Integer.valueOf(i10));
        if (placeableArr != null) {
            return placeableArr;
        }
        Object key = this.itemContentFactory.getItemProvider().invoke().getKey(i10);
        List<Measurable> listSubcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i10, key));
        int size = listSubcompose.size();
        Placeable[] placeableArr2 = new Placeable[size];
        for (int i11 = 0; i11 < size; i11++) {
            placeableArr2[i11] = listSubcompose.get(i11).mo2987measureBRTryo0(j10);
        }
        this.placeablesCache.put(Integer.valueOf(i10), placeableArr2);
        return placeableArr2;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo289roundToPxR2X_6o(long j10) {
        return this.subcomposeMeasureScope.mo289roundToPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo290roundToPx0680j_4(float f10) {
        return this.subcomposeMeasureScope.mo290roundToPx0680j_4(f10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo291toDpGaN1DYA(long j10) {
        return this.subcomposeMeasureScope.mo291toDpGaN1DYA(j10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo293toDpu2uoSUM(int i10) {
        return this.subcomposeMeasureScope.mo293toDpu2uoSUM(i10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo294toDpSizekrfVVM(long j10) {
        return this.subcomposeMeasureScope.mo294toDpSizekrfVVM(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo295toPxR2X_6o(long j10) {
        return this.subcomposeMeasureScope.mo295toPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo296toPx0680j_4(float f10) {
        return this.subcomposeMeasureScope.mo296toPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo297toSizeXkaWNTQ(long j10) {
        return this.subcomposeMeasureScope.mo297toSizeXkaWNTQ(j10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo298toSp0xMU5do(float f10) {
        return this.subcomposeMeasureScope.mo298toSp0xMU5do(f10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo299toSpkPz2Gy4(float f10) {
        return this.subcomposeMeasureScope.mo299toSpkPz2Gy4(f10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo292toDpu2uoSUM(float f10) {
        return this.subcomposeMeasureScope.mo292toDpu2uoSUM(f10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo300toSpkPz2Gy4(int i10) {
        return this.subcomposeMeasureScope.mo300toSpkPz2Gy4(i10);
    }
}
