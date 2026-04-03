package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabRowKt$TabRow$1 extends v implements q<List<? extends TabPosition>, Composer, Integer, k0> {
    final /* synthetic */ int $selectedTabIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRow$1(int i10) {
        super(3);
        this.$selectedTabIndex = i10;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
        invoke((List<TabPosition>) list, composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull List<TabPosition> tabPositions, @Nullable Composer composer, int i10) {
        t.i(tabPositions, "tabPositions");
        TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
        tabRowDefaults.m1176Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.Companion, tabPositions.get(this.$selectedTabIndex)), 0.0f, 0L, composer, 3072, 6);
    }
}
