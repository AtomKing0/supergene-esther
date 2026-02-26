package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NestedScrollInteropConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float f10) {
        return (float) (f10 >= 0.0f ? Math.ceil(f10) : Math.floor(f10));
    }

    public static final int composeToViewOffset(float f10) {
        return ((int) ceilAwayFromZero(f10)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final int m3208getScrollAxesk4lQ0M(long j10) {
        int i10 = Math.abs(Offset.m1367getXimpl(j10)) >= 0.5f ? 1 : 0;
        return Math.abs(Offset.m1368getYimpl(j10)) >= 0.5f ? i10 | 2 : i10;
    }

    @Composable
    @ExperimentalComposeUiApi
    @NotNull
    public static final NestedScrollConnection rememberNestedScrollInteropConnection(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1471602047);
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new NestedScrollInteropConnection(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) objRememberedValue;
        composer.endReplaceableGroup();
        return nestedScrollInteropConnection;
    }

    private static final float reverseAxis(int i10) {
        return i10 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    public static final long m3209toOffsetUv8p0NA(int[] iArr, long j10) {
        return OffsetKt.Offset(Offset.m1367getXimpl(j10) >= 0.0f ? n9.o.i(reverseAxis(iArr[0]), Offset.m1367getXimpl(j10)) : n9.o.d(reverseAxis(iArr[0]), Offset.m1367getXimpl(j10)), Offset.m1368getYimpl(j10) >= 0.0f ? n9.o.i(reverseAxis(iArr[1]), Offset.m1368getYimpl(j10)) : n9.o.d(reverseAxis(iArr[1]), Offset.m1368getYimpl(j10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m3210toViewTypeGyEprt8(int i10) {
        return !NestedScrollSource.m2782equalsimpl0(i10, NestedScrollSource.Companion.m2787getDragWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toViewVelocity(float f10) {
        return f10 * (-1.0f);
    }
}
