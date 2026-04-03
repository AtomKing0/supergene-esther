package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.semantics.NodeLocationHolder;
import h9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.z;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsSort.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsSortKt {
    @Nullable
    public static final LayoutNode findNodeByPredicateTraversal(@NotNull LayoutNode layoutNode, @NotNull l<? super LayoutNode, Boolean> predicate) {
        t.i(layoutNode, "<this>");
        t.i(predicate, "predicate");
        if (predicate.invoke(layoutNode).booleanValue()) {
            return layoutNode;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i10 = 0; i10 < size; i10++) {
            LayoutNode layoutNodeFindNodeByPredicateTraversal = findNodeByPredicateTraversal(children$ui_release.get(i10), predicate);
            if (layoutNodeFindNodeByPredicateTraversal != null) {
                return layoutNodeFindNodeByPredicateTraversal;
            }
        }
        return null;
    }

    @NotNull
    public static final List<SemanticsEntity> findOneLayerOfSemanticsWrappersSortedByBounds(@NotNull LayoutNode layoutNode, @NotNull List<SemanticsEntity> list) {
        t.i(layoutNode, "<this>");
        t.i(list, "list");
        if (!layoutNode.isAttached()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i10 = 0; i10 < size; i10++) {
            LayoutNode layoutNode2 = children$ui_release.get(i10);
            if (layoutNode2.isAttached()) {
                arrayList.add(new NodeLocationHolder(layoutNode, layoutNode2));
            }
        }
        List<NodeLocationHolder> listFindOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(arrayList);
        ArrayList arrayList2 = new ArrayList(listFindOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size());
        int size2 = listFindOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size();
        for (int i11 = 0; i11 < size2; i11++) {
            arrayList2.add(listFindOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.get(i11).getNode$ui_release());
        }
        int size3 = arrayList2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            LayoutNode layoutNode3 = (LayoutNode) arrayList2.get(i12);
            SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode3);
            if (outerSemantics != null) {
                list.add(outerSemantics);
            } else {
                findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode3, list);
            }
        }
        return list;
    }

    public static /* synthetic */ List findOneLayerOfSemanticsWrappersSortedByBounds$default(LayoutNode layoutNode, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode, list);
    }

    private static final List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(List<NodeLocationHolder> list) {
        try {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Stripe);
            List<NodeLocationHolder> listR0 = d0.R0(list);
            z.z(listR0);
            return listR0;
        } catch (IllegalArgumentException unused) {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Location);
            List<NodeLocationHolder> listR02 = d0.R0(list);
            z.z(listR02);
            return listR02;
        }
    }

    @NotNull
    public static final LayoutNodeWrapper findWrapperToGetBounds(@NotNull LayoutNode layoutNode) {
        LayoutNodeWrapper layoutNodeWrapper;
        t.i(layoutNode, "<this>");
        SemanticsEntity outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        }
        return (outerMergingSemantics == null || (layoutNodeWrapper = outerMergingSemantics.getLayoutNodeWrapper()) == null) ? layoutNode.getInnerLayoutNodeWrapper$ui_release() : layoutNodeWrapper;
    }
}
