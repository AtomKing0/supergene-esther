package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface WindowInsets {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: WindowInsets.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    int getBottom(@NotNull Density density);

    int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getTop(@NotNull Density density);
}
