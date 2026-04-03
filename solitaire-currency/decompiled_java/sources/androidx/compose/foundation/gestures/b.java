package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ Object a(PointerAwareDraggableState pointerAwareDraggableState, MutatePriority mutatePriority, p pVar, z8.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drag");
        }
        if ((i10 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return pointerAwareDraggableState.drag(mutatePriority, pVar, dVar);
    }
}
