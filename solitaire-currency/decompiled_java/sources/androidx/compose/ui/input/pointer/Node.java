package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Node extends NodeParent {

    @Nullable
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;

    @Nullable
    private PointerEvent pointerEvent;

    @NotNull
    private final MutableVector<PointerId> pointerIds;

    @NotNull
    private final PointerInputFilter pointerInputFilter;

    @NotNull
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(@NotNull PointerInputFilter pointerInputFilter) {
        t.i(pointerInputFilter, "pointerInputFilter");
        this.pointerInputFilter = pointerInputFilter;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(h9.a<k0> aVar) {
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.isAttached$ui_release()) {
            return false;
        }
        aVar.invoke();
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!Offset.m1364equalsimpl0(pointerEvent.getChanges().get(i10).m2873getPositionF1C5BW0(), pointerEvent2.getChanges().get(i10).m2873getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bc  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean buildCache(@org.jetbrains.annotations.NotNull java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r31, @org.jetbrains.annotations.NotNull androidx.compose.ui.layout.LayoutCoordinates r32, @org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.InternalPointerEvent r33, boolean r34) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(@NotNull InternalPointerEvent internalPointerEvent) {
        t.i(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i10 = 0; i10 < size; i10++) {
            PointerInputChange pointerInputChange = changes.get(i10);
            if ((pointerInputChange.getPressed() || (internalPointerEvent.m2807issuesEnterExitEvent0FcD4WY(pointerInputChange.m2872getIdJ3iCeTQ()) && this.isIn)) ? false : true) {
                this.pointerIds.remove(PointerId.m2857boximpl(pointerInputChange.m2872getIdJ3iCeTQ()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m2827equalsimpl0(pointerEvent.m2820getType7fucELk(), PointerEventType.Companion.m2832getExit7fucELk());
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i10 = 0;
            do {
                content[i10].dispatchCancel();
                i10++;
            } while (i10 < size);
        }
        this.pointerInputFilter.onCancel();
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(@NotNull InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        t.i(internalPointerEvent, "internalPointerEvent");
        boolean z10 = false;
        int i10 = 0;
        z10 = false;
        if (!this.relevantChanges.isEmpty() && this.pointerInputFilter.isAttached$ui_release()) {
            PointerEvent pointerEvent = this.pointerEvent;
            t.f(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            t.f(layoutCoordinates);
            this.pointerInputFilter.mo2894onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, layoutCoordinates.mo2989getSizeYbymL2g());
            if (this.pointerInputFilter.isAttached$ui_release() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i10].dispatchFinalEventPass(internalPointerEvent);
                    i10++;
                } while (i10 < size);
            }
            z10 = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z10;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(@NotNull Map<PointerId, PointerInputChange> changes, @NotNull LayoutCoordinates parentCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z10) {
        MutableVector<Node> children;
        int size;
        t.i(changes, "changes");
        t.i(parentCoordinates, "parentCoordinates");
        t.i(internalPointerEvent, "internalPointerEvent");
        int i10 = 0;
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.isAttached$ui_release()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        t.f(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        t.f(layoutCoordinates);
        long jMo2989getSizeYbymL2g = layoutCoordinates.mo2989getSizeYbymL2g();
        this.pointerInputFilter.mo2894onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo2989getSizeYbymL2g);
        if (this.pointerInputFilter.isAttached$ui_release() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            do {
                Node node = content[i10];
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                t.f(layoutCoordinates2);
                node.dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent, z10);
                i10++;
            } while (i10 < size);
        }
        if (this.pointerInputFilter.isAttached$ui_release()) {
            this.pointerInputFilter.mo2894onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo2989getSizeYbymL2g);
        }
        return true;
    }

    @NotNull
    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    @NotNull
    public final PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @NotNull
    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
