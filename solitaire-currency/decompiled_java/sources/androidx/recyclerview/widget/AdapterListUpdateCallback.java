package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i10, int i11, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i10, i11, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i10, int i11) {
        this.mAdapter.notifyItemRangeInserted(i10, i11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i10, int i11) {
        this.mAdapter.notifyItemMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i10, int i11) {
        this.mAdapter.notifyItemRangeRemoved(i10, i11);
    }
}
