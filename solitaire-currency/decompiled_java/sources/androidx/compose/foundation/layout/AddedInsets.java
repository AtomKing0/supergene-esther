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
final class AddedInsets implements WindowInsets {

    @NotNull
    private final WindowInsets first;

    @NotNull
    private final WindowInsets second;

    public AddedInsets(@NotNull WindowInsets first, @NotNull WindowInsets second) {
        t.i(first, "first");
        t.i(second, "second");
        this.first = first;
        this.second = second;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddedInsets)) {
            return false;
        }
        AddedInsets addedInsets = (AddedInsets) obj;
        return t.d(addedInsets.first, this.first) && t.d(addedInsets.second, this.second);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        t.i(density, "density");
        return this.first.getBottom(density) + this.second.getBottom(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return this.first.getLeft(density, layoutDirection) + this.second.getLeft(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return this.first.getRight(density, layoutDirection) + this.second.getRight(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        t.i(density, "density");
        return this.first.getTop(density) + this.second.getTop(density);
    }

    public int hashCode() {
        return this.first.hashCode() + (this.second.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return '(' + this.first + " + " + this.second + ')';
    }
}
