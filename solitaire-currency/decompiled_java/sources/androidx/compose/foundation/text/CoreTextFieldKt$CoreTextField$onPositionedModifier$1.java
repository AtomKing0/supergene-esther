package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$onPositionedModifier$1 extends v implements l<LayoutCoordinates, k0> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$onPositionedModifier$1(TextFieldState textFieldState, boolean z10, TextFieldSelectionManager textFieldSelectionManager) {
        super(1);
        this.$state = textFieldState;
        this.$enabled = z10;
        this.$manager = textFieldSelectionManager;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutCoordinates it) {
        t.i(it, "it");
        this.$state.setLayoutCoordinates(it);
        if (this.$enabled) {
            if (this.$state.getHandleState() == HandleState.Selection) {
                if (this.$state.getShowFloatingToolbar()) {
                    this.$manager.showSelectionToolbar$foundation_release();
                } else {
                    this.$manager.hideSelectionToolbar$foundation_release();
                }
                this.$state.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, true));
                this.$state.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, false));
            } else if (this.$state.getHandleState() == HandleState.Cursor) {
                this.$state.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, true));
            }
        }
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        layoutResult.setInnerTextFieldCoordinates(it);
    }
}
