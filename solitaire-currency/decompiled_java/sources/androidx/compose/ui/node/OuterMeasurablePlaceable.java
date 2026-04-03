package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OuterMeasurablePlaceable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OuterMeasurablePlaceable extends Placeable implements Measurable {
    private boolean duringAlignmentLinesQuery;

    @Nullable
    private l<? super GraphicsLayerScope, k0> lastLayerBlock;
    private long lastPosition;
    private float lastZIndex;

    @NotNull
    private final LayoutNode layoutNode;
    private boolean measuredOnce;

    @NotNull
    private LayoutNodeWrapper outerWrapper;

    @Nullable
    private Object parentData;
    private boolean placedOnce;

    /* JADX INFO: compiled from: OuterMeasurablePlaceable.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public OuterMeasurablePlaceable(@NotNull LayoutNode layoutNode, @NotNull LayoutNodeWrapper outerWrapper) {
        t.i(layoutNode, "layoutNode");
        t.i(outerWrapper, "outerWrapper");
        this.layoutNode = layoutNode;
        this.outerWrapper = outerWrapper;
        this.lastPosition = IntOffset.Companion.m3801getZeronOccac();
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.requestRemeasure$ui_release$default(this.layoutNode, false, 1, null);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release == null || this.layoutNode.getIntrinsicsUsageByParent$ui_release() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = this.layoutNode;
        int i10 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        layoutNode.setIntrinsicsUsageByParent$ui_release(i10 != 1 ? i10 != 2 ? parent$ui_release.getIntrinsicsUsageByParent$ui_release() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeOuterWrapper-f8xVGno, reason: not valid java name */
    public final void m3139placeOuterWrapperf8xVGno(long j10, float f10, l<? super GraphicsLayerScope, k0> lVar) {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        if (lVar == null) {
            companion.m3021place70tqf50(this.outerWrapper, j10, f10);
        } else {
            companion.m3026placeWithLayeraW9wM(this.outerWrapper, j10, f10, lVar);
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(@NotNull AlignmentLine alignmentLine) {
        t.i(alignmentLine, "alignmentLine");
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
            this.layoutNode.getAlignmentLines$ui_release().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                this.layoutNode.getAlignmentLines$ui_release().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i10 = this.outerWrapper.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i10;
    }

    public final boolean getDuringAlignmentLinesQuery$ui_release() {
        return this.duringAlignmentLinesQuery;
    }

    @Nullable
    /* JADX INFO: renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m3140getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m3629boximpl(m3014getMeasurementConstraintsmsEJaDk());
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return this.outerWrapper.getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return this.outerWrapper.getMeasuredWidth();
    }

    @NotNull
    public final LayoutNodeWrapper getOuterWrapper() {
        return this.outerWrapper;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    @Nullable
    public Object getParentData() {
        return this.parentData;
    }

    public final void invalidateIntrinsicsParent(boolean z10) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = this.layoutNode.getIntrinsicsUsageByParent$ui_release();
        if (parent$ui_release2 == null || intrinsicsUsageByParent$ui_release == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
            parent$ui_release2 = parent$ui_release;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
        if (i10 == 1) {
            parent$ui_release2.requestRemeasure$ui_release(z10);
        } else {
            if (i10 != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
            }
            parent$ui_release2.requestRelayout$ui_release(z10);
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i10) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i10) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.Measurable
    @NotNull
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo2987measureBRTryo0(long j10) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            if (!(this.layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.NotUsed || this.layoutNode.getCanMultiMeasure$ui_release())) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + this.layoutNode.getMeasuredByParent$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + '.').toString());
            }
            LayoutNode layoutNode = this.layoutNode;
            int i10 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i10 == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block.Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            layoutNode.setMeasuredByParent$ui_release(usageByParent);
        } else {
            this.layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
        m3141remeasureBRTryo0(j10);
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i10) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i10) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicWidth(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo2988placeAtf8xVGno(long j10, float f10, @Nullable l<? super GraphicsLayerScope, k0> lVar) {
        this.lastPosition = j10;
        this.lastZIndex = f10;
        this.lastLayerBlock = lVar;
        LayoutNodeWrapper wrappedBy$ui_release = this.outerWrapper.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null && wrappedBy$ui_release.isShallowPlacing()) {
            m3139placeOuterWrapperf8xVGno(j10, f10, lVar);
            return;
        }
        this.placedOnce = true;
        this.layoutNode.getAlignmentLines$ui_release().setUsedByModifierLayout$ui_release(false);
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(this.layoutNode, new OuterMeasurablePlaceable$placeAt$1(this, j10, f10, lVar));
    }

    public final void recalculateParentData() {
        this.parentData = this.outerWrapper.getParentData();
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m3141remeasureBRTryo0(long j10) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(this.layoutNode);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        LayoutNode layoutNode = this.layoutNode;
        boolean z10 = true;
        layoutNode.setCanMultiMeasure$ui_release(layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
        if (!this.layoutNode.getMeasurePending$ui_release() && Constraints.m3634equalsimpl0(m3014getMeasurementConstraintsmsEJaDk(), j10)) {
            ownerRequireOwner.forceMeasureTheSubtree(this.layoutNode);
            this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
            return false;
        }
        this.layoutNode.getAlignmentLines$ui_release().setUsedByModifierMeasurement$ui_release(false);
        MutableVector<LayoutNode> mutableVector = this.layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].getAlignmentLines$ui_release().setUsedDuringParentMeasurement$ui_release(false);
                i10++;
            } while (i10 < size);
        }
        this.measuredOnce = true;
        long jMo2989getSizeYbymL2g = this.outerWrapper.mo2989getSizeYbymL2g();
        m3016setMeasurementConstraintsBRTryo0(j10);
        this.layoutNode.m3102performMeasureBRTryo0$ui_release(j10);
        if (IntSize.m3831equalsimpl0(this.outerWrapper.mo2989getSizeYbymL2g(), jMo2989getSizeYbymL2g) && this.outerWrapper.getWidth() == getWidth() && this.outerWrapper.getHeight() == getHeight()) {
            z10 = false;
        }
        m3015setMeasuredSizeozmzZPI(IntSizeKt.IntSize(this.outerWrapper.getWidth(), this.outerWrapper.getHeight()));
        return z10;
    }

    public final void replace() {
        if (!this.placedOnce) {
            throw new IllegalStateException("Check failed.".toString());
        }
        mo2988placeAtf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
    }

    public final void setDuringAlignmentLinesQuery$ui_release(boolean z10) {
        this.duringAlignmentLinesQuery = z10;
    }

    public final void setOuterWrapper(@NotNull LayoutNodeWrapper layoutNodeWrapper) {
        t.i(layoutNodeWrapper, "<set-?>");
        this.outerWrapper = layoutNodeWrapper;
    }
}
