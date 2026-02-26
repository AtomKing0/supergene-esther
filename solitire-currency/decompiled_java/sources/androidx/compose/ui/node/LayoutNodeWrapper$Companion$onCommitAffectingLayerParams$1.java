package androidx.compose.ui.node;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LayoutNodeWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1 extends v implements l<LayoutNodeWrapper, k0> {
    public static final LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1 INSTANCE = new LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1();

    LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutNodeWrapper layoutNodeWrapper) {
        invoke2(layoutNodeWrapper);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNodeWrapper wrapper) {
        t.i(wrapper, "wrapper");
        if (wrapper.isValid()) {
            wrapper.updateLayerParameters();
        }
    }
}
