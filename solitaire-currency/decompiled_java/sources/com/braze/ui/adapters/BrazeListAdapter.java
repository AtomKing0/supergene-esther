package com.braze.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.models.cards.ShortNewsCard;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.feed.view.BaseFeedCardView;
import com.braze.ui.widget.CaptionedImageCardView;
import com.braze.ui.widget.DefaultCardView;
import com.braze.ui.widget.ImageOnlyCardView;
import com.braze.ui.widget.ShortNewsCardView;
import com.braze.ui.widget.TextAnnouncementCardView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BrazeListAdapter extends ArrayAdapter<Card> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeListAdapter.class);
    private final Set<String> mCardIdImpressions;
    private final Context mContext;

    public BrazeListAdapter(Context context, int i10, List<Card> list) {
        super(context, i10, list);
        this.mContext = context;
        this.mCardIdImpressions = new HashSet();
    }

    private void logCardImpression(Card card) {
        String id = card.getId();
        if (this.mCardIdImpressions.contains(id)) {
            BrazeLogger.v(TAG, "Already counted impression for card " + id);
        } else {
            this.mCardIdImpressions.add(id);
            card.logImpression();
            BrazeLogger.v(TAG, "Logged impression for card " + id);
        }
        if (card.getViewed()) {
            return;
        }
        card.setViewed(true);
    }

    public void batchSetCardsToRead(int i10, int i11) {
        if (getCount() == 0) {
            BrazeLogger.d(TAG, "mAdapter is empty in setting some cards to viewed.");
            return;
        }
        int iMin = Math.min(getCount(), i11);
        for (int iMax = Math.max(0, i10); iMax < iMin; iMax++) {
            Card card = (Card) getItem(iMax);
            if (card == null) {
                BrazeLogger.d(TAG, "Card was null in setting some cards to viewed.");
                return;
            } else {
                if (!card.isIndicatorHighlighted()) {
                    card.setIndicatorHighlighted(true);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        Card card = (Card) getItem(i10);
        if (card instanceof ImageOnlyCard) {
            return 1;
        }
        if (card instanceof CaptionedImageCard) {
            return 2;
        }
        if (card instanceof ShortNewsCard) {
            return 3;
        }
        return card instanceof TextAnnouncementCard ? 4 : 0;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NonNull
    public View getView(int i10, View view, @NonNull ViewGroup viewGroup) {
        BaseFeedCardView imageOnlyCardView;
        Card card = (Card) getItem(i10);
        if (view == null) {
            imageOnlyCardView = card instanceof ImageOnlyCard ? new ImageOnlyCardView(this.mContext) : card instanceof CaptionedImageCard ? new CaptionedImageCardView(this.mContext) : card instanceof ShortNewsCard ? new ShortNewsCardView(this.mContext) : card instanceof TextAnnouncementCard ? new TextAnnouncementCardView(this.mContext) : new DefaultCardView(this.mContext);
        } else {
            BrazeLogger.v(TAG, "Reusing convertView for rendering of item " + i10);
            imageOnlyCardView = (BaseFeedCardView) view;
        }
        BrazeLogger.v(TAG, "Using view of type: " + imageOnlyCardView.getClass().getName() + " for card at position " + i10 + ": " + card.toString());
        imageOnlyCardView.setCard(card);
        logCardImpression(card);
        return imageOnlyCardView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    public synchronized void replaceFeed(List<Card> list) {
        int i10 = 0;
        setNotifyOnChange(false);
        if (list == null) {
            clear();
            notifyDataSetChanged();
            return;
        }
        BrazeLogger.d(TAG, "Replacing existing feed of " + getCount() + " cards with new feed containing " + list.size() + " cards.");
        int size = list.size();
        int i11 = 0;
        while (i10 < getCount()) {
            Card card = (Card) getItem(i10);
            Card card2 = i11 < size ? list.get(i11) : null;
            if (card2 == null || !card2.equals(card)) {
                remove(card);
            } else {
                i10++;
                i11++;
            }
        }
        super.addAll(list.subList(i11, size));
        notifyDataSetChanged();
    }

    public void resetCardImpressionTracker() {
        this.mCardIdImpressions.clear();
    }

    @Override // android.widget.ArrayAdapter
    public synchronized void add(Card card) {
        super.add(card);
    }
}
