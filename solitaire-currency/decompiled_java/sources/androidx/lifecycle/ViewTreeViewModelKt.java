package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: ViewTreeViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    public static final /* synthetic */ ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        t.i(view, "view");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
