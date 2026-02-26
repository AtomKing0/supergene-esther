package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerInputModifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerInputEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEntity extends LayoutNodeEntity<PointerInputEntity, PointerInputModifier> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerInputEntity(@NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull PointerInputModifier modifier) {
        super(layoutNodeWrapper, modifier);
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        super.onAttach();
        getModifier().getPointerInputFilter().setLayoutCoordinates$ui_release(getLayoutNodeWrapper());
        getModifier().getPointerInputFilter().setAttached$ui_release(true);
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onDetach() {
        super.onDetach();
        getModifier().getPointerInputFilter().setAttached$ui_release(false);
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        if (!getModifier().getPointerInputFilter().getShareWithSiblings()) {
            PointerInputEntity next = getNext();
            if (!(next != null ? next.shouldSharePointerInputWithSiblings() : false)) {
                return false;
            }
        }
        return true;
    }
}
