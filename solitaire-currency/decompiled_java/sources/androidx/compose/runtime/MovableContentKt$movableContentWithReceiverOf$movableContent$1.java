package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class MovableContentKt$movableContentWithReceiverOf$movableContent$1<R> extends v implements q<R, Composer, Integer, k0> {
    final /* synthetic */ q<R, Composer, Integer, k0> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$1(q<? super R, ? super Composer, ? super Integer, k0> qVar) {
        super(3);
        this.$content = qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Object obj, Composer composer, Integer num) {
        invoke(obj, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(R r10, @Nullable Composer composer, int i10) {
        if ((i10 & 14) == 0) {
            i10 |= composer.changed(r10) ? 4 : 2;
        }
        if ((i10 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            this.$content.invoke(r10, composer, Integer.valueOf(i10 & 14));
        }
    }
}
