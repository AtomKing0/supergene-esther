package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DpRect {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    /* JADX INFO: compiled from: Dp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public /* synthetic */ DpRect(float f10, float f11, float f12, float f13, k kVar) {
        this(f10, f11, f12, f13);
    }

    /* JADX INFO: renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpRect m3745copya9UjIt4$default(DpRect dpRect, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = dpRect.left;
        }
        if ((i10 & 2) != 0) {
            f11 = dpRect.top;
        }
        if ((i10 & 4) != 0) {
            f12 = dpRect.right;
        }
        if ((i10 & 8) != 0) {
            f13 = dpRect.bottom;
        }
        return dpRect.m3754copya9UjIt4(f10, f11, f12, f13);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m3750component1D9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m3751component2D9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m3752component3D9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m3753component4D9Ej5fM() {
        return this.bottom;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-a9UjIt4, reason: not valid java name */
    public final DpRect m3754copya9UjIt4(float f10, float f11, float f12, float f13) {
        return new DpRect(f10, f11, f12, f13, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) obj;
        return Dp.m3678equalsimpl0(this.left, dpRect.left) && Dp.m3678equalsimpl0(this.top, dpRect.top) && Dp.m3678equalsimpl0(this.right, dpRect.right) && Dp.m3678equalsimpl0(this.bottom, dpRect.bottom);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m3755getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m3756getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m3757getRightD9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m3758getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((Dp.m3679hashCodeimpl(this.left) * 31) + Dp.m3679hashCodeimpl(this.top)) * 31) + Dp.m3679hashCodeimpl(this.right)) * 31) + Dp.m3679hashCodeimpl(this.bottom);
    }

    @NotNull
    public String toString() {
        return "DpRect(left=" + ((Object) Dp.m3684toStringimpl(this.left)) + ", top=" + ((Object) Dp.m3684toStringimpl(this.top)) + ", right=" + ((Object) Dp.m3684toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m3684toStringimpl(this.bottom)) + ')';
    }

    public /* synthetic */ DpRect(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    private DpRect(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    private DpRect(long j10, long j11) {
        this(DpOffset.m3734getXD9Ej5fM(j10), DpOffset.m3736getYD9Ej5fM(j10), Dp.m3673constructorimpl(DpOffset.m3734getXD9Ej5fM(j10) + DpSize.m3771getWidthD9Ej5fM(j11)), Dp.m3673constructorimpl(DpOffset.m3736getYD9Ej5fM(j10) + DpSize.m3769getHeightD9Ej5fM(j11)), null);
    }

    @Stable
    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3746getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3747getLeftD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3748getRightD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3749getTopD9Ej5fM$annotations() {
    }
}
