package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabKt$Tab$2 extends v implements q<ColumnScope, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ p<Composer, Integer, k0> $styledText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabKt$Tab$2(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10) {
        super(3);
        this.$styledText = pVar;
        this.$icon = pVar2;
        this.$$dirty = i10;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull ColumnScope Tab, @Nullable Composer composer, int i10) {
        t.i(Tab, "$this$Tab");
        if ((i10 & 81) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            TabKt.TabBaselineLayout(this.$styledText, this.$icon, composer, (this.$$dirty >> 12) & 112);
        }
    }
}
