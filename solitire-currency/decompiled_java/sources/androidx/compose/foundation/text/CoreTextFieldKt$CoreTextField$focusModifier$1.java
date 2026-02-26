package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$focusModifier$1 extends v implements l<FocusState, k0> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ o0 $coroutineScope;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$focusModifier$1(TextFieldState textFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, TextFieldSelectionManager textFieldSelectionManager, o0 o0Var, BringIntoViewRequester bringIntoViewRequester, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$textInputService = textInputService;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$manager = textFieldSelectionManager;
        this.$coroutineScope = o0Var;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$offsetMapping = offsetMapping;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusState focusState) {
        invoke2(focusState);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FocusState it) {
        TextLayoutResultProxy layoutResult;
        t.i(it, "it");
        if (this.$state.getHasFocus() == it.isFocused()) {
            return;
        }
        this.$state.setHasFocus(it.isFocused());
        TextInputService textInputService = this.$textInputService;
        if (textInputService != null) {
            CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService, this.$state, this.$value, this.$imeOptions);
            if (it.isFocused() && (layoutResult = this.$state.getLayoutResult()) != null) {
                k.d(this.$coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, layoutResult, this.$offsetMapping, null), 3, null);
            }
        }
        if (it.isFocused()) {
            return;
        }
        TextFieldSelectionManager.m835deselect_kEHs6E$foundation_release$default(this.$manager, null, 1, null);
    }
}
