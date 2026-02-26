package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Shape.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface Shape {
    @NotNull
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    Outline mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density);
}
