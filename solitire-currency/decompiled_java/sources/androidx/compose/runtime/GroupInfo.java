package androidx.compose.runtime;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class GroupInfo {
    private int nodeCount;
    private int nodeIndex;
    private int slotIndex;

    public GroupInfo(int i10, int i11, int i12) {
        this.slotIndex = i10;
        this.nodeIndex = i11;
        this.nodeCount = i12;
    }

    public final int getNodeCount() {
        return this.nodeCount;
    }

    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final int getSlotIndex() {
        return this.slotIndex;
    }

    public final void setNodeCount(int i10) {
        this.nodeCount = i10;
    }

    public final void setNodeIndex(int i10) {
        this.nodeIndex = i10;
    }

    public final void setSlotIndex(int i10) {
        this.slotIndex = i10;
    }
}
