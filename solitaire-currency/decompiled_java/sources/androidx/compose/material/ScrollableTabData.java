package androidx.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollableTabData {

    @NotNull
    private final o0 coroutineScope;

    @NotNull
    private final ScrollState scrollState;

    @Nullable
    private Integer selectedTab;

    public ScrollableTabData(@NotNull ScrollState scrollState, @NotNull o0 coroutineScope) {
        t.i(scrollState, "scrollState");
        t.i(coroutineScope, "coroutineScope");
        this.scrollState = scrollState;
        this.coroutineScope = coroutineScope;
    }

    private final int calculateTabOffset(TabPosition tabPosition, Density density, int i10, List<TabPosition> list) {
        int iMo290roundToPx0680j_4 = density.mo290roundToPx0680j_4(((TabPosition) d0.t0(list)).m1173getRightD9Ej5fM()) + i10;
        int maxValue = iMo290roundToPx0680j_4 - this.scrollState.getMaxValue();
        return o.n(density.mo290roundToPx0680j_4(tabPosition.m1172getLeftD9Ej5fM()) - ((maxValue / 2) - (density.mo290roundToPx0680j_4(tabPosition.m1174getWidthD9Ej5fM()) / 2)), 0, o.e(iMo290roundToPx0680j_4 - maxValue, 0));
    }

    public final void onLaidOut(@NotNull Density density, int i10, @NotNull List<TabPosition> tabPositions, int i11) {
        int iCalculateTabOffset;
        t.i(density, "density");
        t.i(tabPositions, "tabPositions");
        Integer num = this.selectedTab;
        if (num != null && num.intValue() == i11) {
            return;
        }
        this.selectedTab = Integer.valueOf(i11);
        TabPosition tabPosition = (TabPosition) d0.l0(tabPositions, i11);
        if (tabPosition == null || this.scrollState.getValue() == (iCalculateTabOffset = calculateTabOffset(tabPosition, density, i10, tabPositions))) {
            return;
        }
        k.d(this.coroutineScope, null, null, new ScrollableTabData$onLaidOut$1$1(this, iCalculateTabOffset, null), 3, null);
    }
}
