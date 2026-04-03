package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TestModifierUpdater.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class TestModifierUpdater {
    public static final int $stable = 8;

    @NotNull
    private final LayoutNode node;

    public TestModifierUpdater(@NotNull LayoutNode node) {
        t.i(node, "node");
        this.node = node;
    }

    public final void updateModifier(@NotNull Modifier modifier) {
        t.i(modifier, "modifier");
        this.node.setModifier(modifier);
    }
}
