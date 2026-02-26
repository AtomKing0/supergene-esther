package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.internal.t;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewTreeLifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeLifecycleOwner {
    @Nullable
    public static final LifecycleOwner get(@NotNull View view) {
        t.i(view, "<this>");
        return (LifecycleOwner) o.n(o.t(o9.m.f(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }

    public static final void set(@NotNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        t.i(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
