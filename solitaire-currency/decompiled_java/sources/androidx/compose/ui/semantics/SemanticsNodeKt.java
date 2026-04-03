package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.EntityList;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import h9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, l<? super LayoutNode, Boolean> lVar) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (lVar.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    private static final List<SemanticsEntity> findOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsEntity> list) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            LayoutNode[] content = zSortedChildren.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode2 = content[i10];
                SemanticsEntity outerSemantics = getOuterSemantics(layoutNode2);
                if (outerSemantics != null) {
                    list.add(outerSemantics);
                } else {
                    findOneLayerOfSemanticsWrappers(layoutNode2, list);
                }
                i10++;
            } while (i10 < size);
        }
        return list;
    }

    static /* synthetic */ List findOneLayerOfSemanticsWrappers$default(LayoutNode layoutNode, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappers(layoutNode, list);
    }

    @Nullable
    public static final SemanticsEntity getOuterMergingSemantics(@NotNull LayoutNode layoutNode) {
        SemanticsEntity next;
        t.i(layoutNode, "<this>");
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = layoutNode.getOuterLayoutNodeWrapper$ui_release();
        while (outerLayoutNodeWrapper$ui_release != null && !EntityList.m3075has0OSVbXo(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) {
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
        }
        if (outerLayoutNodeWrapper$ui_release == null || (next = (SemanticsEntity) EntityList.m3077head0OSVbXo(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) == null) {
            return null;
        }
        LayoutNodeWrapper layoutNodeWrapper = next.getLayoutNodeWrapper();
        while (layoutNodeWrapper != null) {
            while (next != null) {
                if (next.getModifier().getSemanticsConfiguration().isMergingSemanticsOfDescendants()) {
                    return next;
                }
                next = next.getNext();
            }
            layoutNodeWrapper = layoutNodeWrapper.getWrapped$ui_release();
            next = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
        }
        return null;
    }

    @Nullable
    public static final SemanticsEntity getOuterSemantics(@NotNull LayoutNode layoutNode) {
        SemanticsEntity semanticsEntity;
        t.i(layoutNode, "<this>");
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = layoutNode.getOuterLayoutNodeWrapper$ui_release();
        while (outerLayoutNodeWrapper$ui_release != null && !EntityList.m3075has0OSVbXo(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) {
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
        }
        if (outerLayoutNodeWrapper$ui_release == null || (semanticsEntity = (SemanticsEntity) EntityList.m3077head0OSVbXo(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) == null) {
            return null;
        }
        LayoutNodeWrapper layoutNodeWrapper = semanticsEntity.getLayoutNodeWrapper();
        while (layoutNodeWrapper != null) {
            if (semanticsEntity != null) {
                return semanticsEntity;
            }
            layoutNodeWrapper = layoutNodeWrapper.getWrapped$ui_release();
            semanticsEntity = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    @Nullable
    public static final SemanticsEntity nearestSemantics(@NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull l<? super SemanticsEntity, Boolean> predicate) {
        SemanticsEntity next;
        t.i(layoutNodeWrapper, "<this>");
        t.i(predicate, "predicate");
        while (layoutNodeWrapper != null && !EntityList.m3075has0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) {
            layoutNodeWrapper = layoutNodeWrapper.getWrapped$ui_release();
        }
        if (layoutNodeWrapper == null || (next = (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) == null) {
            return null;
        }
        LayoutNodeWrapper layoutNodeWrapper2 = next.getLayoutNodeWrapper();
        while (layoutNodeWrapper2 != null) {
            while (next != null) {
                if (predicate.invoke(next).booleanValue()) {
                    return next;
                }
                next = next.getNext();
            }
            layoutNodeWrapper2 = layoutNodeWrapper2.getWrapped$ui_release();
            next = layoutNodeWrapper2 != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper2.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
