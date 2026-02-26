package androidx.compose.foundation.text;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1 extends v implements a<TextLayoutResultProxy> {
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(TextFieldState textFieldState) {
        super(0);
        this.$state = textFieldState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @Nullable
    public final TextLayoutResultProxy invoke() {
        return this.$state.getLayoutResult();
    }
}
