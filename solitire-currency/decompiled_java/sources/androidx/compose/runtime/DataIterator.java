package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DataIterator implements Iterable<Object>, Iterator<Object>, i9.a {
    private final int end;
    private final int group;
    private int index;
    private final int start;

    @NotNull
    private final SlotTable table;

    public DataIterator(@NotNull SlotTable table, int i10) {
        t.i(table, "table");
        this.table = table;
        this.group = i10;
        int iDataAnchor = SlotTableKt.dataAnchor(table.getGroups(), i10);
        this.start = iDataAnchor;
        this.end = i10 + 1 < table.getGroupsSize() ? SlotTableKt.dataAnchor(table.getGroups(), i10 + 1) : table.getSlotsSize();
        this.index = iDataAnchor;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getGroup() {
        return this.group;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getStart() {
        return this.start;
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
    @Nullable
    public Object next() {
        int i10 = this.index;
        Object obj = (i10 < 0 || i10 >= this.table.getSlots().length) ? null : this.table.getSlots()[this.index];
        this.index++;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Object> iterator() {
        return this;
    }
}
