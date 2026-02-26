package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsOwner.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsOwner {
    public static final int $stable = 8;

    @NotNull
    private final LayoutNode rootNode;

    public SemanticsOwner(@NotNull LayoutNode rootNode) {
        t.i(rootNode, "rootNode");
        this.rootNode = rootNode;
    }

    @NotNull
    public final SemanticsNode getRootSemanticsNode() {
        SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(this.rootNode);
        t.f(outerSemantics);
        return new SemanticsNode(outerSemantics, true);
    }

    @NotNull
    public final SemanticsNode getUnmergedRootSemanticsNode() {
        SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(this.rootNode);
        t.f(outerSemantics);
        return new SemanticsNode(outerSemantics, false);
    }
}
