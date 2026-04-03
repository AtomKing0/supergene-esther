package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Rect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RectKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m1405Rect0a9Yr6o(long j10, long j11) {
        return new Rect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m1406Rect3MmeM6k(long j10, float f10) {
        return new Rect(Offset.m1367getXimpl(j10) - f10, Offset.m1368getYimpl(j10) - f10, Offset.m1367getXimpl(j10) + f10, Offset.m1368getYimpl(j10) + f10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m1407Recttz77jQw(long j10, long j11) {
        return new Rect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11), Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11));
    }

    @Stable
    @NotNull
    public static final Rect lerp(@NotNull Rect start, @NotNull Rect stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new Rect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f10), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f10), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f10), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f10));
    }
}
