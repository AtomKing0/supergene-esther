package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.Owner;

/* JADX INFO: compiled from: Owner.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    static {
        Owner.Companion companion = Owner.Companion;
    }

    public static /* synthetic */ void d(Owner owner, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        owner.measureAndLayout(z10);
    }

    public static /* synthetic */ void e(Owner owner, LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        owner.onRequestMeasure(layoutNode, z10);
    }

    public static /* synthetic */ void f(Owner owner, LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        owner.onRequestRelayout(layoutNode, z10);
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void a() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void c() {
    }
}
