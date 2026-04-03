package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NestedScrollInteropConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {

    @NotNull
    private final int[] consumedScrollCache;

    @NotNull
    private final NestedScrollingChildHelper nestedScrollChildHelper;

    @NotNull
    private final View view;

    public NestedScrollInteropConnection(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo301onPostFlingRZ2iAVY(long j10, long j11, @NotNull z8.d<? super Velocity> dVar) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3898getXimpl(j11)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3899getYimpl(j11)), true)) {
            j11 = Velocity.Companion.m3909getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m3889boximpl(j11);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo302onPostScrollDzOQY0M(long j10, long j11, int i10) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m3208getScrollAxesk4lQ0M(j11), NestedScrollInteropConnectionKt.m3210toViewTypeGyEprt8(i10))) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }
        kotlin.collections.o.u(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1367getXimpl(j10)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1368getYimpl(j10)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1367getXimpl(j11)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1368getYimpl(j11)), null, NestedScrollInteropConnectionKt.m3210toViewTypeGyEprt8(i10), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m3209toOffsetUv8p0NA(this.consumedScrollCache, j11);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo303onPreFlingQWom1Mo(long j10, @NotNull z8.d<? super Velocity> dVar) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3898getXimpl(j10)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m3899getYimpl(j10)))) {
            j10 = Velocity.Companion.m3909getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m3889boximpl(j10);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo304onPreScrollOzD1aCk(long j10, int i10) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m3208getScrollAxesk4lQ0M(j10), NestedScrollInteropConnectionKt.m3210toViewTypeGyEprt8(i10))) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }
        kotlin.collections.o.u(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1367getXimpl(j10)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1368getYimpl(j10)), this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m3210toViewTypeGyEprt8(i10));
        return NestedScrollInteropConnectionKt.m3209toOffsetUv8p0NA(this.consumedScrollCache, j10);
    }
}
