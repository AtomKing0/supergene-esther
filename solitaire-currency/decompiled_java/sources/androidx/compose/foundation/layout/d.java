package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: Column.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ Modifier a(ColumnScope columnScope, Modifier modifier, float f10, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return columnScope.weight(modifier, f10, z10);
    }
}
