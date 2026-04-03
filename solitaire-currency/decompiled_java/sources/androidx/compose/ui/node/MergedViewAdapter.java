package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewInterop.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MergedViewAdapter implements ViewAdapter {

    @NotNull
    private final List<ViewAdapter> adapters = new ArrayList();
    private final int id;

    @Override // androidx.compose.ui.node.ViewAdapter
    public void didInsert(@NotNull View view, @NotNull ViewGroup parent) {
        t.i(view, "view");
        t.i(parent, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).didInsert(view, parent);
        }
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public void didUpdate(@NotNull View view, @NotNull ViewGroup parent) {
        t.i(view, "view");
        t.i(parent, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).didUpdate(view, parent);
        }
    }

    @NotNull
    public final <T extends ViewAdapter> T get(int i10, @NotNull h9.a<? extends T> factory) {
        ViewAdapter viewAdapter;
        t.i(factory, "factory");
        List<ViewAdapter> adapters = getAdapters();
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
        getAdapters().add(tInvoke);
        return tInvoke;
    }

    @NotNull
    public final List<ViewAdapter> getAdapters() {
        return this.adapters;
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public int getId() {
        return this.id;
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public void willInsert(@NotNull View view, @NotNull ViewGroup parent) {
        t.i(view, "view");
        t.i(parent, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).willInsert(view, parent);
        }
    }
}
