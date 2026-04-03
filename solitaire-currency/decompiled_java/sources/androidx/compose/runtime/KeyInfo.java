package androidx.compose.runtime;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInfo {
    private final int index;
    private final int key;
    private final int location;
    private final int nodes;

    @Nullable
    private final Object objectKey;

    public KeyInfo(int i10, @Nullable Object obj, int i11, int i12, int i13) {
        this.key = i10;
        this.objectKey = obj;
        this.location = i11;
        this.nodes = i12;
        this.index = i13;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getKey() {
        return this.key;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getNodes() {
        return this.nodes;
    }

    @Nullable
    public final Object getObjectKey() {
        return this.objectKey;
    }
}
