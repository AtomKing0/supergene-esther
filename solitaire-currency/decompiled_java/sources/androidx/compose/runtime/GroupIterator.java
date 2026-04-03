package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
final class GroupIterator implements Iterator<CompositionGroup>, i9.a {
    private final int end;
    private int index;

    @NotNull
    private final SlotTable table;
    private final int version;

    public GroupIterator(@NotNull SlotTable table, int i10, int i11) {
        t.i(table, "table");
        this.table = table;
        this.end = i11;
        this.index = i10;
        this.version = table.getVersion$runtime_release();
        if (table.getWriter$runtime_release()) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
            throw new ConcurrentModificationException();
        }
    }

    public final int getEnd() {
        return this.end;
    }

    @NotNull
    public final SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public CompositionGroup next() {
        validateRead();
        int i10 = this.index;
        this.index = SlotTableKt.groupSize(this.table.getGroups(), i10) + i10;
        return new AnonymousClass1(i10);
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.GroupIterator$next$1, reason: invalid class name */
    /* JADX INFO: compiled from: SlotTable.kt */
    public static final class AnonymousClass1 implements CompositionGroup, Iterable<CompositionGroup>, i9.a {
        final /* synthetic */ int $group;

        AnonymousClass1(int i10) {
            this.$group = i10;
        }

        @Override // androidx.compose.runtime.tooling.CompositionGroup
        @NotNull
        public Iterable<Object> getData() {
            return new DataIterator(GroupIterator.this.getTable(), this.$group);
        }

        @Override // androidx.compose.runtime.tooling.CompositionGroup
        @NotNull
        public Object getIdentity() {
            GroupIterator.this.validateRead();
            SlotTable table = GroupIterator.this.getTable();
            int i10 = this.$group;
            SlotReader slotReaderOpenReader = table.openReader();
            try {
                return slotReaderOpenReader.anchor(i10);
            } finally {
                slotReaderOpenReader.close();
            }
        }

        @Override // androidx.compose.runtime.tooling.CompositionGroup
        @NotNull
        public Object getKey() {
            if (!SlotTableKt.hasObjectKey(GroupIterator.this.getTable().getGroups(), this.$group)) {
                return Integer.valueOf(SlotTableKt.key(GroupIterator.this.getTable().getGroups(), this.$group));
            }
            Object obj = GroupIterator.this.getTable().getSlots()[SlotTableKt.objectKeyIndex(GroupIterator.this.getTable().getGroups(), this.$group)];
            t.f(obj);
            return obj;
        }

        @Override // androidx.compose.runtime.tooling.CompositionGroup
        @Nullable
        public Object getNode() {
            if (SlotTableKt.isNode(GroupIterator.this.getTable().getGroups(), this.$group)) {
                return GroupIterator.this.getTable().getSlots()[SlotTableKt.nodeIndex(GroupIterator.this.getTable().getGroups(), this.$group)];
            }
            return null;
        }

        @Override // androidx.compose.runtime.tooling.CompositionGroup
        @Nullable
        public String getSourceInfo() {
            if (!SlotTableKt.hasAux(GroupIterator.this.getTable().getGroups(), this.$group)) {
                return null;
            }
            Object obj = GroupIterator.this.getTable().getSlots()[SlotTableKt.auxIndex(GroupIterator.this.getTable().getGroups(), this.$group)];
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        @Override // androidx.compose.runtime.tooling.CompositionData
        public boolean isEmpty() {
            return SlotTableKt.groupSize(GroupIterator.this.getTable().getGroups(), this.$group) == 0;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<CompositionGroup> iterator() {
            GroupIterator.this.validateRead();
            SlotTable table = GroupIterator.this.getTable();
            int i10 = this.$group;
            return new GroupIterator(table, i10 + 1, i10 + SlotTableKt.groupSize(GroupIterator.this.getTable().getGroups(), this.$group));
        }

        @Override // androidx.compose.runtime.tooling.CompositionData
        @NotNull
        public Iterable<CompositionGroup> getCompositionGroups() {
            return this;
        }
    }
}
