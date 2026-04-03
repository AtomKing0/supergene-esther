package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import h9.l;
import h9.q;
import h9.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.r0;
import kotlin.collections.z;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SelectionRegistrarImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionRegistrarImpl implements SelectionRegistrar {

    @Nullable
    private l<? super Long, k0> afterSelectableUnsubscribe;

    @Nullable
    private l<? super Long, k0> onPositionChangeCallback;

    @Nullable
    private l<? super Long, k0> onSelectableChangeCallback;

    @Nullable
    private s<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> onSelectionUpdateCallback;

    @Nullable
    private h9.a<k0> onSelectionUpdateEndCallback;

    @Nullable
    private l<? super Long, k0> onSelectionUpdateSelectAll;

    @Nullable
    private q<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, k0> onSelectionUpdateStartCallback;
    private boolean sorted;

    @NotNull
    private final List<Selectable> _selectables = new ArrayList();

    @NotNull
    private final Map<Long, Selectable> _selectableMap = new LinkedHashMap();

    @NotNull
    private AtomicLong incrementId = new AtomicLong(1);

    @NotNull
    private final MutableState subselections$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0.g(), null, 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sort$lambda-2, reason: not valid java name */
    public static final int m830sort$lambda2(LayoutCoordinates containerLayoutCoordinates, Selectable a10, Selectable b10) {
        t.i(containerLayoutCoordinates, "$containerLayoutCoordinates");
        t.i(a10, "a");
        t.i(b10, "b");
        LayoutCoordinates layoutCoordinates = a10.getLayoutCoordinates();
        LayoutCoordinates layoutCoordinates2 = b10.getLayoutCoordinates();
        long jMo2990localPositionOfR5De75A = layoutCoordinates != null ? containerLayoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m1383getZeroF1C5BW0()) : Offset.Companion.m1383getZeroF1C5BW0();
        long jMo2990localPositionOfR5De75A2 = layoutCoordinates2 != null ? containerLayoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m1383getZeroF1C5BW0()) : Offset.Companion.m1383getZeroF1C5BW0();
        return (Offset.m1368getYimpl(jMo2990localPositionOfR5De75A) > Offset.m1368getYimpl(jMo2990localPositionOfR5De75A2) ? 1 : (Offset.m1368getYimpl(jMo2990localPositionOfR5De75A) == Offset.m1368getYimpl(jMo2990localPositionOfR5De75A2) ? 0 : -1)) == 0 ? x8.b.a(Float.valueOf(Offset.m1367getXimpl(jMo2990localPositionOfR5De75A)), Float.valueOf(Offset.m1367getXimpl(jMo2990localPositionOfR5De75A2))) : x8.b.a(Float.valueOf(Offset.m1368getYimpl(jMo2990localPositionOfR5De75A)), Float.valueOf(Offset.m1368getYimpl(jMo2990localPositionOfR5De75A2)));
    }

    @Nullable
    public final l<Long, k0> getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    @Nullable
    public final l<Long, k0> getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    @Nullable
    public final l<Long, k0> getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    @Nullable
    public final s<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean> getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    @Nullable
    public final h9.a<k0> getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    @Nullable
    public final l<Long, k0> getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    @Nullable
    public final q<LayoutCoordinates, Offset, SelectionAdjustment, k0> getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    @NotNull
    public final Map<Long, Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    @NotNull
    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    public final boolean getSorted$foundation_release() {
        return this.sorted;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    @NotNull
    public Map<Long, Selection> getSubselections() {
        return (Map) this.subselections$delegate.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long andIncrement = this.incrementId.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.incrementId.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long j10) {
        this.sorted = false;
        l<? super Long, k0> lVar = this.onPositionChangeCallback;
        if (lVar != null) {
            lVar.invoke(Long.valueOf(j10));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long j10) {
        l<? super Long, k0> lVar = this.onSelectableChangeCallback;
        if (lVar != null) {
            lVar.invoke(Long.valueOf(j10));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdate-5iVPX68 */
    public boolean mo828notifySelectionUpdate5iVPX68(@NotNull LayoutCoordinates layoutCoordinates, long j10, long j11, boolean z10, @NotNull SelectionAdjustment adjustment) {
        t.i(layoutCoordinates, "layoutCoordinates");
        t.i(adjustment, "adjustment");
        s<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> sVar = this.onSelectionUpdateCallback;
        if (sVar != null) {
            return sVar.invoke(layoutCoordinates, Offset.m1356boximpl(j10), Offset.m1356boximpl(j11), Boolean.valueOf(z10), adjustment).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        h9.a<k0> aVar = this.onSelectionUpdateEndCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long j10) {
        l<? super Long, k0> lVar = this.onSelectionUpdateSelectAll;
        if (lVar != null) {
            lVar.invoke(Long.valueOf(j10));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdateStart-d-4ec7I */
    public void mo829notifySelectionUpdateStartd4ec7I(@NotNull LayoutCoordinates layoutCoordinates, long j10, @NotNull SelectionAdjustment adjustment) {
        t.i(layoutCoordinates, "layoutCoordinates");
        t.i(adjustment, "adjustment");
        q<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, k0> qVar = this.onSelectionUpdateStartCallback;
        if (qVar != null) {
            qVar.invoke(layoutCoordinates, Offset.m1356boximpl(j10), adjustment);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(@Nullable l<? super Long, k0> lVar) {
        this.afterSelectableUnsubscribe = lVar;
    }

    public final void setOnPositionChangeCallback$foundation_release(@Nullable l<? super Long, k0> lVar) {
        this.onPositionChangeCallback = lVar;
    }

    public final void setOnSelectableChangeCallback$foundation_release(@Nullable l<? super Long, k0> lVar) {
        this.onSelectableChangeCallback = lVar;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(@Nullable s<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> sVar) {
        this.onSelectionUpdateCallback = sVar;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(@Nullable h9.a<k0> aVar) {
        this.onSelectionUpdateEndCallback = aVar;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(@Nullable l<? super Long, k0> lVar) {
        this.onSelectionUpdateSelectAll = lVar;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(@Nullable q<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, k0> qVar) {
        this.onSelectionUpdateStartCallback = qVar;
    }

    public final void setSorted$foundation_release(boolean z10) {
        this.sorted = z10;
    }

    public void setSubselections(@NotNull Map<Long, Selection> map) {
        t.i(map, "<set-?>");
        this.subselections$delegate.setValue(map);
    }

    @NotNull
    public final List<Selectable> sort(@NotNull final LayoutCoordinates containerLayoutCoordinates) {
        t.i(containerLayoutCoordinates, "containerLayoutCoordinates");
        if (!this.sorted) {
            z.A(this._selectables, new Comparator() { // from class: androidx.compose.foundation.text.selection.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SelectionRegistrarImpl.m830sort$lambda2(containerLayoutCoordinates, (Selectable) obj, (Selectable) obj2);
                }
            });
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    @NotNull
    public Selectable subscribe(@NotNull Selectable selectable) {
        t.i(selectable, "selectable");
        if (!(selectable.getSelectableId() != 0)) {
            throw new IllegalArgumentException(("The selectable contains an invalid id: " + selectable.getSelectableId()).toString());
        }
        if (!this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectableMap.put(Long.valueOf(selectable.getSelectableId()), selectable);
            this._selectables.add(selectable);
            this.sorted = false;
            return selectable;
        }
        throw new IllegalArgumentException(("Another selectable with the id: " + selectable + ".selectableId has already subscribed.").toString());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(@NotNull Selectable selectable) {
        t.i(selectable, "selectable");
        if (this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectables.remove(selectable);
            this._selectableMap.remove(Long.valueOf(selectable.getSelectableId()));
            l<? super Long, k0> lVar = this.afterSelectableUnsubscribe;
            if (lVar != null) {
                lVar.invoke(Long.valueOf(selectable.getSelectableId()));
            }
        }
    }
}
