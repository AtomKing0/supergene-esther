package com.braze.ui.contentcards.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.models.cards.Card;
import com.braze.ui.R$drawable;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.BrazeContentCardUtils;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.widget.BaseCardView;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseContentCardView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseContentCardView<T extends Card> extends BaseCardView<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseContentCardView(@NotNull Context context) {
        super(context);
        t.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViewHolder$lambda$0(BaseContentCardView this$0, Card card, UriAction uriAction, View view) {
        t.i(this$0, "this$0");
        t.i(card, "$card");
        this$0.handleCardClick(this$0.applicationContext, card, uriAction);
    }

    public void bindViewHolder(@NotNull ContentCardViewHolder viewHolder, @NotNull final Card card) {
        t.i(viewHolder, "viewHolder");
        t.i(card, "card");
        viewHolder.setPinnedIconVisible(card.isPinned());
        viewHolder.setUnreadBarVisible(this.configurationProvider.isContentCardsUnreadVisualIndicatorEnabled() && !card.isIndicatorHighlighted());
        final UriAction uriActionForCard = BrazeContentCardUtils.INSTANCE.getUriActionForCard(card);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.braze.ui.contentcards.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseContentCardView.bindViewHolder$lambda$0(this.f8127a, card, uriActionForCard, view);
            }
        });
        viewHolder.setActionHintVisible(uriActionForCard != null);
    }

    @NotNull
    public abstract ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup);

    @Override // com.braze.ui.widget.BaseCardView
    protected boolean isClickHandled(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction) {
        t.i(context, "context");
        t.i(card, "card");
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        return contentCardsActionListener != null && contentCardsActionListener.onContentCardClicked(context, card, iAction);
    }

    @TargetApi(21)
    protected final void safeSetClipToOutline(@Nullable ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setClipToOutline(true);
    }

    public final void setOptionalCardImage(@Nullable ImageView imageView, float f10, @Nullable String str, @NotNull Card card) {
        t.i(card, "card");
        if (imageView == null || str == null) {
            return;
        }
        setImageViewToUrl(imageView, str, f10, card);
    }

    protected final void setViewBackground(@NotNull View view) {
        t.i(view, "view");
        view.setBackground(getResources().getDrawable(R$drawable.com_braze_content_card_background));
        view.setForeground(getResources().getDrawable(R$drawable.com_braze_content_card_scrim));
    }
}
