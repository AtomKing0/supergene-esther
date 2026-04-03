package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsKt {
    @NotNull
    public static final WindowInsets WindowInsets(int i10, int i11, int i12, int i13) {
        return new FixedIntInsets(i10, i11, i12, i13);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        return WindowInsets(i10, i11, i12, i13);
    }

    @NotNull
    /* JADX INFO: renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m455WindowInsetsa9UjIt4(float f10, float f11, float f12, float f13) {
        return new FixedDpInsets(f10, f11, f12, f13, null);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m456WindowInsetsa9UjIt4$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(0);
        }
        return m455WindowInsetsa9UjIt4(f10, f11, f12, f13);
    }

    @NotNull
    public static final WindowInsets add(@NotNull WindowInsets windowInsets, @NotNull WindowInsets insets) {
        t.i(windowInsets, "<this>");
        t.i(insets, "insets");
        return new AddedInsets(windowInsets, insets);
    }

    @NotNull
    public static final WindowInsets asInsets(@NotNull PaddingValues paddingValues) {
        t.i(paddingValues, "<this>");
        return new PaddingValuesInsets(paddingValues);
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @Nullable Composer composer, int i10) {
        t.i(windowInsets, "<this>");
        return new InsetsPaddingValues(windowInsets, (Density) composer.consume(CompositionLocalsKt.getLocalDensity()));
    }

    @NotNull
    public static final WindowInsets exclude(@NotNull WindowInsets windowInsets, @NotNull WindowInsets insets) {
        t.i(windowInsets, "<this>");
        t.i(insets, "insets");
        return new ExcludeInsets(windowInsets, insets);
    }

    @NotNull
    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m457onlybOOhFvg(@NotNull WindowInsets only, int i10) {
        t.i(only, "$this$only");
        return new LimitInsets(only, i10, null);
    }

    @NotNull
    public static final WindowInsets union(@NotNull WindowInsets windowInsets, @NotNull WindowInsets insets) {
        t.i(windowInsets, "<this>");
        t.i(insets, "insets");
        return new UnionInsets(windowInsets, insets);
    }

    @NotNull
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @NotNull Density density) {
        t.i(windowInsets, "<this>");
        t.i(density, "density");
        return new InsetsPaddingValues(windowInsets, density);
    }
}
