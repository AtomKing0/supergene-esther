package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.b;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsSort.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NodeLocationHolder implements Comparable<NodeLocationHolder> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static ComparisonStrategy comparisonStrategy = ComparisonStrategy.Stripe;

    @NotNull
    private final LayoutDirection layoutDirection;

    @Nullable
    private final Rect location;

    @NotNull
    private final LayoutNode node;

    @NotNull
    private final LayoutNode subtreeRoot;

    /* JADX INFO: compiled from: SemanticsSort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ComparisonStrategy getComparisonStrategy$ui_release() {
            return NodeLocationHolder.comparisonStrategy;
        }

        public final void setComparisonStrategy$ui_release(@NotNull ComparisonStrategy comparisonStrategy) {
            t.i(comparisonStrategy, "<set-?>");
            NodeLocationHolder.comparisonStrategy = comparisonStrategy;
        }
    }

    /* JADX INFO: compiled from: SemanticsSort.kt */
    public enum ComparisonStrategy {
        Stripe,
        Location
    }

    public NodeLocationHolder(@NotNull LayoutNode subtreeRoot, @NotNull LayoutNode node) {
        t.i(subtreeRoot, "subtreeRoot");
        t.i(node, "node");
        this.subtreeRoot = subtreeRoot;
        this.node = node;
        this.layoutDirection = subtreeRoot.getLayoutDirection();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = subtreeRoot.getInnerLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapperFindWrapperToGetBounds = SemanticsSortKt.findWrapperToGetBounds(node);
        Rect rectA = null;
        if (innerLayoutNodeWrapper$ui_release.isAttached() && layoutNodeWrapperFindWrapperToGetBounds.isAttached()) {
            rectA = b.a(innerLayoutNodeWrapper$ui_release, layoutNodeWrapperFindWrapperToGetBounds, false, 2, null);
        }
        this.location = rectA;
    }

    @NotNull
    public final LayoutNode getNode$ui_release() {
        return this.node;
    }

    @NotNull
    public final LayoutNode getSubtreeRoot$ui_release() {
        return this.subtreeRoot;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull NodeLocationHolder other) {
        t.i(other, "other");
        Rect rect = this.location;
        if (rect == null) {
            return 1;
        }
        if (other.location == null) {
            return -1;
        }
        if (comparisonStrategy == ComparisonStrategy.Stripe) {
            if (rect.getBottom() - other.location.getTop() <= 0.0f) {
                return -1;
            }
            if (this.location.getTop() - other.location.getBottom() >= 0.0f) {
                return 1;
            }
        }
        if (this.layoutDirection == LayoutDirection.Ltr) {
            float left = this.location.getLeft() - other.location.getLeft();
            if (!(left == 0.0f)) {
                return left < 0.0f ? -1 : 1;
            }
        } else {
            float right = this.location.getRight() - other.location.getRight();
            if (!(right == 0.0f)) {
                return right < 0.0f ? 1 : -1;
            }
        }
        float top = this.location.getTop() - other.location.getTop();
        if (!(top == 0.0f)) {
            return top < 0.0f ? -1 : 1;
        }
        float height = this.location.getHeight() - other.location.getHeight();
        if (!(height == 0.0f)) {
            return height < 0.0f ? 1 : -1;
        }
        float width = this.location.getWidth() - other.location.getWidth();
        if (!(width == 0.0f)) {
            return width < 0.0f ? 1 : -1;
        }
        Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findWrapperToGetBounds(this.node));
        Rect rectBoundsInRoot2 = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findWrapperToGetBounds(other.node));
        LayoutNode layoutNodeFindNodeByPredicateTraversal = SemanticsSortKt.findNodeByPredicateTraversal(this.node, new NodeLocationHolder$compareTo$child1$1(rectBoundsInRoot));
        LayoutNode layoutNodeFindNodeByPredicateTraversal2 = SemanticsSortKt.findNodeByPredicateTraversal(other.node, new NodeLocationHolder$compareTo$child2$1(rectBoundsInRoot2));
        return (layoutNodeFindNodeByPredicateTraversal == null || layoutNodeFindNodeByPredicateTraversal2 == null) ? layoutNodeFindNodeByPredicateTraversal != null ? 1 : -1 : new NodeLocationHolder(this.subtreeRoot, layoutNodeFindNodeByPredicateTraversal).compareTo(new NodeLocationHolder(other.subtreeRoot, layoutNodeFindNodeByPredicateTraversal2));
    }
}
