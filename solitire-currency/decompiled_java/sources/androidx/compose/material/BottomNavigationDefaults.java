package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class BottomNavigationDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final BottomNavigationDefaults INSTANCE = new BottomNavigationDefaults();
    private static final float Elevation = Dp.m3673constructorimpl(8);

    private BottomNavigationDefaults() {
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m879getElevationD9Ej5fM() {
        return Elevation;
    }
}
