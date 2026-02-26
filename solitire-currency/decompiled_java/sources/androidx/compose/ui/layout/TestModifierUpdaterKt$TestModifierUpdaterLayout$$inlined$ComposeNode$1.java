package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composables.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1 extends v implements h9.a<LayoutNode> {
    final /* synthetic */ h9.a $factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1(h9.a aVar) {
        super(0);
        this.$factory = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
    @Override // h9.a
    @NotNull
    public final LayoutNode invoke() {
        return this.$factory.invoke();
    }
}
