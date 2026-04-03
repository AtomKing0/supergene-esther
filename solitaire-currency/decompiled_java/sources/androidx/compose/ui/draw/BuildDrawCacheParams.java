package androidx.compose.ui.draw;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface BuildDrawCacheParams {
    @NotNull
    Density getDensity();

    @NotNull
    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    long mo1289getSizeNHjbRc();
}
