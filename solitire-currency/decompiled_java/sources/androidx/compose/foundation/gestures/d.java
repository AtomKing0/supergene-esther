package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ Object a(ScrollableState scrollableState, MutatePriority mutatePriority, p pVar, z8.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
        }
        if ((i10 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollableState.scroll(mutatePriority, pVar, dVar);
    }
}
