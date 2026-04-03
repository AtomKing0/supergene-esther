package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class ExcludeInsets implements WindowInsets {

    @NotNull
    private final WindowInsets excluded;

    @NotNull
    private final WindowInsets included;

    public ExcludeInsets(@NotNull WindowInsets included, @NotNull WindowInsets excluded) {
        t.i(included, "included");
        t.i(excluded, "excluded");
        this.included = included;
        this.excluded = excluded;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExcludeInsets)) {
            return false;
        }
        ExcludeInsets excludeInsets = (ExcludeInsets) obj;
        return t.d(excludeInsets.included, this.included) && t.d(excludeInsets.excluded, this.excluded);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        t.i(density, "density");
        return n9.o.e(this.included.getBottom(density) - this.excluded.getBottom(density), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return n9.o.e(this.included.getLeft(density, layoutDirection) - this.excluded.getLeft(density, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return n9.o.e(this.included.getRight(density, layoutDirection) - this.excluded.getRight(density, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        t.i(density, "density");
        return n9.o.e(this.included.getTop(density) - this.excluded.getTop(density), 0);
    }

    public int hashCode() {
        return (this.included.hashCode() * 31) + this.excluded.hashCode();
    }

    @NotNull
    public String toString() {
        return '(' + this.included + " - " + this.excluded + ')';
    }
}
