package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: DepthSortedSet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DepthSortedSet {

    @NotNull
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;

    @NotNull
    private final l mapOfOriginalDepth$delegate;

    @NotNull
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet() {
        this(false, 1, null);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final void add(@NotNull LayoutNode node) {
        t.i(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.extraAssertions) {
            Integer num = getMapOfOriginalDepth().get(node);
            if (num == null) {
                getMapOfOriginalDepth().put(node, Integer.valueOf(node.getDepth$ui_release()));
            } else {
                if (!(num.intValue() == node.getDepth$ui_release())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        this.set.add(node);
    }

    public final boolean contains(@NotNull LayoutNode node) {
        t.i(node, "node");
        boolean zContains = this.set.contains(node);
        if (this.extraAssertions) {
            if (!(zContains == getMapOfOriginalDepth().containsKey(node))) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return zContains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    @NotNull
    public final LayoutNode pop() {
        LayoutNode node = this.set.first();
        t.h(node, "node");
        remove(node);
        return node;
    }

    public final void popEach(@NotNull h9.l<? super LayoutNode, k0> block) {
        t.i(block, "block");
        while (!isEmpty()) {
            block.invoke(pop());
        }
    }

    public final boolean remove(@NotNull LayoutNode node) {
        t.i(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zRemove = this.set.remove(node);
        if (this.extraAssertions) {
            Integer numRemove = getMapOfOriginalDepth().remove(node);
            if (zRemove) {
                if (!(numRemove != null && numRemove.intValue() == node.getDepth$ui_release())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                if (!(numRemove == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        return zRemove;
    }

    @NotNull
    public String toString() {
        String string = this.set.toString();
        t.h(string, "set.toString()");
        return string;
    }

    public DepthSortedSet(boolean z10) {
        this.extraAssertions = z10;
        this.mapOfOriginalDepth$delegate = n.b(p.f35203c, DepthSortedSet$mapOfOriginalDepth$2.INSTANCE);
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(@NotNull LayoutNode l12, @NotNull LayoutNode l22) {
                t.i(l12, "l1");
                t.i(l22, "l2");
                int iK = t.k(l12.getDepth$ui_release(), l22.getDepth$ui_release());
                return iK != 0 ? iK : t.k(l12.hashCode(), l22.hashCode());
            }
        };
        this.DepthComparator = comparator;
        this.set = new TreeSet<>(comparator);
    }

    public /* synthetic */ DepthSortedSet(boolean z10, int i10, k kVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
