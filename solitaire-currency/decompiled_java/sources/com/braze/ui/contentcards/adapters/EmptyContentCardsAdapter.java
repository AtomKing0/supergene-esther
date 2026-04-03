package com.braze.ui.contentcards.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.R$layout;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EmptyContentCardsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class EmptyContentCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: compiled from: EmptyContentCardsAdapter.kt */
    public static final class NetworkUnavailableViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkUnavailableViewHolder(@NotNull View view) {
            super(view);
            t.i(view, "view");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i10) {
        t.i(viewHolder, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i10) {
        t.i(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.com_braze_content_cards_empty, viewGroup, false);
        t.h(view, "view");
        return new NetworkUnavailableViewHolder(view);
    }
}
