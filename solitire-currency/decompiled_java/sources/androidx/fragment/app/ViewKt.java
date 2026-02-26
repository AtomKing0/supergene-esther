package androidx.fragment.app;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "<this>");
        F f10 = (F) FragmentManager.findFragment(view);
        kotlin.jvm.internal.t.h(f10, "findFragment(this)");
        return f10;
    }
}
