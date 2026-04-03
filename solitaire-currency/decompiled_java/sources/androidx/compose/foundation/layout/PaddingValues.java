package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface PaddingValues {

    /* JADX INFO: compiled from: Padding.kt */
    @Immutable
    public static final class Absolute implements PaddingValues {
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f10, float f11, float f12, float f13, kotlin.jvm.internal.k kVar) {
            this(f10, f11, f12, f13);
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo379calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo380calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo381calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
        public float mo382calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            return Dp.m3678equalsimpl0(this.left, absolute.left) && Dp.m3678equalsimpl0(this.top, absolute.top) && Dp.m3678equalsimpl0(this.right, absolute.right) && Dp.m3678equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return (((((Dp.m3679hashCodeimpl(this.left) * 31) + Dp.m3679hashCodeimpl(this.top)) * 31) + Dp.m3679hashCodeimpl(this.right)) * 31) + Dp.m3679hashCodeimpl(this.bottom);
        }

        @NotNull
        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) Dp.m3684toStringimpl(this.left)) + ", top=" + ((Object) Dp.m3684toStringimpl(this.top)) + ", right=" + ((Object) Dp.m3684toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m3684toStringimpl(this.bottom)) + ')';
        }

        private Absolute(float f10, float f11, float f12, float f13) {
            this.left = f10;
            this.top = f11;
            this.right = f12;
            this.bottom = f13;
        }

        public /* synthetic */ Absolute(float f10, float f11, float f12, float f13, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? Dp.m3673constructorimpl(0) : f10, (i10 & 2) != 0 ? Dp.m3673constructorimpl(0) : f11, (i10 & 4) != 0 ? Dp.m3673constructorimpl(0) : f12, (i10 & 8) != 0 ? Dp.m3673constructorimpl(0) : f13, null);
        }

        @Stable
        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m408getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m409getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m410getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m411getTopD9Ej5fM$annotations() {
        }
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float mo379calculateBottomPaddingD9Ej5fM();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo380calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo381calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float mo382calculateTopPaddingD9Ej5fM();
}
