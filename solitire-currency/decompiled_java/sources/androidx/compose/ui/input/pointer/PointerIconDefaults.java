package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerIcon.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class PointerIconDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final PointerIconDefaults INSTANCE = new PointerIconDefaults();

    @NotNull
    private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();

    @NotNull
    private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();

    @NotNull
    private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();

    @NotNull
    private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

    private PointerIconDefaults() {
    }

    @NotNull
    public final PointerIcon getCrosshair() {
        return Crosshair;
    }

    @NotNull
    public final PointerIcon getDefault() {
        return Default;
    }

    @NotNull
    public final PointerIcon getHand() {
        return Hand;
    }

    @NotNull
    public final PointerIcon getText() {
        return Text;
    }
}
