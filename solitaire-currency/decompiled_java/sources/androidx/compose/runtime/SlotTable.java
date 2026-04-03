package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.ironsource.v8;
import h9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.p;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, i9.a {
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private int version;
    private boolean writer;

    @NotNull
    private int[] groups = new int[0];

    @NotNull
    private Object[] slots = new Object[0];

    @NotNull
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb, int i10, int i11) {
        boolean z10 = false;
        for (int i12 = 0; i12 < i11; i12++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i10);
        sb.append(") key=");
        sb.append(SlotTableKt.key(this.groups, i10));
        int iGroupSize = SlotTableKt.groupSize(this.groups, i10);
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, i10));
        sb.append(", size=");
        sb.append(iGroupSize);
        if (SlotTableKt.hasMark(this.groups, i10)) {
            sb.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, i10)) {
            sb.append(", contains mark");
        }
        int iEmitGroup$dataIndex = emitGroup$dataIndex(this, i10);
        int iEmitGroup = i10 + 1;
        int iEmitGroup$dataIndex2 = emitGroup$dataIndex(this, iEmitGroup);
        if (iEmitGroup$dataIndex >= 0 && iEmitGroup$dataIndex <= iEmitGroup$dataIndex2) {
            z10 = true;
        }
        if (!z10 || iEmitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + iEmitGroup$dataIndex + '-' + iEmitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i10)) {
                sb.append(" objectKey=" + this.slots[SlotTableKt.objectKeyIndex(this.groups, i10)]);
            }
            if (SlotTableKt.isNode(this.groups, i10)) {
                sb.append(" node=" + this.slots[SlotTableKt.nodeIndex(this.groups, i10)]);
            }
            if (SlotTableKt.hasAux(this.groups, i10)) {
                sb.append(" aux=" + this.slots[SlotTableKt.auxIndex(this.groups, i10)]);
            }
            int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i10);
            if (iSlotAnchor < iEmitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(iSlotAnchor);
                sb.append(": ");
                for (int i13 = iSlotAnchor; i13 < iEmitGroup$dataIndex2; i13++) {
                    if (i13 != iSlotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i13]));
                }
                sb.append(v8.i.f15839e);
            }
        }
        sb.append('\n');
        int i14 = i10 + iGroupSize;
        while (iEmitGroup < i14) {
            iEmitGroup += emitGroup(sb, iEmitGroup, i11 + 1);
        }
        return iGroupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i10) {
        return i10 >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i10);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i10) {
        while (i10 > 0) {
            for (Object obj : new DataIterator(this, i10)) {
                if (obj instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) obj;
                }
            }
            i10 = SlotTableKt.parentAnchor(this.groups, i10);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    private final boolean invalidateGroup(int i10) {
        while (i10 >= 0) {
            for (Object obj : new DataIterator(this, i10)) {
                if (obj instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    return recomposeScopeImpl.invalidateForResult(null) != InvalidationResult.IGNORED;
                }
            }
            i10 = SlotTableKt.parentAnchor(this.groups, i10);
        }
        return false;
    }

    /* JADX INFO: renamed from: invalidateGroupsWithKey$lambda-14$scanGroup, reason: not valid java name */
    private static final void m1256invalidateGroupsWithKey$lambda14$scanGroup(SlotReader slotReader, int i10, List<Anchor> list, i0 i0Var, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        if (slotReader.getGroupKey() != i10) {
            slotReader.startGroup();
            while (!slotReader.isGroupEnd()) {
                m1256invalidateGroupsWithKey$lambda14$scanGroup(slotReader, i10, list, i0Var, slotTable, list2);
            }
            slotReader.endGroup();
            return;
        }
        list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
        if (i0Var.f29826a) {
            RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
            if (recomposeScopeImplFindEffectiveRecomposeScope != null) {
                list2.add(recomposeScopeImplFindEffectiveRecomposeScope);
            } else {
                i0Var.f29826a = false;
                list2.clear();
            }
        }
        slotReader.skipGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static final int verifyWellFormed$validateGroup(l0 l0Var, SlotTable slotTable, int i10, int i11) {
        int i12 = l0Var.f29831a;
        int i13 = i12 + 1;
        l0Var.f29831a = i13;
        int iParentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i12);
        if ((iParentAnchor == i10) != true) {
            throw new IllegalStateException(("Invalid parent index detected at " + i12 + ", expected parent index to be " + i10 + " found " + iParentAnchor).toString());
        }
        int iGroupSize = SlotTableKt.groupSize(slotTable.groups, i12) + i12;
        if ((iGroupSize <= slotTable.groupsSize) != true) {
            throw new IllegalStateException(("A group extends past the end of the table at " + i12).toString());
        }
        if ((iGroupSize <= i11) != true) {
            throw new IllegalStateException(("A group extends past its parent group at " + i12).toString());
        }
        int iDataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i12);
        int iDataAnchor2 = i12 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i13);
        if ((iDataAnchor2 <= slotTable.slots.length) != true) {
            throw new IllegalStateException(("Slots for " + i12 + " extend past the end of the slot table").toString());
        }
        if ((iDataAnchor <= iDataAnchor2) != true) {
            throw new IllegalStateException(("Invalid data anchor at " + i12).toString());
        }
        if ((SlotTableKt.slotAnchor(slotTable.groups, i12) <= iDataAnchor2) != true) {
            throw new IllegalStateException(("Slots start out of range at " + i12).toString());
        }
        if ((iDataAnchor2 - iDataAnchor >= ((SlotTableKt.isNode(slotTable.groups, i12) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, i12) ? 1 : 0)) + (SlotTableKt.hasAux(slotTable.groups, i12) ? 1 : 0)) != true) {
            throw new IllegalStateException(("Not enough slots added for group " + i12).toString());
        }
        boolean zIsNode = SlotTableKt.isNode(slotTable.groups, i12);
        if (((zIsNode && slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i12)] == null) ? false : true) != true) {
            throw new IllegalStateException(("No node recorded for a node group at " + i12).toString());
        }
        int iVerifyWellFormed$validateGroup = 0;
        while (l0Var.f29831a < iGroupSize) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(l0Var, slotTable, i12, iGroupSize);
        }
        int iNodeCount = SlotTableKt.nodeCount(slotTable.groups, i12);
        int iGroupSize2 = SlotTableKt.groupSize(slotTable.groups, i12);
        if ((iNodeCount == iVerifyWellFormed$validateGroup) != true) {
            throw new IllegalStateException(("Incorrect node count detected at " + i12 + ", expected " + iNodeCount + ", received " + iVerifyWellFormed$validateGroup).toString());
        }
        int i14 = l0Var.f29831a - i12;
        if ((iGroupSize2 == i14) != true) {
            throw new IllegalStateException(("Incorrect slot count detected at " + i12 + ", expected " + iGroupSize2 + ", received " + i14).toString());
        }
        if (SlotTableKt.containsAnyMark(slotTable.groups, i12)) {
            if (!(i12 <= 0 || SlotTableKt.containsMark(slotTable.groups, i10))) {
                throw new IllegalStateException(("Expected group " + i10 + " to record it contains a mark because " + i12 + " does").toString());
            }
        }
        if (zIsNode) {
            return 1;
        }
        return iVerifyWellFormed$validateGroup;
    }

    @NotNull
    public final Anchor anchor(int i10) {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
            throw new h();
        }
        boolean z10 = false;
        if (i10 >= 0 && i10 < this.groupsSize) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, i10, this.groupsSize);
        if (iSearch < 0) {
            Anchor anchor = new Anchor(i10);
            arrayList.add(-(iSearch + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(iSearch);
        t.h(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new h();
        }
        if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        }
        throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
    }

    @NotNull
    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('\n');
        int i10 = this.groupsSize;
        if (i10 > 0) {
            int iEmitGroup = 0;
            while (iEmitGroup < i10) {
                iEmitGroup += emitGroup(sb, iEmitGroup, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void close$runtime_release(@NotNull SlotReader reader) {
        t.i(reader, "reader");
        if (!(reader.getTable$runtime_release() == this && this.readers > 0)) {
            throw new IllegalArgumentException("Unexpected reader close()".toString());
        }
        this.readers--;
    }

    @NotNull
    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @NotNull
    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    @NotNull
    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int i10, @NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Writer is active".toString());
            throw new h();
        }
        if (!(i10 >= 0 && i10 < this.groupsSize)) {
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new h();
        }
        if (ownsAnchor(anchor)) {
            int iGroupSize = SlotTableKt.groupSize(this.groups, i10) + i10;
            int location$runtime_release = anchor.getLocation$runtime_release();
            if (i10 <= location$runtime_release && location$runtime_release < iGroupSize) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int i10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        i0 i0Var = new i0();
        i0Var.f29826a = true;
        SlotReader slotReaderOpenReader = openReader();
        try {
            m1256invalidateGroupsWithKey$lambda14$scanGroup(slotReaderOpenReader, i10, arrayList, i0Var, this, arrayList2);
            k0 k0Var = k0.f35197a;
            slotReaderOpenReader.close();
            SlotWriter slotWriterOpenWriter = openWriter();
            try {
                slotWriterOpenWriter.startGroup();
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Anchor anchor = (Anchor) arrayList.get(i11);
                    if (anchor.toIndexFor(slotWriterOpenWriter) >= slotWriterOpenWriter.getCurrentGroup()) {
                        slotWriterOpenWriter.seek(anchor);
                        slotWriterOpenWriter.bashGroup$runtime_release();
                    }
                }
                slotWriterOpenWriter.skipToGroupEnd();
                slotWriterOpenWriter.endGroup();
                slotWriterOpenWriter.close();
                if (i0Var.f29826a) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                slotWriterOpenWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            slotReaderOpenReader.close();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @NotNull
    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.readers++;
        return new SlotReader(this);
    }

    @NotNull
    public final SlotWriter openWriter() {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
            throw new h();
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new h();
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(@NotNull Anchor anchor) {
        t.i(anchor, "anchor");
        if (!anchor.getValid()) {
            return false;
        }
        int iSearch = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
        return iSearch >= 0 && t.d(this.anchors.get(iSearch), anchor);
    }

    public final <T> T read(@NotNull l<? super SlotReader, ? extends T> block) {
        t.i(block, "block");
        SlotReader slotReaderOpenReader = openReader();
        try {
            return block.invoke(slotReaderOpenReader);
        } finally {
            r.b(1);
            slotReaderOpenReader.close();
            r.a(1);
        }
    }

    public final void setAnchors$runtime_release(@NotNull ArrayList<Anchor> arrayList) {
        t.i(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public final void setTo$runtime_release(@NotNull int[] groups, int i10, @NotNull Object[] slots, int i11, @NotNull ArrayList<Anchor> anchors) {
        t.i(groups, "groups");
        t.i(slots, "slots");
        t.i(anchors, "anchors");
        this.groups = groups;
        this.groupsSize = i10;
        this.slots = slots;
        this.slotsSize = i11;
        this.anchors = anchors;
    }

    public final void setVersion$runtime_release(int i10) {
        this.version = i10;
    }

    @NotNull
    public final List<Object> slotsOf$runtime_release(int i10) {
        int iDataAnchor = SlotTableKt.dataAnchor(this.groups, i10);
        int i11 = i10 + 1;
        return p.o0(this.slots).subList(iDataAnchor, i11 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i11) : this.slots.length);
    }

    public final void verifyWellFormed() {
        int i10;
        int i11;
        l0 l0Var = new l0();
        int i12 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i10 = l0Var.f29831a;
                i11 = this.groupsSize;
                if (i10 >= i11) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(l0Var, this, -1, i10 + SlotTableKt.groupSize(this.groups, i10));
                }
            }
            if (!(i10 == i11)) {
                throw new IllegalStateException(("Incomplete group at root " + l0Var.f29831a + " expected to be " + this.groupsSize).toString());
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            int indexFor = arrayList.get(i13).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                throw new IllegalArgumentException("Location out of bound".toString());
            }
            if (!(i12 < indexFor)) {
                throw new IllegalArgumentException("Anchor is out of order".toString());
            }
            i13++;
            i12 = indexFor;
        }
    }

    public final <T> T write(@NotNull l<? super SlotWriter, ? extends T> block) {
        t.i(block, "block");
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            return block.invoke(slotWriterOpenWriter);
        } finally {
            r.b(1);
            slotWriterOpenWriter.close();
            r.a(1);
        }
    }

    public final void close$runtime_release(@NotNull SlotWriter writer, @NotNull int[] groups, int i10, @NotNull Object[] slots, int i11, @NotNull ArrayList<Anchor> anchors) {
        t.i(writer, "writer");
        t.i(groups, "groups");
        t.i(slots, "slots");
        t.i(anchors, "anchors");
        if (writer.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(groups, i10, slots, i11, anchors);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }
}
