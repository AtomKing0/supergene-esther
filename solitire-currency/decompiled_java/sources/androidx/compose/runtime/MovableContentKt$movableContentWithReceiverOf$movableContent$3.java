package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: Add missing generic type declarations: [P1, R, P2] */
/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class MovableContentKt$movableContentWithReceiverOf$movableContent$3<P1, P2, R> extends v implements q<s<? extends s<? extends R, ? extends P1>, ? extends P2>, Composer, Integer, k0> {
    final /* synthetic */ h9.s<R, P1, P2, Composer, Integer, k0> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$3(h9.s<? super R, ? super P1, ? super P2, ? super Composer, ? super Integer, k0> sVar) {
        super(3);
        this.$content = sVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Object obj, Composer composer, Integer num) {
        invoke((s) obj, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@NotNull s<? extends s<? extends R, ? extends P1>, ? extends P2> it, @Nullable Composer composer, int i10) {
        t.i(it, "it");
        this.$content.invoke(it.c().c(), it.c().d(), it.d(), composer, 0);
    }
}
