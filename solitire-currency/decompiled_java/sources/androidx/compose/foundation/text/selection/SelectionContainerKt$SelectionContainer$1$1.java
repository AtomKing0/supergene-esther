package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SelectionContainer.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectionContainerKt$SelectionContainer$1$1 extends v implements l<Selection, k0> {
    final /* synthetic */ MutableState<Selection> $selection$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$1$1(MutableState<Selection> mutableState) {
        super(1);
        this.$selection$delegate = mutableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Selection selection) {
        invoke2(selection);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Selection selection) {
        this.$selection$delegate.setValue(selection);
    }
}
