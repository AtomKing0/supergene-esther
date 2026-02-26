package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HitPathTracker {

    @NotNull
    private final NodeParent root;

    @NotNull
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(@NotNull LayoutCoordinates rootCoordinates) {
        t.i(rootCoordinates, "rootCoordinates");
        this.rootCoordinates = rootCoordinates;
        this.root = new NodeParent();
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX INFO: renamed from: addHitPath-KNwqfcY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2806addHitPathKNwqfcY(long r12, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.input.pointer.PointerInputFilter> r14) {
        /*
            r11 = this;
            java.lang.String r0 = "pointerInputFilters"
            kotlin.jvm.internal.t.i(r14, r0)
            androidx.compose.ui.input.pointer.NodeParent r0 = r11.root
            int r1 = r14.size()
            r2 = 1
            r3 = 0
            r4 = r3
        Le:
            if (r4 >= r1) goto L7a
            java.lang.Object r5 = r14.get(r4)
            androidx.compose.ui.input.pointer.PointerInputFilter r5 = (androidx.compose.ui.input.pointer.PointerInputFilter) r5
            if (r2 == 0) goto L5f
            androidx.compose.runtime.collection.MutableVector r6 = r0.getChildren()
            int r7 = r6.getSize()
            if (r7 <= 0) goto L3b
            java.lang.Object[] r6 = r6.getContent()
            r8 = r3
        L27:
            r9 = r6[r8]
            r10 = r9
            androidx.compose.ui.input.pointer.Node r10 = (androidx.compose.ui.input.pointer.Node) r10
            androidx.compose.ui.input.pointer.PointerInputFilter r10 = r10.getPointerInputFilter()
            boolean r10 = kotlin.jvm.internal.t.d(r10, r5)
            if (r10 == 0) goto L37
            goto L3c
        L37:
            int r8 = r8 + 1
            if (r8 < r7) goto L27
        L3b:
            r9 = 0
        L3c:
            androidx.compose.ui.input.pointer.Node r9 = (androidx.compose.ui.input.pointer.Node) r9
            if (r9 == 0) goto L5e
            r9.markIsIn()
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m2857boximpl(r12)
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L5c
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m2857boximpl(r12)
            r0.add(r5)
        L5c:
            r0 = r9
            goto L77
        L5e:
            r2 = r3
        L5f:
            androidx.compose.ui.input.pointer.Node r6 = new androidx.compose.ui.input.pointer.Node
            r6.<init>(r5)
            androidx.compose.runtime.collection.MutableVector r5 = r6.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r7 = androidx.compose.ui.input.pointer.PointerId.m2857boximpl(r12)
            r5.add(r7)
            androidx.compose.runtime.collection.MutableVector r0 = r0.getChildren()
            r0.add(r6)
            r0 = r6
        L77:
            int r4 = r4 + 1
            goto Le
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m2806addHitPathKNwqfcY(long, java.util.List):void");
    }

    public final boolean dispatchChanges(@NotNull InternalPointerEvent internalPointerEvent, boolean z10) {
        t.i(internalPointerEvent, "internalPointerEvent");
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z10)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z10);
        }
        return false;
    }

    @NotNull
    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
