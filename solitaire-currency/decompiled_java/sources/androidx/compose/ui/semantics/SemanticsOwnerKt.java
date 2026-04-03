package androidx.compose.ui.semantics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsOwnerKt {
    @NotNull
    public static final List<SemanticsNode> getAllSemanticsNodes(@NotNull SemanticsOwner semanticsOwner, boolean z10) {
        t.i(semanticsOwner, "<this>");
        return d0.P0(getAllSemanticsNodesToMap(semanticsOwner, !z10).values());
    }

    @NotNull
    public static final Map<Integer, SemanticsNode> getAllSemanticsNodesToMap(@NotNull SemanticsOwner semanticsOwner, boolean z10) {
        t.i(semanticsOwner, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(linkedHashMap, z10 ? semanticsOwner.getUnmergedRootSemanticsNode() : semanticsOwner.getRootSemanticsNode());
        return linkedHashMap;
    }

    public static /* synthetic */ Map getAllSemanticsNodesToMap$default(SemanticsOwner semanticsOwner, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return getAllSemanticsNodesToMap(semanticsOwner, z10);
    }

    private static final void getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(Map<Integer, SemanticsNode> map, SemanticsNode semanticsNode) {
        map.put(Integer.valueOf(semanticsNode.getId()), semanticsNode);
        List<SemanticsNode> children = semanticsNode.getChildren();
        int size = children.size();
        for (int i10 = 0; i10 < size; i10++) {
            getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(map, children.get(i10));
        }
    }
}
