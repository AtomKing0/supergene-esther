package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoImpl implements WindowInfo {

    @NotNull
    private final MutableState<Boolean> _isWindowFocused = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return this._isWindowFocused.getValue().booleanValue();
    }

    public void setWindowFocused(boolean z10) {
        this._isWindowFocused.setValue(Boolean.valueOf(z10));
    }
}
