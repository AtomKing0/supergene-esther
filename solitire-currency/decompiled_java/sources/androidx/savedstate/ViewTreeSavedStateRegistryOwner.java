package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.t;
import o9.m;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewTreeSavedStateRegistryOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeSavedStateRegistryOwner {
    @Nullable
    public static final SavedStateRegistryOwner get(@NotNull View view) {
        t.i(view, "<this>");
        return (SavedStateRegistryOwner) o.n(o.t(m.f(view, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.INSTANCE), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.INSTANCE));
    }

    public static final void set(@NotNull View view, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        t.i(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
