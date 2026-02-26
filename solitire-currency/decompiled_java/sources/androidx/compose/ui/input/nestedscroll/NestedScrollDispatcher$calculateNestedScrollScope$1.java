package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class NestedScrollDispatcher$calculateNestedScrollScope$1 extends v implements h9.a<o0> {
    final /* synthetic */ NestedScrollDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedScrollDispatcher$calculateNestedScrollScope$1(NestedScrollDispatcher nestedScrollDispatcher) {
        super(0);
        this.this$0 = nestedScrollDispatcher;
    }

    @Override // h9.a
    @Nullable
    public final o0 invoke() {
        return this.this$0.getOriginNestedScrollScope$ui_release();
    }
}
