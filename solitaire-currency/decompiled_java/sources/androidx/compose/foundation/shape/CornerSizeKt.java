package androidx.compose.foundation.shape;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CornerSize.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CornerSizeKt {

    @NotNull
    private static final CornerSize ZeroCornerSize = new CornerSizeKt$ZeroCornerSize$1();

    @Stable
    @NotNull
    public static final CornerSize CornerSize(float f10) {
        return new PxCornerSize(f10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: CornerSize-0680j_4, reason: not valid java name */
    public static final CornerSize m638CornerSize0680j_4(float f10) {
        return new DpCornerSize(f10, null);
    }

    @NotNull
    public static final CornerSize getZeroCornerSize() {
        return ZeroCornerSize;
    }

    @Stable
    @NotNull
    public static final CornerSize CornerSize(int i10) {
        return new PercentCornerSize(i10);
    }

    @Stable
    public static /* synthetic */ void getZeroCornerSize$annotations() {
    }
}
