package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsNode$parent$2 extends v implements l<LayoutNode, Boolean> {
    public static final SemanticsNode$parent$2 INSTANCE = new SemanticsNode$parent$2();

    SemanticsNode$parent$2() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull LayoutNode it) {
        t.i(it, "it");
        return Boolean.valueOf(SemanticsNodeKt.getOuterSemantics(it) != null);
    }
}
