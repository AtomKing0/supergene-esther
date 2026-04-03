package androidx.compose.foundation.text.selection;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextPreparedSelectionState {

    @Nullable
    private Float cachedX;

    @Nullable
    public final Float getCachedX() {
        return this.cachedX;
    }

    public final void resetCachedX() {
        this.cachedX = null;
    }

    public final void setCachedX(@Nullable Float f10) {
        this.cachedX = f10;
    }
}
