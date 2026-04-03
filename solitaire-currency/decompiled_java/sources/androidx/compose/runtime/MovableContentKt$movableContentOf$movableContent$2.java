package androidx.compose.runtime;

import h9.q;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: Add missing generic type declarations: [P1, P2] */
/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class MovableContentKt$movableContentOf$movableContent$2<P1, P2> extends v implements q<s<? extends P1, ? extends P2>, Composer, Integer, k0> {
    final /* synthetic */ r<P1, P2, Composer, Integer, k0> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentOf$movableContent$2(r<? super P1, ? super P2, ? super Composer, ? super Integer, k0> rVar) {
        super(3);
        this.$content = rVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Object obj, Composer composer, Integer num) {
        invoke((s) obj, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@NotNull s<? extends P1, ? extends P2> it, @Nullable Composer composer, int i10) {
        t.i(it, "it");
        if ((i10 & 14) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if ((i10 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            this.$content.invoke(it.c(), it.d(), composer, 0);
        }
    }
}
