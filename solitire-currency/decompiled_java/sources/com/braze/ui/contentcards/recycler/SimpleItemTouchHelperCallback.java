package com.braze.ui.contentcards.recycler;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SimpleItemTouchHelperCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    @NotNull
    private final ItemTouchHelperAdapter adapter;

    public SimpleItemTouchHelperCallback(@NotNull ItemTouchHelperAdapter adapter) {
        t.i(adapter, "adapter");
        this.adapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        t.i(recyclerView, "recyclerView");
        t.i(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(0, this.adapter.isItemDismissable(viewHolder.getBindingAdapterPosition()) ? 16 : 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        t.i(recyclerView, "recyclerView");
        t.i(viewHolder, "viewHolder");
        t.i(target, "target");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i10) {
        t.i(viewHolder, "viewHolder");
        this.adapter.onItemDismiss(viewHolder.getBindingAdapterPosition());
    }
}
