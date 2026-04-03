package androidx.compose.runtime;

import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class MovableContentKt$movableContentOf$movableContent$1 extends v implements q<k0, Composer, Integer, k0> {
    final /* synthetic */ p<Composer, Integer, k0> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentOf$movableContent$1(p<? super Composer, ? super Integer, k0> pVar) {
        super(3);
        this.$content = pVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(k0 k0Var, Composer composer, Integer num) {
        invoke(k0Var, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@NotNull k0 it, @Nullable Composer composer, int i10) {
        t.i(it, "it");
        if ((i10 & 81) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            this.$content.mo4invoke(composer, 0);
        }
    }
}
