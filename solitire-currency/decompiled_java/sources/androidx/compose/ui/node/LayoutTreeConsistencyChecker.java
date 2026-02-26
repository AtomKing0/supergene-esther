package androidx.compose.ui.node;

import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutTreeConsistencyChecker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutTreeConsistencyChecker {

    @NotNull
    private final List<LayoutNode> postponedMeasureRequests;

    @NotNull
    private final DepthSortedSet relayoutNodes;

    @NotNull
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(@NotNull LayoutNode root, @NotNull DepthSortedSet relayoutNodes, @NotNull List<LayoutNode> postponedMeasureRequests) {
        t.i(root, "root");
        t.i(relayoutNodes, "relayoutNodes");
        t.i(postponedMeasureRequests, "postponedMeasureRequests");
        this.root = root;
        this.relayoutNodes = relayoutNodes;
        this.postponedMeasureRequests = postponedMeasureRequests;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r6) {
        /*
            r5 = this;
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            boolean r1 = r6.isPlaced()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L22
            int r1 = r6.getPlaceOrder$ui_release()
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r4) goto L8c
            if (r0 == 0) goto L1f
            boolean r1 = r0.isPlaced()
            if (r1 != r3) goto L1f
            r1 = r3
            goto L20
        L1f:
            r1 = r2
        L20:
            if (r1 == 0) goto L8c
        L22:
            boolean r1 = r6.getMeasurePending$ui_release()
            if (r1 == 0) goto L31
            java.util.List<androidx.compose.ui.node.LayoutNode> r1 = r5.postponedMeasureRequests
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L31
            return r3
        L31:
            if (r0 == 0) goto L38
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.getLayoutState$ui_release()
            goto L39
        L38:
            r1 = 0
        L39:
            boolean r4 = r6.getMeasurePending$ui_release()
            if (r4 == 0) goto L5a
            androidx.compose.ui.node.DepthSortedSet r4 = r5.relayoutNodes
            boolean r6 = r4.contains(r6)
            if (r6 != 0) goto L58
            if (r0 == 0) goto L51
            boolean r6 = r0.getMeasurePending$ui_release()
            if (r6 != r3) goto L51
            r6 = r3
            goto L52
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L58
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r1 != r6) goto L59
        L58:
            r2 = r3
        L59:
            return r2
        L5a:
            boolean r4 = r6.getLayoutPending$ui_release()
            if (r4 == 0) goto L8c
            androidx.compose.ui.node.DepthSortedSet r4 = r5.relayoutNodes
            boolean r6 = r4.contains(r6)
            if (r6 != 0) goto L8a
            if (r0 == 0) goto L72
            boolean r6 = r0.getMeasurePending$ui_release()
            if (r6 != r3) goto L72
            r6 = r3
            goto L73
        L72:
            r6 = r2
        L73:
            if (r6 != 0) goto L8a
            if (r0 == 0) goto L7f
            boolean r6 = r0.getLayoutPending$ui_release()
            if (r6 != r3) goto L7f
            r6 = r3
            goto L80
        L7f:
            r6 = r2
        L80:
            if (r6 != 0) goto L8a
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r1 == r6) goto L8a
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r1 != r6) goto L8b
        L8a:
            r2 = r3
        L8b:
            return r2
        L8c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final boolean isTreeConsistent(LayoutNode layoutNode) {
        if (!consistentLayoutState(layoutNode)) {
            return false;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!isTreeConsistent(children$ui_release.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private final String logTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        t.h(sb, "append(value)");
        sb.append('\n');
        t.h(sb, "append('\\n')");
        logTree$printSubTree(this, sb, this.root, 0);
        String string = sb.toString();
        t.h(string, "stringBuilder.toString()");
        return string;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb, LayoutNode layoutNode, int i10) {
        String strNodeToString = layoutTreeConsistencyChecker.nodeToString(layoutNode);
        if (strNodeToString.length() > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                sb.append("..");
            }
            sb.append(strNodeToString);
            t.h(sb, "append(value)");
            sb.append('\n');
            t.h(sb, "append('\\n')");
            i10++;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i12 = 0; i12 < size; i12++) {
            logTree$printSubTree(layoutTreeConsistencyChecker, sb, children$ui_release.get(i12), i10);
        }
    }

    private final String nodeToString(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(layoutNode);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(layoutNode.getLayoutState$ui_release());
        sb2.append(']');
        sb.append(sb2.toString());
        if (!layoutNode.isPlaced()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + layoutNode.getMeasuredByParent$ui_release() + ']');
        if (!consistentLayoutState(layoutNode)) {
            sb.append("[INCONSISTENT]");
        }
        String string = sb.toString();
        t.h(string, "with(StringBuilder()) {\n…     toString()\n        }");
        return string;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println((Object) logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }
}
