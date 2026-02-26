package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.OffsetMapping;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$pointerModifier$1 extends v implements l<Offset, k0> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$pointerModifier$1(TextFieldState textFieldState, FocusRequester focusRequester, boolean z10, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$focusRequester = focusRequester;
        this.$readOnly = z10;
        this.$manager = textFieldSelectionManager;
        this.$offsetMapping = offsetMapping;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
        m665invokek4lQ0M(offset.m1377unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final void m665invokek4lQ0M(long j10) {
        CoreTextFieldKt.tapToFocus(this.$state, this.$focusRequester, !this.$readOnly);
        if (this.$state.getHasFocus()) {
            if (this.$state.getHandleState() == HandleState.Selection) {
                this.$manager.m838deselect_kEHs6E$foundation_release(Offset.m1356boximpl(j10));
                return;
            }
            TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
            if (layoutResult != null) {
                TextFieldState textFieldState = this.$state;
                TextFieldDelegate.Companion.m725setCursorOffsetULxng0E$foundation_release(j10, layoutResult, textFieldState.getProcessor(), this.$offsetMapping, textFieldState.getOnValueChange());
                if (textFieldState.getTextDelegate().getText().length() > 0) {
                    textFieldState.setHandleState(HandleState.Cursor);
                }
            }
        }
    }
}
