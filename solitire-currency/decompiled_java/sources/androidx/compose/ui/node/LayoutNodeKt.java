package androidx.compose.ui.node;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;

    public static final void add(@NotNull LayoutNode layoutNode, @NotNull LayoutNode child) {
        t.i(layoutNode, "<this>");
        t.i(child, "child");
        layoutNode.insertAt$ui_release(layoutNode.getChildren$ui_release().size(), child);
    }

    @NotNull
    public static final Owner requireOwner(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "<this>");
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }
}
