package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.material.ComposableSingletons$AppBarKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$AppBarKt$lambda1$1 extends v implements q<RowScope, Composer, Integer, k0> {
    public static final ComposableSingletons$AppBarKt$lambda1$1 INSTANCE = new ComposableSingletons$AppBarKt$lambda1$1();

    ComposableSingletons$AppBarKt$lambda1$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(RowScope rowScope, Composer composer, Integer num) {
        invoke(rowScope, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i10) {
        t.i(rowScope, "$this$null");
        if ((i10 & 81) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        }
    }
}
