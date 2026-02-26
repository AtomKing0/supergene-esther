package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class MenuDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final MenuDefaults INSTANCE = new MenuDefaults();

    @NotNull
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m393PaddingValuesYgX7TsA(MenuKt.DropdownMenuItemHorizontalPadding, Dp.m3673constructorimpl(0));

    private MenuDefaults() {
    }

    @NotNull
    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
