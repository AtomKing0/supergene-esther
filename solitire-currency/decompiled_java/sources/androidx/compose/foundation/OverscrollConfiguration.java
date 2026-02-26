package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OverscrollConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public final class OverscrollConfiguration {

    @NotNull
    private final PaddingValues drawPadding;
    private final long glowColor;

    public /* synthetic */ OverscrollConfiguration(long j10, PaddingValues paddingValues, kotlin.jvm.internal.k kVar) {
        this(j10, paddingValues);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(OverscrollConfiguration.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        }
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) obj;
        return Color.m1599equalsimpl0(this.glowColor, overscrollConfiguration.glowColor) && t.d(this.drawPadding, overscrollConfiguration.drawPadding);
    }

    @NotNull
    public final PaddingValues getDrawPadding() {
        return this.drawPadding;
    }

    /* JADX INFO: renamed from: getGlowColor-0d7_KjU, reason: not valid java name */
    public final long m235getGlowColor0d7_KjU() {
        return this.glowColor;
    }

    public int hashCode() {
        return (Color.m1605hashCodeimpl(this.glowColor) * 31) + this.drawPadding.hashCode();
    }

    @NotNull
    public String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) Color.m1606toStringimpl(this.glowColor)) + ", drawPadding=" + this.drawPadding + ')';
    }

    private OverscrollConfiguration(long j10, PaddingValues paddingValues) {
        this.glowColor = j10;
        this.drawPadding = paddingValues;
    }

    public /* synthetic */ OverscrollConfiguration(long j10, PaddingValues paddingValues, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? ColorKt.Color(4284900966L) : j10, (i10 & 2) != 0 ? PaddingKt.m394PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null) : paddingValues, null);
    }
}
