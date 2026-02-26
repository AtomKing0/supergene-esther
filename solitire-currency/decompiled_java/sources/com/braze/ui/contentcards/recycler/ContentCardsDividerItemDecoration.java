package com.braze.ui.contentcards.recycler;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.R$dimen;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentCardsDividerItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCardsDividerItemDecoration extends RecyclerView.ItemDecoration {

    @NotNull
    private final Context appContext;
    private final int contentCardsItemMaxWidth;
    private final int itemDividerHeight;

    public ContentCardsDividerItemDecoration(@NotNull Context context) {
        t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
        this.itemDividerHeight = applicationContext.getResources().getDimensionPixelSize(R$dimen.com_braze_content_cards_divider_height);
        this.contentCardsItemMaxWidth = applicationContext.getResources().getDimensionPixelSize(R$dimen.com_braze_content_cards_max_width);
    }

    private final int getSidePaddingValue(int i10) {
        return o.e((i10 - this.contentCardsItemMaxWidth) / 2, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect itemViewOutputRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        boolean zIsControlCardAtPosition;
        t.i(itemViewOutputRect, "itemViewOutputRect");
        t.i(view, "view");
        t.i(parent, "parent");
        t.i(state, "state");
        super.getItemOffsets(itemViewOutputRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (parent.getAdapter() instanceof ContentCardAdapter) {
            RecyclerView.Adapter adapter = parent.getAdapter();
            t.g(adapter, "null cannot be cast to non-null type com.braze.ui.contentcards.adapters.ContentCardAdapter");
            zIsControlCardAtPosition = ((ContentCardAdapter) adapter).isControlCardAtPosition(childAdapterPosition);
        } else {
            zIsControlCardAtPosition = false;
        }
        itemViewOutputRect.top = childAdapterPosition == 0 ? this.itemDividerHeight : 0;
        itemViewOutputRect.bottom = zIsControlCardAtPosition ? 0 : this.itemDividerHeight;
        int sidePaddingValue = getSidePaddingValue(parent.getWidth());
        itemViewOutputRect.left = sidePaddingValue;
        itemViewOutputRect.right = sidePaddingValue;
    }
}
