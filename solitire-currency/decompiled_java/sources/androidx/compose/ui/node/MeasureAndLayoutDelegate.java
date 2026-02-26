package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MeasureAndLayoutDelegate {

    @Nullable
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private long measureIteration;

    @NotNull
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners;

    @NotNull
    private final OnPositionedDispatcher onPositionedDispatcher;

    @NotNull
    private final List<LayoutNode> postponedMeasureRequests;

    @NotNull
    private final DepthSortedSet relayoutNodes;

    @NotNull
    private final LayoutNode root;

    @Nullable
    private Constraints rootConstraints;

    /* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            iArr[LayoutNode.LayoutState.Idle.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(@NotNull LayoutNode root) {
        t.i(root, "root");
        this.root = root;
        Owner.Companion companion = Owner.Companion;
        DepthSortedSet depthSortedSet = new DepthSortedSet(companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSet;
        this.onPositionedDispatcher = new OnPositionedDispatcher();
        this.onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
        this.measureIteration = 1L;
        ArrayList arrayList = new ArrayList();
        this.postponedMeasureRequests = arrayList;
        this.consistencyChecker = companion.getEnableExtraAssertions() ? new LayoutTreeConsistencyChecker(root, depthSortedSet, arrayList) : null;
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Owner.OnLayoutCompletedListener[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].onLayoutComplete();
                i10++;
            } while (i10 < size);
        }
        this.onLayoutCompletedListeners.clear();
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z10);
    }

    /* JADX INFO: renamed from: doRemeasure-sdFAvZA, reason: not valid java name */
    private final boolean m3135doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean zM3103remeasure_Sx5XlM$ui_release = constraints != null ? layoutNode.m3103remeasure_Sx5XlM$ui_release(constraints) : LayoutNode.m3099remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (zM3103remeasure_Sx5XlM$ui_release && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure$default(this, parent$ui_release, false, 2, null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout$default(this, parent$ui_release, false, 2, null);
            }
        }
        return zM3103remeasure_Sx5XlM$ui_release;
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getMeasurePending$ui_release() && (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getAlignmentLines$ui_release().getRequired$ui_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(aVar);
    }

    private final void performMeasureAndLayout(h9.a<k0> aVar) {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                aVar.invoke();
                r.b(1);
                this.duringMeasureLayout = false;
                r.a(1);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                r.b(1);
                this.duringMeasureLayout = false;
                r.a(1);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode) {
        boolean zM3135doRemeasuresdFAvZA;
        Constraints constraints;
        if (!layoutNode.isPlaced() && !getCanAffectParent(layoutNode) && !layoutNode.getAlignmentLines$ui_release().getRequired$ui_release()) {
            return false;
        }
        if (layoutNode.getMeasurePending$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                t.f(constraints);
            } else {
                constraints = null;
            }
            zM3135doRemeasuresdFAvZA = m3135doRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            zM3135doRemeasuresdFAvZA = false;
        }
        if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
            if (layoutNode == this.root) {
                layoutNode.place$ui_release(0, 0);
            } else {
                layoutNode.replace$ui_release();
            }
            this.onPositionedDispatcher.onNodePositioned(layoutNode);
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        }
        if (!this.postponedMeasureRequests.isEmpty()) {
            List<LayoutNode> list = this.postponedMeasureRequests;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                LayoutNode layoutNode2 = list.get(i10);
                if (layoutNode2.isAttached()) {
                    requestRemeasure$default(this, layoutNode2, false, 2, null);
                }
            }
            this.postponedMeasureRequests.clear();
        }
        return zM3135doRemeasuresdFAvZA;
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z10);
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z10);
    }

    public final void dispatchOnPositionedCallbacks(boolean z10) {
        if (z10) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "layoutNode");
        if (this.relayoutNodes.isEmpty()) {
            return;
        }
        if (!this.duringMeasureLayout) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(!layoutNode.getMeasurePending$ui_release())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode2 = content[i10];
                if (layoutNode2.getMeasurePending$ui_release() && this.relayoutNodes.remove(layoutNode2)) {
                    remeasureAndRelayoutIfNeeded(layoutNode2);
                }
                if (!layoutNode2.getMeasurePending$ui_release()) {
                    forceMeasureTheSubtree(layoutNode2);
                }
                i10++;
            } while (i10 < size);
        }
        if (layoutNode.getMeasurePending$ui_release() && this.relayoutNodes.remove(layoutNode)) {
            remeasureAndRelayoutIfNeeded(layoutNode);
        }
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return !this.relayoutNodes.isEmpty();
    }

    public final long getMeasureIteration() {
        if (this.duringMeasureLayout) {
            return this.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    public final boolean measureAndLayout(@Nullable h9.a<k0> aVar) {
        boolean z10;
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        boolean z11 = false;
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                if (!this.relayoutNodes.isEmpty()) {
                    DepthSortedSet depthSortedSet = this.relayoutNodes;
                    z10 = false;
                    while (!depthSortedSet.isEmpty()) {
                        LayoutNode layoutNodePop = depthSortedSet.pop();
                        boolean zRemeasureAndRelayoutIfNeeded = remeasureAndRelayoutIfNeeded(layoutNodePop);
                        if (layoutNodePop == this.root && zRemeasureAndRelayoutIfNeeded) {
                            z10 = true;
                        }
                    }
                    if (aVar != null) {
                        aVar.invoke();
                    }
                } else {
                    z10 = false;
                }
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                z11 = z10;
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
        return z11;
    }

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m3136measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j10) {
        t.i(layoutNode, "layoutNode");
        if (!(!t.d(layoutNode, this.root))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                this.relayoutNodes.remove(layoutNode);
                m3135doRemeasuresdFAvZA(layoutNode, Constraints.m3629boximpl(j10));
                if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                    layoutNode.replace$ui_release();
                    this.onPositionedDispatcher.onNodePositioned(layoutNode);
                }
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
    }

    public final void onNodeDetached(@NotNull LayoutNode node) {
        t.i(node, "node");
        this.relayoutNodes.remove(node);
    }

    public final void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener listener) {
        t.i(listener, "listener");
        this.onLayoutCompletedListeners.add(listener);
    }

    public final boolean requestRelayout(@NotNull LayoutNode layoutNode, boolean z10) {
        t.i(layoutNode, "layoutNode");
        int i10 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i10 == 1 || i10 == 2) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        } else {
            if (i10 != 3) {
                throw new q();
            }
            if ((layoutNode.getMeasurePending$ui_release() || layoutNode.getLayoutPending$ui_release()) && !z10) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                if (layoutTreeConsistencyChecker2 != null) {
                    layoutTreeConsistencyChecker2.assertConsistent();
                }
            } else {
                layoutNode.markLayoutPending$ui_release();
                if (layoutNode.isPlaced()) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if (!(parent$ui_release != null && parent$ui_release.getLayoutPending$ui_release())) {
                        if (!(parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release())) {
                            this.relayoutNodes.add(layoutNode);
                        }
                    }
                }
                if (!this.duringMeasureLayout) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean requestRemeasure(@NotNull LayoutNode layoutNode, boolean z10) {
        t.i(layoutNode, "layoutNode");
        int i10 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                this.postponedMeasureRequests.add(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else {
                if (i10 != 3) {
                    throw new q();
                }
                if (!layoutNode.getMeasurePending$ui_release() || z10) {
                    layoutNode.markMeasurePending$ui_release();
                    if (layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (!(parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release())) {
                            this.relayoutNodes.add(layoutNode);
                        }
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: updateRootConstraints-BRTryo0, reason: not valid java name */
    public final void m3137updateRootConstraintsBRTryo0(long j10) {
        Constraints constraints = this.rootConstraints;
        if (constraints == null ? false : Constraints.m3634equalsimpl0(constraints.m3647unboximpl(), j10)) {
            return;
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.rootConstraints = Constraints.m3629boximpl(j10);
        this.root.markMeasurePending$ui_release();
        this.relayoutNodes.add(this.root);
    }
}
