package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class EmptyBuildDrawCacheParams implements BuildDrawCacheParams {

    @NotNull
    public static final EmptyBuildDrawCacheParams INSTANCE = new EmptyBuildDrawCacheParams();
    private static final long size = Size.Companion.m1444getUnspecifiedNHjbRc();

    @NotNull
    private static final LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @NotNull
    private static final Density density = DensityKt.Density(1.0f, 1.0f);

    private EmptyBuildDrawCacheParams() {
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    @NotNull
    public Density getDensity() {
        return density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return layoutDirection;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public long mo1289getSizeNHjbRc() {
        return size;
    }
}
