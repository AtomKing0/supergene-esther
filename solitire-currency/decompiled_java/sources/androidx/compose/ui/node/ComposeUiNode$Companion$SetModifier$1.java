package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ComposeUiNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposeUiNode$Companion$SetModifier$1 extends v implements p<ComposeUiNode, Modifier, k0> {
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE = new ComposeUiNode$Companion$SetModifier$1();

    ComposeUiNode$Companion$SetModifier$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(ComposeUiNode composeUiNode, Modifier modifier) {
        invoke2(composeUiNode, modifier);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ComposeUiNode composeUiNode, @NotNull Modifier it) {
        t.i(composeUiNode, "$this$null");
        t.i(it, "it");
        composeUiNode.setModifier(it);
    }
}
