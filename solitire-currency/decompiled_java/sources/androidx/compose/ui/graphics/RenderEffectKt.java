package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RenderEffect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: BlurEffect-3YTHUZs, reason: not valid java name */
    public static final BlurEffect m1849BlurEffect3YTHUZs(float f10, float f11, int i10) {
        return new BlurEffect(null, f10, f11, i10, null);
    }

    /* JADX INFO: renamed from: BlurEffect-3YTHUZs$default, reason: not valid java name */
    public static /* synthetic */ BlurEffect m1850BlurEffect3YTHUZs$default(float f10, float f11, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = TileMode.Companion.m1905getClamp3opZhB0();
        }
        return m1849BlurEffect3YTHUZs(f10, f11, i10);
    }

    @Stable
    @NotNull
    public static final OffsetEffect OffsetEffect(float f10, float f11) {
        return new OffsetEffect(null, OffsetKt.Offset(f10, f11), null);
    }
}
