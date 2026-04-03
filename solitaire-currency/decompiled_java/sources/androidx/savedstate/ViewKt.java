package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewKt {
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        t.i(view, "<this>");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
