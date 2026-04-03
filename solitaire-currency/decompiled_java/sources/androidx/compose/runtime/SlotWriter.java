package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SlotWriter {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private ArrayList<Anchor> anchors;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;

    @NotNull
    private final IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;

    @NotNull
    private int[] groups;
    private int insertCount;
    private int nodeCount;

    @NotNull
    private final IntStack nodeCountStack;
    private int parent;

    @Nullable
    private PrioritySet pendingRecalculateMarks;

    @NotNull
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;

    @NotNull
    private final IntStack startStack;

    @NotNull
    private final SlotTable table;

    /* JADX INFO: compiled from: SlotTable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter slotWriter, int i10, SlotWriter slotWriter2, boolean z10, boolean z11) {
            List<Anchor> listL;
            boolean zRemoveGroup;
            int i11;
            int iGroupSize = slotWriter.groupSize(i10);
            int i12 = i10 + iGroupSize;
            int iDataIndex = slotWriter.dataIndex(i10);
            int iDataIndex2 = slotWriter.dataIndex(i12);
            int i13 = iDataIndex2 - iDataIndex;
            boolean zContainsAnyGroupMarks = slotWriter.containsAnyGroupMarks(i10);
            slotWriter2.insertGroups(iGroupSize);
            slotWriter2.insertSlots(i13, slotWriter2.getCurrentGroup());
            if (slotWriter.groupGapStart < i12) {
                slotWriter.moveGroupGapTo(i12);
            }
            if (slotWriter.slotsGapStart < iDataIndex2) {
                slotWriter.moveSlotGapTo(iDataIndex2, i12);
            }
            int[] iArr = slotWriter2.groups;
            int currentGroup = slotWriter2.getCurrentGroup();
            o.g(slotWriter.groups, iArr, currentGroup * 5, i10 * 5, i12 * 5);
            Object[] objArr = slotWriter2.slots;
            int i14 = slotWriter2.currentSlot;
            o.i(slotWriter.slots, objArr, i14, iDataIndex, iDataIndex2);
            int parent = slotWriter2.getParent();
            SlotTableKt.updateParentAnchor(iArr, currentGroup, parent);
            int i15 = currentGroup - i10;
            int i16 = currentGroup + iGroupSize;
            int iDataIndex3 = i14 - slotWriter2.dataIndex(iArr, currentGroup);
            int i17 = slotWriter2.slotsGapOwner;
            int i18 = slotWriter2.slotsGapLen;
            int length = objArr.length;
            int i19 = i17;
            int i20 = currentGroup;
            while (true) {
                if (i20 >= i16) {
                    break;
                }
                if (i20 != currentGroup) {
                    i11 = i16;
                    SlotTableKt.updateParentAnchor(iArr, i20, SlotTableKt.parentAnchor(iArr, i20) + i15);
                } else {
                    i11 = i16;
                }
                int i21 = iDataIndex3;
                SlotTableKt.updateDataAnchor(iArr, i20, slotWriter2.dataIndexToDataAnchor(slotWriter2.dataIndex(iArr, i20) + iDataIndex3, i19 >= i20 ? slotWriter2.slotsGapStart : 0, i18, length));
                if (i20 == i19) {
                    i19++;
                }
                i20++;
                iDataIndex3 = i21;
                i16 = i11;
            }
            int i22 = i16;
            slotWriter2.slotsGapOwner = i19;
            int iLocationOf = SlotTableKt.locationOf(slotWriter.anchors, i10, slotWriter.getSize$runtime_release());
            int iLocationOf2 = SlotTableKt.locationOf(slotWriter.anchors, i12, slotWriter.getSize$runtime_release());
            if (iLocationOf < iLocationOf2) {
                ArrayList arrayList = slotWriter.anchors;
                ArrayList arrayList2 = new ArrayList(iLocationOf2 - iLocationOf);
                for (int i23 = iLocationOf; i23 < iLocationOf2; i23++) {
                    Object obj = arrayList.get(i23);
                    t.h(obj, "sourceAnchors[anchorIndex]");
                    Anchor anchor = (Anchor) obj;
                    anchor.setLocation$runtime_release(anchor.getLocation$runtime_release() + i15);
                    arrayList2.add(anchor);
                }
                slotWriter2.anchors.addAll(SlotTableKt.locationOf(slotWriter2.anchors, slotWriter2.getCurrentGroup(), slotWriter2.getSize$runtime_release()), arrayList2);
                arrayList.subList(iLocationOf, iLocationOf2).clear();
                listL = arrayList2;
            } else {
                listL = v.l();
            }
            int iParent = slotWriter.parent(i10);
            if (z10) {
                int i24 = iParent >= 0 ? 1 : 0;
                if (i24 != 0) {
                    slotWriter.startGroup();
                    slotWriter.advanceBy(iParent - slotWriter.getCurrentGroup());
                    slotWriter.startGroup();
                }
                slotWriter.advanceBy(i10 - slotWriter.getCurrentGroup());
                zRemoveGroup = slotWriter.removeGroup();
                if (i24 != 0) {
                    slotWriter.skipToGroupEnd();
                    slotWriter.endGroup();
                    slotWriter.skipToGroupEnd();
                    slotWriter.endGroup();
                }
            } else {
                boolean zRemoveGroups = slotWriter.removeGroups(i10, iGroupSize);
                slotWriter.removeSlots(iDataIndex, i13, i10 - 1);
                zRemoveGroup = zRemoveGroups;
            }
            if (!(!zRemoveGroup)) {
                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                throw new h();
            }
            slotWriter2.nodeCount += SlotTableKt.isNode(iArr, currentGroup) ? 1 : SlotTableKt.nodeCount(iArr, currentGroup);
            if (z11) {
                slotWriter2.currentGroup = i22;
                slotWriter2.currentSlot = i14 + i13;
            }
            if (zContainsAnyGroupMarks) {
                slotWriter2.updateContainsMark(parent);
            }
            return listL;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SlotWriter$groupSlots$1, reason: invalid class name */
    /* JADX INFO: compiled from: SlotTable.kt */
    public static final class AnonymousClass1 implements Iterator<Object>, i9.a {
        final /* synthetic */ int $end;
        private int current;
        final /* synthetic */ SlotWriter this$0;

        AnonymousClass1(int i10, int i11, SlotWriter slotWriter) {
            this.$end = i11;
            this.this$0 = slotWriter;
            this.current = i10;
        }

        public final int getCurrent() {
            return this.current;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current < this.$end;
        }

        @Override // java.util.Iterator
        @Nullable
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            Object[] objArr = this.this$0.slots;
            SlotWriter slotWriter = this.this$0;
            int i10 = this.current;
            this.current = i10 + 1;
            return objArr[slotWriter.dataIndexToDataAddress(i10)];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCurrent(int i10) {
            this.current = i10;
        }
    }

    public SlotWriter(@NotNull SlotTable table) {
        t.i(table, "table");
        this.table = table;
        this.groups = table.getGroups();
        this.slots = table.getSlots();
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = table.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - table.getGroupsSize();
        this.currentGroupEnd = table.getGroupsSize();
        this.slotsGapStart = table.getSlotsSize();
        this.slotsGapLen = this.slots.length - table.getSlotsSize();
        this.slotsGapOwner = table.getGroupsSize();
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.parent = -1;
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i10);
    }

    private final int auxIndex(int[] iArr, int i10) {
        return dataIndex(iArr, i10) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i10) >> 29);
    }

    private final boolean childContainsAnyMarks(int i10) {
        int iGroupSize = i10 + 1;
        int iGroupSize2 = i10 + groupSize(i10);
        while (iGroupSize < iGroupSize2) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(iGroupSize))) {
                return true;
            }
            iGroupSize += groupSize(iGroupSize);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int i10) {
        return i10 >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i10));
    }

    private final boolean containsGroupMark(int i10) {
        return i10 >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(i10));
    }

    private final int dataAnchorToDataIndex(int i10, int i11, int i12) {
        return i10 < 0 ? (i12 - i11) + i10 + 1 : i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int i10) {
        return dataIndex(this.groups, groupIndexToAddress(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i10) {
        return i10 < this.slotsGapStart ? i10 : i10 + this.slotsGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int i10, int i11, int i12, int i13) {
        return i10 > i11 ? -(((i13 - i12) - i10) + 1) : i10;
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List listDataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List listA0 = d0.A0(d0.G0(listDataAnchors$default, n9.o.u(0, this.groupGapStart)), d0.G0(listDataAnchors$default, n9.o.u(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(listA0.size());
        int size = listA0.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) listA0.get(i10)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final void fixParentAnchorsFor(int i10, int i11, int i12) {
        int iParentIndexToAnchor = parentIndexToAnchor(i10, this.groupGapStart);
        while (i12 < i11) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(i12), iParentIndexToAnchor);
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i12)) + i12;
            fixParentAnchorsFor(i12, iGroupSize, i12 + 1);
            i12 = iGroupSize;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final void groupAsString(StringBuilder sb, int i10) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        sb.append("Group(");
        if (i10 < 10) {
            sb.append(' ');
        }
        if (i10 < 100) {
            sb.append(' ');
        }
        if (i10 < 1000) {
            sb.append(' ');
        }
        sb.append(i10);
        if (iGroupIndexToAddress != i10) {
            sb.append("(");
            sb.append(iGroupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, iGroupIndexToAddress));
        boolean zGroupAsString$isStarted = groupAsString$isStarted(this, i10);
        if (zGroupAsString$isStarted) {
            sb.append('?');
        }
        sb.append('^');
        sb.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, iGroupIndexToAddress)));
        sb.append(": key=");
        sb.append(SlotTableKt.key(this.groups, iGroupIndexToAddress));
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress));
        if (zGroupAsString$isStarted) {
            sb.append('?');
        }
        sb.append(", dataAnchor=");
        sb.append(SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress));
        sb.append(", parentAnchor=");
        sb.append(SlotTableKt.parentAnchor(this.groups, iGroupIndexToAddress));
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            sb.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))]);
        }
        int iSlotIndex = slotIndex(this.groups, iGroupIndexToAddress);
        int iDataIndex = dataIndex(this.groups, iGroupIndexToAddress + 1);
        if (iDataIndex > iSlotIndex) {
            sb.append(", [");
            for (int i11 = iSlotIndex; i11 < iDataIndex; i11++) {
                if (i11 != iSlotIndex) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(this.slots[dataIndexToDataAddress(i11)]));
            }
            sb.append(']');
        }
        sb.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter slotWriter, int i10) {
        return i10 < slotWriter.currentGroup && (i10 == slotWriter.parent || slotWriter.startStack.indexOf(i10) >= 0 || groupAsString$isStarted(slotWriter, slotWriter.parent(i10)));
    }

    private final int groupIndexToAddress(int i10) {
        return i10 < this.groupGapStart ? i10 : i10 + this.groupGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int i10) {
        if (i10 > 0) {
            int i11 = this.currentGroup;
            moveGroupGapTo(i11);
            int i12 = this.groupGapStart;
            int i13 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i14 = length - i13;
            if (i13 < i10) {
                int iMax = Math.max(Math.max(length * 2, i14 + i10), 32);
                int[] iArr2 = new int[iMax * 5];
                int i15 = iMax - i14;
                o.g(iArr, iArr2, 0, 0, i12 * 5);
                o.g(iArr, iArr2, (i12 + i15) * 5, (i13 + i12) * 5, length * 5);
                this.groups = iArr2;
                i13 = i15;
            }
            int i16 = this.currentGroupEnd;
            if (i16 >= i12) {
                this.currentGroupEnd = i16 + i10;
            }
            int i17 = i12 + i10;
            this.groupGapStart = i17;
            this.groupGapLen = i13 - i10;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(i14 > 0 ? dataIndex(i11 + i10) : 0, this.slotsGapOwner >= i12 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i18 = i12; i18 < i17; i18++) {
                SlotTableKt.updateDataAnchor(this.groups, i18, iDataIndexToDataAnchor);
            }
            int i19 = this.slotsGapOwner;
            if (i19 >= i12) {
                this.slotsGapOwner = i19 + i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int i10, int i11) {
        if (i10 > 0) {
            moveSlotGapTo(this.currentSlot, i11);
            int i12 = this.slotsGapStart;
            int i13 = this.slotsGapLen;
            if (i13 < i10) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i14 = length - i13;
                int iMax = Math.max(Math.max(length * 2, i14 + i10), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i15 = 0; i15 < iMax; i15++) {
                    objArr2[i15] = null;
                }
                int i16 = iMax - i14;
                int i17 = i13 + i12;
                o.i(objArr, objArr2, 0, 0, i12);
                o.i(objArr, objArr2, i12 + i16, i17, length);
                this.slots = objArr2;
                i13 = i16;
            }
            int i18 = this.currentSlotEnd;
            if (i18 >= i12) {
                this.currentSlotEnd = i18 + i10;
            }
            this.slotsGapStart = i12 + i10;
            this.slotsGapLen = i13 - i10;
        }
    }

    private final List<Integer> keys() {
        List listKeys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(listKeys$default.size());
        int size = listKeys$default.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = listKeys$default.get(i10);
            ((Number) obj).intValue();
            int i11 = this.groupGapStart;
            if (i10 < i11 || i10 >= i11 + this.groupGapLen) {
                arrayList.add(obj);
            }
            i10++;
        }
        return arrayList;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = slotWriter.parent;
        }
        slotWriter.markGroup(i10);
    }

    private final void moveAnchors(int i10, int i11, int i12) {
        int i13 = i12 + i10;
        int size$runtime_release = getSize$runtime_release();
        int iLocationOf = SlotTableKt.locationOf(this.anchors, i10, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (iLocationOf >= 0) {
            while (iLocationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(iLocationOf);
                t.h(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int iAnchorIndex = anchorIndex(anchor2);
                if (iAnchorIndex < i10 || iAnchorIndex >= i13) {
                    break;
                }
                arrayList.add(anchor2);
                this.anchors.remove(iLocationOf);
            }
        }
        int i14 = i11 - i10;
        int size = arrayList.size();
        for (int i15 = 0; i15 < size; i15++) {
            Anchor anchor3 = (Anchor) arrayList.get(i15);
            int iAnchorIndex2 = anchorIndex(anchor3) + i14;
            if (iAnchorIndex2 >= this.groupGapStart) {
                anchor3.setLocation$runtime_release(-(size$runtime_release - iAnchorIndex2));
            } else {
                anchor3.setLocation$runtime_release(iAnchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, iAnchorIndex2, size$runtime_release), anchor3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int i10) {
        int i11 = this.groupGapLen;
        int i12 = this.groupGapStart;
        if (i12 != i10) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i12, i10);
            }
            if (i11 > 0) {
                int[] iArr = this.groups;
                int i13 = i10 * 5;
                int i14 = i11 * 5;
                int i15 = i12 * 5;
                if (i10 < i12) {
                    o.g(iArr, iArr, i14 + i13, i13, i15);
                } else {
                    o.g(iArr, iArr, i15, i15 + i14, i13 + i14);
                }
            }
            if (i10 < i12) {
                i12 = i10 + i11;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i12 < capacity);
            while (i12 < capacity) {
                int iParentAnchor = SlotTableKt.parentAnchor(this.groups, i12);
                int iParentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(iParentAnchor), i10);
                if (iParentIndexToAnchor != iParentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i12, iParentIndexToAnchor);
                }
                i12++;
                if (i12 == i10) {
                    i12 += i11;
                }
            }
        }
        this.groupGapStart = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int i10, int i11) {
        int i12 = this.slotsGapLen;
        int i13 = this.slotsGapStart;
        int i14 = this.slotsGapOwner;
        if (i13 != i10) {
            Object[] objArr = this.slots;
            if (i10 < i13) {
                o.i(objArr, objArr, i10 + i12, i10, i13);
            } else {
                o.i(objArr, objArr, i13, i13 + i12, i10 + i12);
            }
            o.s(objArr, null, i10, i10 + i12);
        }
        int iMin = Math.min(i11 + 1, getSize$runtime_release());
        if (i14 != iMin) {
            int length = this.slots.length - i12;
            if (iMin < i14) {
                int iGroupIndexToAddress = groupIndexToAddress(iMin);
                int iGroupIndexToAddress2 = groupIndexToAddress(i14);
                int i15 = this.groupGapStart;
                while (iGroupIndexToAddress < iGroupIndexToAddress2) {
                    int iDataAnchor = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress);
                    if (!(iDataAnchor >= 0)) {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new h();
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress, -((length - iDataAnchor) + 1));
                    iGroupIndexToAddress++;
                    if (iGroupIndexToAddress == i15) {
                        iGroupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int iGroupIndexToAddress3 = groupIndexToAddress(i14);
                int iGroupIndexToAddress4 = groupIndexToAddress(iMin);
                while (iGroupIndexToAddress3 < iGroupIndexToAddress4) {
                    int iDataAnchor2 = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress3);
                    if (!(iDataAnchor2 < 0)) {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new h();
                    }
                    SlotTableKt.updateDataAnchor(this.groups, iGroupIndexToAddress3, iDataAnchor2 + length + 1);
                    iGroupIndexToAddress3++;
                    if (iGroupIndexToAddress3 == this.groupGapStart) {
                        iGroupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = iMin;
        }
        this.slotsGapStart = i10;
    }

    private final int nodeIndex(int[] iArr, int i10) {
        return dataIndex(iArr, i10);
    }

    private final int parentAnchorToIndex(int i10) {
        return i10 > -2 ? i10 : getSize$runtime_release() + i10 + 2;
    }

    private final int parentIndexToAnchor(int i10, int i11) {
        return i10 < i11 ? i10 : -((getSize$runtime_release() - i10) + 2);
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    private final boolean removeAnchors(int i10, int i11) {
        int i12 = i11 + i10;
        int iLocationOf = SlotTableKt.locationOf(this.anchors, i12, getCapacity() - this.groupGapLen);
        if (iLocationOf >= this.anchors.size()) {
            iLocationOf--;
        }
        int i13 = iLocationOf + 1;
        int i14 = 0;
        while (iLocationOf >= 0) {
            Anchor anchor = this.anchors.get(iLocationOf);
            t.h(anchor, "anchors[index]");
            Anchor anchor2 = anchor;
            int iAnchorIndex = anchorIndex(anchor2);
            if (iAnchorIndex < i10) {
                break;
            }
            if (iAnchorIndex < i12) {
                anchor2.setLocation$runtime_release(Integer.MIN_VALUE);
                if (i14 == 0) {
                    i14 = iLocationOf + 1;
                }
                i13 = iLocationOf;
            }
            iLocationOf--;
        }
        boolean z10 = i13 < i14;
        if (z10) {
            this.anchors.subList(i13, i14).clear();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int i10, int i11) {
        if (i11 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i10);
            zRemoveAnchors = arrayList.isEmpty() ^ true ? removeAnchors(i10, i11) : false;
            this.groupGapStart = i10;
            this.groupGapLen += i11;
            int i12 = this.slotsGapOwner;
            if (i12 > i10) {
                this.slotsGapOwner = Math.max(i10, i12 - i11);
            }
            int i13 = this.currentGroupEnd;
            if (i13 >= this.groupGapStart) {
                this.currentGroupEnd = i13 - i11;
            }
            if (containsGroupMark(this.parent)) {
                updateContainsMark(this.parent);
            }
        }
        return zRemoveAnchors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int i10, int i11, int i12) {
        if (i11 > 0) {
            int i13 = this.slotsGapLen;
            int i14 = i10 + i11;
            moveSlotGapTo(i14, i12);
            this.slotsGapStart = i10;
            this.slotsGapLen = i13 + i11;
            o.s(this.slots, null, i10, i14);
            int i15 = this.currentSlotEnd;
            if (i15 >= i10) {
                this.currentSlotEnd = i15 - i11;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int slotIndex(int[] iArr, int i10) {
        return i10 >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i10), this.slotsGapLen, this.slots.length);
    }

    private final void updateAnchors(int i10, int i11) {
        int i12;
        int capacity = getCapacity() - this.groupGapLen;
        if (i10 >= i11) {
            for (int iLocationOf = SlotTableKt.locationOf(this.anchors, i11, capacity); iLocationOf < this.anchors.size(); iLocationOf++) {
                Anchor anchor = this.anchors.get(iLocationOf);
                t.h(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location$runtime_release = anchor2.getLocation$runtime_release();
                if (location$runtime_release < 0) {
                    return;
                }
                anchor2.setLocation$runtime_release(-(capacity - location$runtime_release));
            }
            return;
        }
        for (int iLocationOf2 = SlotTableKt.locationOf(this.anchors, i10, capacity); iLocationOf2 < this.anchors.size(); iLocationOf2++) {
            Anchor anchor3 = this.anchors.get(iLocationOf2);
            t.h(anchor3, "anchors[index]");
            Anchor anchor4 = anchor3;
            int location$runtime_release2 = anchor4.getLocation$runtime_release();
            if (location$runtime_release2 >= 0 || (i12 = location$runtime_release2 + capacity) >= i11) {
                return;
            }
            anchor4.setLocation$runtime_release(i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateContainsMark(int i10) {
        if (i10 >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(null, 1, 0 == true ? 1 : 0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(i10);
        }
    }

    private final void updateContainsMarkNow(int i10, PrioritySet prioritySet) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        boolean zChildContainsAnyMarks = childContainsAnyMarks(i10);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress) != zChildContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, iGroupIndexToAddress, zChildContainsAnyMarks);
            int iParent = parent(i10);
            if (iParent >= 0) {
                prioritySet.add(iParent);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i10, int i11) {
        SlotTableKt.updateDataAnchor(iArr, i10, dataIndexToDataAnchor(i11, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final void updateNodeOfGroup(int i10, Object obj) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        int[] iArr = this.groups;
        if (iGroupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, iGroupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))] = obj;
            return;
        }
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + i10 + " that was not created with as a node group").toString());
        throw new h();
    }

    public final void addToGroupSizeAlongSpine(int i10, int i11) {
        while (i10 > 0) {
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, i10, SlotTableKt.groupSize(iArr, i10) + i11);
            i10 = groupIndexToAddress(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, i10)));
        }
    }

    public final void advanceBy(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Cannot seek backwards".toString());
        }
        if (!(this.insertCount <= 0)) {
            throw new IllegalStateException("Cannot call seek() while inserting".toString());
        }
        if (i10 == 0) {
            return;
        }
        int i11 = this.currentGroup + i10;
        if (i11 >= this.parent && i11 <= this.currentGroupEnd) {
            this.currentGroup = i11;
            int iDataIndex = dataIndex(this.groups, groupIndexToAddress(i11));
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            return;
        }
        ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
        throw new h();
    }

    @NotNull
    public final Anchor anchor(int i10) {
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, i10, getSize$runtime_release());
        if (iSearch >= 0) {
            Anchor anchor = arrayList.get(iSearch);
            t.h(anchor, "get(location)");
            return anchor;
        }
        if (i10 > this.groupGapStart) {
            i10 = -(getSize$runtime_release() - i10);
        }
        Anchor anchor2 = new Anchor(i10);
        arrayList.add(-(iSearch + 1), anchor2);
        return anchor2;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        int location$runtime_release = anchor.getLocation$runtime_release();
        return location$runtime_release < 0 ? location$runtime_release + getSize$runtime_release() : location$runtime_release;
    }

    public final void bashGroup$runtime_release() {
        startGroup();
        while (!isGroupEnd()) {
            insertParentGroup(-3);
            skipGroup();
        }
        endGroup();
    }

    public final void beginInsert() {
        int i10 = this.insertCount;
        this.insertCount = i10 + 1;
        if (i10 == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final int endGroup() {
        boolean z10 = this.insertCount > 0;
        int i10 = this.currentGroup;
        int i11 = this.currentGroupEnd;
        int i12 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i12);
        int i13 = this.nodeCount;
        int i14 = i10 - i12;
        boolean zIsNode = SlotTableKt.isNode(this.groups, iGroupIndexToAddress);
        if (z10) {
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i14);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i13);
            this.nodeCount = this.nodeCountStack.pop() + (zIsNode ? 1 : i13);
            this.parent = parent(this.groups, i12);
        } else {
            if ((i10 != i11 ? 0 : 1) == 0) {
                throw new IllegalArgumentException("Expected to be at the end of a group".toString());
            }
            int iGroupSize = SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
            int iNodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress, i14);
            SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress, i13);
            int iPop = this.startStack.pop();
            restoreCurrentGroupEnd();
            this.parent = iPop;
            int iParent = parent(this.groups, i12);
            int iPop2 = this.nodeCountStack.pop();
            this.nodeCount = iPop2;
            if (iParent == iPop) {
                this.nodeCount = iPop2 + (zIsNode ? 0 : i13 - iNodeCount);
            } else {
                int i15 = i14 - iGroupSize;
                int i16 = zIsNode ? 0 : i13 - iNodeCount;
                if (i15 != 0 || i16 != 0) {
                    while (iParent != 0 && iParent != iPop && (i16 != 0 || i15 != 0)) {
                        int iGroupIndexToAddress2 = groupIndexToAddress(iParent);
                        if (i15 != 0) {
                            SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress2, SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2) + i15);
                        }
                        if (i16 != 0) {
                            int[] iArr = this.groups;
                            SlotTableKt.updateNodeCount(iArr, iGroupIndexToAddress2, SlotTableKt.nodeCount(iArr, iGroupIndexToAddress2) + i16);
                        }
                        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress2)) {
                            i16 = 0;
                        }
                        iParent = parent(this.groups, iParent);
                    }
                }
                this.nodeCount += i16;
            }
        }
        return i13;
    }

    public final void endInsert() {
        int i10 = this.insertCount;
        if (!(i10 > 0)) {
            throw new IllegalStateException("Unbalanced begin/end insert".toString());
        }
        int i11 = i10 - 1;
        this.insertCount = i11;
        if (i11 == 0) {
            if (this.nodeCountStack.getSize() == this.startStack.getSize()) {
                restoreCurrentGroupEnd();
            } else {
                ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                throw new h();
            }
        }
    }

    public final void ensureStarted(int i10) {
        if (!(this.insertCount <= 0)) {
            throw new IllegalArgumentException("Cannot call ensureStarted() while inserting".toString());
        }
        int i11 = this.parent;
        if (i11 != i10) {
            if (!(i10 >= i11 && i10 < this.currentGroupEnd)) {
                throw new IllegalArgumentException(("Started group at " + i10 + " must be a subgroup of the group at " + i11).toString());
            }
            int i12 = this.currentGroup;
            int i13 = this.currentSlot;
            int i14 = this.currentSlotEnd;
            this.currentGroup = i10;
            startGroup();
            this.currentGroup = i12;
            this.currentSlot = i13;
            this.currentSlotEnd = i14;
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    @NotNull
    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int i10) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        return SlotTableKt.hasAux(this.groups, iGroupIndexToAddress) ? this.slots[auxIndex(this.groups, iGroupIndexToAddress)] : Composer.Companion.getEmpty();
    }

    public final int groupKey(int i10) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(i10));
    }

    @Nullable
    public final Object groupObjectKey(int i10) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        if (SlotTableKt.hasObjectKey(this.groups, iGroupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, iGroupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i10) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(i10));
    }

    @NotNull
    public final Iterator<Object> groupSlots() {
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i10 = this.currentGroup;
        return new AnonymousClass1(iDataIndex, dataIndex(iArr, groupIndexToAddress(i10 + groupSize(i10))), this);
    }

    @NotNull
    public final String groupsAsString() {
        StringBuilder sb = new StringBuilder();
        int size$runtime_release = getSize$runtime_release();
        for (int i10 = 0; i10 < size$runtime_release; i10++) {
            groupAsString(sb, i10);
            sb.append('\n');
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean indexInCurrentGroup(int i10) {
        return indexInGroup(i10, this.currentGroup);
    }

    public final boolean indexInGroup(int i10, int i11) {
        int iIndexOf;
        int capacity;
        if (i11 == this.parent) {
            capacity = this.currentGroupEnd;
        } else if (i11 <= this.startStack.peekOr(0) && (iIndexOf = this.startStack.indexOf(i11)) >= 0) {
            capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(iIndexOf);
        } else {
            int iGroupSize = groupSize(i11);
            capacity = iGroupSize + i11;
        }
        return i10 > i11 && i10 < capacity;
    }

    public final boolean indexInParent(int i10) {
        int i11 = this.parent;
        return (i10 > i11 && i10 < this.currentGroupEnd) || (i11 == 0 && i10 == 0);
    }

    public final void insertAux(@Nullable Object obj) {
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
            throw new h();
        }
        int i10 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        if (!(!SlotTableKt.hasAux(this.groups, iGroupIndexToAddress))) {
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new h();
        }
        insertSlots(1, i10);
        int iAuxIndex = auxIndex(this.groups, iGroupIndexToAddress);
        int iDataIndexToDataAddress = dataIndexToDataAddress(iAuxIndex);
        int i11 = this.currentSlot;
        if (i11 > iAuxIndex) {
            int i12 = i11 - iAuxIndex;
            if (!(i12 < 3)) {
                throw new IllegalStateException("Moving more than two slot not supported".toString());
            }
            if (i12 > 1) {
                Object[] objArr = this.slots;
                objArr[iDataIndexToDataAddress + 2] = objArr[iDataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[iDataIndexToDataAddress + 1] = objArr2[iDataIndexToDataAddress];
        }
        SlotTableKt.addAux(this.groups, iGroupIndexToAddress);
        this.slots[iDataIndexToDataAddress] = obj;
        this.currentSlot++;
    }

    public final void insertParentGroup(int i10) {
        int iNodeCount = 0;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeRuntimeError("Writer cannot be inserting".toString());
            throw new h();
        }
        if (isGroupEnd()) {
            beginInsert();
            startGroup(i10);
            endGroup();
            endInsert();
            return;
        }
        int i11 = this.currentGroup;
        int iParent = parent(this.groups, i11);
        int iGroupSize = iParent + groupSize(iParent);
        int i12 = iGroupSize - i11;
        int iGroupSize2 = i11;
        while (iGroupSize2 < iGroupSize) {
            int iGroupIndexToAddress = groupIndexToAddress(iGroupSize2);
            iNodeCount += SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
            iGroupSize2 += SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
        }
        int iDataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress(i11));
        beginInsert();
        insertGroups(1);
        endInsert();
        int iGroupIndexToAddress2 = groupIndexToAddress(i11);
        SlotTableKt.initGroup(this.groups, iGroupIndexToAddress2, i10, false, false, false, iParent, iDataAnchor);
        SlotTableKt.updateGroupSize(this.groups, iGroupIndexToAddress2, i12 + 1);
        SlotTableKt.updateNodeCount(this.groups, iGroupIndexToAddress2, iNodeCount);
        addToGroupSizeAlongSpine(groupIndexToAddress(iParent), 1);
        fixParentAnchorsFor(iParent, iGroupSize, i11);
        this.currentGroup = iGroupSize;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i10 = this.currentGroup;
        return i10 < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i10));
    }

    public final void markGroup(int i10) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        if (SlotTableKt.hasMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        SlotTableKt.updateMark(this.groups, iGroupIndexToAddress, true);
        if (SlotTableKt.containsMark(this.groups, iGroupIndexToAddress)) {
            return;
        }
        updateContainsMark(parent(i10));
    }

    @NotNull
    public final List<Anchor> moveFrom(@NotNull SlotTable table, int i10) {
        t.i(table, "table");
        if (!(this.insertCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i10 != 0 || this.currentGroup != 0 || this.table.getGroupsSize() != 0) {
            SlotWriter slotWriterOpenWriter = table.openWriter();
            try {
                return Companion.moveGroup(slotWriterOpenWriter, i10, this, true, true);
            } finally {
                slotWriterOpenWriter.close();
            }
        }
        int[] iArr = this.groups;
        Object[] objArr = this.slots;
        ArrayList<Anchor> arrayList = this.anchors;
        int[] groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        Object[] slots = table.getSlots();
        int slotsSize = table.getSlotsSize();
        this.groups = groups;
        this.slots = slots;
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = groupsSize;
        this.groupGapLen = (groups.length / 5) - groupsSize;
        this.slotsGapStart = slotsSize;
        this.slotsGapLen = slots.length - slotsSize;
        this.slotsGapOwner = groupsSize;
        table.setTo$runtime_release(iArr, 0, objArr, 0, arrayList);
        return this.anchors;
    }

    public final void moveGroup(int i10) {
        if (!(this.insertCount == 0)) {
            throw new IllegalArgumentException("Cannot move a group while inserting".toString());
        }
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
        }
        if (i10 == 0) {
            return;
        }
        int i11 = this.currentGroup;
        int i12 = this.parent;
        int i13 = this.currentGroupEnd;
        int iGroupSize = i11;
        for (int i14 = i10; i14 > 0; i14--) {
            iGroupSize += SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
            if (!(iGroupSize <= i13)) {
                throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
            }
        }
        int iGroupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress(iGroupSize));
        int i15 = this.currentSlot;
        int iDataIndex = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        int i16 = iGroupSize + iGroupSize2;
        int iDataIndex2 = dataIndex(this.groups, groupIndexToAddress(i16));
        int i17 = iDataIndex2 - iDataIndex;
        insertSlots(i17, Math.max(this.currentGroup - 1, 0));
        insertGroups(iGroupSize2);
        int[] iArr = this.groups;
        int iGroupIndexToAddress = groupIndexToAddress(i16) * 5;
        o.g(iArr, iArr, groupIndexToAddress(i11) * 5, iGroupIndexToAddress, (iGroupSize2 * 5) + iGroupIndexToAddress);
        if (i17 > 0) {
            Object[] objArr = this.slots;
            o.i(objArr, objArr, i15, dataIndexToDataAddress(iDataIndex + i17), dataIndexToDataAddress(iDataIndex2 + i17));
        }
        int i18 = iDataIndex + i17;
        int i19 = i18 - i15;
        int i20 = this.slotsGapStart;
        int i21 = this.slotsGapLen;
        int length = this.slots.length;
        int i22 = this.slotsGapOwner;
        int i23 = i11 + iGroupSize2;
        int i24 = i11;
        while (i24 < i23) {
            int iGroupIndexToAddress2 = groupIndexToAddress(i24);
            int i25 = i20;
            int i26 = i19;
            updateDataIndex(iArr, iGroupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, iGroupIndexToAddress2) - i19, i22 < iGroupIndexToAddress2 ? 0 : i25, i21, length));
            i24++;
            i20 = i25;
            i19 = i26;
        }
        moveAnchors(i16, i11, iGroupSize2);
        if (!(!removeGroups(i16, iGroupSize2))) {
            ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
            throw new h();
        }
        fixParentAnchorsFor(i12, this.currentGroupEnd, i11);
        if (i17 > 0) {
            removeSlots(i18, i17, i16 - 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.Anchor> moveIntoGroupFrom(int r10, @org.jetbrains.annotations.NotNull androidx.compose.runtime.SlotTable r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "table"
            kotlin.jvm.internal.t.i(r11, r0)
            int r0 = r9.insertCount
            if (r0 > 0) goto L14
            int r0 = r9.currentGroup
            int r0 = r0 + r10
            int r0 = r9.groupSize(r0)
            r1 = 1
            if (r0 != r1) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            androidx.compose.runtime.ComposerKt.runtimeCheck(r1)
            int r0 = r9.currentGroup
            int r1 = r9.currentSlot
            int r2 = r9.currentSlotEnd
            r9.advanceBy(r10)
            r9.startGroup()
            r9.beginInsert()
            androidx.compose.runtime.SlotWriter r10 = r11.openWriter()
            androidx.compose.runtime.SlotWriter$Companion r3 = androidx.compose.runtime.SlotWriter.Companion     // Catch: java.lang.Throwable -> L46
            r7 = 0
            r8 = 1
            r4 = r10
            r5 = r12
            r6 = r9
            java.util.List r11 = androidx.compose.runtime.SlotWriter.Companion.access$moveGroup(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L46
            r10.close()
            r9.endInsert()
            r9.endGroup()
            r9.currentGroup = r0
            r9.currentSlot = r1
            r9.currentSlotEnd = r2
            return r11
        L46:
            r11 = move-exception
            r10.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveIntoGroupFrom(int, androidx.compose.runtime.SlotTable, int):java.util.List");
    }

    @NotNull
    public final List<Anchor> moveTo(@NotNull Anchor anchor, int i10, @NotNull SlotWriter writer) {
        t.i(anchor, "anchor");
        t.i(writer, "writer");
        if (!(writer.insertCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(this.insertCount == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!anchor.getValid()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iAnchorIndex = anchorIndex(anchor) + i10;
        int i11 = this.currentGroup;
        if (!(i11 <= iAnchorIndex && iAnchorIndex < this.currentGroupEnd)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iParent = parent(iAnchorIndex);
        int iGroupSize = groupSize(iAnchorIndex);
        int iNodeCount = isNode(iAnchorIndex) ? 1 : nodeCount(iAnchorIndex);
        List<Anchor> listMoveGroup = Companion.moveGroup(this, iAnchorIndex, writer, false, false);
        updateContainsMark(iParent);
        boolean z10 = iNodeCount > 0;
        while (iParent >= i11) {
            int iGroupIndexToAddress = groupIndexToAddress(iParent);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, iGroupIndexToAddress, SlotTableKt.groupSize(iArr, iGroupIndexToAddress) - iGroupSize);
            if (z10) {
                if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
                    z10 = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, iGroupIndexToAddress, SlotTableKt.nodeCount(iArr2, iGroupIndexToAddress) - iNodeCount);
                }
            }
            iParent = parent(iParent);
        }
        if (z10) {
            ComposerKt.runtimeCheck(this.nodeCount >= iNodeCount);
            this.nodeCount -= iNodeCount;
        }
        return listMoveGroup;
    }

    @Nullable
    public final Object node(int i10) {
        int iGroupIndexToAddress = groupIndexToAddress(i10);
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, iGroupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int i10) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(i10));
    }

    public final int parent(int i10) {
        return parent(this.groups, i10);
    }

    public final boolean removeGroup() {
        if (!(this.insertCount == 0)) {
            throw new IllegalArgumentException("Cannot remove group while inserting".toString());
        }
        int i10 = this.currentGroup;
        int i11 = this.currentSlot;
        int iSkipGroup = skipGroup();
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty() && prioritySet.peek() >= i10) {
                prioritySet.takeMax();
            }
        }
        boolean zRemoveGroups = removeGroups(i10, this.currentGroup - i10);
        removeSlots(i11, this.currentSlot - i11, i10 - 1);
        this.currentGroup = i10;
        this.currentSlot = i11;
        this.nodeCount -= iSkipGroup;
        return zRemoveGroups;
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
            throw new h();
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final void seek(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void set(@Nullable Object obj) {
        int i10 = this.currentSlot;
        if (i10 <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i10 - 1)] = obj;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new h();
        }
    }

    @Nullable
    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i10 = this.currentSlot;
        this.currentSlot = i10 + 1;
        return objArr[dataIndexToDataAddress(i10)];
    }

    public final int skipGroup() {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int iGroupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, iGroupIndexToAddress);
        this.currentGroup = iGroupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(iGroupSize));
        if (SlotTableKt.isNode(this.groups, iGroupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress);
    }

    public final void skipToGroupEnd() {
        int i10 = this.currentGroupEnd;
        this.currentGroup = i10;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i10));
    }

    @Nullable
    public final Object slot(@NotNull Anchor anchor, int i10) {
        t.i(anchor, "anchor");
        return slot(anchorIndex(anchor), i10);
    }

    public final void startData(int i10, @Nullable Object obj, @Nullable Object obj2) {
        startGroup(i10, obj, false, obj2);
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            throw new IllegalArgumentException("Key must be supplied when inserting".toString());
        }
        Composer.Companion companion = Composer.Companion;
        startGroup(0, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startNode(@Nullable Object obj) {
        startGroup(125, obj, true, Composer.Companion.getEmpty());
    }

    @NotNull
    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    @Nullable
    public final Object update(@Nullable Object obj) {
        Object objSkip = skip();
        set(obj);
        return objSkip;
    }

    public final void updateAux(@Nullable Object obj) {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.hasAux(this.groups, iGroupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, iGroupIndexToAddress))] = obj;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new h();
        }
    }

    public final void updateNode(@Nullable Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateParentNode(@Nullable Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void verifyDataAnchors$runtime_release() {
        int i10 = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        while (i11 < size$runtime_release) {
            int iGroupIndexToAddress = groupIndexToAddress(i11);
            int iDataAnchor = SlotTableKt.dataAnchor(this.groups, iGroupIndexToAddress);
            int iDataIndex = dataIndex(this.groups, iGroupIndexToAddress);
            if (!(iDataIndex >= i12)) {
                throw new IllegalStateException(("Data index out of order at " + i11 + ", previous = " + i12 + ", current = " + iDataIndex).toString());
            }
            if (!(iDataIndex <= length)) {
                throw new IllegalStateException(("Data index, " + iDataIndex + ", out of bound at " + i11).toString());
            }
            if (iDataAnchor < 0 && !z10) {
                if (!(i10 == i11)) {
                    throw new IllegalStateException(("Expected the slot gap owner to be " + i10 + " found gap at " + i11).toString());
                }
                z10 = true;
            }
            i11++;
            i12 = iDataIndex;
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int i10 = this.groupGapStart;
        int i11 = this.groupGapLen;
        int capacity = getCapacity();
        int i12 = 0;
        while (true) {
            if (i12 >= i10) {
                for (int i13 = i11 + i10; i13 < capacity; i13++) {
                    int iParentAnchor = SlotTableKt.parentAnchor(this.groups, i13);
                    if (parentAnchorToIndex(iParentAnchor) < i10) {
                        if (!(iParentAnchor > -2)) {
                            throw new IllegalStateException(("Expected a start relative anchor at " + i13).toString());
                        }
                    } else {
                        if (!(iParentAnchor <= -2)) {
                            throw new IllegalStateException(("Expected an end relative anchor at " + i13).toString());
                        }
                    }
                }
                return;
            }
            if (!(SlotTableKt.parentAnchor(this.groups, i12) > -2)) {
                throw new IllegalStateException(("Expected a start relative anchor at " + i12).toString());
            }
            i12++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i10) {
        return i10 >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i10), this.slotsGapLen, this.slots.length);
    }

    public final boolean isNode(int i10) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(i10));
    }

    public final int parent(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    @Nullable
    public final Object slot(int i10, int i11) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(i10));
        int i12 = i11 + iSlotIndex;
        if (iSlotIndex <= i12 && i12 < dataIndex(this.groups, groupIndexToAddress(i10 + 1))) {
            return this.slots[dataIndexToDataAddress(i12)];
        }
        return Composer.Companion.getEmpty();
    }

    public final void startData(int i10, @Nullable Object obj) {
        startGroup(i10, Composer.Companion.getEmpty(), false, obj);
    }

    public final void startNode(@Nullable Object obj, @Nullable Object obj2) {
        startGroup(125, obj, true, obj2);
    }

    public final void updateNode(@NotNull Anchor anchor, @Nullable Object obj) {
        t.i(anchor, "anchor");
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    private final int parent(int[] iArr, int i10) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i10)));
    }

    @Nullable
    public final Object node(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        return node(anchor.toIndexFor(this));
    }

    @Nullable
    public final Object set(int i10, @Nullable Object obj) {
        int iSlotIndex = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int i11 = iSlotIndex + i10;
        if (i11 >= iSlotIndex && i11 < dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1))) {
            int iDataIndexToDataAddress = dataIndexToDataAddress(i11);
            Object[] objArr = this.slots;
            Object obj2 = objArr[iDataIndexToDataAddress];
            objArr[iDataIndexToDataAddress] = obj;
            return obj2;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + i10 + " for group " + this.currentGroup).toString());
        throw new h();
    }

    public final void startGroup(int i10) {
        Composer.Companion companion = Composer.Companion;
        startGroup(i10, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startGroup(int i10, @Nullable Object obj) {
        startGroup(i10, obj, false, Composer.Companion.getEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int i10, Object obj, boolean z10, Object obj2) {
        int iGroupSize;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != false) {
            insertGroups(1);
            int i11 = this.currentGroup;
            int iGroupIndexToAddress = groupIndexToAddress(i11);
            Composer.Companion companion = Composer.Companion;
            int i12 = obj != companion.getEmpty() ? 1 : 0;
            int i13 = (z10 || obj2 == companion.getEmpty()) ? 0 : 1;
            SlotTableKt.initGroup(this.groups, iGroupIndexToAddress, i10, z10, i12, i13, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i14 = (z10 ? 1 : 0) + i12 + i13;
            if (i14 > 0) {
                insertSlots(i14, i11);
                Object[] objArr2 = this.slots;
                int i15 = this.currentSlot;
                if (z10) {
                    objArr2[i15] = obj2;
                    i15++;
                }
                if (i12 != 0) {
                    objArr2[i15] = obj;
                    i15++;
                }
                if (i13 != 0) {
                    objArr2[i15] = obj2;
                    i15++;
                }
                this.currentSlot = i15;
            }
            this.nodeCount = 0;
            iGroupSize = i11 + 1;
            this.parent = i11;
            this.currentGroup = iGroupSize;
        } else {
            this.startStack.push(this.parent);
            saveCurrentGroupEnd();
            int i16 = this.currentGroup;
            int iGroupIndexToAddress2 = groupIndexToAddress(i16);
            if (!t.d(obj2, Composer.Companion.getEmpty())) {
                if (z10) {
                    updateNode(obj2);
                } else {
                    updateAux(obj2);
                }
            }
            this.currentSlot = slotIndex(this.groups, iGroupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, iGroupIndexToAddress2);
            this.parent = i16;
            this.currentGroup = i16 + 1;
            iGroupSize = i16 + SlotTableKt.groupSize(this.groups, iGroupIndexToAddress2);
        }
        this.currentGroupEnd = iGroupSize;
    }

    public final void ensureStarted(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        ensureStarted(anchor.toIndexFor(this));
    }
}
