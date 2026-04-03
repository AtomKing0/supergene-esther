package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BasicText.kt */
/* JADX INFO: loaded from: classes.dex */
final class BasicTextKt$BasicText$selectableId$2 extends v implements a<Long> {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$selectableId$2(SelectionRegistrar selectionRegistrar) {
        super(0);
        this.$selectionRegistrar = selectionRegistrar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Long invoke() {
        SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
        return Long.valueOf(selectionRegistrar != null ? selectionRegistrar.nextSelectableId() : 0L);
    }
}
