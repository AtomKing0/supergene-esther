package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsNode$parent$1 extends v implements l<LayoutNode, Boolean> {
    public static final SemanticsNode$parent$1 INSTANCE = new SemanticsNode$parent$1();

    SemanticsNode$parent$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull LayoutNode it) {
        SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration;
        t.i(it, "it");
        SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(it);
        boolean z10 = false;
        if (outerSemantics != null && (semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics.collapsedSemanticsConfiguration()) != null && semanticsConfigurationCollapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }
}
