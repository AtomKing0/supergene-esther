package com.braze.ui.contentcards.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import h9.a;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentCardAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCardAdapter extends RecyclerView.Adapter<ContentCardViewHolder> implements ItemTouchHelperAdapter {

    @NotNull
    private final List<Card> cardData;

    @NotNull
    private final IContentCardsViewBindingHandler contentCardsViewBindingHandler;

    @NotNull
    private final Context context;

    @NotNull
    private final Handler handler;

    @NotNull
    private Set<String> impressedCardIdsInternal;

    @NotNull
    private final LinearLayoutManager layoutManager;

    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    private static final class CardListDiffCallback extends DiffUtil.Callback {

        @NotNull
        private final List<Card> newCards;

        @NotNull
        private final List<Card> oldCards;

        /* JADX WARN: Multi-variable type inference failed */
        public CardListDiffCallback(@NotNull List<? extends Card> oldCards, @NotNull List<? extends Card> newCards) {
            t.i(oldCards, "oldCards");
            t.i(newCards, "newCards");
            this.oldCards = oldCards;
            this.newCards = newCards;
        }

        private final boolean doItemsShareIds(int i10, int i11) {
            return t.d(this.oldCards.get(i10).getId(), this.newCards.get(i11).getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i10, int i11) {
            return doItemsShareIds(i10, i11);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i10, int i11) {
            return doItemsShareIds(i10, i11);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newCards.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldCards.size();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$getCardAtIndex$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ int $index;
        final /* synthetic */ ContentCardAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, ContentCardAdapter contentCardAdapter) {
            super(0);
            this.$index = i10;
            this.this$0 = contentCardAdapter;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot return card at index: " + this.$index + " in cards list of size: " + this.this$0.cardData.size();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$logImpression$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11551 extends v implements a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11551(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Logged impression for card " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$logImpression$2, reason: invalid class name */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ Card $card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Card card) {
            super(0);
            this.$card = card;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Already counted impression for card " + this.$card.getId();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$markOnScreenCardsAsRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11561 extends v implements a<String> {
        public static final C11561 INSTANCE = new C11561();

        C11561() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Card list is empty. Not marking on-screen cards as read.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$markOnScreenCardsAsRead$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11572 extends v implements a<String> {
        final /* synthetic */ int $firstVisibleIndex;
        final /* synthetic */ int $lastVisibleIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11572(int i10, int i11) {
            super(0);
            this.$firstVisibleIndex = i10;
            this.$lastVisibleIndex = i11;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not marking all on-screen cards as read. Either the first or last index is negative. First visible: " + this.$firstVisibleIndex + " . Last visible: " + this.$lastVisibleIndex;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$onItemDismiss$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11581 extends v implements a<String> {
        final /* synthetic */ int $position;
        final /* synthetic */ ContentCardAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11581(int i10, ContentCardAdapter contentCardAdapter) {
            super(0);
            this.$position = i10;
            this.this$0 = contentCardAdapter;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot dismiss card at index: " + this.$position + " in cards list of size: " + this.this$0.cardData.size();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$onViewAttachedToWindow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11591 extends v implements a<String> {
        final /* synthetic */ int $adapterPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11591(int i10) {
            super(0);
            this.$adapterPosition = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The card at position " + this.$adapterPosition + " isn't on screen or does not have a valid adapter position. Not logging impression.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.contentcards.adapters.ContentCardAdapter$onViewDetachedFromWindow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentCardAdapter.kt */
    static final class C11601 extends v implements a<String> {
        final /* synthetic */ int $adapterPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11601(int i10) {
            super(0);
            this.$adapterPosition = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The card at position " + this.$adapterPosition + " isn't on screen or does not have a valid adapter position. Not marking as read.";
        }
    }

    public ContentCardAdapter(@NotNull Context context, @NotNull LinearLayoutManager layoutManager, @NotNull List<Card> cardData, @NotNull IContentCardsViewBindingHandler contentCardsViewBindingHandler) {
        t.i(context, "context");
        t.i(layoutManager, "layoutManager");
        t.i(cardData, "cardData");
        t.i(contentCardsViewBindingHandler, "contentCardsViewBindingHandler");
        this.context = context;
        this.layoutManager = layoutManager;
        this.cardData = cardData;
        this.contentCardsViewBindingHandler = contentCardsViewBindingHandler;
        this.handler = new Handler(Looper.getMainLooper());
        this.impressedCardIdsInternal = new LinkedHashSet();
        setHasStableIds(true);
    }

    private final boolean isInvalidIndex(int i10) {
        return i10 < 0 || i10 >= this.cardData.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markOnScreenCardsAsRead$lambda$1(int i10, int i11, ContentCardAdapter this$0) {
        t.i(this$0, "this$0");
        this$0.notifyItemRangeChanged(i11, (i10 - i11) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewDetachedFromWindow$lambda$0(ContentCardAdapter this$0, int i10) {
        t.i(this$0, "this$0");
        this$0.notifyItemChanged(i10);
    }

    @VisibleForTesting
    @Nullable
    public final Card getCardAtIndex(int i10) {
        if (!isInvalidIndex(i10)) {
            return this.cardData.get(i10);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass1(i10, this), 7, (Object) null);
        return null;
    }

    @NotNull
    public final List<String> getImpressedCardIds() {
        return d0.P0(this.impressedCardIdsInternal);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        String id;
        Card cardAtIndex = getCardAtIndex(i10);
        if (cardAtIndex == null || (id = cardAtIndex.getId()) == null) {
            return 0L;
        }
        return id.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.contentCardsViewBindingHandler.getItemViewType(this.context, this.cardData, i10);
    }

    @VisibleForTesting
    public final boolean isAdapterPositionOnScreen(int i10) {
        return Math.min(this.layoutManager.findFirstVisibleItemPosition(), this.layoutManager.findFirstCompletelyVisibleItemPosition()) <= i10 && i10 <= Math.max(this.layoutManager.findLastVisibleItemPosition(), this.layoutManager.findLastCompletelyVisibleItemPosition());
    }

    public final boolean isControlCardAtPosition(int i10) {
        Card cardAtIndex = getCardAtIndex(i10);
        return cardAtIndex != null && cardAtIndex.isControl();
    }

    @Override // com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter
    public boolean isItemDismissable(int i10) {
        if (this.cardData.isEmpty() || isInvalidIndex(i10)) {
            return false;
        }
        return this.cardData.get(i10).isDismissibleByUser();
    }

    @VisibleForTesting
    public final void logImpression(@Nullable Card card) {
        if (card == null) {
            return;
        }
        if (this.impressedCardIdsInternal.contains(card.getId())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass2(card), 6, (Object) null);
        } else {
            card.logImpression();
            this.impressedCardIdsInternal.add(card.getId());
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11551(card), 6, (Object) null);
        }
        if (card.getViewed()) {
            return;
        }
        card.setViewed(true);
    }

    public final void markOnScreenCardsAsRead() {
        if (this.cardData.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11561.INSTANCE, 7, (Object) null);
            return;
        }
        final int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        final int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11572(iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition), 7, (Object) null);
            return;
        }
        if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
            int i10 = iFindFirstVisibleItemPosition;
            while (true) {
                Card cardAtIndex = getCardAtIndex(i10);
                if (cardAtIndex != null) {
                    cardAtIndex.setIndicatorHighlighted(true);
                }
                if (i10 == iFindLastVisibleItemPosition) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.handler.post(new Runnable() { // from class: j0.b
            @Override // java.lang.Runnable
            public final void run() {
                ContentCardAdapter.markOnScreenCardsAsRead$lambda$1(iFindLastVisibleItemPosition, iFindFirstVisibleItemPosition, this);
            }
        });
    }

    @Override // com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter
    public void onItemDismiss(int i10) {
        if (isInvalidIndex(i10)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11581(i10, this), 7, (Object) null);
            return;
        }
        Card cardRemove = this.cardData.remove(i10);
        cardRemove.setDismissed(true);
        notifyItemRemoved(i10);
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        if (contentCardsActionListener != null) {
            contentCardsActionListener.onContentCardDismissed(this.context, cardRemove);
        }
    }

    public final synchronized void replaceCards(@NotNull List<? extends Card> newCardData) {
        t.i(newCardData, "newCardData");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new CardListDiffCallback(this.cardData, newCardData));
        t.h(diffResultCalculateDiff, "calculateDiff(diffCallback)");
        this.cardData.clear();
        this.cardData.addAll(newCardData);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public final void setImpressedCardIds(@NotNull List<String> impressedCardIds) {
        t.i(impressedCardIds, "impressedCardIds");
        this.impressedCardIdsInternal = d0.S0(impressedCardIds);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ContentCardViewHolder viewHolder, int i10) {
        t.i(viewHolder, "viewHolder");
        this.contentCardsViewBindingHandler.onBindViewHolder(this.context, this.cardData, viewHolder, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ContentCardViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i10) {
        t.i(viewGroup, "viewGroup");
        return this.contentCardsViewBindingHandler.onCreateViewHolder(this.context, this.cardData, viewGroup, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull ContentCardViewHolder holder) {
        t.i(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (this.cardData.isEmpty()) {
            return;
        }
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11591(bindingAdapterPosition), 6, (Object) null);
        } else {
            logImpression(getCardAtIndex(bindingAdapterPosition));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull ContentCardViewHolder holder) {
        t.i(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (this.cardData.isEmpty()) {
            return;
        }
        final int bindingAdapterPosition = holder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11601(bindingAdapterPosition), 6, (Object) null);
            return;
        }
        Card cardAtIndex = getCardAtIndex(bindingAdapterPosition);
        if (cardAtIndex == null || cardAtIndex.isIndicatorHighlighted()) {
            return;
        }
        cardAtIndex.setIndicatorHighlighted(true);
        this.handler.post(new Runnable() { // from class: j0.a
            @Override // java.lang.Runnable
            public final void run() {
                ContentCardAdapter.onViewDetachedFromWindow$lambda$0(this.f28605a, bindingAdapterPosition);
            }
        });
    }
}
