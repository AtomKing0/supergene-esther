package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AppBarDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m3673constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m3673constructorimpl(8);

    @NotNull
    private static final PaddingValues ContentPadding = PaddingKt.m396PaddingValuesa9UjIt4$default(AppBarKt.AppBarHorizontalPadding, 0.0f, AppBarKt.AppBarHorizontalPadding, 0.0f, 10, null);

    private AppBarDefaults() {
    }

    /* JADX INFO: renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m857getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m858getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }
}
