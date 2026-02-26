package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OnPositionedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnPositionedDispatcher {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16], 0);

    /* JADX INFO: compiled from: OnPositionedDispatcher.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: OnPositionedDispatcher.kt */
        private static final class DepthComparator implements Comparator<LayoutNode> {

            @NotNull
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            public int compare(@NotNull LayoutNode a10, @NotNull LayoutNode b10) {
                t.i(a10, "a");
                t.i(b10, "b");
                int iK = t.k(b10.getDepth$ui_release(), a10.getDepth$ui_release());
                return iK != 0 ? iK : t.k(a10.hashCode(), b10.hashCode());
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        int i10 = 0;
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                dispatchHierarchy(content[i10]);
                i10++;
            } while (i10 < size);
        }
    }

    public final void dispatch() {
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        MutableVector<LayoutNode> mutableVector = this.layoutNodes;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i10 = size - 1;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.getNeedsOnPositionedDispatch$ui_release()) {
                    dispatchHierarchy(layoutNode);
                }
                i10--;
            } while (i10 >= 0);
        }
        this.layoutNodes.clear();
    }

    public final void onNodePositioned(@NotNull LayoutNode node) {
        t.i(node, "node");
        this.layoutNodes.add(node);
        node.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void onRootNodePositioned(@NotNull LayoutNode rootNode) {
        t.i(rootNode, "rootNode");
        this.layoutNodes.clear();
        this.layoutNodes.add(rootNode);
        rootNode.setNeedsOnPositionedDispatch$ui_release(true);
    }
}
