package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class TwoLine$ListItem$1$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $overlineText;
    final /* synthetic */ p<Composer, Integer, k0> $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TwoLine$ListItem$1$2(p<? super Composer, ? super Integer, k0> pVar, int i10, p<? super Composer, ? super Integer, k0> pVar2) {
        super(2);
        this.$overlineText = pVar;
        this.$$dirty = i10;
        this.$text = pVar2;
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
            this.$overlineText.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 12) & 14));
            this.$text.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 6) & 14));
        }
    }
}
