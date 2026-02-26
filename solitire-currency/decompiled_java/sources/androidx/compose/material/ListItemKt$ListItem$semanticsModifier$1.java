package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class ListItemKt$ListItem$semanticsModifier$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    public static final ListItemKt$ListItem$semanticsModifier$1 INSTANCE = new ListItemKt$ListItem$semanticsModifier$1();

    ListItemKt$ListItem$semanticsModifier$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }
}
