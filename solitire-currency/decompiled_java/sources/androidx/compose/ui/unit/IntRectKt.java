package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntRect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntRectKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m3822IntRectE1MhUcY(long j10, long j11) {
        return new IntRect(IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10), IntOffset.m3791getXimpl(j11), IntOffset.m3792getYimpl(j11));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m3823IntRectVbeCjmY(long j10, long j11) {
        return new IntRect(IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10), IntOffset.m3791getXimpl(j10) + IntSize.m3833getWidthimpl(j11), IntOffset.m3792getYimpl(j10) + IntSize.m3832getHeightimpl(j11));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m3824IntRectar5cAso(long j10, int i10) {
        return new IntRect(IntOffset.m3791getXimpl(j10) - i10, IntOffset.m3792getYimpl(j10) - i10, IntOffset.m3791getXimpl(j10) + i10, IntOffset.m3792getYimpl(j10) + i10);
    }

    @Stable
    @NotNull
    public static final IntRect lerp(@NotNull IntRect start, @NotNull IntRect stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new IntRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f10), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f10), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f10), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f10));
    }
}
