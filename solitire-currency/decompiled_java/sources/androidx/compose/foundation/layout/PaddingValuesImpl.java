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
@Immutable
public final class PaddingValuesImpl implements PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f10, float f11, float f12, float f13, kotlin.jvm.internal.k kVar) {
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
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo381calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float mo382calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        return Dp.m3678equalsimpl0(this.start, paddingValuesImpl.start) && Dp.m3678equalsimpl0(this.top, paddingValuesImpl.top) && Dp.m3678equalsimpl0(this.end, paddingValuesImpl.end) && Dp.m3678equalsimpl0(this.bottom, paddingValuesImpl.bottom);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m416getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m417getEndD9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m418getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m419getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((Dp.m3679hashCodeimpl(this.start) * 31) + Dp.m3679hashCodeimpl(this.top)) * 31) + Dp.m3679hashCodeimpl(this.end)) * 31) + Dp.m3679hashCodeimpl(this.bottom);
    }

    @NotNull
    public String toString() {
        return "PaddingValues(start=" + ((Object) Dp.m3684toStringimpl(this.start)) + ", top=" + ((Object) Dp.m3684toStringimpl(this.top)) + ", end=" + ((Object) Dp.m3684toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m3684toStringimpl(this.bottom)) + ')';
    }

    private PaddingValuesImpl(float f10, float f11, float f12, float f13) {
        this.start = f10;
        this.top = f11;
        this.end = f12;
        this.bottom = f13;
    }

    public /* synthetic */ PaddingValuesImpl(float f10, float f11, float f12, float f13, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? Dp.m3673constructorimpl(0) : f10, (i10 & 2) != 0 ? Dp.m3673constructorimpl(0) : f11, (i10 & 4) != 0 ? Dp.m3673constructorimpl(0) : f12, (i10 & 8) != 0 ? Dp.m3673constructorimpl(0) : f13, null);
    }

    @Stable
    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m412getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getEnd-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m413getEndD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getStart-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m414getStartD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m415getTopD9Ej5fM$annotations() {
    }
}
