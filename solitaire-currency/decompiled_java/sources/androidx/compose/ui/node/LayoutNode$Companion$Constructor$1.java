package androidx.compose.ui.node;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNode$Companion$Constructor$1 extends v implements h9.a<LayoutNode> {
    public static final LayoutNode$Companion$Constructor$1 INSTANCE = new LayoutNode$Companion$Constructor$1();

    LayoutNode$Companion$Constructor$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final LayoutNode invoke() {
        return new LayoutNode(false, 1, null);
    }
}
