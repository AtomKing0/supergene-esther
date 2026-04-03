package androidx.compose.ui.state;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ToggleableState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleableStateKt {
    @NotNull
    public static final ToggleableState ToggleableState(boolean z10) {
        return z10 ? ToggleableState.On : ToggleableState.Off;
    }
}
