package androidx.compose.runtime;

import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SlotReader {
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;

    @NotNull
    private final int[] groups;
    private final int groupsSize;
    private int parent;

    @NotNull
    private final Object[] slots;
    private final int slotsSize;

    @NotNull
    private final SlotTable table;

    public SlotReader(@NotNull SlotTable table) {
        t.i(table, "table");
        this.table = table;
        this.groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = table.getSlots();
        this.slotsSize = table.getSlotsSize();
        this.currentEnd = groupsSize;
        this.parent = -1;
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = slotReader.currentGroup;
        }
        return slotReader.anchor(i10);
    }

    private final Object aux(int[] iArr, int i10) {
        return SlotTableKt.hasAux(iArr, i10) ? this.slots[SlotTableKt.auxIndex(iArr, i10)] : Composer.Companion.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i10) {
        if (SlotTableKt.hasObjectKey(iArr, i10)) {
            return this.slots[SlotTableKt.objectKeyIndex(iArr, i10)];
        }
        return null;
    }

    @NotNull
    public final Anchor anchor(int i10) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int iSearch = SlotTableKt.search(anchors$runtime_release, i10, this.groupsSize);
        if (iSearch < 0) {
            Anchor anchor = new Anchor(i10);
            anchors$runtime_release.add(-(iSearch + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = anchors$runtime_release.get(iSearch);
        t.h(anchor2, "get(location)");
        return anchor2;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.table.close$runtime_release(this);
    }

    public final boolean containsMark(int i10) {
        return SlotTableKt.containsMark(this.groups, i10);
    }

    public final void endEmpty() {
        int i10 = this.emptyCount;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
        }
        this.emptyCount = i10 - 1;
    }

    public final void endGroup() {
        if (this.emptyCount == 0) {
            if (!(this.currentGroup == this.currentEnd)) {
                throw new IllegalArgumentException("endGroup() not called at the end of a group".toString());
            }
            int iParentAnchor = SlotTableKt.parentAnchor(this.groups, this.parent);
            this.parent = iParentAnchor;
            this.currentEnd = iParentAnchor < 0 ? this.groupsSize : iParentAnchor + SlotTableKt.groupSize(this.groups, iParentAnchor);
        }
    }

    @NotNull
    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int iGroupSize = this.currentGroup;
        int i10 = 0;
        while (iGroupSize < this.currentEnd) {
            arrayList.add(new KeyInfo(SlotTableKt.key(this.groups, iGroupSize), objectKey(this.groups, iGroupSize), iGroupSize, SlotTableKt.isNode(this.groups, iGroupSize) ? 1 : SlotTableKt.nodeCount(this.groups, iGroupSize), i10));
            iGroupSize += SlotTableKt.groupSize(this.groups, iGroupSize);
            i10++;
        }
        return arrayList;
    }

    public final void forEachData$runtime_release(int i10, @NotNull p<? super Integer, Object, k0> block) {
        t.i(block, "block");
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i10);
        int i11 = i10 + 1;
        int iDataAnchor = i11 < this.table.getGroupsSize() ? SlotTableKt.dataAnchor(this.table.getGroups(), i11) : this.table.getSlotsSize();
        for (int i12 = iSlotAnchor; i12 < iDataAnchor; i12++) {
            block.mo4invoke(Integer.valueOf(i12 - iSlotAnchor), this.slots[i12]);
        }
    }

    @Nullable
    public final Object get(int i10) {
        int i11 = this.currentSlot + i10;
        return i11 < this.currentSlotEnd ? this.slots[i11] : Composer.Companion.getEmpty();
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    @Nullable
    public final Object getGroupAux() {
        int i10 = this.currentGroup;
        if (i10 < this.currentEnd) {
            return aux(this.groups, i10);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int i10 = this.currentGroup;
        if (i10 < this.currentEnd) {
            return SlotTableKt.key(this.groups, i10);
        }
        return 0;
    }

    @Nullable
    public final Object getGroupNode() {
        int i10 = this.currentGroup;
        if (i10 < this.currentEnd) {
            return node(this.groups, i10);
        }
        return null;
    }

    @Nullable
    public final Object getGroupObjectKey() {
        int i10 = this.currentGroup;
        if (i10 < this.currentEnd) {
            return objectKey(this.groups, i10);
        }
        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int i10 = this.currentGroup;
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i10);
        int i11 = i10 + 1;
        return (i11 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i11) : this.slotsSize) - iSlotAnchor;
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getNodeCount() {
        return SlotTableKt.nodeCount(this.groups, this.currentGroup);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i10 = this.parent;
        if (i10 >= 0) {
            return SlotTableKt.nodeCount(this.groups, i10);
        }
        return 0;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    @NotNull
    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int i10) {
        return aux(this.groups, i10);
    }

    public final int groupEnd(int i10) {
        return i10 + SlotTableKt.groupSize(this.groups, i10);
    }

    @Nullable
    public final Object groupGet(int i10) {
        return groupGet(this.currentGroup, i10);
    }

    public final int groupKey(int i10) {
        return SlotTableKt.key(this.groups, i10);
    }

    @Nullable
    public final Object groupObjectKey(int i10) {
        return objectKey(this.groups, i10);
    }

    public final int groupSize(int i10) {
        return SlotTableKt.groupSize(this.groups, i10);
    }

    public final boolean hasMark(int i10) {
        return SlotTableKt.hasMark(this.groups, i10);
    }

    public final boolean hasObjectKey(int i10) {
        return SlotTableKt.hasObjectKey(this.groups, i10);
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean isNode() {
        return SlotTableKt.isNode(this.groups, this.currentGroup);
    }

    @Nullable
    public final Object next() {
        int i10;
        if (this.emptyCount > 0 || (i10 = this.currentSlot) >= this.currentSlotEnd) {
            return Composer.Companion.getEmpty();
        }
        Object[] objArr = this.slots;
        this.currentSlot = i10 + 1;
        return objArr[i10];
    }

    @Nullable
    public final Object node(int i10) {
        if (SlotTableKt.isNode(this.groups, i10)) {
            return node(this.groups, i10);
        }
        return null;
    }

    public final int nodeCount(int i10) {
        return SlotTableKt.nodeCount(this.groups, i10);
    }

    public final int parent(int i10) {
        return SlotTableKt.parentAnchor(this.groups, i10);
    }

    public final int parentOf(int i10) {
        if (i10 >= 0 && i10 < this.groupsSize) {
            return SlotTableKt.parentAnchor(this.groups, i10);
        }
        throw new IllegalArgumentException(("Invalid group index " + i10).toString());
    }

    public final void reposition(int i10) {
        if (!(this.emptyCount == 0)) {
            throw new IllegalArgumentException("Cannot reposition while in an empty region".toString());
        }
        this.currentGroup = i10;
        int iParentAnchor = i10 < this.groupsSize ? SlotTableKt.parentAnchor(this.groups, i10) : -1;
        this.parent = iParentAnchor;
        if (iParentAnchor < 0) {
            this.currentEnd = this.groupsSize;
        } else {
            this.currentEnd = iParentAnchor + SlotTableKt.groupSize(this.groups, iParentAnchor);
        }
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void restoreParent(int i10) {
        int iGroupSize = SlotTableKt.groupSize(this.groups, i10) + i10;
        int i11 = this.currentGroup;
        if (i11 >= i10 && i11 <= iGroupSize) {
            this.parent = i10;
            this.currentEnd = iGroupSize;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        throw new IllegalArgumentException(("Index " + i10 + " is not a parent of " + i11).toString());
    }

    public final int skipGroup() {
        if (!(this.emptyCount == 0)) {
            throw new IllegalArgumentException("Cannot skip while in an empty region".toString());
        }
        int iNodeCount = SlotTableKt.isNode(this.groups, this.currentGroup) ? 1 : SlotTableKt.nodeCount(this.groups, this.currentGroup);
        int i10 = this.currentGroup;
        this.currentGroup = i10 + SlotTableKt.groupSize(this.groups, i10);
        return iNodeCount;
    }

    public final void skipToGroupEnd() {
        if (!(this.emptyCount == 0)) {
            throw new IllegalArgumentException("Cannot skip the enclosing group while in an empty region".toString());
        }
        this.currentGroup = this.currentEnd;
    }

    public final void startGroup() {
        if (this.emptyCount <= 0) {
            if (!(SlotTableKt.parentAnchor(this.groups, this.currentGroup) == this.parent)) {
                throw new IllegalArgumentException("Invalid slot table detected".toString());
            }
            int i10 = this.currentGroup;
            this.parent = i10;
            this.currentEnd = i10 + SlotTableKt.groupSize(this.groups, i10);
            int i11 = this.currentGroup;
            int i12 = i11 + 1;
            this.currentGroup = i12;
            this.currentSlot = SlotTableKt.slotAnchor(this.groups, i11);
            this.currentSlotEnd = i11 >= this.groupsSize - 1 ? this.slotsSize : SlotTableKt.dataAnchor(this.groups, i12);
        }
    }

    public final void startNode() {
        if (this.emptyCount <= 0) {
            if (!SlotTableKt.isNode(this.groups, this.currentGroup)) {
                throw new IllegalArgumentException("Expected a node group".toString());
            }
            startGroup();
        }
    }

    @NotNull
    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }

    private final Object node(int[] iArr, int i10) {
        return SlotTableKt.isNode(iArr, i10) ? this.slots[SlotTableKt.nodeIndex(iArr, i10)] : Composer.Companion.getEmpty();
    }

    @Nullable
    public final Object groupGet(int i10, int i11) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i10);
        int i12 = i10 + 1;
        int i13 = iSlotAnchor + i11;
        return i13 < (i12 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i12) : this.slotsSize) ? this.slots[i13] : Composer.Companion.getEmpty();
    }

    public final int groupKey(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        if (anchor.getValid()) {
            return SlotTableKt.key(this.groups, this.table.anchorIndex(anchor));
        }
        return 0;
    }

    public final boolean isNode(int i10) {
        return SlotTableKt.isNode(this.groups, i10);
    }
}
