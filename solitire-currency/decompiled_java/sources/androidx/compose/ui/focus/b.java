package androidx.compose.ui.focus;

/* JADX INFO: compiled from: FocusManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ void a(FocusManager focusManager, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        focusManager.clearFocus(z10);
    }
}
