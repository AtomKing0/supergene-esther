package androidx.compose.ui.node;

import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewInterop.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = tagKey("ViewAdapter");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final <T extends ViewAdapter> T getOrAddAdapter(@NotNull View view, int i10, @NotNull h9.a<? extends T> factory) {
        ViewAdapter viewAdapter;
        t.i(view, "<this>");
        t.i(factory, "factory");
        MergedViewAdapter viewAdapter2 = getViewAdapter(view);
        List<ViewAdapter> adapters = viewAdapter2.getAdapters();
        int size = adapters.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                viewAdapter = null;
                break;
            }
            viewAdapter = adapters.get(i11);
            if (viewAdapter.getId() == i10) {
                break;
            }
            i11++;
        }
        T t10 = viewAdapter instanceof ViewAdapter ? (T) viewAdapter : null;
        if (t10 != null) {
            return t10;
        }
        T tInvoke = factory.invoke();
        viewAdapter2.getAdapters().add(tInvoke);
        return tInvoke;
    }

    @NotNull
    public static final MergedViewAdapter getViewAdapter(@NotNull View view) {
        t.i(view, "<this>");
        int i10 = viewAdaptersKey;
        Object tag = view.getTag(i10);
        MergedViewAdapter mergedViewAdapter = tag instanceof MergedViewAdapter ? (MergedViewAdapter) tag : null;
        if (mergedViewAdapter != null) {
            return mergedViewAdapter;
        }
        MergedViewAdapter mergedViewAdapter2 = new MergedViewAdapter();
        view.setTag(i10, mergedViewAdapter2);
        return mergedViewAdapter2;
    }

    @Nullable
    public static final MergedViewAdapter getViewAdapterIfExists(@NotNull View view) {
        t.i(view, "<this>");
        Object tag = view.getTag(viewAdaptersKey);
        if (tag instanceof MergedViewAdapter) {
            return (MergedViewAdapter) tag;
        }
        return null;
    }

    public static final int tagKey(@NotNull String key) {
        t.i(key, "key");
        return key.hashCode() | 50331648;
    }
}
