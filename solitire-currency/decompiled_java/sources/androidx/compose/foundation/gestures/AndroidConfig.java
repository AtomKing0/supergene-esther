package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidScrollable.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidConfig implements ScrollConfig {

    @NotNull
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo238calculateMouseWheelScroll8xgXZGE(@NotNull Density calculateMouseWheelScroll, @NotNull PointerEvent event, long j10) {
        t.i(calculateMouseWheelScroll, "$this$calculateMouseWheelScroll");
        t.i(event, "event");
        List<PointerInputChange> changes = event.getChanges();
        Offset offsetM1356boximpl = Offset.m1356boximpl(Offset.Companion.m1383getZeroF1C5BW0());
        int size = changes.size();
        for (int i10 = 0; i10 < size; i10++) {
            offsetM1356boximpl = Offset.m1356boximpl(Offset.m1372plusMKHz9U(offsetM1356boximpl.m1377unboximpl(), changes.get(i10).m2875getScrollDeltaF1C5BW0()));
        }
        return Offset.m1374timestuRUvjQ(offsetM1356boximpl.m1377unboximpl(), -calculateMouseWheelScroll.mo296toPx0680j_4(Dp.m3673constructorimpl(64)));
    }
}
