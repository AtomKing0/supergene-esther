package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasurePolicy;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ComposeUiNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposeUiNode$Companion$SetMeasurePolicy$1 extends v implements p<ComposeUiNode, MeasurePolicy, k0> {
    public static final ComposeUiNode$Companion$SetMeasurePolicy$1 INSTANCE = new ComposeUiNode$Companion$SetMeasurePolicy$1();

    ComposeUiNode$Companion$SetMeasurePolicy$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(ComposeUiNode composeUiNode, MeasurePolicy measurePolicy) {
        invoke2(composeUiNode, measurePolicy);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ComposeUiNode composeUiNode, @NotNull MeasurePolicy it) {
        t.i(composeUiNode, "$this$null");
        t.i(it, "it");
        composeUiNode.setMeasurePolicy(it);
    }
}
