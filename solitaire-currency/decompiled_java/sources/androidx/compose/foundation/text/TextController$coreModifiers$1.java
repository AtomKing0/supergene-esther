package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextController$coreModifiers$1 extends v implements l<LayoutCoordinates, k0> {
    final /* synthetic */ TextController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextController$coreModifiers$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutCoordinates it) {
        SelectionRegistrar selectionRegistrar;
        t.i(it, "it");
        this.this$0.getState().setLayoutCoordinates(it);
        if (SelectionRegistrarKt.hasSelection(this.this$0.selectionRegistrar, this.this$0.getState().getSelectableId())) {
            long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(it);
            if (!Offset.m1364equalsimpl0(jPositionInWindow, this.this$0.getState().m749getPreviousGlobalPositionF1C5BW0()) && (selectionRegistrar = this.this$0.selectionRegistrar) != null) {
                selectionRegistrar.notifyPositionChange(this.this$0.getState().getSelectableId());
            }
            this.this$0.getState().m751setPreviousGlobalPositionk4lQ0M(jPositionInWindow);
        }
    }
}
