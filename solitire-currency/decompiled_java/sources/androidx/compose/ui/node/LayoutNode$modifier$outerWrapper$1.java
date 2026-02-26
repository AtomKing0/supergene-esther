package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNode$modifier$outerWrapper$1 extends v implements p<Modifier.Element, LayoutNodeWrapper, LayoutNodeWrapper> {
    final /* synthetic */ LayoutNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNode$modifier$outerWrapper$1(LayoutNode layoutNode) {
        super(2);
        this.this$0 = layoutNode;
    }

    @Override // h9.p
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final LayoutNodeWrapper mo4invoke(@NotNull Modifier.Element mod, @NotNull LayoutNodeWrapper toWrap) {
        t.i(mod, "mod");
        t.i(toWrap, "toWrap");
        if (mod instanceof RemeasurementModifier) {
            ((RemeasurementModifier) mod).onRemeasurementAvailable(this.this$0);
        }
        EntityList.m3065addBeforeLayoutModifierimpl(toWrap.m3125getEntitiesCHwCgZE(), toWrap, mod);
        if (mod instanceof OnGloballyPositionedModifier) {
            this.this$0.getOrCreateOnPositionedCallbacks$ui_release().add(y.a(toWrap, mod));
        }
        if (mod instanceof LayoutModifier) {
            LayoutModifier layoutModifier = (LayoutModifier) mod;
            ModifiedLayoutNode modifiedLayoutNodeReuseLayoutNodeWrapper = this.this$0.reuseLayoutNodeWrapper(toWrap, layoutModifier);
            if (modifiedLayoutNodeReuseLayoutNodeWrapper == null) {
                modifiedLayoutNodeReuseLayoutNodeWrapper = new ModifiedLayoutNode(toWrap, layoutModifier);
            }
            toWrap = modifiedLayoutNodeReuseLayoutNodeWrapper;
            toWrap.onInitialize();
        }
        EntityList.m3064addAfterLayoutModifierimpl(toWrap.m3125getEntitiesCHwCgZE(), toWrap, mod);
        return toWrap;
    }
}
