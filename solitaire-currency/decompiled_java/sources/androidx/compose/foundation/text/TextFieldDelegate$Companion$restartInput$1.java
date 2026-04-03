package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextFieldDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldDelegate$Companion$restartInput$1 extends v implements l<List<? extends EditCommand>, k0> {
    final /* synthetic */ EditProcessor $editProcessor;
    final /* synthetic */ l<TextFieldValue, k0> $onValueChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldDelegate$Companion$restartInput$1(EditProcessor editProcessor, l<? super TextFieldValue, k0> lVar) {
        super(1);
        this.$editProcessor = editProcessor;
        this.$onValueChange = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(List<? extends EditCommand> list) {
        invoke2(list);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<? extends EditCommand> it) {
        t.i(it, "it");
        TextFieldDelegate.Companion.onEditCommand(it, this.$editProcessor, this.$onValueChange);
    }
}
