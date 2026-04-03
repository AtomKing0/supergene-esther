package androidx.compose.ui.node;

import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ComposeUiNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposeUiNode$Companion$SetDensity$1 extends v implements p<ComposeUiNode, Density, k0> {
    public static final ComposeUiNode$Companion$SetDensity$1 INSTANCE = new ComposeUiNode$Companion$SetDensity$1();

    ComposeUiNode$Companion$SetDensity$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(ComposeUiNode composeUiNode, Density density) {
        invoke2(composeUiNode, density);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ComposeUiNode composeUiNode, @NotNull Density it) {
        t.i(composeUiNode, "$this$null");
        t.i(it, "it");
        composeUiNode.setDensity(it);
    }
}
