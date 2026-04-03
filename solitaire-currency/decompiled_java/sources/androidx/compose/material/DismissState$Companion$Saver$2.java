package androidx.compose.material;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
final class DismissState$Companion$Saver$2 extends v implements l<DismissValue, DismissState> {
    final /* synthetic */ l<DismissValue, Boolean> $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DismissState$Companion$Saver$2(l<? super DismissValue, Boolean> lVar) {
        super(1);
        this.$confirmStateChange = lVar;
    }

    @Override // h9.l
    @Nullable
    public final DismissState invoke(@NotNull DismissValue it) {
        t.i(it, "it");
        return new DismissState(it, this.$confirmStateChange);
    }
}
