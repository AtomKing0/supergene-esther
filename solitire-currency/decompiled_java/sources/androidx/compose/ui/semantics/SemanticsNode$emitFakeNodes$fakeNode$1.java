package androidx.compose.ui.semantics;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsNode$emitFakeNodes$fakeNode$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ Role $nodeRole;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SemanticsNode$emitFakeNodes$fakeNode$1(Role role) {
        super(1);
        this.$nodeRole = role;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver fakeSemanticsNode) {
        t.i(fakeSemanticsNode, "$this$fakeSemanticsNode");
        SemanticsPropertiesKt.m3247setRolekuIjeqM(fakeSemanticsNode, this.$nodeRole.m3233unboximpl());
    }
}
