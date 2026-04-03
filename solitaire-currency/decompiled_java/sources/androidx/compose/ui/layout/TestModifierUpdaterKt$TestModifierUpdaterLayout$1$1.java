package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TestModifierUpdater.kt */
/* JADX INFO: loaded from: classes.dex */
final class TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 extends v implements h9.l<LayoutNode, k0> {
    final /* synthetic */ h9.l<TestModifierUpdater, k0> $onAttached;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(h9.l<? super TestModifierUpdater, k0> lVar) {
        super(1);
        this.$onAttached = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutNode layoutNode) {
        invoke2(layoutNode);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode init) {
        t.i(init, "$this$init");
        this.$onAttached.invoke(new TestModifierUpdater(init));
    }
}
