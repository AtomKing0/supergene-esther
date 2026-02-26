package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ p<Composer, Integer, k0> $it;
    final /* synthetic */ long $leadingIconColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(long j10, p<? super Composer, ? super Integer, k0> pVar) {
        super(2);
        this.$leadingIconColor = j10;
        this.$it = pVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            TextFieldImplKt.m1204DecorationeuL9pac(this.$leadingIconColor, null, null, this.$it, composer, 0, 6);
        }
    }
}
