package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import j9.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayoutNodeAlignmentLines.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeAlignmentLines {

    @NotNull
    private final Map<AlignmentLine, Integer> alignmentLines;
    private boolean dirty;

    @NotNull
    private final LayoutNode layoutNode;
    private boolean previousUsedDuringParentLayout;

    @Nullable
    private LayoutNode queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;

    public LayoutNodeAlignmentLines(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.dirty = true;
        this.alignmentLines = new HashMap();
    }

    private static final void recalculate$addAlignmentLine(LayoutNodeAlignmentLines layoutNodeAlignmentLines, AlignmentLine alignmentLine, int i10, LayoutNodeWrapper layoutNodeWrapper) {
        float f10 = i10;
        long jOffset = OffsetKt.Offset(f10, f10);
        while (true) {
            jOffset = layoutNodeWrapper.m3131toParentPositionMKHz9U(jOffset);
            layoutNodeWrapper = layoutNodeWrapper.getWrappedBy$ui_release();
            t.f(layoutNodeWrapper);
            if (t.d(layoutNodeWrapper, layoutNodeAlignmentLines.layoutNode.getInnerLayoutNodeWrapper$ui_release())) {
                break;
            } else if (layoutNodeWrapper.getMeasureResult().getAlignmentLines().containsKey(alignmentLine)) {
                float f11 = layoutNodeWrapper.get(alignmentLine);
                jOffset = OffsetKt.Offset(f11, f11);
            }
        }
        int iC = alignmentLine instanceof HorizontalAlignmentLine ? c.c(Offset.m1368getYimpl(jOffset)) : c.c(Offset.m1367getXimpl(jOffset));
        Map<AlignmentLine, Integer> map = layoutNodeAlignmentLines.alignmentLines;
        if (map.containsKey(alignmentLine)) {
            iC = AlignmentLineKt.merge(alignmentLine, ((Number) r0.h(layoutNodeAlignmentLines.alignmentLines, alignmentLine)).intValue(), iC);
        }
        map.put(alignmentLine, Integer.valueOf(iC));
    }

    public final boolean getDirty$ui_release() {
        return this.dirty;
    }

    @NotNull
    public final Map<AlignmentLine, Integer> getLastCalculation() {
        return this.alignmentLines;
    }

    public final boolean getPreviousUsedDuringParentLayout$ui_release() {
        return this.previousUsedDuringParentLayout;
    }

    public final boolean getQueried$ui_release() {
        return this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout;
    }

    public final boolean getRequired$ui_release() {
        recalculateQueryOwner$ui_release();
        return this.queryOwner != null;
    }

    public final boolean getUsedByModifierLayout$ui_release() {
        return this.usedByModifierLayout;
    }

    public final boolean getUsedByModifierMeasurement$ui_release() {
        return this.usedByModifierMeasurement;
    }

    public final boolean getUsedDuringParentLayout$ui_release() {
        return this.usedDuringParentLayout;
    }

    public final boolean getUsedDuringParentMeasurement$ui_release() {
        return this.usedDuringParentMeasurement;
    }

    public final void recalculate() {
        this.alignmentLines.clear();
        MutableVector<LayoutNode> mutableVector = this.layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.isPlaced()) {
                    if (layoutNode.getAlignmentLines$ui_release().dirty) {
                        layoutNode.layoutChildren$ui_release();
                    }
                    for (Map.Entry<AlignmentLine, Integer> entry : layoutNode.getAlignmentLines$ui_release().alignmentLines.entrySet()) {
                        recalculate$addAlignmentLine(this, entry.getKey(), entry.getValue().intValue(), layoutNode.getInnerLayoutNodeWrapper$ui_release());
                    }
                    LayoutNodeWrapper wrappedBy$ui_release = layoutNode.getInnerLayoutNodeWrapper$ui_release().getWrappedBy$ui_release();
                    t.f(wrappedBy$ui_release);
                    while (!t.d(wrappedBy$ui_release, this.layoutNode.getInnerLayoutNodeWrapper$ui_release())) {
                        for (AlignmentLine alignmentLine : wrappedBy$ui_release.getMeasureResult().getAlignmentLines().keySet()) {
                            recalculate$addAlignmentLine(this, alignmentLine, wrappedBy$ui_release.get(alignmentLine), wrappedBy$ui_release);
                        }
                        wrappedBy$ui_release = wrappedBy$ui_release.getWrappedBy$ui_release();
                        t.f(wrappedBy$ui_release);
                    }
                }
                i10++;
            } while (i10 < size);
        }
        this.alignmentLines.putAll(this.layoutNode.getInnerLayoutNodeWrapper$ui_release().getMeasureResult().getAlignmentLines());
        this.dirty = false;
    }

    public final void recalculateQueryOwner$ui_release() {
        LayoutNode layoutNode;
        LayoutNodeAlignmentLines alignmentLines$ui_release;
        LayoutNodeAlignmentLines alignmentLines$ui_release2;
        if (getQueried$ui_release()) {
            layoutNode = this.layoutNode;
        } else {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                return;
            }
            layoutNode = parent$ui_release.getAlignmentLines$ui_release().queryOwner;
            if (layoutNode == null || !layoutNode.getAlignmentLines$ui_release().getQueried$ui_release()) {
                LayoutNode layoutNode2 = this.queryOwner;
                if (layoutNode2 == null || layoutNode2.getAlignmentLines$ui_release().getQueried$ui_release()) {
                    return;
                }
                LayoutNode parent$ui_release2 = layoutNode2.getParent$ui_release();
                if (parent$ui_release2 != null && (alignmentLines$ui_release2 = parent$ui_release2.getAlignmentLines$ui_release()) != null) {
                    alignmentLines$ui_release2.recalculateQueryOwner$ui_release();
                }
                LayoutNode parent$ui_release3 = layoutNode2.getParent$ui_release();
                layoutNode = (parent$ui_release3 == null || (alignmentLines$ui_release = parent$ui_release3.getAlignmentLines$ui_release()) == null) ? null : alignmentLines$ui_release.queryOwner;
            }
        }
        this.queryOwner = layoutNode;
    }

    public final void reset$ui_release() {
        this.dirty = true;
        this.usedDuringParentMeasurement = false;
        this.previousUsedDuringParentLayout = false;
        this.usedDuringParentLayout = false;
        this.usedByModifierMeasurement = false;
        this.usedByModifierLayout = false;
        this.queryOwner = null;
    }

    public final void setDirty$ui_release(boolean z10) {
        this.dirty = z10;
    }

    public final void setPreviousUsedDuringParentLayout$ui_release(boolean z10) {
        this.previousUsedDuringParentLayout = z10;
    }

    public final void setUsedByModifierLayout$ui_release(boolean z10) {
        this.usedByModifierLayout = z10;
    }

    public final void setUsedByModifierMeasurement$ui_release(boolean z10) {
        this.usedByModifierMeasurement = z10;
    }

    public final void setUsedDuringParentLayout$ui_release(boolean z10) {
        this.usedDuringParentLayout = z10;
    }

    public final void setUsedDuringParentMeasurement$ui_release(boolean z10) {
        this.usedDuringParentMeasurement = z10;
    }
}
