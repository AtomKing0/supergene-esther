package androidx.compose.material;

import androidx.compose.runtime.Immutable;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class FabPlacement {
    private final int height;
    private final boolean isDocked;
    private final int left;
    private final int width;

    public FabPlacement(boolean z10, int i10, int i11, int i12) {
        this.isDocked = z10;
        this.left = i10;
        this.width = i11;
        this.height = i12;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isDocked() {
        return this.isDocked;
    }
}
