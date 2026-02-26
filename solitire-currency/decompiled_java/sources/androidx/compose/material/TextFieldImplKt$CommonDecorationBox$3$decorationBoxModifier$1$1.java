package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ String $defaultErrorMessage;
    final /* synthetic */ boolean $isError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1(boolean z10, String str) {
        super(1);
        this.$isError = z10;
        this.$defaultErrorMessage = str;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        if (this.$isError) {
            SemanticsPropertiesKt.error(semantics, this.$defaultErrorMessage);
        }
    }
}
