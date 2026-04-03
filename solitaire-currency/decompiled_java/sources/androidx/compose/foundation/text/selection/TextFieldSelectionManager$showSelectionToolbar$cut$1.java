package androidx.compose.foundation.text.selection;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldSelectionManager$showSelectionToolbar$cut$1 extends v implements h9.a<k0> {
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$showSelectionToolbar$cut$1(TextFieldSelectionManager textFieldSelectionManager) {
        super(0);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.cut$foundation_release();
        this.this$0.hideSelectionToolbar$foundation_release();
    }
}
