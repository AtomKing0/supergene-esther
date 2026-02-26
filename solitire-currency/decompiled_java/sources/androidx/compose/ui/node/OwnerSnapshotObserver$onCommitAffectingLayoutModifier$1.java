package androidx.compose.ui.node;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OwnerSnapshotObserver.kt */
/* JADX INFO: loaded from: classes.dex */
final class OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1 extends v implements l<LayoutNode, k0> {
    public static final OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1();

    OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutNode layoutNode) {
        invoke2(layoutNode);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode layoutNode) {
        t.i(layoutNode, "layoutNode");
        if (layoutNode.isValid()) {
            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
        }
    }
}
