package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidViewHolder$layoutNode$1$1 extends v implements l<Modifier, k0> {
    final /* synthetic */ Modifier $coreModifier;
    final /* synthetic */ LayoutNode $layoutNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$1(LayoutNode layoutNode, Modifier modifier) {
        super(1);
        this.$layoutNode = layoutNode;
        this.$coreModifier = modifier;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier) {
        invoke2(modifier);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Modifier it) {
        t.i(it, "it");
        this.$layoutNode.setModifier(it.then(this.$coreModifier));
    }
}
