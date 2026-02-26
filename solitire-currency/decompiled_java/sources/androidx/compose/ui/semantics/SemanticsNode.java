package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import h9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsNode {
    public static final int $stable = 8;

    @Nullable
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;

    @NotNull
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;

    @NotNull
    private final SemanticsEntity outerSemanticsEntity;

    @NotNull
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(@NotNull SemanticsEntity outerSemanticsEntity, boolean z10) {
        t.i(outerSemanticsEntity, "outerSemanticsEntity");
        this.outerSemanticsEntity = outerSemanticsEntity;
        this.mergingEnabled = z10;
        this.unmergedConfig = outerSemanticsEntity.collapsedSemanticsConfiguration();
        this.id = outerSemanticsEntity.getModifier().getId();
        this.layoutNode = outerSemanticsEntity.getLayoutNode();
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        Role role = SemanticsNodeKt.getRole(this);
        if (role != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!list.isEmpty())) {
            list.add(m3240fakeSemanticsNodeypyhhiA(role, new SemanticsNode$emitFakeNodes$fakeNode$1(role)));
        }
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (semanticsConfiguration.contains(semanticsProperties.getContentDescription()) && (!list.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, semanticsProperties.getContentDescription());
            String str = list2 != null ? (String) d0.k0(list2) : null;
            if (str != null) {
                list.add(0, m3240fakeSemanticsNodeypyhhiA(null, new SemanticsNode$emitFakeNodes$fakeNode$2(str)));
            }
        }
    }

    /* JADX INFO: renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m3240fakeSemanticsNodeypyhhiA(Role role, l<? super SemanticsPropertyReceiver, k0> lVar) {
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsEntity(new LayoutNode(true).getInnerLayoutNodeWrapper$ui_release(), new SemanticsModifierCore(role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this), false, false, lVar)), false);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list, boolean z10) {
        List listUnmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, z10, false, 2, null);
        int size = listUnmergedChildren$ui_release$default.size();
        for (int i10 = 0; i10 < size; i10++) {
            SemanticsNode semanticsNode = (SemanticsNode) listUnmergedChildren$ui_release$default.get(i10);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics()) {
                findOneLayerOfMergingSemanticsNodes$default(semanticsNode, list, false, 2, null);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = new ArrayList();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, z10);
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    private final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics()) {
            return;
        }
        List listUnmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, null);
        int size = listUnmergedChildren$ui_release$default.size();
        for (int i10 = 0; i10 < size; i10++) {
            SemanticsNode semanticsNode = (SemanticsNode) listUnmergedChildren$ui_release$default.get(i10);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui_release(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(semanticsConfiguration);
            }
        }
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z10, z11);
    }

    @NotNull
    public final LayoutNodeWrapper findWrapperToGetBounds$ui_release() {
        if (!this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            return this.outerSemanticsEntity.getLayoutNodeWrapper();
        }
        SemanticsEntity outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsEntity;
        }
        return outerMergingSemantics.getLayoutNodeWrapper();
    }

    public final int getAlignmentLinePosition(@NotNull AlignmentLine alignmentLine) {
        t.i(alignmentLine, "alignmentLine");
        return findWrapperToGetBounds$ui_release().get(alignmentLine);
    }

    @NotNull
    public final Rect getBoundsInRoot() {
        return !this.layoutNode.isAttached() ? Rect.Companion.getZero() : LayoutCoordinatesKt.boundsInRoot(findWrapperToGetBounds$ui_release());
    }

    @NotNull
    public final Rect getBoundsInWindow() {
        return !this.layoutNode.isAttached() ? Rect.Companion.getZero() : LayoutCoordinatesKt.boundsInWindow(findWrapperToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getChildren() {
        return getChildren(false, !this.mergingEnabled, false);
    }

    @NotNull
    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration semanticsConfigurationCopy = this.unmergedConfig.copy();
        mergeConfig(semanticsConfigurationCopy);
        return semanticsConfigurationCopy;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    @NotNull
    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    @NotNull
    public final SemanticsEntity getOuterSemanticsEntity$ui_release() {
        return this.outerSemanticsEntity;
    }

    @Nullable
    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode layoutNodeFindClosestParentNode = this.mergingEnabled ? SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$1.INSTANCE) : null;
        if (layoutNodeFindClosestParentNode == null) {
            layoutNodeFindClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$2.INSTANCE);
        }
        SemanticsEntity outerSemantics = layoutNodeFindClosestParentNode != null ? SemanticsNodeKt.getOuterSemantics(layoutNodeFindClosestParentNode) : null;
        if (outerSemantics == null) {
            return null;
        }
        return new SemanticsNode(outerSemantics, this.mergingEnabled);
    }

    /* JADX INFO: renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m3241getPositionInRootF1C5BW0() {
        return !this.layoutNode.isAttached() ? Offset.Companion.m1383getZeroF1C5BW0() : LayoutCoordinatesKt.positionInRoot(findWrapperToGetBounds$ui_release());
    }

    /* JADX INFO: renamed from: getPositionInWindow-F1C5BW0, reason: not valid java name */
    public final long m3242getPositionInWindowF1C5BW0() {
        return !this.layoutNode.isAttached() ? Offset.Companion.m1383getZeroF1C5BW0() : LayoutCoordinatesKt.positionInWindow(findWrapperToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, false, true);
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildrenSortedByBounds$ui_release() {
        return getChildren(true, false, true);
    }

    @Nullable
    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m3243getSizeYbymL2g() {
        return findWrapperToGetBounds$ui_release().mo2989getSizeYbymL2g();
    }

    @NotNull
    public final Rect getTouchBoundsInRoot() {
        SemanticsEntity outerMergingSemantics;
        if (!this.unmergedConfig.isMergingSemanticsOfDescendants() || (outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode)) == null) {
            outerMergingSemantics = this.outerSemanticsEntity;
        }
        return outerMergingSemantics.touchBoundsInRoot();
    }

    @NotNull
    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final void setFake$ui_release(boolean z10) {
        this.isFake = z10;
    }

    @NotNull
    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z10, boolean z11) {
        if (this.isFake) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        List listFindOneLayerOfSemanticsWrappersSortedByBounds$default = z10 ? SemanticsSortKt.findOneLayerOfSemanticsWrappersSortedByBounds$default(this.layoutNode, null, 1, null) : SemanticsNodeKt.findOneLayerOfSemanticsWrappers$default(this.layoutNode, null, 1, null);
        int size = listFindOneLayerOfSemanticsWrappersSortedByBounds$default.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new SemanticsNode((SemanticsEntity) listFindOneLayerOfSemanticsWrappersSortedByBounds$default.get(i10), this.mergingEnabled));
        }
        if (z11) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }

    private final List<SemanticsNode> getChildren(boolean z10, boolean z11, boolean z12) {
        if (!z11 && this.unmergedConfig.isClearingSemantics()) {
            return v.l();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, null, z10, 1, null);
        }
        return unmergedChildren$ui_release(z10, z12);
    }
}
